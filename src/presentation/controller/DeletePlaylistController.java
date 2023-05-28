package presentation.controller;

import business.BusinessLogicPlayList;
import presentation.view.DeletePlaylistView;
import presentation.view.ViewsController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletePlaylistController implements ActionListener {
    private final BusinessLogicPlayList businessLogicPlaylist;
    private final ViewsController viewsController;
    private final DeletePlaylistView deletePlaylistView;
    private final PlaylistController playlistController;

    /**
     * Delete playlist controller
     * @param businessLogicPlaylist business logic playlist
     * @param viewsController views controller
     * @param deletePlaylistView delete playlist view
     * @param playlistController playlist controller
     */
    public DeletePlaylistController(BusinessLogicPlayList businessLogicPlaylist, ViewsController viewsController, DeletePlaylistView deletePlaylistView, PlaylistController playlistController) {
        this.businessLogicPlaylist = businessLogicPlaylist;
        this.viewsController = viewsController;
        this.deletePlaylistView = deletePlaylistView;
        this.playlistController = playlistController;
    }

    /**
     * Delete playlist
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(DeletePlaylistView.DELETE_PLAYLIST_COMMAND)) {
            if (businessLogicPlaylist.deletePlaylist(deletePlaylistView.getPlaylistName())) {
                deletePlaylistView.successfulDeletePlaylist();
            } else {
                deletePlaylistView.notExistingPlaylistError();
            }
            viewsController.setPlaylistView();
            playlistController.loadPlaylistsFromApi();
        }
        if (e.getActionCommand().equals(DeletePlaylistView.BACK_FROM_DELETE_PLAYLIST)){
            viewsController.setPlaylistView();
        }
    }
}