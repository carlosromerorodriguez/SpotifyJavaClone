package presentation.view;

import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static presentation.view.Utilities.UIPalette.APP_BACKGROUND;

/**
 * The view class for displaying music information.
 */
public class ShowMusicInfoView {
    private String nom;
    private String genre;
    private String artist;
    private String album;
    private String owner;
    private final JPanel panelMusicInfo;
    private final JLabel songTitle;
    private final JLabel songGenre;
    private final JLabel songArtist;
    private final JLabel songAlbum;
    private final JLabel songOwner;
    private final JTextPane songLyrics;

    /**
     * Constructs a new ShowMusicInfoView object.
     */
    public ShowMusicInfoView() {
        panelMusicInfo = new JPanel(new GridBagLayout());
        panelMusicInfo.setBackground(APP_BACKGROUND.getColor());
        GridBagConstraints c = new GridBagConstraints();

        Font boldFont = Fonts.getBoldFont(30f);
        Font lightFont = Fonts.getLightFont(15f);

        panelMusicInfo.setBorder(new EmptyBorder(0, 0, 0, 0));

        songTitle = new JLabel("Song name: " + nom);
        songTitle.setForeground(UIPalette.TEXT_COLOR.getColor());
        songTitle.setFont(boldFont);
        c.ipadx = 100;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(20, 0, 20, 0);
        panelMusicInfo.add(songTitle, c);

        songGenre = new JLabel("Genre: " + genre);
        songGenre.setForeground(UIPalette.TEXT_COLOR.getColor());
        songGenre.setFont(lightFont);
        c.ipadx = 100;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(20, 0, 20, 0);
        panelMusicInfo.add(songGenre, c);

        songArtist = new JLabel("Artist: " + artist);
        songArtist.setForeground(UIPalette.TEXT_COLOR.getColor());
        songArtist.setFont(lightFont);
        c.ipadx = 100;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(20, 0, 20, 0);
        panelMusicInfo.add(songArtist, c);

        songAlbum = new JLabel("Album: " + album);
        songAlbum.setForeground(UIPalette.TEXT_COLOR.getColor());
        songAlbum.setFont(lightFont);
        c.ipadx = 100;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(20, 0, 20, 0);
        panelMusicInfo.add(songAlbum, c);

        songOwner = new JLabel("Owner: " + owner);
        songOwner.setForeground(UIPalette.TEXT_COLOR.getColor());
        songOwner.setFont(lightFont);
        c.ipadx = 100;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(20, 0, 20, 0);
        panelMusicInfo.add(songOwner, c);

        songLyrics = new JTextPane();
        songLyrics.setForeground(UIPalette.TEXT_COLOR.getColor());
        songLyrics.setFont(Fonts.getLightFont(20f));
        songLyrics.setEditable(false);
        songLyrics.setBackground(UIPalette.APP_BACKGROUND.getColor());
        c.ipadx = 100;
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1.0;

        JScrollPane scrollPane = new JScrollPane(songLyrics);
        scrollPane.setBackground(UIPalette.APP_BACKGROUND.getColor());
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setPreferredSize(new Dimension(750, 450));
        scrollPane.getViewport().setBackground(UIPalette.APP_BACKGROUND.getColor());
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        panelMusicInfo.add(scrollPane, c);
    }

    /**
     * Sets the information of the song to be displayed.
     *
     * @param name   the name of the song
     * @param title  the genre of the song
     * @param artist the artist of the song
     * @param album  the album of the song
     * @param lyrics the lyrics of the song
     * @param owner  the owner of the song
     */
    public void setSongInfo(String name, String title, String artist, String album, String lyrics, String owner) {
        this.nom = name;
        this.genre = title;
        this.artist = artist;
        this.album = album;
        this.owner = owner;

        songTitle.setText("Song name: " + title(name));
        songGenre.setText("Genre: " + title(title));
        songArtist.setText("Artist: " + title(artist));
        songAlbum.setText("Album: " + title(album));
        songOwner.setText("Owner: " + title(owner));
        songLyrics.setText("Lyrics: \n\n" + lyrics);
    }

    /**
     * Returns the panel containing the music information.
     *
     * @return the panel containing the music information
     */
    public JPanel getPanelShowSongInfo() {
        return panelMusicInfo;
    }

    /**
     * Capitalizes the first letter of each word in the given text.
     *
     * @param text the text to capitalize
     * @return the capitalized text
     */
    public static String title(String text) {
        String[] words = text.split(" ");
        StringBuilder title = new StringBuilder();
        for (String word : words) {
            title.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase()).append(" ");
        }
        return title.toString();
    }
}
