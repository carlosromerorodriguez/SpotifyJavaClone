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
     * @param playlistDatabaseDAO playlist database DAO to set the playlist database DAO
     * @param userDatabaseDAO user database DAO to set the user database DAO
     */
    public BusinessLogicPlayList(PlaylistDatabaseDAO playlistDatabaseDAO, UserDatabaseDAO userDatabaseDAO) {
        this.playlistDatabaseDAO = playlistDatabaseDAO;
        this.userDatabaseDAO = userDatabaseDAO;
    }

    /**
     * Get playlists with the user first
     * @return list of playlists with the user first
     */
    public ArrayList<Playlist> getPlaylistsWithTheUserFirst() {
        return playlistDatabaseDAO.getPlaylistsWithTheUserFirst(userDatabaseDAO.getUserNameFromFile());
    }

    /**
     * @param playlistName playlist name to check if exists in the database
     * @throws TitleException if the playlist name already exists in the database
     */
    public void createPlaylist(String playlistName) throws TitleException {
        playlistDatabaseDAO.checkRepeatedPlaylistOwnerName(new Playlist(playlistName, userDatabaseDAO.getUserNameFromFile()));
        playlistDatabaseDAO.createPlaylist(new Playlist(playlistName, userDatabaseDAO.getUserNameFromFile()));
    }

    /**
     * Get songs from playlist
     * @param playlistName playlist name to get the songs from the playlist
     * @return list of songs from the playlist
     */
    public List<Song> getSongsFromPlaylist(String playlistName) {
        return playlistDatabaseDAO.getSongsFromPlaylist(playlistName);
    }

    /**
     * Add song to playlist
     * @param playlistName playlist name to add the song to the playlist
     * @param song song to add to the playlist
     * @throws DuplicateKeyException if the song is already in the playlist
     */
    public void addSongToPlaylist(String playlistName, Song song) throws DuplicateKeyException {
        playlistDatabaseDAO.addSongToPlaylist(playlistName, song);
    }

    /**
     * Delete playlist
     * @param playlistName playlist name to delete the playlist
     * @return true if the playlist was deleted, false if not
     */
    public boolean deletePlaylist(String playlistName) {
        return playlistDatabaseDAO.deletePlaylist(playlistName, userDatabaseDAO.getUserNameFromFile());
    }

    /**
     * Delete song from playlist
     * @param playlistName playlist name of the playlist to delete the song
     * @param title title of the song to delete from the playlist
     * @return true if the song was deleted, false if not
     */
    public boolean deleteSongFromPlaylist(String playlistName, String title) {
        return playlistDatabaseDAO.deleteSongFromPlaylist(playlistName, title, userDatabaseDAO.getUserNameFromFile());
    }

    /**
     * Is playlist from user
     * @param playlistName playlist name to check if it is from the user
     * @return true if it is from the user, false if not or if it does not exist
     */
    public boolean isPlaylistFromUser(String playlistName) {
        return playlistDatabaseDAO.isFromSameOwner(playlistName, userDatabaseDAO.getUserNameFromFile());
    }

    /**
     * Sort songs alphabetically
     * @param playlistName playlist name to sort the songs alphabetically
     * @return list of songs sorted alphabetically
     */
    public List<Song> sortSongsAlphabetically(String playlistName) {
        return playlistDatabaseDAO.sortSongsAlphabetically(playlistName);
    }

    /**
     * Sort songs by genre
     * @param playlistName playlist name to sort the songs by genre
     * @return list of songs sorted by genre alphabetically
     */
    public List<Song> sortSongsByGenre(String playlistName) {
        return playlistDatabaseDAO.sortSongsByGenre(playlistName);
    }
}
