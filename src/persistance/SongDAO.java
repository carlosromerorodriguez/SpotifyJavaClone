package persistance;

import business.entities.Music;
import business.entities.Song;

public interface SongDAO {
    boolean createSong(Song song);
    Music readSongList();
    boolean updateSong(Song song);
    boolean deleteSong(Song song);
    String readLyrics(Song song);
}
