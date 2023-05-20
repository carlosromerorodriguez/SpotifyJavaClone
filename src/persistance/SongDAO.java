package persistance;

import business.entities.Music;
import business.entities.Song;
import business.entities.User;

import java.util.List;

public interface SongDAO {
    boolean addSong(Song song);
    List<Song> readSongList();
    boolean updateSong(Song song);
    boolean deleteSong(String title);
}
