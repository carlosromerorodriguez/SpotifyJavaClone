package business;

import business.entities.Song;
import business.exceptions.*;
import persistance.SongDAO;
import persistance.exceptions.*;

import java.net.URL;
import java.util.UUID;

public class BusinessLogicSong {
    SongDAO songDAO;

    public BusinessLogicSong(SongDAO songDAO) {
        this.songDAO = songDAO;
    }
    public void registerSong(String title, String genre, String album, String author) throws TitleException, AuthorException, AlbumException, GenreException, UrlException {
        if (title.isEmpty() || title.isBlank()) { throw new TitleException(); }
        if (author.isEmpty() || author.isBlank()) { throw new AuthorException(); }
        if (album.isEmpty() || album.isBlank()) { throw new AlbumException(); }
        if (genre.isEmpty() || genre.isBlank()) { throw new GenreException(); }

        Song newSong = new Song(title, genre, album, author, getPathFromSong(title));

        if (songDAO.addSong(newSong)) {
            System.out.println("Song added");
        }
    }

    private String getPathFromSong(String title) {
        return "data/music/" + title + ".mp3";
    }

    public void deleteSong(String title) throws TitleException {
        if (title.isEmpty() || title.isBlank()) { throw new TitleException();}
        if (songDAO.deleteSong(title)){
            System.out.println("Cancion eliminada");
        }
    }
}
