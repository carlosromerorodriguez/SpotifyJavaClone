package presentation.view;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.ActionListener;

import static presentation.view.Utilities.UIPalette.ADD_SONG_COLOR;

public class AddMusicView extends JFrame {
    public static final String ADD_COMMAND = "ADD_COMMAND";
    public static final String BACK_FROM_ADD = "BACK_FROM_ADD";
    private final JTextField jTFSongTitleText;
    private final JTextField jTFSongGenreText;
    private final JTextField jTFSongAlbumText;
    private final JTextField jTFSongAuthorText;
    private final JPanel panelAddSong;
    private final JButton buttonAdd;
    private final JButton buttonBack;

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

    public AddMusicView() {
        setSize(700, 700);

        panelAddSong = new JPanel(new GridBagLayout());
        panelAddSong.setBackground(ADD_SONG_COLOR.getColor());
        GridBagConstraints c = new GridBagConstraints();

        panelAddSong.setBackground(new Color(40, 42, 54));
        panelAddSong.setSize(500, 500);

        Font fuente_titol = new Font("Sans-Serif", Font.PLAIN, 35);
        Font fuente_petit = new Font("Sans-Serif", Font.PLAIN, 15);

        panelAddSong.setBorder(new EmptyBorder(0, 0, 0, 0));


        JLabel add_song = new JLabel("AÑADIR CANCION");
        add_song.setForeground(UIPalette.TEXT_COLOR.getColor());
        add_song.setFont(fuente_titol);
        c.ipadx = 100;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(100, 0, 20, 0);
        panelAddSong.add(add_song, c);

        JLabel title = new JLabel("TITLE");
        title.setForeground(UIPalette.TEXT_COLOR.getColor());
        title.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 10, 0);
        panelAddSong.add(title, c);

        jTFSongTitleText = new JTextField();
        jTFSongTitleText.setPreferredSize(new Dimension(120, 30));
        jTFSongTitleText.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 7;
        c.insets = new Insets(0, 0, 10, 0);
        panelAddSong.add(jTFSongTitleText, c);

        JLabel genre = new JLabel("GENRE:");
        genre.setForeground(UIPalette.TEXT_COLOR.getColor());
        genre.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 10, 0);
        panelAddSong.add(genre, c);

        jTFSongGenreText = new JTextField();
        jTFSongGenreText.setPreferredSize(new Dimension(120, 30));
        jTFSongGenreText.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 7;
        c.insets = new Insets(0, 0, 10, 0);
        panelAddSong.add(jTFSongGenreText, c);

        JLabel album = new JLabel("ALBUM:");
        album.setForeground(UIPalette.TEXT_COLOR.getColor());
        album.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 10, 0);
        panelAddSong.add(album, c);

        jTFSongAlbumText = new JTextField();
        jTFSongAlbumText.setPreferredSize(new Dimension(120, 30));
        jTFSongAlbumText.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 7;
        c.insets = new Insets(0, 0, 10, 0);
        panelAddSong.add(jTFSongAlbumText, c);

        JLabel author = new JLabel("AUTHOR:");
        author.setForeground(UIPalette.TEXT_COLOR.getColor());
        author.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 10, 0);
        panelAddSong.add(author, c);

        jTFSongAuthorText = new JTextField();
        jTFSongAuthorText.setPreferredSize(new Dimension(120, 30));
        jTFSongAuthorText.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 8;
        c.gridwidth = 7;
        c.insets = new Insets(0, 0, 10, 0);
        panelAddSong.add(jTFSongAuthorText, c);

        JLabel url = new JLabel("URL:");
        url.setForeground(UIPalette.TEXT_COLOR.getColor());
        url.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 9;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 10, 0);
        panelAddSong.add(url, c);

        JFileChooser jTF_song_url = new JFileChooser();
        jTF_song_url.setPreferredSize(new Dimension(200, 400));
        jTF_song_url.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy =10;
        c.gridwidth = 7;
        c.insets = new Insets(0, 0, 10, 0);
        panelAddSong.add(jTF_song_url, c);

        buttonAdd = new JButton("ADD");
        buttonAdd.setPreferredSize(new Dimension(50, 30));
        buttonAdd.setActionCommand(ADD_COMMAND);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 11;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(20, 220, 0, 0);
        panelAddSong.add(buttonAdd, c);

        buttonBack = new JButton("<");
        buttonBack.setActionCommand(BACK_FROM_ADD);
        c.ipady = 0;
        c.gridx = 1; // Changed from 0 to 1
        c.gridy = 11;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(20, 0, 0, 220);
        panelAddSong.add(buttonBack, c);

        JScrollPane scrollPane = new JScrollPane(panelAddSong,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);
        scrollPane.setPreferredSize(new Dimension(750, 450));
        scrollPane.getViewport().setBackground(new Color(40, 42, 54));
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Color.RED;
            }
        });

        // Añadir el scrollPane al JFrame en lugar del panel
        this.add(scrollPane);
    }

    public void addMusicController(ActionListener actionListener) {
        buttonAdd.addActionListener(actionListener);
    }
    public void backSongController(ActionListener actionListener) {
        buttonBack.addActionListener(actionListener);
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
}