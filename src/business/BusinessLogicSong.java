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

    public BusinessLogicSong(SongDAO songDAO, StatisticsDatabaseDAO statisticsDatabaseDAO, UserDatabaseDAO userDatabaseDAO) {
        this.songDAO = songDAO;
        this.statisticsDatabaseDAO = statisticsDatabaseDAO;
        this.userDatabaseDAO = userDatabaseDAO;
    }
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

    public boolean deleteSong(String title) throws TitleException {
        if (title.isEmpty() || title.isBlank()) { throw new TitleException();}
        return songDAO.deleteSong(title, userDatabaseDAO.getUserNameFromFile());
    }

    public HashMap<String, Integer> getStatistics() {
        return statisticsDatabaseDAO.getStatistics();
    }
}
