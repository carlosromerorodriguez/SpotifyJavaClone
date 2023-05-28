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

    /**
     * Constructor
     * @param s filename of the song
     */
    public MPlayer(String s) {
        filename = s;
        player = null;
        fis = null;
        total = 0;
        isPaused = false;
        playerThread = null;
    }

    /**
     * Pause the song if it is playing and save the position of the song
     */
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

    /**
     * Resume the song if it is paused
     */
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

    /**
     * Stop the song if it is playing or paused and reset the position of the song
     */
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

    /**
     * Check if the song is paused
     * @return true if the song is paused
     */
    public boolean isPaused() {
        return isPaused;
    }

    /**
     * Get the position of the song
     * @return position of the song
     */
    public int getPausePosition() {
        return pausePosition;
    }

    /**
     * Check if the song is finished
     * @return true if the song is finished
     */
    public boolean isFinished() {
        return playerThread != null && !playerThread.isAlive();
    }

    /**
     * Get the time of the song
     * @return time of the song
     */
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

    /**
     * Check if the file input stream is not closed
     * @return true if the file input stream is not closed
     */
    private boolean fisNotClosed() {
        try {
            fis.available();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    /**
     * Get the duration of the song
     * @return duration of the song
     */
    public int getDuration() {
        return total / 1000;
    }
}