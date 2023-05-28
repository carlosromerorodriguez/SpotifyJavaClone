package presentation.controller;

import business.BusinessLogicPlayList;
import business.exceptions.TitleException;
import presentation.view.AddPlaylistView;
import presentation.view.ViewsController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPlaylistController implements ActionListener {
    private final BusinessLogicPlayList businessLogicPlaylist;
    private final ViewsController viewsController;
    private final AddPlaylistView addPlaylistView;
    private final PlaylistController playlistController;

    /**
     * Add playlist controller
     * @param businessLogicPlaylist
     * @param viewsController
     * @param addPlaylistView
     * @param playlistController
     */
    public AddPlaylistController(BusinessLogicPlayList businessLogicPlaylist, ViewsController viewsController, AddPlaylistView addPlaylistView, PlaylistController playlistController) {
        this.businessLogicPlaylist = businessLogicPlaylist;
        this.viewsController = viewsController;
        this.addPlaylistView = addPlaylistView;
        this.playlistController = playlistController;
    }

    /**
     * Action performed
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(AddPlaylistView.ADD_PLAYLIST_COMMAND)) {
            try {
                businessLogicPlaylist.createPlaylist(addPlaylistView.getPlaylistName());
                viewsController.setPlaylistView();
                playlistController.loadPlaylistsFromApi();
            } catch (TitleException ex) {
                addPlaylistView.repeatPlaylistNameError();
            }
        }
        if (e.getActionCommand().equals(AddPlaylistView.BACK_FROM_ADD_PLAYLIST)){
            viewsController.setPlaylistView();
        }
    }
}
