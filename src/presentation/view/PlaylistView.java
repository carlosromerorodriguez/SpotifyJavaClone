package presentation.view;

import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;

public class PlaylistView {

    private final JPanel contentPane;

    private JLabel Playlist;

    public PlaylistView() {
        this.contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        Playlist = new JLabel("Playlist");
        Playlist.setFont(Fonts.getBoldFont(20f));
        Playlist.setForeground(UIPalette.TEXT_COLOR.getColor());
        contentPane.add(Playlist);
    }

    public JPanel getContentPane() {
        return contentPane;
    }
}
