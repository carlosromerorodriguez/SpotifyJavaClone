package presentation.controller;

import business.BusinessLogicPlayList;
import presentation.view.DeleteSongFromPlaylistView;
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
    public PlaylistController(PlaylistView playlistView, BusinessLogicPlayList businessLogicPlayList, ViewsController viewsController, PlaylistSongsController playlistSongsController) {
        this.playlistView = playlistView;
        this.businessLogicPlayList = businessLogicPlayList;
        this.viewsController = viewsController;
        this.playlistSongsController = playlistSongsController;
        playlistView.setListener(this);
        playlistView.getTable().addMouseListener(this);
        playlistView.getOptionsButton().addActionListener(e -> playlistView.showOptionsDialog());
    }

    public void loadPlaylistsFromApi() {
        playlistView.setData(businessLogicPlayList.getPlaylists());
    }

    @Override
    public void onAddPlaylist() {
        viewsController.setAddPlaylistView();
    }

    @Override
    public void onDeletePlaylist() {
        viewsController.setDeletePlaylistView();
    }

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
