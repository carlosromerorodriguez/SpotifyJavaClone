package presentation.controller;

import business.BusinessLogicPlayList;
import presentation.view.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlaylistSongsController implements PlaylistSongsViewListener {
    private final PlaylistSongsView playlistSongsView;
    private final BusinessLogicPlayList businessLogicPlayList;
    private final ViewsController viewsController;
    private final AddSongToPlaylistView addSongToPlaylistView;
    private final DeleteSongFromPlaylistView deleteSongFromPlaylistView;
    public PlaylistSongsController(PlaylistSongsView playlistSongsView, BusinessLogicPlayList businessLogicPlayList, ViewsController viewsController, AddSongToPlaylistView addSongToPlaylistView, DeleteSongFromPlaylistView deleteSongFromPlaylistView) {
        this.playlistSongsView = playlistSongsView;
        this.businessLogicPlayList = businessLogicPlayList;
        this.viewsController = viewsController;
        this.addSongToPlaylistView = addSongToPlaylistView;
        this.deleteSongFromPlaylistView = deleteSongFromPlaylistView;
        playlistSongsView.setListener(this);
        playlistSongsView.getOptionsButton().addActionListener(e -> playlistSongsView.showOptionsDialog());
    }

    public void loadSongsFromApi(String playlistName) {
        playlistSongsView.setSongs(businessLogicPlayList.getSongsFromPlaylist(playlistName));
    }

    @Override
    public void onAddSong() {
        viewsController.setAddSongToPlaylistView();
        addSongToPlaylistView.setPlaylistName(playlistSongsView.getPlaylistName());
    }

    @Override
    public void onDeleteSong() {
        viewsController.setDeleteSongFromPlaylistView();
        deleteSongFromPlaylistView.setPlaylistName(playlistSongsView.getPlaylistName());
    }

    public void setPlaylistName(String selectedPlaylistName) {
        playlistSongsView.setPlaylistName(selectedPlaylistName);
    }
}
