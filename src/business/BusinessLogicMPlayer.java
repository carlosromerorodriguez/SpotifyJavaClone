package business;

import business.entities.MPlayer;
import business.entities.Song;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import java.awt.*;
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
            new Thread(() -> {
                while (player.isPlaying()) {
                    try {
                        Thread.sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                onSongEnd();
            }).start();
        } else if (player.isPaused()) {
            player.play(player.getPausePosition());
        } else {
            player.pause();
        }
    }

    public void repeatMusic(int index) {
        switch (index) {
            case 0 -> {
                System.out.println("No repeat");
                isIndividualRepetition = false;
                isGlobalRepetition = false;
            }
            case 1 -> {
                System.out.println("Individual repeat");
                isIndividualRepetition = !isIndividualRepetition;
                isGlobalRepetition = false;
            }
            default -> {
                System.out.println("Global repeat");
                isGlobalRepetition = !isGlobalRepetition;
                isIndividualRepetition = false;
            }
        }
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
        player = new MPlayer(songs.get(whichSong).getUrl());
        player.play(0);
    }

    public void nextMusic() {
        // TODO: Tener la lista de canciones y avanzar a la siguiente
        this.stopMusic();
        whichSong = (whichSong+1) % songs.size();
        player = new MPlayer(songs.get(whichSong).getUrl());
        player.play(0);
    }

    public void onSongEnd() {
        if (isIndividualRepetition) {
            player = new MPlayer(songs.get(whichSong).getUrl());
            player.play(0);
        } else if (isGlobalRepetition) {
            nextMusic();
        } else {
            stopMusic();
        }
    }

}
