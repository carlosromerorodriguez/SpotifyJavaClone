package presentation.view;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

import static presentation.view.Utilities.UIPalette.ADD_SONG_COLOR;

public class AddMusicView extends JFrame {
    public static final String ADD_COMMAND = "ADD_COMMAND";
    public static final String BACK_FROM_ADD = "BACK_FROM_ADD";
    private final JTextField jTF_song_title;
    private final JTextField jTF_song_genre;
    private final JTextField jTF_song_album;
    private final JTextField jTF_song_author;
    private final JPanel panel_add_song;
    private final JButton button_add;
    private final JButton button_Back;

    public String getTitle() {
        return jTF_song_title.getText();
    }

    public String getGenre() {
        return jTF_song_genre.getText();
    }

    public String getAlbum() {
        return jTF_song_album.getText();
    }

    public String getAuthor() {
        return jTF_song_author.getText();
    }



    public JPanel getPanel_add_song() {
        return panel_add_song;
    }

    public AddMusicView() {
        setSize(700, 700);

        panel_add_song = new JPanel(new GridBagLayout());
        panel_add_song.setBackground(ADD_SONG_COLOR.getColor());
        GridBagConstraints c = new GridBagConstraints();

        Font fuente_titol = new Font("Sans-Serif", Font.PLAIN, 35);
        Font fuente_petit = new Font("Sans-Serif", Font.PLAIN, 15);

        panel_add_song.setBorder(new EmptyBorder(0, 0, 0, 0));


        JLabel add_song = new JLabel("AÑADIR CANCION");
        add_song.setForeground(UIPalette.TEXT_COLOR.getColor());
        add_song.setFont(fuente_titol);
        c.ipadx = 100;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(100, 0, 20, 0);
        panel_add_song.add(add_song, c);

        JLabel title = new JLabel("TITLE");
        title.setForeground(UIPalette.TEXT_COLOR.getColor());
        title.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 10, 0);
        panel_add_song.add(title, c);

        jTF_song_title = new JTextField();
        jTF_song_title.setPreferredSize(new Dimension(120, 30));
        jTF_song_title.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 7;
        c.insets = new Insets(0, 0, 10, 0);
        panel_add_song.add(jTF_song_title, c);

        JLabel genre = new JLabel("GENRE:");
        genre.setForeground(UIPalette.TEXT_COLOR.getColor());
        genre.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 10, 0);
        panel_add_song.add(genre, c);

        jTF_song_genre = new JTextField();
        jTF_song_genre.setPreferredSize(new Dimension(120, 30));
        jTF_song_genre.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 7;
        c.insets = new Insets(0, 0, 10, 0);
        panel_add_song.add(jTF_song_genre, c);

        JLabel album = new JLabel("ALBUM:");
        album.setForeground(UIPalette.TEXT_COLOR.getColor());
        album.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 10, 0);
        panel_add_song.add(album, c);

        jTF_song_album = new JTextField();
        jTF_song_album.setPreferredSize(new Dimension(120, 30));
        jTF_song_album.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 7;
        c.insets = new Insets(0, 0, 10, 0);
        panel_add_song.add(jTF_song_album, c);

        JLabel author = new JLabel("AUTHOR:");
        author.setForeground(UIPalette.TEXT_COLOR.getColor());
        author.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 7;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 10, 0);
        panel_add_song.add(author, c);

        jTF_song_author = new JTextField();
        jTF_song_author.setPreferredSize(new Dimension(120, 30));
        jTF_song_author.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 8;
        c.gridwidth = 7;
        c.insets = new Insets(0, 0, 10, 0);
        panel_add_song.add(jTF_song_author, c);

        JLabel url = new JLabel("URL:");
        url.setForeground(UIPalette.TEXT_COLOR.getColor());
        url.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 9;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 10, 0);
        panel_add_song.add(url, c);

        JFileChooser jTF_song_url = new JFileChooser();
        jTF_song_url.setPreferredSize(new Dimension(200, 400));
        jTF_song_url.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy =10;
        c.gridwidth = 7;
        c.insets = new Insets(0, 0, 10, 0);
        panel_add_song.add(jTF_song_url, c);

        button_add = new JButton("ADD");
        button_add.setPreferredSize(new Dimension(50, 30));
        button_add.setActionCommand(ADD_COMMAND);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 11;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(20, 220, 0, 0);
        panel_add_song.add(button_add, c);

        button_Back = new JButton("<");
        button_Back.setActionCommand(BACK_FROM_ADD);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 11;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(20, 0, 0, 220);
        panel_add_song.add(button_Back, c);

        c.ipady = 0;
        c.weighty = 0.2;
        c.gridx = 0;
        c.gridy = 11;
        c.anchor = GridBagConstraints.CENTER;
        panel_add_song.add(new JLabel(), c);
    }

    public void addMusicController(ActionListener actionListener) {
        button_add.addActionListener(actionListener);
    }
    public void backSongController(ActionListener actionListener) {
        button_Back.addActionListener(actionListener);
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