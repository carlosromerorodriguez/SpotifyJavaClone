package business;

import business.entities.Song;
import business.exceptions.*;
import persistance.SongDAO;
import persistance.StatisticsDatabaseDAO;
import persistance.UserDatabaseDAO;
import persistance.exceptions.RepeatedSongNameException;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;

public class BusinessLogicSong {
    private final SongDAO songDAO;
    private final StatisticsDatabaseDAO statisticsDatabaseDAO;
    private final UserDatabaseDAO userDatabaseDAO;

    /**
     * Constructor
     * @param songDAO Song DAO
     * @param statisticsDatabaseDAO Statistics DAO
     * @param userDatabaseDAO User DAO
     */
    public BusinessLogicSong(SongDAO songDAO, StatisticsDatabaseDAO statisticsDatabaseDAO, UserDatabaseDAO userDatabaseDAO) {
        this.songDAO = songDAO;
        this.statisticsDatabaseDAO = statisticsDatabaseDAO;
        this.userDatabaseDAO = userDatabaseDAO;
    }

    /**
     * Register song
     * @param title Titol de la canço
     * @param genre Genere de la canço
     * @param album Album de la canço
     * @param author Autor de la canço
     * @param file File de la canço
     * @return True if the song is registered
     * @throws TitleException
     * @throws AuthorException
     * @throws AlbumException
     * @throws GenreException
     * @throws UrlException
     * @throws RepeatedSongNameException
     */
    public boolean registerSong(String title, String genre, String album, String author, File file) throws TitleException, AuthorException, AlbumException, GenreException, UrlException, RepeatedSongNameException {
        if (title.isEmpty() || title.isBlank()) { throw new TitleException(); }
        if (author.isEmpty() || author.isBlank()) { throw new AuthorException(); }
        if (album.isEmpty() || album.isBlank()) { throw new AlbumException(); }
        if (genre.isEmpty() || genre.isBlank()) { throw new GenreException(); }
        if (file == null || !file.getName().endsWith(".mp3")) { throw new UrlException(); }
        if (songDAO.readSongList().stream().anyMatch(song -> song.getTitle().toLowerCase(Locale.ROOT).equals(title.toLowerCase(Locale.ROOT)))) { throw new RepeatedSongNameException(); }
        return songDAO.addSong(new Song(title, genre, album, author, getPathFromSong(title.toLowerCase()), userDatabaseDAO.getUserNameFromFile()));
    }

    private String getPathFromSong(String title) {
        return ("data/music/" + title + ".mp3");
    }

    /**
     * Delete song
     * @param title Titol de la canço
     * @return True if the song is deleted
     * @throws TitleException
     */
    public boolean deleteSong(String title) throws TitleException {
        if (title.isEmpty() || title.isBlank()) { throw new TitleException();}
        return songDAO.deleteSong(title, userDatabaseDAO.getUserNameFromFile());
    }

    /**
     * Get statistics
     * @return Statistics
     */
    public HashMap<String, Integer> getStatistics() {
        return statisticsDatabaseDAO.getStatistics();
    }
}
