package persistance;

import business.entities.Playlist;
import business.entities.Song;

import java.util.ArrayList;

public interface PlaylistDAO {
    boolean createPlaylist(Playlist playlist);
    boolean removePlaylist();
    ArrayList<Playlist> getPlaylists();
    boolean addSongPlaylist(Playlist playlist, Song song);
    boolean removeSongPlaylist(Playlist playlist, Song song);
    boolean removeSongAllPlaylist(Song song);
}
