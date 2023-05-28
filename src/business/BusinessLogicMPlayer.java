package business;

import business.entities.MPlayer;
import business.entities.Song;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BusinessLogicMPlayer {
    private final ArrayList<Song> songs;
    private MPlayer player;
    private boolean isPaused;
    private boolean isIndividualRepetition;
    private boolean isGlobalRepetition;
    private int whichSong;
    private Thread repeatThread;
    private volatile boolean isRepeatThreadRunning;

    /**
     * get current song duration
     * @return duration in seconds
     */
    public int getDuration() {
        return player.getDuration();
    }

    /**
     * get current song time
     * @return time in seconds
     */
    public int getSongTime() {
        return player.getSongTime();
    }

    /**
     * constructor
     */
    public BusinessLogicMPlayer() {
        isIndividualRepetition = false;
        isGlobalRepetition = false;
        this.songs = new ArrayList<>();
        whichSong = 0;
    }

    /**
     * set songs
     * @param songs songs to set to the player
     */
    public void setSongs(List<Song> songs) {
        this.songs.clear();
        this.songs.addAll(songs);
    }

    /**
     * Play pause thread
     */
    public void playPauseMusic() {
        if (player == null) {
            isPaused = false;
            player = new MPlayer(songs.get(whichSong).getUrl());
            player.play(0);
        } else if (player.isPaused()) {
            isPaused = false;
            player.play(player.getPausePosition());
            if (!isRepeatThreadRunning) {
                isRepeatThreadRunning = true;
                repeatThread = new Thread(() -> {
                    while (isRepeatThreadRunning) {
                        checkRepetition();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ignored) {}
                    }
                });
                repeatThread.start();
            }
        } else {
            isPaused = true;
            player.pause();
            if (isRepeatThreadRunning) {
                isRepeatThreadRunning = false;
            }
        }
    }

    /**
     * No music repetition
     */
    public void noMusicRepetition() {
        isIndividualRepetition = false;
        isGlobalRepetition = false;
    }

    /**
     * Individual music repetition
     */
    public void individualRepeatMusic() {
        isIndividualRepetition = true;
        isGlobalRepetition = false;
    }

    /**
     * Global music repetition
     */
    public void globalRepeatMusic() {
        isIndividualRepetition = false;
        isGlobalRepetition = true;
    }

    /**
     * Stop music
     */
    public void stopMusic() {
        if (player != null) {
            player.stop();
            player = null;
        }
    }

    /**
     * Previous music
     */
    public void previousMusic() {
        // TODO: Tener la lista de canciones y avanzar a la anterior
        this.stopMusic();
        whichSong = ((whichSong-1) + songs.size()) % songs.size();
        playPauseMusic();
    }

    /**
     * Next music
     */
    public void nextMusic() {
        // TODO: Tener la lista de canciones y avanzar a la siguiente
        this.stopMusic();
        whichSong = (whichSong+1) % songs.size();
        playPauseMusic();
    }

    /**
     * Devuelve el indice del icono de play/pause
     * @return
     */
    public int getPlayIconIndex() {
        return isPaused ? 0 : 1;
    }

    /**
     * Check repetition
     */
    public void checkRepetition() {
        if (player != null) {
            if (player.isFinished()) {
                if (isIndividualRepetition) {
                    player.play(0);
                } else if (isGlobalRepetition) {
                    this.nextMusic();
                }
            }
        }
    }

    /**
     * Update repeat mode
     */
    public void updateRepeatMode() {
        if (isIndividualRepetition) {
            this.globalRepeatMusic();
        } else if (isGlobalRepetition) {
            this.noMusicRepetition();
        } else {
            this.individualRepeatMusic();
        }
    }

    /**
     *
     * @return
     */
    public int getRepeatIconIndex() {
        if (isIndividualRepetition) {
            return 1;
        } else if (isGlobalRepetition) {
            return 2;
        } else {
            return 0;
        }
    }

    /**
     * Play music
     */
    public void playMusic() {
        if (player != null) {
            player.stop();
            player = null;
        }
        player = new MPlayer(songs.get(whichSong).getUrl());
        if (repeatThread != null && isRepeatThreadRunning) {
            isRepeatThreadRunning = false;
            try {
                repeatThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isRepeatThreadRunning = true;
        repeatThread = new Thread(() -> {
            while (isRepeatThreadRunning) {
                checkRepetition();
                try {
                    //System.out.println("Time: " + player.getSongTime());
                    Thread.sleep(1000);
                } catch (InterruptedException ignored) {}
            }
        });
        repeatThread.start();
        player.play(0);
    }

    /**
     * Select song
     * @param songName
     */
    public void selectSong(String songName) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equalsIgnoreCase(songName)) {
                whichSong = i;
                break;
            }
        }
    }

    /**
     * Check if is playing
     * @return
     */
    public boolean isPlaying() {
        return player != null && !player.isPaused();
    }

    /**
     * Get song name
     * @return song name of the song
     */
    public Object getSongName() {
        return songs.get(whichSong).getTitle();
    }

    /**
     * Get artist name
     * @return artist name of the song
     */
    public Object getArtistName() {
        return songs.get(whichSong).getAuthor();
    }

}
