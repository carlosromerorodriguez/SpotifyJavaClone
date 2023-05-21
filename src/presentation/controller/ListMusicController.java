package presentation.controller;

import business.BusinessLogicMusic;
import presentation.view.ListMusicView;
import presentation.view.ListMusicViewListener;
import presentation.view.ShowMusicInfoView;
import presentation.view.ViewsController;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ListMusicController implements MouseListener, ListMusicViewListener {
    private final ViewsController viewsController;
    private final ShowMusicInfoView showMusicInfoView;
    private final BusinessLogicMusic businessLogicMusic;

    public ListMusicController(BusinessLogicMusic businessLogicMusic, ViewsController viewsController, ListMusicView listMusicView, ShowMusicInfoView showMusicInfoView) {
        this.viewsController = viewsController;
        this.businessLogicMusic = businessLogicMusic;
        this.showMusicInfoView = showMusicInfoView;
        listMusicView.setListener(this);
        listMusicView.addMouseListener(this);
        showAllSongs(listMusicView);
        listMusicView.getOptionsButton().addActionListener(e -> listMusicView.showOptionsDialog());
    }

    private void showAllSongs(ListMusicView listMusicView) {
        listMusicView.setSongs(businessLogicMusic.listMusic(), "Hola");
    }

    @Override
    public void onAddMusic() {
        viewsController.setAddMusicView();
    }

    @Override
    public void onDeleteMusic() {
        System.out.println("Eliminar música");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JTable table = (JTable) e.getSource();

        int clickedRow = table.rowAtPoint(e.getPoint());
        int clickedColumn = table.columnAtPoint(e.getPoint());

        if (clickedColumn == 0){
            Object value = table.getValueAt(clickedRow, clickedColumn);
            Object genreObjString = table.getValueAt(clickedRow, clickedColumn + 1);
            Object artistObjString = table.getValueAt(clickedRow, clickedColumn + 2);
            Object albumObjString = table.getValueAt(clickedRow, clickedColumn + 3);

            if (value != null) {
                String nom = value.toString();
                String genre = genreObjString.toString().toLowerCase();
                String artist = artistObjString.toString();
                String album = albumObjString.toString().toLowerCase();

                try {
                    showMusicInfoView.setSongInfo(nom, genre, artist, album,
                            businessLogicMusic.getMusicLyricsFromApi(nom.toLowerCase().replace(" ", "%20"),
                                                                     artist.toLowerCase().replace(" ", "%20")));
                    viewsController.showMusicInfo();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }

    }
    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}