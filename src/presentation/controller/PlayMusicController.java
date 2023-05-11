package presentation.controller;

import business.BusinessLogicUser;
import presentation.view.PlayMusicView;
import presentation.view.ViewsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Timer;

public class PlayMusicController implements ActionListener {

    private PlayMusicView playMusicView;

    private BusinessLogicUser businessLogicUser;
    private ViewsController viewsController;
    private int iconIndex = 1;
    private int iconIndexRepeat = 0;


    public PlayMusicController(PlayMusicView playMusicView, BusinessLogicUser businessLogicUser, ViewsController viewsController) {
        this.playMusicView = playMusicView;
        this.businessLogicUser = businessLogicUser;
        this.viewsController = viewsController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ImageIcon[] imageIcons = new ImageIcon[2];
        imageIcons[0] = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/pause.png")).getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        imageIcons[1] = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/play.png")).getScaledInstance(25, 25, Image.SCALE_SMOOTH));


        ImageIcon[] imageRepeat = new ImageIcon[3];
        imageRepeat[0] = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/repeat.png")).getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        imageRepeat[1] = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/repeat_global.png")).getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        imageRepeat[2] = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/repeat_unic.png")).getScaledInstance(20, 20, Image.SCALE_SMOOTH));

        if (e.getActionCommand().equals(PlayMusicView.PLAY_MUSIC_COMMAND)) {
            iconIndex = (iconIndex + 1) % 2;
            playMusicView.getbPlay().setIcon(imageIcons[iconIndex]);
            System.out.println("Play music");
        }
        if(e.getActionCommand().equals(playMusicView.PREVIOUS_MUSIC_COMMAND)){
            System.out.println("Previous music");
        }
        if(e.getActionCommand().equals(playMusicView.NEXT_MUSIC_COMMAND)){
            System.out.println("Next music");
        }
        if (e.getActionCommand().equals(playMusicView.REPEAT_MUSIC_COMMAND)) {
            iconIndexRepeat = (iconIndexRepeat + 1) % 3;
            playMusicView.getbRepeat().setIcon(imageRepeat[iconIndexRepeat]);
            System.out.println("Repeat music");
        }
    }

}
