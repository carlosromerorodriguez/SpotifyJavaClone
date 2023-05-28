package persistance;

import business.entities.Playlist;
import business.entities.Song;
import business.exceptions.TitleException;
import persistance.exceptions.DuplicateKeyException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDatabaseDAO implements PlaylistDAO {
    private final DDBBAccess ddbbAccess;
    public PlaylistDatabaseDAO(DDBBAccess ddbbAccess) {
        this.ddbbAccess = ddbbAccess;
    }
    @Override
    public void createPlaylist(Playlist playlist) {
        String query = "INSERT INTO playlist (nom, creador) VALUES (?, ?)";
        try {
            PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(query);
            statement.setString(1, playlist.getName());
            statement.setString(2, playlist.getOwner());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al crear la playlist: " + e.getMessage());
        }
    }

    @Override
    public void checkRepeatedPlaylistOwnerName(Playlist playlist) throws TitleException {
        String query = "SELECT * FROM playlist WHERE nom = ? AND creador = ?";
        try {
            PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(query);
            statement.setString(1, playlist.getName());
            statement.setString(2, playlist.getOwner());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                throw new TitleException();
            }
        } catch (SQLException e) {
            System.err.println("Error al comprobar si existe una playlist con ese nombre: " + e.getMessage());
        }
    }

    @Override
    public boolean removePlaylist() {
        return false;
    }

    @Override
    public ArrayList<Playlist> getPlaylistsWithTheUserFirst(String userNameFromFile) {
        ArrayList<Playlist> playlists = new ArrayList<>();
        String query = "SELECT * FROM playlist ORDER BY CASE WHEN creador = ? THEN 0 ELSE 1 END, creador";
        try {
            PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(query);
            statement.setString(1, userNameFromFile);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Playlist playlist = new Playlist(
                        resultSet.getString("nom"),
                        resultSet.getString("creador")
                );
                playlists.add(playlist);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener las playlists: " + e.getMessage());
        }
        return playlists;
    }

    @Override
    public List<Song> getSongsFromPlaylist(String playlistName) {
        List<Song> songs = new ArrayList<>();
        String query = "SELECT c.* FROM cancion c INNER JOIN playlist_cancion pc ON c.id = pc.cancion INNER JOIN playlist p ON pc.playlist = p.id WHERE p.nom = ?";
        try {
            PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(query);
            statement.setString(1, playlistName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Song song = new Song(
                        resultSet.getString("nom"),
                        resultSet.getString("genere"),
                        resultSet.getString("album"),
                        resultSet.getString("autor"),
                        resultSet.getString("url"),
                        resultSet.getString("owner")
                );
                songs.add(song);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener las canciones de la playlist: " + e.getMessage());
        }
        return songs;
    }

    @Override
    public boolean deletePlaylist(String playlistName, String userNameFromFile) {
        String query = "DELETE FROM playlist WHERE nom = ? AND creador = ?";
        try {
            PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(query);
            statement.setString(1, playlistName);
            statement.setString(2, userNameFromFile);
            return (statement.executeUpdate() > 0);
        } catch (SQLException e) {
            System.err.println("Error al eliminar la playlist: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteSongFromPlaylist(String playlistName, String title, String userNameFromFile) {
        String query = "DELETE FROM playlist_cancion WHERE playlist = (SELECT id FROM playlist WHERE nom = ? AND creador = ? LIMIT 1) AND cancion = (SELECT id FROM cancion WHERE nom = ? LIMIT 1)";
        try {
            PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(query);
            statement.setString(1, playlistName);
            statement.setString(2, userNameFromFile);
            statement.setString(3, title);
            return (statement.executeUpdate() > 0);
        } catch (SQLException e) {
            System.err.println("Error al eliminar la canción de la playlist: " + e.getMessage());
        }
        return false;
    }

    /**
     * Añade una canción a una playlist
     * @param playlistName
     * @param song
     * @throws DuplicateKeyException
     */
    public void addSongToPlaylist(String playlistName, Song song) throws DuplicateKeyException {
        String query = "INSERT INTO playlist_cancion (playlist, cancion) VALUES ((SELECT id FROM playlist WHERE nom = ? LIMIT 1), (SELECT id FROM cancion WHERE nom = ? LIMIT 1))";
        try {
            PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(query);
            statement.setString(1, playlistName);
            statement.setString(2, song.getTitle());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al añadir la canción a la playlist: " + e.getMessage());

            if (e.getMessage().contains("Duplicate entry")) {
                throw new DuplicateKeyException();
            }
        }
    }

    /**
     * Comprueba si la playlist es del mismo usuario
     * @param playlistName
     * @param userNameFromFile
     * @return
     */
    public boolean isFromSameOwner(String playlistName, String userNameFromFile) {
        String query = "SELECT * FROM playlist WHERE nom = ? AND creador = ?";
        try {
            PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(query);
            statement.setString(1, playlistName);
            statement.setString(2, userNameFromFile);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.err.println("Error al comprobar si la playlist es del mismo usuario: " + e.getMessage());
        }
        return false;
    }

    /**
     * Ordena las canciones de una playlist alfabéticamente
     * @param playlistName
     * @return
     */
    public List<Song> sortSongsAlphabetically(String playlistName) {
        List<Song> songs = new ArrayList<>();
        String query = "SELECT c.* FROM cancion c INNER JOIN playlist_cancion pc ON c.id = pc.cancion INNER JOIN playlist p ON pc.playlist = p.id WHERE p.nom = ? ORDER BY c.nom ASC";
        try {
            PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(query);
            statement.setString(1, playlistName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Song song = new Song(
                        resultSet.getString("nom"),
                        resultSet.getString("genere"),
                        resultSet.getString("album"),
                        resultSet.getString("autor"),
                        resultSet.getString("url"),
                        resultSet.getString("owner")
                );
                songs.add(song);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener las canciones de la playlist: " + e.getMessage());
        }
        return songs;
    }

    /**
     * Ordena las canciones de una playlist por género
     * @param playlistName
     * @return
     */
    public List<Song> sortSongsByGenre(String playlistName) {
        List<Song> songs = new ArrayList<>();
        String query = "SELECT c.* FROM cancion c INNER JOIN playlist_cancion pc ON c.id = pc.cancion INNER JOIN playlist p ON pc.playlist = p.id WHERE p.nom = ? ORDER BY c.genere ASC";
        try {
            PreparedStatement statement = ddbbAccess.getConnection().prepareStatement(query);
            statement.setString(1, playlistName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Song song = new Song(
                        resultSet.getString("nom"),
                        resultSet.getString("genere"),
                        resultSet.getString("album"),
                        resultSet.getString("autor"),
                        resultSet.getString("url"),
                        resultSet.getString("owner")
                );
                songs.add(song);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener las canciones de la playlist: " + e.getMessage());
        }
        return songs;
    }
}
