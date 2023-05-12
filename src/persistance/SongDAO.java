package persistance;

import business.entities.Music;
import business.entities.Song;
import business.entities.User;

public interface SongDAO {
    boolean addSong(Song song);
    Music readSongList();
    boolean updateSong(Song song);
    boolean deleteSong(String title);
    String readLyrics(Song song);
}
