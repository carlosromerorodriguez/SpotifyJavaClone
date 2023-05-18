package presentation.view;

import business.BusinessLogicMusic;
import business.entities.Music;
import business.entities.Song;
import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import java.awt.*;

import static presentation.view.Utilities.UIPalette.ADD_SONG_COLOR;


public class ListMusicView extends JFrame {
    //JFrame ventana = new JFrame("Lista de canciones");
    JPanel panel_list;
    public ListMusicView (BusinessLogicMusic businessLogicMusic) {
        panel_list = new JPanel(new GridBagLayout());
        panel_list.setBackground(ADD_SONG_COLOR.getColor());
        Music music = businessLogicMusic.listMusic();
        GridBagConstraints c = new GridBagConstraints();

        Font fuente_titol = Fonts.getBoldFont(50f);
        Font fuente_petit = Fonts.getLightFont(15f);

        JLabel title = new JLabel("Cançons");
        title.setForeground(UIPalette.TEXT_COLOR.getColor());
        title.setFont(fuente_titol);
        c.ipadx = 100;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(50, 0, 0, 525);
        panel_list.add(title, c);

        int i = 1;
        //JTable
        for (Song s:music.getArraySongs()) {
            System.out.println(s.getTitle());
            String print = s.getTitle() + " - " + s.getGenre() + " - "+s.getAuthor()+" - "+s.getAlbum();
            JLabel song = new JLabel("* "+print);
            song.setForeground(UIPalette.TEXT_COLOR.getColor());
            song.setFont(fuente_petit);
            c.ipady = 0;
            c.gridx = 0;
            c.gridy = i;
            c.gridheight = 1;
            c.gridwidth = 1;
            c.insets = new Insets(0, 0, 10, 0);
            panel_list.add(song, c);
            i++;
        }
        c.ipady = 0;
        c.weighty = 0.2;
        c.gridx = 0;
        c.gridy = 11;
        c.anchor = GridBagConstraints.CENTER;
        panel_list.add(new JLabel(), c);
    }

    public JPanel getPanel_list() {
        return panel_list;
    }
}