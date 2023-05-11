package presentation.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

public class PlayMusicView {


    public static final String PLAY_MUSIC_COMMAND = "PLAY_MUSIC_COMMAND";
    public static final String PREVIOUS_MUSIC_COMMAND = "PREVIOUS_MUSIC_COMMAND";
    public static final String NEXT_MUSIC_COMMAND = "NEXT_MUSIC_COMMAND";
    public static final String REPEAT_MUSIC_COMMAND = "REPEAT_MUSIC_COMMAND";

    private JPanel contentPane;
    private JButton bPrev;
    private JButton bPlay;
    private JButton bNext;
    private JProgressBar progressBar;
    private JButton bRepeat;

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

        bPrev = new JButton(imageResize("src/img/previous.png", 25, 25));
        bPrev.setContentAreaFilled(false);
        bPrev.setBorderPainted(false);
        bPrev.setBounds(690, 30, 30, 23);
        bPrev.setActionCommand(PREVIOUS_MUSIC_COMMAND);
        contentPane.setLayout(null);
        contentPane.add(bPrev);

        bPlay = new JButton(imageResize("src/img/play.png", 25, 25));
        bPlay.setContentAreaFilled(false);
        bPlay.setBorderPainted(false);
        bPlay.setBounds(750, 27, 30, 28);
        bPlay.setActionCommand(PLAY_MUSIC_COMMAND);
        contentPane.add(bPlay);

        bNext = new JButton(imageResize("src/img/next.png",30, 25));
        bNext.setContentAreaFilled(false);
        bNext.setBorderPainted(false);
        bNext.setBounds(810, 30, 30, 23);
        bNext.setActionCommand(NEXT_MUSIC_COMMAND);
        contentPane.add(bNext);

        bRepeat = new JButton(imageResize("src/img/repeat.png", 20, 20));
        bRepeat.setContentAreaFilled(false);
        bRepeat.setBorderPainted(false);
        bRepeat.setBounds(1140, 30, 47, 23);
        bRepeat.setActionCommand(REPEAT_MUSIC_COMMAND);
        contentPane.add(bRepeat);

        progressBar = new JProgressBar();
        progressBar.setBounds(390, 70, 800, 14);
        progressBar.setValue(40);
        progressBar.setMaximum(200);
        contentPane.add(progressBar);

    }

    private ImageIcon imageResize(String ruta, int width, int height){

        ImageIcon imagenIcono = new ImageIcon(ruta);
        Image imagenOriginal = imagenIcono.getImage();
        Image nuevaImagen = imagenOriginal.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon iconoRedimensionado = new ImageIcon(nuevaImagen);
        return iconoRedimensionado;
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
