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

    /**
     * Constructor
     * @param playlistDatabaseDAO
     * @param userDatabaseDAO
     */
    public BusinessLogicPlayList(PlaylistDatabaseDAO playlistDatabaseDAO, UserDatabaseDAO userDatabaseDAO) {
        this.playlistDatabaseDAO = playlistDatabaseDAO;
        this.userDatabaseDAO = userDatabaseDAO;
    }

    /**
     * Get playlists with the user first
     * @return
     */
    public ArrayList<Playlist> getPlaylistsWithTheUserFirst() {
        return playlistDatabaseDAO.getPlaylistsWithTheUserFirst(userDatabaseDAO.getUserNameFromFile());
    }

    /**
     * Create playlist
     * @param playlistName
     * @throws TitleException
     */
    public void createPlaylist(String playlistName) throws TitleException {
        playlistDatabaseDAO.checkRepeatedPlaylistOwnerName(new Playlist(playlistName, userDatabaseDAO.getUserNameFromFile()));
        playlistDatabaseDAO.createPlaylist(new Playlist(playlistName, userDatabaseDAO.getUserNameFromFile()));
    }

    /**
     * Get songs from playlist
     * @param playlistName
     * @return
     */
    public List<Song> getSongsFromPlaylist(String playlistName) {
        return playlistDatabaseDAO.getSongsFromPlaylist(playlistName);
    }

    /**
     * Add song to playlist
     * @param playlistName
     * @param song
     * @throws DuplicateKeyException
     */
    public void addSongToPlaylist(String playlistName, Song song) throws DuplicateKeyException {
        playlistDatabaseDAO.addSongToPlaylist(playlistName, song);
    }

    /**
     * Delete playlist
     * @param playlistName
     * @return
     */
    public boolean deletePlaylist(String playlistName) {
        return playlistDatabaseDAO.deletePlaylist(playlistName, userDatabaseDAO.getUserNameFromFile());
    }

    /**
     * Delete song from playlist
     * @param playlistName
     * @param title
     * @return
     */
    public boolean deleteSongFromPlaylist(String playlistName, String title) {
        return playlistDatabaseDAO.deleteSongFromPlaylist(playlistName, title, userDatabaseDAO.getUserNameFromFile());
    }

    /**
     * Is playlist from user
     * @param playlistName
     * @return
     */
    public boolean isPlaylistFromUser(String playlistName) {
        return playlistDatabaseDAO.isFromSameOwner(playlistName, userDatabaseDAO.getUserNameFromFile());
    }

    /**
     * Sort songs alphabetically
     * @param playlistName
     * @return
     */
    public List<Song> sortSongsAlphabetically(String playlistName) {
        return playlistDatabaseDAO.sortSongsAlphabetically(playlistName);
    }

    /**
     * Sort songs by genre
     * @param playlistName
     * @return
     */
    public List<Song> sortSongsByGenre(String playlistName) {
        return playlistDatabaseDAO.sortSongsByGenre(playlistName);
    }
}
