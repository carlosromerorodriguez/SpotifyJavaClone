package presentation.controller;

import presentation.view.MainMenuView;
import presentation.view.ViewsController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Main menu controller class
 */
public class MainMenuController implements ActionListener {
    private final ViewsController viewsController;
    private final ListMusicController listMusicController;
    private final MusicStatisticsController musicStatisticsController;
    private final PlaylistController playlistController;

    /**
     * Main menu controller
     * @param viewsController views controller
     * @param listMusicController list music controller
     * @param musicStatisticsController music statistics controller
     * @param playlistController playlist controller
     */
    public MainMenuController(ViewsController viewsController, ListMusicController listMusicController, MusicStatisticsController musicStatisticsController, PlaylistController playlistController) {
        this.viewsController = viewsController;
        this.listMusicController = listMusicController;
        this.musicStatisticsController = musicStatisticsController;
        this.playlistController = playlistController;
    }

    /**
     * Action performed
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(MainMenuView.PLAY_MUSIC)) {
            viewsController.setListMusicView();
            listMusicController.loadSongsFromApi();
        }
        if (e.getActionCommand().equals(MainMenuView.PLAYLIST)) {
            viewsController.setPlaylistView();
            playlistController.loadPlaylistsFromApi();
        }
        if (e.getActionCommand().equals(MainMenuView.MUSIC_STATISTICS)) {
            viewsController.setMusicStatisticsView();
            musicStatisticsController.updateData();
        }
        if (e.getActionCommand().equals(MainMenuView.EXIT)) {
            viewsController.setLogOutView();
        }
    }
}
