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
     * @throws TitleException Title exception if the title is empty or blank
     * @throws AuthorException Author exception if the author is empty or blank
     * @throws AlbumException Album exception if the album is empty or blank
     * @throws GenreException Genre exception if the genre is empty or blank
     * @throws UrlException Url exception if the url is empty or blank
     * @throws RepeatedSongNameException Repeated song name exception if the song name is repeated
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
     * @param title Song title to delete
     * @return True if the song is deleted
     * @throws TitleException Title exception if the title is empty or blank
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
