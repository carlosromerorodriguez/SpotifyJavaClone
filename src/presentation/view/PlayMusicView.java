package presentation.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class PlayMusicView {
    public static final String PLAY_PAUSE_MUSIC_COMMAND = "PLAY_MUSIC_COMMAND";
    public static final String PREVIOUS_MUSIC_COMMAND = "PREVIOUS_MUSIC_COMMAND";
    public static final String NEXT_MUSIC_COMMAND = "NEXT_MUSIC_COMMAND";
    public static final String REPEAT_MUSIC_COMMAND = "REPEAT_MUSIC_COMMAND";

    private final JPanel contentPane;
    private final JButton bPrev;
    private final JButton bPlay;
    private final JButton bNext;
    private final JProgressBar progressBar;
    private final JButton bRepeat;

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

        GridBagConstraints gbc = new GridBagConstraints();

        bPrev = new JButton(imageResize("data/img/previous.png", 25, 25));
        bPrev.setContentAreaFilled(false);
        bPrev.setBorderPainted(false);
        bPrev.setActionCommand(PREVIOUS_MUSIC_COMMAND);
        gbc.gridx = 0; // posición X
        gbc.gridy = 0; // posición Y
        gbc.insets = new Insets(0, 750, 0, 0);
        contentPane.add(bPrev, gbc);

        gbc.insets = new Insets(0, 0, 0, 0);
        bPlay = new JButton(imageResize("data/img/play.png", 25, 25));
        bPlay.setContentAreaFilled(false);
        bPlay.setBorderPainted(false);
        bPlay.setActionCommand(PLAY_PAUSE_MUSIC_COMMAND);
        gbc.gridx = 1;
        contentPane.add(bPlay, gbc);

        bNext = new JButton(imageResize("data/img/next.png",30, 25));
        bNext.setContentAreaFilled(false);
        bNext.setBorderPainted(false);
        bNext.setActionCommand(NEXT_MUSIC_COMMAND);
        gbc.gridx = 2;
        gbc.insets = new Insets(0, -350, 0, 0);
        contentPane.add(bNext, gbc);

        bRepeat = new JButton(imageResize("data/img/repeat.png", 20, 20));
        bRepeat.setContentAreaFilled(false);
        bRepeat.setBorderPainted(false);
        bRepeat.setActionCommand(REPEAT_MUSIC_COMMAND);
        gbc.gridx = 3;
        contentPane.add(bRepeat, gbc);

        progressBar = new JProgressBar();
        progressBar.setValue(40);
        progressBar.setMaximum(200);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3; // La barra de progreso se extenderá sobre las 4 columnas
        gbc.weightx = 1.0; // Asigna más espacio a la barra de progreso
        gbc.fill = GridBagConstraints.HORIZONTAL; // Hace que la barra de progreso se expanda horizontalmente
        gbc.insets = new Insets(0, 500, 0, 0); // Añade margen a la izquierda para centrar la barra
        contentPane.add(progressBar, gbc);
    }

    private ImageIcon imageResize(String ruta, int width, int height){
        ImageIcon imagenIcono = new ImageIcon(ruta);
        Image imagenOriginal = imagenIcono.getImage();
        Image nuevaImagen = imagenOriginal.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(nuevaImagen);
    }

    public JPanel getPanel_reproductor() {
        return contentPane;
    }

    public void addController(ActionListener actionListener) {
        bPlay.addActionListener(actionListener);
        bPrev.addActionListener(actionListener);
        bNext.addActionListener(actionListener);
        bRepeat.addActionListener(actionListener);
    }

}
