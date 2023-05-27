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

    public int getDuration() {
        return player.getDuration();
    }

    public int getSongTime() {
        return player.getSongTime();
    }

    public BusinessLogicMPlayer() {
        isIndividualRepetition = false;
        isGlobalRepetition = false;
        this.songs = new ArrayList<>();
        whichSong = 0;
    }

    public void setWhichSong(int whichSong) {
        this.whichSong = whichSong;
    }

    public void setSongs(List<Song> songs) {
        this.songs.clear();
        this.songs.addAll(songs);
    }

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

    public void noMusicRepetition() {
        isIndividualRepetition = false;
        isGlobalRepetition = false;
    }

    public void individualRepeatMusic() {
        isIndividualRepetition = true;
        isGlobalRepetition = false;
    }

    public void globalRepeatMusic() {
        isIndividualRepetition = false;
        isGlobalRepetition = true;
    }

    public void stopMusic() {
        if (player != null) {
            player.stop();
            player = null;
        }
    }

    public void previousMusic() {
        // TODO: Tener la lista de canciones y avanzar a la anterior
        this.stopMusic();
        whichSong = ((whichSong-1) + songs.size()) % songs.size();
        playPauseMusic();
    }

    public void nextMusic() {
        // TODO: Tener la lista de canciones y avanzar a la siguiente
        this.stopMusic();
        whichSong = (whichSong+1) % songs.size();
        playPauseMusic();
    }

    public int getPlayIconIndex() {
        return isPaused ? 0 : 1;
    }

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

    public void updateRepeatMode() {
        if (isIndividualRepetition) {
            this.globalRepeatMusic();
        } else if (isGlobalRepetition) {
            this.noMusicRepetition();
        } else {
            this.individualRepeatMusic();
        }
    }

    public int getRepeatIconIndex() {
        if (isIndividualRepetition) {
            return 1;
        } else if (isGlobalRepetition) {
            return 2;
        } else {
            return 0;
        }
    }

    public void continueReproducingWithTheNewSong() {
        if (player != null) {
            player.stop();
            player = null;
        }
        player = new MPlayer(songs.get(whichSong).getUrl());
        player.play(0);
    }

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

    public void selectSong(String songName) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equalsIgnoreCase(songName)) {
                whichSong = i;
                break;
            }
        }
    }

    public boolean isPlaying() {
        return player != null && !player.isPaused();
    }

    public Object getSongName() {
        return songs.get(whichSong).getTitle();
    }

    public Object getArtistName() {
        return songs.get(whichSong).getAuthor();
    }
}
