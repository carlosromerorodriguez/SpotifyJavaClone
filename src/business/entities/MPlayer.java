package business.entities;

import javazoom.jl.player.advanced.*;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class MPlayer {

    private AdvancedPlayer player;
    private final String filename;
    private FileInputStream fis;
    private boolean isPaused;
    private int pausePosition;
    private int total;
    private Thread playerThread;

    public MPlayer(String s) {
        filename = s;
        player = null;
        fis = null;
        total = 0;
        isPaused = false;
        playerThread = null;
    }

    public void pause() {
        if (player != null) {
            try {
                pausePosition = total - fis.available();
                player.close();
                isPaused = true;
            } catch (Exception e) {
                System.out.println("Problem pausing " + filename);
                System.out.println(e.getMessage());
            }
        }
    }

    public void play(int pos) {
        try {
            fis = new FileInputStream(filename);
            total = fis.available();
            fis.skip(pos);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new AdvancedPlayer(bis);
            isPaused = false;
            playerThread = new Thread(() -> {
                try {
                    player.play();
                } catch (Exception e) {
                    System.out.println("Problem playing " + filename);
                    System.out.println(e.getMessage());
                }
            });
            playerThread.start();
        } catch (Exception e) {
            System.out.println("Problem playing " + filename);
            System.out.println(e.getMessage());
        }
    }

    public void stop() {
        if (player != null) {
            try {
                player.close();
                isPaused = false;
                playerThread = null;
            } catch (Exception e) {
                System.out.println("Problem stopping " + filename);
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean isPaused() {
        return isPaused;
    }

    public int getPausePosition() {
        return pausePosition;
    }

    public boolean isFinished() {
        return playerThread != null && !playerThread.isAlive();
    }

    public int getSongTime() {
        if (player != null && fisNotClosed()) {
            try {
                return fis.available() / 1000;
            } catch (IOException e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    private boolean fisNotClosed() {
        try {
            fis.available();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public int getDuration() {
        return total / 1000;
    }
}