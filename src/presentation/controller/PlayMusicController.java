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
    private BusinessLogicMPlayer businessLogicMPlayer;
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
        imageIcons[0] = imageResize("data/img/pause.png", 25, 25);
        imageIcons[1] = imageResize("data/img/play.png", 25, 25);


        ImageIcon[] imageRepeat = new ImageIcon[3];
        imageRepeat[0] = imageResize("data/img/repeat.png", 25, 25);
        imageRepeat[1] = imageResize("data/img/repeat_global.png", 25, 25);
        imageRepeat[2] = imageResize("data/img/repeat_unic.png", 25, 25);

        if (e.getActionCommand().equals(PlayMusicView.PLAY_PAUSE_MUSIC_COMMAND)) {
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

    private ImageIcon imageResize(String ruta, int width, int height){

        ImageIcon imagenIcono = new ImageIcon(ruta);
        Image imagenOriginal = imagenIcono.getImage();
        Image nuevaImagen = imagenOriginal.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(nuevaImagen);
    }

}
