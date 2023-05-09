package persistance;

import business.entities.Music;
import business.entities.Song;
import business.entities.User;

public interface SongDAO {
    public boolean addSong(Song song);
    Music readSongList();
    boolean updateSong(Song song);
    boolean deleteSong(Song song);
    String readLyrics(Song song);
}
