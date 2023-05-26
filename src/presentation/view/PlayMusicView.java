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
    private JLabel timeCounter;
    private JLabel titleSong;
    private JLabel titleArtist;


    private final ImageIcon[] imageIcons;
    private final ImageIcon[] imageRepeat;

    public JButton getPlayButton() {
        return bPlay;
    }

    public JProgressBar getProgressBar() { return progressBar; }

    public JButton getRepetitionButton() {
        return bRepeat;
    }

    public PlayMusicView() {
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new GridBagLayout());
        contentPane.setBackground(UIPalette.COLOR_REPRODUCTOR.getColor());

        imageIcons = new ImageIcon[2];
        imageIcons[0] = imageResize("data/img/play.png");
        imageIcons[1] = imageResize("data/img/pause.png");

        imageRepeat = new ImageIcon[3];
        imageRepeat[0] = imageResize("data/img/repeat.png");
        imageRepeat[1] = imageResize("data/img/repeat_individual.png");
        imageRepeat[2] = imageResize("data/img/repeat_global.png");

        timeCounter = new JLabel("00:00");

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

    private ImageIcon imageResize(String ruta){
        return new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
    }

    public ImageIcon[] getImageIcons() {
        return imageIcons;
    }

    public ImageIcon[] getImageRepeat() {
        return imageRepeat;
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
        gbc.insets = new Insets(0, 50, 0, 0);
        contentPane.add(titleSong, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 25, 0, 10);
        contentPane.add(titleArtist, gbc);
    }

    public void setTitleSong(String songName) {
        titleSong.setText(songName);
    }

    public void setTitleArtist(String artistName) {
        titleArtist.setText(artistName);
    }

    private void addProgressBar(GridBagConstraints gbc) {
        progressBar = new JProgressBar();
        progressBar.setMaximum(200);
        progressBar.setMinimum(0);
        progressBar.setPreferredSize(new Dimension(300, 20));
        progressBar.setBackground(UIPalette.TEXT_COLOR.getColor());
        progressBar.setForeground(UIPalette.COLOR_REPRODUCTOR.getColor());
        progressBar.setBorderPainted(false);
        progressBar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 5;
        gbc.ipadx = -11;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0, 300, 0, -150);
        contentPane.add(progressBar, gbc);

        timeCounter = new JLabel("00:00");
        timeCounter.setForeground(UIPalette.TEXT_COLOR.getColor());
        timeCounter.setFont(Fonts.getLightFont(15f));
        gbc.gridx = 6;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.ipadx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0, 0, 0, 100);
        contentPane.add(timeCounter, gbc);
    }

    public void setTimeCounter(String time) {
        timeCounter.setText(time);
    }


    private void addPreviousButton(GridBagConstraints gbc) {
        bPrev = new JButton(imageResize("data/img/previous.png", 25));
        bPrev.setContentAreaFilled(false);
        bPrev.setBorderPainted(false);
        bPrev.setActionCommand(PREVIOUS_MUSIC_COMMAND);
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 10, 0, 17);
        contentPane.add(bPrev, gbc);
    }


    private void addPlayButton(GridBagConstraints gbc) {
        bPlay = new JButton(imageResize("data/img/play.png", 25));
        bPlay.setContentAreaFilled(false);
        bPlay.setBorderPainted(false);
        bPlay.setActionCommand(PLAY_PAUSE_MUSIC_COMMAND);
        gbc.gridx = 3;
        gbc.insets = new Insets(0, 10, 0, 10); // Añadir margen derecho e izquierdo
        contentPane.add(bPlay, gbc);
    }


    private void addNextButton(GridBagConstraints gbc) {
        bNext = new JButton(imageResize("data/img/next.png", 30));
        bNext.setContentAreaFilled(false);
        bNext.setBorderPainted(false);
        bNext.setActionCommand(NEXT_MUSIC_COMMAND);
        gbc.gridx = 4;
        gbc.insets = new Insets(0, 10, 0, 10); // Añadir margen derecho e izquierdo
        contentPane.add(bNext, gbc);
    }

    private void addRepeatButton(GridBagConstraints gbc) {
        bRepeat = new JButton(imageResize("data/img/repeat.png", 25));
        bRepeat.setContentAreaFilled(false);
        bRepeat.setBorderPainted(false);
        bRepeat.setActionCommand(REPEAT_MUSIC_COMMAND);
        gbc.gridx = 5;
        gbc.insets = new Insets(0, 10, 0, 10); // Añadir margen derecho e izquierdo
        contentPane.add(bRepeat, gbc);
    }


    private void addStopButton(GridBagConstraints gbc) {
        bStop = new JButton(imageResize("data/img/stop_music.png", 25));
        bStop.setContentAreaFilled(false);
        bStop.setBorderPainted(false);
        bStop.setActionCommand(STOP_MUSIC_COMMAND);
        gbc.gridx = 6;
        gbc.insets = new Insets(0, 10, 0, 250); // Añadir margen izquierdo
        contentPane.add(bStop, gbc);
    }


    private ImageIcon imageResize(String ruta, int width){
        return new ImageIcon(new ImageIcon(ruta).getImage().getScaledInstance(width, 25, Image.SCALE_SMOOTH));
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
