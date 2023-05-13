package presentation.view;

import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

public class MainMenuView extends JFrame {

    private final JPanel menuPanel;
    private final JButton bPlayMusic, bPlaylist, bMusicStatistics, bExit;
    private JLabel imageLabel;
    private final JLabel titulo;

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
        titulo = LTitulo("Spotifai");
        addImage();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(15,60,0,0);
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

        addListeners();
    }

    private JButton createButton(String text, String url) {
        JButton button = new JButton();
        button.setActionCommand(text);

        JLabel textLabel = new JLabel(text);
        Font font = Fonts.getMediumFont(25f);
        textLabel.setFont(font);
        textLabel.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 0)); // Ajustar los márgenes según sea necesario

        final ImageIcon[] icons = {imageResize(url, 35, 35), imageResize(url.replace("_negre", ""), 35, 35)};
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
        Image newimg = image.getScaledInstance(70, 70,  java.awt.Image.SCALE_SMOOTH); // Ajusta el tamaño de la imagen.
        imageIcon = new ImageIcon(newimg);
        imageLabel.setIcon(imageIcon);
    }

    private void addListeners() {
        ActionListener actionListener = e -> {
            String command = e.getActionCommand();
            System.out.println(command);
            if ("Exit".equals(command)) {
                System.exit(0);
            }
        };
        bPlayMusic.addActionListener(actionListener);
        bPlaylist.addActionListener(actionListener);
        bMusicStatistics.addActionListener(actionListener);
        bExit.addActionListener(actionListener);
    }

    public JLabel LTitulo(String titulo) {
        JLabel label = new JLabel(titulo);
        label.setFont(Fonts.getBoldFont(50f));
        label.setForeground(UIPalette.TEXT_COLOR.getColor());
        return label;
    }
    public JPanel getMenuPanel() {
        return menuPanel;
    }

    private ImageIcon imageResize(String ruta, int width, int height){
        ImageIcon imagenIcono = new ImageIcon(ruta);
        Image imagenOriginal = imagenIcono.getImage();
        Image nuevaImagen = imagenOriginal.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(nuevaImagen);
    }
}