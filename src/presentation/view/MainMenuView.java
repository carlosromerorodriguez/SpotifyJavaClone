package presentation.view;

import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Main menu view
 */
public class MainMenuView extends JFrame {
    private final JPanel menuPanel;
    private final JButton bPlayMusic, bPlaylist, bMusicStatistics, bExit;
    /**
     * Check if the user wants to play music
     */
    public static final String PLAY_MUSIC = "PLAY_MUSIC";
    /**
     * Check if the user wants to see the playlist
     */
    public static final String PLAYLIST = "PLAYLIST";
    /**
     * Check if the user wants to see the music statistics
     */
    public static final String MUSIC_STATISTICS = "MUSIC_STATISTICS";
    /**
     * Check if the user wants to exit
     */
    public static final String EXIT = "EXIT";
    private JLabel imageLabel;

    /**
     * Main menu view constructor
     */
    public MainMenuView() {

        menuPanel = new JPanel();
        menuPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weighty = 1;
        gbc.weightx = 0.5;

        bPlayMusic = createButton("Play Music", "data/img/music_negre.png");
        bPlaylist = createButton("Playlist", "data/img/playlist_negre.png");
        bMusicStatistics = createButton("Music Statistics", "data/img/graph_negre.png");
        bExit = createButton("Exit", "data/img/logout_negre.png");
        JLabel titulo = LTitulo("Spotifai");
        addImage();

        assignCommands();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,50,0,0);
        menuPanel.add(titulo,gbc);
        gbc.insets = new Insets(0,0,0,0);
        gbc.gridx = 1;
        gbc.gridy = 0;
        menuPanel.add(imageLabel,gbc);
        gbc.weightx = 1;
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 1;
        menuPanel.add(bPlayMusic,gbc);
        gbc.gridy = 2;
        menuPanel.add(bPlaylist,gbc);
        gbc.gridy = 3;
        menuPanel.add(bMusicStatistics,gbc);
        gbc.gridy = 4;
        menuPanel.add(bExit,gbc);
    }

    private void assignCommands() {
        bPlayMusic.setActionCommand(PLAY_MUSIC);
        bPlaylist.setActionCommand(PLAYLIST);
        bMusicStatistics.setActionCommand(MUSIC_STATISTICS);
        bExit.setActionCommand(EXIT);
    }

    private JButton createButton(String text, String url) {
        JButton button = new JButton();
        button.setActionCommand(text);

        JLabel textLabel = new JLabel(text);
        Font font = Fonts.getMediumFont(25f);
        textLabel.setFont(font);
        textLabel.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0)); // Ajustar los márgenes según sea necesario

        final ImageIcon[] icons = {imageResize(url), imageResize(url.replace("_negre", ""))};
        final JLabel imageLabel = new JLabel(icons[0]);
        imageLabel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 10)); // Ajustar los márgenes según sea necesario

        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);

        button.setForeground(UIPalette.COLOR_REPRODUCTOR.getColor());

        // Establecer el color del resaltado cuando el botón es enfocado
        UIManager.put("Button.focus", UIPalette.COLOR_PRIMARIO.getColor());

        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        panel.add(imageLabel, BorderLayout.WEST);
        panel.add(textLabel, BorderLayout.CENTER);

        button.setLayout(new BorderLayout());
        button.add(panel, BorderLayout.CENTER);

        // Cambiar el color del borde al pasar el ratón por encima
        button.setBorder(BorderFactory.createLineBorder(UIPalette.COLOR_PRIMARIO.getColor()));

        // Agregar el MouseListener al botón
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                textLabel.setForeground(UIPalette.TEXT_COLOR.getColor()); // Cambiar el color del textLabel al pasar el ratón por encima
                imageLabel.setIcon(icons[1]); // Cambiar la imagen al pasar el ratón por encima
                button.setBorder(BorderFactory.createLineBorder(UIPalette.TEXT_COLOR.getColor())); // Cambiar el color del borde al pasar el ratón por encima
            }

            @Override
            public void mouseExited(MouseEvent e) {
                textLabel.setForeground(UIPalette.COLOR_REPRODUCTOR.getColor()); // Restaurar el color del textLabel al salir el ratón
                imageLabel.setIcon(icons[0]); // Restaurar la imagen al salir el ratón
                button.setBorder(BorderFactory.createLineBorder(UIPalette.COLOR_PRIMARIO.getColor())); // Restaurar el color del borde al salir el ratón
            }
        });

        return button;
    }

    private void addImage() {
        imageLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("data/img/spotify.png"); // Reemplaza "testImage.jpg" con tu imagen.
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(70, 70,  Image.SCALE_SMOOTH); // Ajusta el tamaño de la imagen.
        imageIcon = new ImageIcon(newimg);
        imageLabel.setIcon(imageIcon);
    }

    /**
     * Crea un JLabel con el título de la vista.
     * @param titulo Título de la vista.
     * @return JLabel con el título de la vista.
     */
    public JLabel LTitulo(String titulo) {
        JLabel label = new JLabel(titulo);
        label.setFont(Fonts.getBoldFont(50f));
        label.setForeground(UIPalette.TEXT_COLOR.getColor());
        return label;
    }

    /**
     * Devuelve el panel de la vista.
     * @return JPanel de la vista.
     */
    public JPanel getMenuPanel() {
        return menuPanel;
    }

    private ImageIcon imageResize(String ruta){
        ImageIcon imagenIcono = new ImageIcon(ruta);
        Image imagenOriginal = imagenIcono.getImage();
        Image nuevaImagen = imagenOriginal.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        return new ImageIcon(nuevaImagen);
    }


    /**
     * Establece los action listeners de los botones de la vista.
     * @param actionListener Action listener de los botones de la vista.
     */
    public void setActionListeners(ActionListener actionListener) {
        bMusicStatistics.addActionListener(actionListener);
        bPlayMusic.addActionListener(actionListener);
        bPlaylist.addActionListener(actionListener);
        bExit.addActionListener(actionListener);
    }
}