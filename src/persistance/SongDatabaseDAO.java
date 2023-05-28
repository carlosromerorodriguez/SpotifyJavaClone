package persistance;

import business.entities.Song;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongDatabaseDAO implements SongDAO {
    private final DDBBAccess ddbbAccess;

    /**
     * Constructor
     * @param ddbbAccess Database access
     */
    public SongDatabaseDAO(DDBBAccess ddbbAccess) {
        this.ddbbAccess = ddbbAccess;
    }

    /**
     * @param song Song to add to the database
     * @return true if the user has been added successfully to the database, false otherwise
     */
    @Override
    public boolean addSong(Song song) {
        String query = "INSERT INTO cancion (nom, genere, album, autor, duration, url, owner) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(query);
            statement.setString(1, song.getTitle());
            statement.setString(2, song.getGenre());
            statement.setString(3, song.getAlbum());
            statement.setString(4, song.getAuthor());
            statement.setInt(5, song.getDuration());
            statement.setString(6, song.getUrl());
            statement.setString(7, song.getOwner());
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * @return List of songs from the database
     */
    @Override
    public List<Song> readSongList() {
        List<Song> songList = new ArrayList<>();
        String query = "SELECT * FROM cancion";
        try {
            PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(query);
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                String titulo = results.getString("nom");
                String genero = results.getString("genere");
                String album = results.getString("album");
                String autor = results.getString("autor");
                String url = results.getString("url");
                String owner = results.getString("owner");

                Song song = new Song(titulo, genero, album, autor, url, owner);
                songList.add(song);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return songList;
    }

    /**
     * @param title Song title to search in the database
     * @param owner Song owner to search in the database
     * @return true if the song has been deleted successfully from the database, false otherwise
     */
    @Override
    public boolean deleteSong(String title, String owner) {
        String queryDeleteFromPlaylist = "DELETE FROM playlist_cancion WHERE cancion = (SELECT id FROM cancion WHERE nom = ? AND owner = ?)";
        String queryDeleteFromSong = "DELETE FROM cancion WHERE nom = ? AND owner = ?";
        try {
            // Elimina la cancion de todas las playlists
            PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(queryDeleteFromPlaylist);
            statement.setString(1, title);
            statement.setString(2, owner);
            statement.executeUpdate();

            // Elimina la cancion
            statement = ddbbAccess.getConnection().prepareStatement(queryDeleteFromSong);
            statement.setString(1, title);
            statement.setString(2, owner);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * @param searchText Text to search in the database
     * @return List of songs from the database that match the search text
     */
    @Override
    public List<Song> searchAllMusicFromSearchText(String searchText) {
        List<Song> songList = new ArrayList<>();
        String query = "SELECT * FROM cancion WHERE nom LIKE ? OR genere LIKE ? OR album LIKE ? OR autor LIKE ? OR owner LIKE ?";
        try {
            PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(query);
            statement.setString(1, "%" + searchText + "%");
            statement.setString(2, "%" + searchText + "%");
            statement.setString(3, "%" + searchText + "%");
            statement.setString(4, "%" + searchText + "%");
            statement.setString(5, "%" + searchText + "%");
            ResultSet results = statement.executeQuery();
            while (results.next()) {
                String title = results.getString("nom");
                String genre = results.getString("genere");
                String album = results.getString("album");
                String author = results.getString("autor");
                String url = results.getString("url");
                String owner = results.getString("owner");

                Song song = new Song(title, genre, album, author, url, owner);
                songList.add(song);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return songList;
    }
}