package business.entities;

import java.util.ArrayList;

public class Music {
    private final ArrayList<Song> arraySongs;

    public Music(ArrayList<Song> arraySongs) {
        this.arraySongs = arraySongs;
    }

    public ArrayList<Song> getArraySongs() {
        return arraySongs;
    }
}
