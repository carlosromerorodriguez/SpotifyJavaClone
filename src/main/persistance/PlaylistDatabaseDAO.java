package main.persistance;

import main.business.entities.Playlist;
import main.business.entities.Song;

import java.util.ArrayList;

public class PlaylistDatabaseDAO implements PlaylistDAO {
    @Override
    public boolean createPlaylist(Playlist playlist) {
        return false;
    }

    @Override
    public boolean removePlaylist() {
        return false;
    }

    @Override
    public ArrayList<Playlist> getPlaylists() {
        return null;
    }

    @Override
    public boolean addSongPlaylist(Playlist playlist, Song song) {
        return false;
    }

    @Override
    public boolean removeSongPlaylist(Playlist playlist, Song song) {
        return false;
    }

    @Override
    public boolean removeSongAllPlaylist(Song song) {
        return false;
    }
}
