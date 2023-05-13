package presentation.view;

import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class PlayMusicView {
    public static final String PLAY_PAUSE_MUSIC_COMMAND = "PLAY_MUSIC_COMMAND";
    public static final String PREVIOUS_MUSIC_COMMAND = "PREVIOUS_MUSIC_COMMAND";
    public static final String NEXT_MUSIC_COMMAND = "NEXT_MUSIC_COMMAND";
    public static final String REPEAT_MUSIC_COMMAND = "REPEAT_MUSIC_COMMAND";
    public static final String STOP_MUSIC_COMMAND = "STOP_MUSIC_COMMAND";

    private final JPanel contentPane;
    private JButton bPrev;
    private JButton bPlay;
    private JButton bNext;
    private JButton bStop;
    private JProgressBar progressBar;
    private JButton bRepeat;

    private JLabel titleArtist;
    private JLabel titleSong;

    public JButton getbStop() {
        return bStop;
    }

    public JPanel getContentPane() {
        return contentPane;
    }

    public JButton getbPrev() {
        return bPrev;
    }

    public JButton getbPlay() {
        return bPlay;
    }

    public JButton getbNext() {
        return bNext;
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }

    public JButton getbRepeat() {
        return bRepeat;
    }

    public PlayMusicView() {
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new GridBagLayout());
        contentPane.setBackground(UIPalette.COLOR_REPRODUCTOR.getColor());

        GridBagConstraints gbc = new GridBagConstraints();
        addTitleArtist(gbc);
        addBlankSpace(gbc);
        addBlankSpace2(gbc);
        gbc.weightx = 0.0;
        addPreviousButton(gbc);
        addPlayButton(gbc);
        addNextButton(gbc);
        addRepeatButton(gbc);
        addStopButton(gbc);
        addProgressBar(gbc);
    }

    private void addBlankSpace(GridBagConstraints gbc) {
        JLabel blankLabel = new JLabel();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(blankLabel, gbc);
    }
    private void addBlankSpace2(GridBagConstraints gbc) {
        JLabel blankLabel = new JLabel();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 0.0;
        gbc.fill = GridBagConstraints.BOTH;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(blankLabel, gbc);
    }

    private void addTitleArtist(GridBagConstraints gbc) {
        titleSong = new JLabel("Song");
        titleSong.setForeground(UIPalette.TEXT_COLOR.getColor());
        titleSong.setFont(Fonts.getBoldFont(40f));

        titleArtist = new JLabel("Artist");
        titleArtist.setForeground(UIPalette.TEXT_COLOR.getColor());
        titleArtist.setFont(Fonts.getLightFont(25f));

        gbc.weightx = 0.0;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 50, 0, 0); // Añadir margen inferior para separar de los botones
        contentPane.add(titleSong, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 25, 0, 10); // Añadir margen inferior para separar de los botones
        contentPane.add(titleArtist, gbc);
    }

    private void addProgressBar(GridBagConstraints gbc) {
        progressBar = new JProgressBar();
        progressBar.setValue(40);
        progressBar.setMaximum(200);
        progressBar.setBackground(UIPalette.COLOR_PRIMARIO.getColor());
        progressBar.setForeground(UIPalette.TEXT_COLOR.getColor());
        progressBar.setBorderPainted(false);
        gbc.gridx = 1;
        gbc.gridy = 1; // Colocar la barra de progreso en la tercera fila
        gbc.gridwidth = 5; // Ajustar el ancho de la barra de progreso para que ocupe todas las columnas
        gbc.weighty = 0.0;
        gbc.ipadx = -11;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Hace que la barra de progreso se expanda horizontalmente
        gbc.insets = new Insets(0, 300, 0, -230); // Añade margen superior e inferior para separar de los botones
        contentPane.add(progressBar, gbc);
    }


    private void addPreviousButton(GridBagConstraints gbc) {
        bPrev = new JButton(imageResize("data/img/previous.png", 25, 25));
        bPrev.setContentAreaFilled(false);
        bPrev.setBorderPainted(false);
        bPrev.setActionCommand(PREVIOUS_MUSIC_COMMAND);
        gbc.gridx = 2; // Cambiar el valor de gridx a 1
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END; // Alinear a la derecha
        gbc.insets = new Insets(0, 10, 0, 10); // Añadir margen derecho
        contentPane.add(bPrev, gbc);
    }


    private void addPlayButton(GridBagConstraints gbc) {
        bPlay = new JButton(imageResize("data/img/play.png", 25, 25));
        bPlay.setContentAreaFilled(false);
        bPlay.setBorderPainted(false);
        bPlay.setActionCommand(PLAY_PAUSE_MUSIC_COMMAND);
        gbc.gridx = 3; // Cambiar el valor de gridx a 2
        gbc.insets = new Insets(0, 10, 0, 10); // Añadir margen derecho e izquierdo
        contentPane.add(bPlay, gbc);
    }


    private void addNextButton(GridBagConstraints gbc) {
        bNext = new JButton(imageResize("data/img/next.png", 30, 25));
        bNext.setContentAreaFilled(false);
        bNext.setBorderPainted(false);
        bNext.setActionCommand(NEXT_MUSIC_COMMAND);
        gbc.gridx = 4; // Cambiar el valor de gridx a 3
        gbc.insets = new Insets(0, 10, 0, 10); // Añadir margen derecho e izquierdo
        contentPane.add(bNext, gbc);
    }

    private void addRepeatButton(GridBagConstraints gbc) {
        bRepeat = new JButton(imageResize("data/img/repeat.png", 25, 25));
        bRepeat.setContentAreaFilled(false);
        bRepeat.setBorderPainted(false);
        bRepeat.setActionCommand(REPEAT_MUSIC_COMMAND);
        gbc.gridx = 5; // Cambiar el valor de gridx a 4
        gbc.insets = new Insets(0, 10, 0, 10); // Añadir margen derecho e izquierdo
        contentPane.add(bRepeat, gbc);
    }


    private void addStopButton(GridBagConstraints gbc) {
        bStop = new JButton(imageResize("data/img/stop_music.png", 25, 25));
        bStop.setContentAreaFilled(false);
        bStop.setBorderPainted(false);
        bStop.setActionCommand(STOP_MUSIC_COMMAND);
        gbc.gridx = 6; // Cambiar el valor de gridx a 5
        gbc.insets = new Insets(0, 10, 0, 250); // Añadir margen izquierdo
        contentPane.add(bStop, gbc);
    }


    private ImageIcon imageResize(String ruta, int width, int height){
        ImageIcon imagenIcono = new ImageIcon(ruta);
        Image imagenOriginal = imagenIcono.getImage();
        Image nuevaImagen = imagenOriginal.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(nuevaImagen);
    }

    public JPanel getPanelReproductor() {
        return contentPane;
    }

    public void playMusicController(ActionListener actionListener) {
        bPlay.addActionListener(actionListener);
        bPrev.addActionListener(actionListener);
        bNext.addActionListener(actionListener);
        bRepeat.addActionListener(actionListener);
        bStop.addActionListener(actionListener);
    }
}
