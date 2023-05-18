package business;

import business.entities.MPlayer;
import business.entities.Song;

import java.util.ArrayList;
import java.util.List;

public class BusinessLogicMPlayer {
    //TODO: Lista de prueba eliminar luego
    private final List<Song> songs;
    private MPlayer player;
    private boolean isIndividualRepetition;
    private boolean isGlobalRepetition;
    private int whichSong;

    public BusinessLogicMPlayer() {
        isIndividualRepetition = false;
        isGlobalRepetition = false;
        songs = new ArrayList<>();
        songs.add(new Song("Skrillex", "Dubstep", "Bangarang", "Skrillex", "data/music/skrillex.mp3"));
        songs.add(new Song("20SECONDS", "20", "20", "20", "data/music/snap.mp3"));
        whichSong = 0;
    }

    public void playPauseMusic() {
        if (player == null) {
            // TODO: Adaptarlo con la base de datos
            player = new MPlayer(songs.get(whichSong).getUrl());
            player.play(0);
        } else if (player.isPaused()) {
            player.play(player.getPausePosition());
        } else {
            player.pause();
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

    }

    public void nextMusic() {
        // TODO: Tener la lista de canciones y avanzar a la siguiente
        this.stopMusic();
        whichSong = (whichSong+1) % songs.size();
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
}
