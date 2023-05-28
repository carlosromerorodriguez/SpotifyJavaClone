package presentation.controller;

import business.BusinessLogicPlayList;
import presentation.view.PlayListViewListener;
import presentation.view.PlaylistView;
import presentation.view.ViewsController;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlaylistController implements MouseListener, PlayListViewListener {
    private final PlaylistView playlistView;
    private final BusinessLogicPlayList businessLogicPlayList;
    private final ViewsController viewsController;
    private final PlaylistSongsController playlistSongsController;

    /**
     * Playlist controller
     * @param playlistView playlist view
     * @param businessLogicPlayList business logic playlist
     * @param viewsController views controller
     * @param playlistSongsController playlist songs controller
     */
    public PlaylistController(PlaylistView playlistView, BusinessLogicPlayList businessLogicPlayList, ViewsController viewsController, PlaylistSongsController playlistSongsController) {
        this.playlistView = playlistView;
        this.businessLogicPlayList = businessLogicPlayList;
        this.viewsController = viewsController;
        this.playlistSongsController = playlistSongsController;
        playlistView.setListener(this);
        playlistView.getTable().addMouseListener(this);
        playlistView.getOptionsButton().addActionListener(e -> playlistView.showOptionsDialog());
    }

    /**
     * Load playlists from API
     */
    public void loadPlaylistsFromApi() {
        playlistView.setData(businessLogicPlayList.getPlaylistsWithTheUserFirst());
    }

    /**
     * Add playlist
     */
    @Override
    public void onAddPlaylist() {
        viewsController.setAddPlaylistView();
    }

    /**
     * Delete playlist
     */
    @Override
    public void onDeletePlaylist() {
        viewsController.setDeletePlaylistView();
    }

    /**
     * onMouseClick
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            playlistSongsController.setPlaylistName(playlistView.getSelectedPlaylistName());
            playlistSongsController.loadSongsFromApi(playlistView.getSelectedPlaylistName());
            viewsController.setPlaylistSongsView();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
