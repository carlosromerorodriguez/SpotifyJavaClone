package business.entities;

public class Song {
    private final String title;
    private final String genre;
    private final String album;
    private final String author;
    private final String url;
    public Song(String title, String genre, String album, String author, String url) {
        this.title = title;
        this.genre = genre;
        this.album = album;
        this.author = author;
        this.url = url;
    }

    public Song(String title, String genre, String album, String author) {
        this.title = title;
        this.genre = genre;
        this.album = album;
        this.author = author;
        this.url = null;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getAlbum() {
        return album;
    }

    public String getAuthor() {
        return author;
    }

    public String getUrl() {
        return url;
    }
}
