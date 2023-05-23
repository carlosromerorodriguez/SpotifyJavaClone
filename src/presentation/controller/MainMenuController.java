package presentation.controller;

import presentation.view.MainMenuView;
import presentation.view.ViewsController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController implements ActionListener {

    private final ViewsController viewsController;
    private final ListMusicController listMusicController;
    private final MusicStatisticsController musicStatisticsController;

    public MainMenuController(ViewsController viewsController, ListMusicController listMusicController, MusicStatisticsController musicStatisticsController) {
        this.viewsController = viewsController;
        this.listMusicController = listMusicController;
        this.musicStatisticsController = musicStatisticsController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(MainMenuView.PLAY_MUSIC)){
            viewsController.setListMusicView();
            listMusicController.loadSongsFromApi();
        }
        if(e.getActionCommand().equals(MainMenuView.PLAYLIST)){
            viewsController.setPlaylistView();
        }
        if (e.getActionCommand().equals(MainMenuView.MUSIC_STATISTICS)) {
            viewsController.setMusicStatisticsView();
            musicStatisticsController.updateData();
        }
        if(e.getActionCommand().equals(MainMenuView.EXIT)){
            viewsController.setLogOutView();
        }
    }
}
