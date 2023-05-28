package persistance;

import business.entities.Playlist;
import business.entities.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * PlaylistDAO interface for the DAO pattern
 */
public interface PlaylistDAO {
    /**
     * Create playlist
     * @param playlist playlist to create
     */
    void createPlaylist(Playlist playlist);
    /**
     * Check repeated playlist owner name
     * @param playlist playlist to check if the playlist owner name is repeated
     */
    void checkRepeatedPlaylistOwnerName(Playlist playlist) throws Exception;
    /**
     * Order playlists with the user first
     * @param userNameFromFile username from file to order the playlists with the user first
     * @return list of playlists with the user first
     */
    ArrayList<Playlist> getPlaylistsWithTheUserFirst(String userNameFromFile);

    /**
     * Get songs from playlist
     * @param playlistName playlist name to get the songs from the playlist
     * @return list of songs from the playlist
     */
    List<Song> getSongsFromPlaylist(String playlistName);
    /**
     * Delete playlist
     * @param playlistName playlist name to delete the playlist
     * @param userNameFromFile username from file to delete the playlist
     * @return true if the playlist has been deleted, false if not
     */
    boolean deletePlaylist(String playlistName, String userNameFromFile);

    /**
     * Add song to playlist
     * @param playlistName playlist name to add the song to the playlist
     * @param title song to add to the playlist
     * @param userNameFromFile username from file to add the song to the playlist
     * @return true if the song has been added to the playlist, false if not
     */
    boolean deleteSongFromPlaylist(String playlistName, String title, String userNameFromFile);
}
