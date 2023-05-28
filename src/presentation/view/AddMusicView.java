package presentation.view;

import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
/**
 * Add music view
 */
public class AddMusicView extends JFrame {
    /**
     * Check if the user wants to add a song
     */
    public static final String ADD_COMMAND = "ADD_COMMAND";
    /**
     * Check if the user wants to go back
     */
    public static final String BACK_FROM_ADD = "BACK_FROM_ADD";
    private final JTextField jTFSongTitleText;
    private final JTextField jTFSongGenreText;
    private final JTextField jTFSongAlbumText;
    private final JTextField jTFSongAuthorText;
    private final JFileChooser jTFSongUrl;
    private final JPanel panelAddSong;
    private final JButton buttonAdd;
    private final JButton buttonBack;

    /**
     * Add music view
     */
    public AddMusicView() {

        panelAddSong = new JPanel(new GridBagLayout());
        panelAddSong.setBackground(UIPalette.COLOR_PRIMARIO.getColor());
        GridBagConstraints c = new GridBagConstraints();

        panelAddSong.setPreferredSize(new Dimension(500, 500));

        Font boldFont = Fonts.getBoldFont(30f);
        Font mediumFont = Fonts.getMediumFont(15f);

        panelAddSong.setBorder(new EmptyBorder(0, 0, 0, 0));

        JLabel add_song = new JLabel("Add Song");
        add_song.setForeground(UIPalette.TEXT_COLOR.getColor());
        add_song.setFont(boldFont);
        c.ipadx = 100;
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 10, 10, 0);
        panelAddSong.add(add_song, c);

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

        jTFSongUrl = new JFileChooser();
        jTFSongUrl.setPreferredSize(new Dimension(200, 350));
        jTFSongUrl.setFont(mediumFont);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy =6;
        c.gridwidth = 2;
        c.gridheight = 1;
        c.insets = new Insets(0, 0, 10, 0);
        panelAddSong.add(jTFSongUrl, c);

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

    /**
     * Adds action listener to the button
     * @param actionListener action listener defined in the controller
     */
    public void addMusicController(ActionListener actionListener) {
        buttonAdd.addActionListener(actionListener);
    }

    /**
     * Adds action listener to the button
     * @param actionListener action listener defined in the controller
     */
    public void backSongController(ActionListener actionListener) {
        buttonBack.addActionListener(actionListener);
    }

    /**
     * Returns the title of the song
     * @return title of the song
     */
    public String getTitle() {
        return jTFSongTitleText.getText();
    }

    /**
     * Returns the genre of the song
     * @return genre of the song
     */
    public String getGenre() {
        return jTFSongGenreText.getText();
    }

    /**
     * Returns the album of the song
     * @return album of the song
     */
    public String getAlbum() {
        return jTFSongAlbumText.getText();
    }

    /**
     * Returns the author of the song
     * @return author of the song
     */
    public String getAuthor() {
        return jTFSongAuthorText.getText();
    }

    /**
     * Returns the file of the song
     * @return file of the song
     */
    public File getFile() {
        return jTFSongUrl.getSelectedFile();
    }

    /**
     * Returns the panel
     * @return panel
     */
    public JPanel getPanelAddSong() {
        return panelAddSong;
    }

    /**
     * error message for wrong url
     */
    public void wrongUrlError() {
        JOptionPane.showMessageDialog(this,
                "Invalid URL address. Please ensure it meets the requirements and try again.",
                "Invalid Url Address", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * error message for wrong title
     */
    public void wrongTitleError() {
        JOptionPane.showMessageDialog(this,
                "The title you entered is not valid. Please ensure it meets the requirements and try again.",
                "Invalid Title", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * error message for wrong author
     */
    public void wrongAuthorError() {
        JOptionPane.showMessageDialog(this,
                "The author you entered is not valid. Please ensure it meets the requirements and try again.",
                "Invalid Author", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * error message for wrong album
     */
    public void wrongAlbumError() {
        JOptionPane.showMessageDialog(this,
                "The album you entered is not valid. Please ensure it meets the requirements and try again.",
                "Invalid Album", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * error message for wrong genre
     */
    public void wrongGenreError() {
        JOptionPane.showMessageDialog(this,
                "The genre you entered is not valid. Please ensure it meets the requirements and try again.",
                "Invalid Genre", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * error message for repeated song
     */
    public void repeatedSongNameError() {
        JOptionPane.showMessageDialog(this,
                "The song you are trying to add already exists in the library.",
                "Song Not Added", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * success message for adding song
     */
    public void successfulAdd() {
        JOptionPane.showMessageDialog(this,
                "The song was successfully added to the library.",
                "Song Added", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * error message for unsuccessful adding song
     */
    public void unsuccessfulAdd() {
        JOptionPane.showMessageDialog(this,
                "The song was not added to the library. Please try again.",
                "Song Not Added", JOptionPane.ERROR_MESSAGE);
    }
}