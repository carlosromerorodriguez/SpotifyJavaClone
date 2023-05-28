package persistance;

import business.entities.Playlist;
import business.entities.Song;

import java.util.ArrayList;
import java.util.List;

public interface PlaylistDAO {
    void createPlaylist(Playlist playlist);
    void checkRepeatedPlaylistOwnerName(Playlist playlist) throws Exception;
    boolean removePlaylist();
    ArrayList<Playlist> getPlaylistsWithTheUserFirst(String userNameFromFile);
    List<Song> getSongsFromPlaylist(String playlistName);
    boolean deletePlaylist(String playlistName, String userNameFromFile);
    boolean deleteSongFromPlaylist(String playlistName, String title, String userNameFromFile);
}
