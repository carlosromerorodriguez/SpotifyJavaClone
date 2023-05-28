package persistance;

import business.entities.Song;

import java.util.List;

/**
 * SongDAO interface for the DAO pattern
 */
public interface SongDAO {
    /**
     * Add song
     * @param song song to add
     * @return true if the song has been added, false if not
     */
    boolean addSong(Song song);
    /**
     * Read a song list
     * @return list of songs
     */
    List<Song> readSongList();
    /**
     * Delete song
     * @param title title to delete the song
     * @param owner owner to delete the song
     * @return true if the song has been deleted, false if not
     */
    boolean deleteSong(String title, String owner);
    /**
     * Search all music from search text
     * @param searchText search text to search all music from the search text
     * @return list of songs from the search text
     */
    List<Song> searchAllMusicFromSearchText(String searchText);
}
