package business.entities;

public class Song {
    private final String title;
    private final String genre;
    private final String album;
    private final String author;
    private final String url;
    private final String owner;
    public Song(String title, String genre, String album, String author, String url) {
        this.title = title;
        this.genre = genre;
        this.album = album;
        this.author = author;
        this.url = url;
        this.owner = null;
    }

    public Song(String title, String genre, String album, String author, String url, String owner) {
        this.title = title;
        this.genre = genre;
        this.album = album;
        this.author = author;
        this.url = url;
        this.owner = owner;
    }

    public Song(String title, String genre, String album, String author) {
        this.title = title;
        this.genre = genre;
        this.album = album;
        this.author = author;
        this.url = null;
        this.owner = null;
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

    public String getOwner() {
        return owner;
    }

    public int getDuration() {
        return 0;
    }
}
