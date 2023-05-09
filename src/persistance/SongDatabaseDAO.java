package persistance;

import business.entities.Music;
import business.entities.Song;
import business.entities.User;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
     * @param song User to add
     * @return true if the user has been added successfully
     */
    @Override
    public boolean addSong(Song song) {
        String query = "INSERT INTO usuario(email, nom, password) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(query);
            statement.setString(1, song.getTitle());
            statement.setString(2, song.getGenre());
            statement.setString(3, song.getAlbum());
            statement.setString(4, song.getAuthor());
            statement.setString(5, song.getURL());
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Error al insertar el usuario: " + e.getMessage());
        }
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
