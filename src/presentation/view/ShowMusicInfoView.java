package presentation.view;

import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static presentation.view.Utilities.UIPalette.APP_BACKGROUND;

public class ShowMusicInfoView {
    private String nom;
    private String genere;
    private String artist;
    private String album;
    private String owner;
    private final JPanel panelMusicInfo;
    private final JLabel titolCancion;
    private final JLabel genereCancion;
    private final JLabel artistCancion;
    private final JLabel albumCancion;
    private final JLabel ownerCancion;
    private final JTextPane lyricsCancion;

    public ShowMusicInfoView() {
        panelMusicInfo = new JPanel(new GridBagLayout());
        panelMusicInfo.setBackground(APP_BACKGROUND.getColor());
        GridBagConstraints c = new GridBagConstraints();

        Font fuenteTitol = Fonts.getBoldFont(30f);
        Font fuentePetit = Fonts.getLightFont(15f);

        panelMusicInfo.setBorder(new EmptyBorder(0, 0, 0, 0));

        titolCancion = new JLabel("Nombre de la canción: " + nom);
        titolCancion.setForeground(UIPalette.TEXT_COLOR.getColor());
        titolCancion.setFont(fuenteTitol);
        c.ipadx = 100;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(20, 0, 20, 0);
        panelMusicInfo.add(titolCancion, c);

        genereCancion = new JLabel("Género: " + genere);
        genereCancion.setForeground(UIPalette.TEXT_COLOR.getColor());
        genereCancion.setFont(fuentePetit);
        c.ipadx = 100;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(20, 0, 20, 0);
        panelMusicInfo.add(genereCancion, c);

        artistCancion = new JLabel("Artista: " + artist);
        artistCancion.setForeground(UIPalette.TEXT_COLOR.getColor());
        artistCancion.setFont(fuentePetit);
        c.ipadx = 100;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(20, 0, 20, 0);
        panelMusicInfo.add(artistCancion, c);

        albumCancion = new JLabel("Álbum: " + album);
        albumCancion.setForeground(UIPalette.TEXT_COLOR.getColor());
        albumCancion.setFont(fuentePetit);
        c.ipadx = 100;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(20, 0, 20, 0);
        panelMusicInfo.add(albumCancion, c);

        ownerCancion = new JLabel("Propietario: " + owner);
        ownerCancion.setForeground(UIPalette.TEXT_COLOR.getColor());
        ownerCancion.setFont(fuentePetit);
        c.ipadx = 100;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(20, 0, 20, 0);
        panelMusicInfo.add(ownerCancion, c);

        lyricsCancion = new JTextPane();
        lyricsCancion.setForeground(UIPalette.TEXT_COLOR.getColor());
        lyricsCancion.setFont(Fonts.getLightFont(20f));
        lyricsCancion.setEditable(false);
        lyricsCancion.setBackground(UIPalette.APP_BACKGROUND.getColor());
        c.ipadx = 100;
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1.0;

        JScrollPane scrollPane = new JScrollPane(lyricsCancion);
        scrollPane.setBackground(UIPalette.APP_BACKGROUND.getColor());
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setPreferredSize(new Dimension(750, 450));
        scrollPane.getViewport().setBackground(UIPalette.APP_BACKGROUND.getColor());
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        panelMusicInfo.add(scrollPane, c);
    }

    public void setSongInfo(String nom, String genere, String artist, String album, String lyrics) {
        this.nom = nom;
        this.genere = genere;
        this.artist = artist;
        this.album = album;

        titolCancion.setText("Nombre de la canción: " + title(nom));
        genereCancion.setText("Género: " + title(genere));
        artistCancion.setText("Artista: " + title(artist));
        albumCancion.setText("Álbum: " + title(album));
        lyricsCancion.setText("Lyrics: \n\n" + lyrics);
    }

    public JPanel getPanelShowSongInfo() {
        return panelMusicInfo;
    }

    public static String title(String text) {
        String[] words = text.split(" ");
        StringBuilder title = new StringBuilder();
        for (String word : words) {
            title.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase()).append(" ");
        }
        return title.toString();
    }
}
