package main.persistance;

import main.business.entities.Music;
import main.business.entities.Song;

public interface SongDAO {
    boolean createSong(Song song);
    Music readSongList();
    boolean updateSong(Song song);
    boolean deleteSong(Song song);
    String readLyrics(Song song);
}
