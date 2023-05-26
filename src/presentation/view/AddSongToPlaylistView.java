package presentation.view;


import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddSongToPlaylistView extends JFrame {
    public static final String ADD_COMMAND = "ADD_COMMAND";
    public static final String BACK_FROM_ADD = "BACK_FROM_ADD";
    private final JTextField jTFSongTitleText;
    private final JTextField jTFSongGenreText;
    private final JTextField jTFSongAlbumText;
    private final JTextField jTFSongAuthorText;
    private final JTextField jTFPlaylistNameText;
    private final JPanel panelAddSong;
    private final JButton buttonAdd;
    private final JButton buttonBack;
    private JLabel addSongTitle;

    public String getTitle() {
        return jTFSongTitleText.getText();
    }

    public String getGenre() {
        return jTFSongGenreText.getText();
    }

    public String getAlbum() {
        return jTFSongAlbumText.getText();
    }

    public String getAuthor() {
        return jTFSongAuthorText.getText();
    }

    public JPanel getPanelAddSong() {
        return panelAddSong;
    }

    public AddSongToPlaylistView() {
        panelAddSong = new JPanel(new GridBagLayout());
        panelAddSong.setBackground(UIPalette.COLOR_PRIMARIO.getColor());
        GridBagConstraints c = new GridBagConstraints();
        jTFPlaylistNameText = new JTextField("");

        panelAddSong.setPreferredSize(new Dimension(500, 500)); // Set preferred size of the panel

        Font boldFont = Fonts.getBoldFont(30f);
        Font mediumFont = Fonts.getMediumFont(15f);

        panelAddSong.setBorder(new EmptyBorder(0, 0, 0, 0));

        addSongTitle = new JLabel("Add Song To Playlist " + jTFPlaylistNameText.getText());
        addSongTitle.setForeground(UIPalette.TEXT_COLOR.getColor());
        addSongTitle.setFont(boldFont);
        c.ipadx = 100;
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 10, 10, 0);
        panelAddSong.add(addSongTitle, c);

        JLabel title = new JLabel("Title:");
        title.setForeground(UIPalette.TEXT_COLOR.getColor());
        title.setFont(mediumFont);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = new Insets(0, 10, 10, 0);
        panelAddSong.add(title, c);

        jTFSongTitleText = new JTextField();
        jTFSongTitleText.setFont(mediumFont);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        c.insets = new Insets(0, 10, 10, 0);
        panelAddSong.add(jTFSongTitleText, c);

        JLabel genre = new JLabel("Genre:");
        genre.setForeground(UIPalette.TEXT_COLOR.getColor());
        genre.setFont(mediumFont);
        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = new Insets(0, 10, 10, 0);
        panelAddSong.add(genre, c);

        jTFSongGenreText = new JTextField();
        jTFSongGenreText.setFont(mediumFont);
        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        c.insets = new Insets(0, 10, 10, 0);
        panelAddSong.add(jTFSongGenreText, c);

        JLabel album = new JLabel("Album:");
        album.setForeground(UIPalette.TEXT_COLOR.getColor());
        album.setFont(mediumFont);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.insets = new Insets(0, 10, 10, 0);
        panelAddSong.add(album, c);

        jTFSongAlbumText = new JTextField();
        jTFSongAlbumText.setFont(mediumFont);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 1;
        c.insets = new Insets(0, 10, 10, 0);
        panelAddSong.add(jTFSongAlbumText, c);

        JLabel author = new JLabel("Author:");
        author.setForeground(UIPalette.TEXT_COLOR.getColor());
        author.setFont(mediumFont);
        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        c.insets = new Insets(0, 10, 10, 0);
        panelAddSong.add(author, c);

        jTFSongAuthorText = new JTextField();
        jTFSongAuthorText.setFont(mediumFont);
        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 4;
        c.gridwidth = 1;
        c.insets = new Insets(0, 10, 10, 0);
        panelAddSong.add(jTFSongAuthorText, c);

        JLabel url = new JLabel("URL:");
        url.setForeground(UIPalette.TEXT_COLOR.getColor());
        url.setFont(mediumFont);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 7;
        c.insets = new Insets(0, 10, 10, 0);
        panelAddSong.add(url, c);

        JFileChooser jTF_song_url = new JFileChooser();
        jTF_song_url.setPreferredSize(new Dimension(200, 350));
        jTF_song_url.setFont(mediumFont);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy =6;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.insets = new Insets(0, 0, 10, 0);
        panelAddSong.add(jTF_song_url, c);

        buttonBack = new JButton("<");
        buttonBack.setFont(mediumFont);
        buttonBack.setActionCommand(BACK_FROM_ADD);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 1;
        c.insets = new Insets(0, 50, 0, 150);
        panelAddSong.add(buttonBack, c);

        buttonAdd = new JButton("Add");
        buttonAdd.setFont(mediumFont);
        buttonAdd.setActionCommand(ADD_COMMAND);
        c.ipady = 0;
        c.gridx = 1;
        c.gridy = 7;
        c.gridwidth = 1;
        panelAddSong.add(buttonAdd, c);
    }

    public void setPlaylistName(String jTFPlaylistNameText) {
        this.jTFPlaylistNameText.setText(jTFPlaylistNameText);
        addSongTitle.setText("Add Song To Playlist " + jTFPlaylistNameText);
    }

    public void addSongController(ActionListener actionListener) {
        buttonAdd.addActionListener(actionListener);
    }
    public void wrongUrlError() {
        JOptionPane.showMessageDialog(this,
                "The url you entered is not valid. Please ensure you have copied correctly",
                "Invalid Url Address", JOptionPane.ERROR_MESSAGE);
    }

    public void wrongTitleError() {
        JOptionPane.showMessageDialog(this,
                "The title you entered is not valid. Please ensure it meets the requirements and try again.",
                "Invalid Title", JOptionPane.ERROR_MESSAGE);
    }

    public void wrongAuthorError() {
        JOptionPane.showMessageDialog(this,
                "The author you entered is not valid. Please ensure it meets the requirements and try again.",
                "Invalid Author", JOptionPane.ERROR_MESSAGE);
    }

    public void wrongAlbumError() {
        JOptionPane.showMessageDialog(this,
                "The album you entered is not valid. Please ensure it meets the requirements and try again.",
                "Invalid Album", JOptionPane.ERROR_MESSAGE);
    }

    public void wrongGenreError() {
        JOptionPane.showMessageDialog(this,
                "The genre you entered is not valid. Please ensure it meets the requirements and try again.",
                "Invalid Genre", JOptionPane.ERROR_MESSAGE);
    }

    public JPanel getPanel() {
        return panelAddSong;
    }

    public AbstractButton getBackButton() {
        return buttonBack;
    }

    public String getPlaylistName() {
        return jTFPlaylistNameText.getText();
    }
}
