package presentation.view;

import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.BlockingDeque;

public class PlaylistView {

    private final JPanel contentPane;

    private JLabel Playlist;

    public PlaylistView() {
        this.contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.setBorder(BorderFactory.createEmptyBorder(50, 50, 10, 10));
        Playlist = new JLabel("Playlist");
        Playlist.setFont(Fonts.getBoldFont(50f));
        Playlist.setForeground(Color.BLACK);
        contentPane.add(Playlist);
    }

    public JPanel getContentPane() {
        return contentPane;
    }
}
