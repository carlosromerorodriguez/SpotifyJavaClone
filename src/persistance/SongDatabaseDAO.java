package persistance;

import business.entities.Music;
import business.entities.Song;

public class SongDatabaseDAO implements SongDAO {
    @Override
    public boolean createSong(Song song) {
        return false;
    }

    @Override
    public Music readSongList() {
        return null;
    }

    @Override
    public boolean updateSong(Song song) {
        return false;
    }

    @Override
    public boolean deleteSong(Song song) {
        return false;
    }

    @Override
    public String readLyrics(Song song) {
        return null;
    }
}
