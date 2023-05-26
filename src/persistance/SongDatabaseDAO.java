package persistance;

import business.entities.Music;
import business.entities.Song;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
     * @param song User to add
     * @return true if the user has been added successfully
     */
    @Override
    public boolean addSong(Song song) {
        String query = "INSERT INTO cancion(nom, genere, album, autor, url) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(query);
            statement.setString(1, song.getTitle());
            statement.setString(2, song.getGenre());
            statement.setString(3, song.getAlbum());
            statement.setString(4, song.getAuthor());
            statement.setString(5, song.getUrl());
            statement.executeUpdate();
            matchOwnerWithSong(song);
            return true;
        } catch (SQLException e) {
            System.err.println("Error al insertar la cancion: " + e.getMessage());
        }
        return false;
    }

    private void matchOwnerWithSong(Song song) {
        String query = "INSERT INTO usuari_cancio VALUES (?, ?)";
        try {
            PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(query);
            statement.setString(1, readUserInfoFile());
            statement.setString(2, song.getTitle());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al insertar la cancion: " + e.getMessage());
        }
    }

    private String readUserInfoFile() {
        try {
            return new String(Files.readAllBytes(Paths.get("data", "user", "userInfo")));
        } catch (IOException ignored) { return null; }
    }

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

                Song song = new Song(titulo, genero, album, autor, url);
                songList.add(song);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return songList;
    }

    @Override
    public boolean updateSong(Song song) {
        return false;
    }

    @Override
    public boolean deleteSong(String title) {
        List<Song> music = readSongList();
        Song remove_song = null;
        for (Song s : music) {
            if (s.getTitle().equals(title)) {
                remove_song = s;
                break;
            }
        }
        if (remove_song != null) {
            String query = "DELETE FROM cancion WHERE nom LIKE ? AND autor LIKE ?";
            try {
                PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(query);
                statement.setString(1, remove_song.getTitle());
                statement.setString(2, remove_song.getAuthor());
                int filasEliminadas = statement.executeUpdate();
                return filasEliminadas > 0;
            } catch (SQLException e) {
                return false;
            }
        } else {
            return false;
        }
    }
}