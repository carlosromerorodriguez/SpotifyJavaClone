package presentation.controller;

import business.BusinessLogicMPlayer;
import presentation.view.PlayMusicView;
import presentation.view.ViewsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayMusicController implements ActionListener {

    private final PlayMusicView playMusicView;
    private final BusinessLogicMPlayer businessLogicMPlayer;
    private ViewsController viewsController;
    private int iconIndex = 1;
    private int iconIndexRepeat = 0;

    public PlayMusicController(PlayMusicView playMusicView, BusinessLogicMPlayer businessLogicMPlayer, ViewsController viewsController) {
        this.playMusicView = playMusicView;
        this.businessLogicMPlayer = businessLogicMPlayer;
        this.viewsController = viewsController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ImageIcon[] imageIcons = new ImageIcon[2];
        imageIcons[0] = imageResize("data/img/pause.png");
        imageIcons[1] = imageResize("data/img/play.png");

        ImageIcon[] imageRepeat = new ImageIcon[3];
        imageRepeat[0] = imageResize("data/img/repeat.png");
        imageRepeat[1] = imageResize("data/img/repeat_individual.png");
        imageRepeat[2] = imageResize("data/img/repeat_global.png");

        if (e.getActionCommand().equals(PlayMusicView.PLAY_PAUSE_MUSIC_COMMAND)) {
            iconIndex = (iconIndex + 1) % 2;
            playMusicView.getbPlay().setIcon(imageIcons[iconIndex]);
            System.out.println("Play Pause music");
            businessLogicMPlayer.playPauseMusic();
        } else if (e.getActionCommand().equals(PlayMusicView.PREVIOUS_MUSIC_COMMAND)){
            System.out.println("Previous music");
            iconIndex = 1;
            playMusicView.getbPlay().setIcon(imageIcons[iconIndex]);
            businessLogicMPlayer.previousMusic();
        } else if (e.getActionCommand().equals(PlayMusicView.NEXT_MUSIC_COMMAND)){
            System.out.println("Next music");
            iconIndex = 1;
            playMusicView.getbPlay().setIcon(imageIcons[iconIndex]);
            businessLogicMPlayer.nextMusic();
        } else if (e.getActionCommand().equals(PlayMusicView.REPEAT_MUSIC_COMMAND)) {
            iconIndexRepeat = (iconIndexRepeat + 1) % 3;
            playMusicView.getbRepeat().setIcon(imageRepeat[iconIndexRepeat]);
            switch (iconIndexRepeat) {
                case 0 -> businessLogicMPlayer.noMusicRepetition();
                case 1 -> businessLogicMPlayer.individualRepeatMusic();
                case 2 -> businessLogicMPlayer.globalRepeatMusic();
            }
        } else if (e.getActionCommand().equals(PlayMusicView.STOP_MUSIC_COMMAND)) {
            iconIndex = 1;
            playMusicView.getbPlay().setIcon(imageIcons[iconIndex]);
            System.out.println("Stop music");
            businessLogicMPlayer.stopMusic();
        }
    }

    private ImageIcon imageResize(String ruta){
        ImageIcon imagenIcono = new ImageIcon(ruta);
        Image imagenOriginal = imagenIcono.getImage();
        Image nuevaImagen = imagenOriginal.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
        return new ImageIcon(nuevaImagen);
    }

}
