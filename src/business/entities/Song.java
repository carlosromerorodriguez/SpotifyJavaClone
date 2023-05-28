package business.entities;

public class Song {
    private final String title;
    private final String genre;
    private final String album;
    private final String author;
    private final String url;
    private final String owner;

    /**
     * Constructor
     * @param title title of the song
     * @param genre genre of the song
     * @param album album of the song
     * @param author author of the song
     * @param url url of the song
     */
    public Song(String title, String genre, String album, String author, String url) {
        this.title = title;
        this.genre = genre;
        this.album = album;
        this.author = author;
        this.url = url;
        this.owner = null;
    }

    /**
     * Constructor
     * @param title title of the song
     * @param genre genre of the song
     * @param album album of the song
     * @param author author of the song
     * @param url url of the song
     * @param owner owner of the song
     */
    public Song(String title, String genre, String album, String author, String url, String owner) {
        this.title = title;
        this.genre = genre;
        this.album = album;
        this.author = author;
        this.url = url;
        this.owner = owner;
    }

    /**
     * Constructor
     * @param title title of the song
     * @param genre genre of the song
     * @param album album of the song
     * @param author author of the song
     */
    public Song(String title, String genre, String album, String author) {
        this.title = title;
        this.genre = genre;
        this.album = album;
        this.author = author;
        this.url = null;
        this.owner = null;
    }

    /**
     * Get title of the song
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get genre of the song
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Get album of the song
     */
    public String getAlbum() {
        return album;
    }

    /**
     * Get author of the song
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Get url of the song
     */
    public String getUrl() {
        return url;
    }

    /**
     * Get owner of the song
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Get duration of the song
     */
    public int getDuration() {
        return 0;
    }
}
