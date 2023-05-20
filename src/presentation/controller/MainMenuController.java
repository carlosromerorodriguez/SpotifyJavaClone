package presentation.controller;

import business.BusinessLogicUser;
import presentation.view.MainMenuView;
import presentation.view.ViewsController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController implements ActionListener {

    private final ViewsController viewsController;

    public MainMenuController(ViewsController viewsController) {
        this.viewsController = viewsController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(MainMenuView.PLAYLIST)){
            viewsController.setPlaylistView();
        }
        if(e.getActionCommand().equals(MainMenuView.PLAY_MUSIC)){
            viewsController.setListMusicView();
        }
        if (e.getActionCommand().equals(MainMenuView.MUSIC_STATISTICS)) {
            viewsController.setMusicStatisticsView();
        }
        if(e.getActionCommand().equals(MainMenuView.EXIT)){
            viewsController.setLogOutView();
        }
    }
}
