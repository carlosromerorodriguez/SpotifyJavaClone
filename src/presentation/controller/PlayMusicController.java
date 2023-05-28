package presentation.controller;

import business.BusinessLogicMPlayer;
import business.entities.Song;
import presentation.view.PlayMusicView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public class PlayMusicController implements ActionListener {
    private final PlayMusicView playMusicView;
    private final BusinessLogicMPlayer businessLogicMPlayer;
    private final Timer timer;

    public PlayMusicController(PlayMusicView playMusicView, BusinessLogicMPlayer businessLogicMPlayer) {
        this.playMusicView = playMusicView;
        this.businessLogicMPlayer = businessLogicMPlayer;
        this.timer = new Timer(1000, e -> updateProgressBar());
    }

    private void updateProgressBar() {
        float duration = businessLogicMPlayer.getDuration();
        float currentTime = businessLogicMPlayer.getSongTime();
        int progressBarValue = (int) ((currentTime / duration) * 100);

        SwingUtilities.invokeLater(() -> {
            playMusicView.getProgressBar().setValue(progressBarValue);
            playMusicView.setTimeCounter(formatTime((int) currentTime));
        });

    }

    private String formatTime(int timeInSeconds) {
        int minutes = timeInSeconds / 60;
        int seconds = timeInSeconds % 60;

        return String.format("%02d:%02d", minutes, seconds);
    }

    public void setSongsToMPlayer(List<Song> songs) {
        businessLogicMPlayer.setSongs(songs);
    }

    public void playSong(String songName) {
        businessLogicMPlayer.selectSong(songName);
        businessLogicMPlayer.playMusic();
        playMusicView.getPlayButton().setIcon(playMusicView.getImageIcons()[1]);
        playMusicView.setTitleArtist((String) businessLogicMPlayer.getArtistName());
        playMusicView.setTitleSong((String) businessLogicMPlayer.getSongName());
        this.timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(PlayMusicView.PLAY_PAUSE_MUSIC_COMMAND)) {
            businessLogicMPlayer.playPauseMusic();
            if (businessLogicMPlayer.isPlaying()) { timer.start(); } else { timer.stop(); }
            playMusicView.getPlayButton().setIcon(playMusicView.getImageIcons()[businessLogicMPlayer.getPlayIconIndex()]);
            playMusicView.setTitleArtist((String) businessLogicMPlayer.getArtistName());
            playMusicView.setTitleSong((String) businessLogicMPlayer.getSongName());
        } else if (e.getActionCommand().equals(PlayMusicView.PREVIOUS_MUSIC_COMMAND)){
            businessLogicMPlayer.previousMusic();
            playMusicView.getPlayButton().setIcon(playMusicView.getImageIcons()[businessLogicMPlayer.getPlayIconIndex()]);
            playMusicView.setTitleArtist((String) businessLogicMPlayer.getArtistName());
            playMusicView.setTitleSong((String) businessLogicMPlayer.getSongName());
        } else if (e.getActionCommand().equals(PlayMusicView.NEXT_MUSIC_COMMAND)){
            businessLogicMPlayer.nextMusic();
            playMusicView.getPlayButton().setIcon(playMusicView.getImageIcons()[businessLogicMPlayer.getPlayIconIndex()]);
            playMusicView.setTitleArtist((String) businessLogicMPlayer.getArtistName());
            playMusicView.setTitleSong((String) businessLogicMPlayer.getSongName());
        } else if (e.getActionCommand().equals(PlayMusicView.REPEAT_MUSIC_COMMAND)) {
            businessLogicMPlayer.updateRepeatMode();
            playMusicView.getRepetitionButton().setIcon(playMusicView.getImageRepeat()[businessLogicMPlayer.getRepeatIconIndex()]);
        } else if (e.getActionCommand().equals(PlayMusicView.STOP_MUSIC_COMMAND)) {
            businessLogicMPlayer.stopMusic();
            playMusicView.getPlayButton().setIcon(playMusicView.getImageIcons()[0]);
            this.timer.stop();
        }
    }
}
