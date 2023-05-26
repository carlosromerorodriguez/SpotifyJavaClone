package business;

import business.entities.Playlist;
import business.entities.Song;
import business.exceptions.*;
import persistance.PlaylistDatabaseDAO;
import persistance.UserDatabaseDAO;
import persistance.exceptions.DuplicateKeyException;

import java.util.ArrayList;
import java.util.List;

public class BusinessLogicPlayList {
    private final PlaylistDatabaseDAO playlistDatabaseDAO;
    private final UserDatabaseDAO userDatabaseDAO;
    public BusinessLogicPlayList(PlaylistDatabaseDAO playlistDatabaseDAO, UserDatabaseDAO userDatabaseDAO) {
        this.playlistDatabaseDAO = playlistDatabaseDAO;
        this.userDatabaseDAO = userDatabaseDAO;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlistDatabaseDAO.getPlaylists();
    }

    public void createPlaylist(String playlistName) throws TitleException {
        playlistDatabaseDAO.checkRepeatedPlaylistOwnerName(new Playlist(playlistName, userDatabaseDAO.getUserNameFromFile()));
        playlistDatabaseDAO.createPlaylist(new Playlist(playlistName, userDatabaseDAO.getUserNameFromFile()));
    }

    public List<Song> getSongsFromPlaylist(String playlistName) {
        return playlistDatabaseDAO.getSongsFromPlaylist(playlistName, userDatabaseDAO.getUserNameFromFile());
    }

    public void addSongToPlaylist(String playlistName, Song song) throws DuplicateKeyException {
        playlistDatabaseDAO.addSongToPlaylist(playlistName, song);
    }

    public boolean deletePlaylist(String playlistName) {
        return playlistDatabaseDAO.deletePlaylist(playlistName, userDatabaseDAO.getUserNameFromFile());
    }

    public boolean deleteSongFromPlaylist(String playlistName, String title) {
        return playlistDatabaseDAO.deleteSongFromPlaylist(playlistName, title, userDatabaseDAO.getUserNameFromFile());
    }
}
