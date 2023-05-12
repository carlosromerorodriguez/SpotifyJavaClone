package presentation.controller;

import business.BusinessLogicMusic;
import business.BusinessLogicSong;
import persistance.exceptions.*;
import presentation.view.ListMusicView;
import presentation.view.ViewsController;

import java.awt.event.ActionEvent;

public class ListMusicController {
    BusinessLogicMusic businessLogicMusic;
    ViewsController viewsController;

    public ListMusicController(BusinessLogicMusic businessLogicMusic) {
        this.businessLogicMusic = businessLogicMusic;
    }

    public void actionPerformed(ActionEvent e) {
        businessLogicMusic.listMusic();
    }
}