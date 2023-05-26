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
    private final ListMusicView listMusicView;

    public ListMusicController(BusinessLogicMusic businessLogicMusic, ViewsController viewsController, ListMusicView listMusicView, ShowMusicInfoView showMusicInfoView) {
        this.viewsController = viewsController;
        this.businessLogicMusic = businessLogicMusic;
        this.showMusicInfoView = showMusicInfoView;
        this.listMusicView = listMusicView;
        listMusicView.setListener(this);
        listMusicView.addMouseListener(this);
        listMusicView.getOptionsButton().addActionListener(e -> listMusicView.showOptionsDialog());
        loadSongsFromApi();
    }

    public void loadSongsFromApi() {
        listMusicView.setSongs(businessLogicMusic.listMusic(), "Hola");
    }

    @Override
    public void onAddMusic() {
        viewsController.setAddMusicView();
    }

    @Override
    public void onDeleteMusic() {
        viewsController.setDeleteMusicView();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JTable table = (JTable) e.getSource();
        int clickedRow = getClickedRow(e, table);
        int clickedColumn = getClickedColumn(e, table);

        if (clickedColumn == 0){
            processTableCells(clickedRow, clickedColumn, table);
        }
    }

    private int getClickedRow(MouseEvent e, JTable table) {
        return table.rowAtPoint(e.getPoint());
    }

    private int getClickedColumn(MouseEvent e, JTable table) {
        return table.columnAtPoint(e.getPoint());
    }

    private void processTableCells(int clickedRow, int clickedColumn, JTable table) {
        Object value = table.getValueAt(clickedRow, clickedColumn);
        Object genreObjString = table.getValueAt(clickedRow, clickedColumn + 1);
        Object artistObjString = table.getValueAt(clickedRow, clickedColumn + 2);
        Object albumObjString = table.getValueAt(clickedRow, clickedColumn + 3);

        if (value != null) {
            extractAndProcessSongInfo(value, genreObjString, artistObjString, albumObjString);
        }
    }

    private void extractAndProcessSongInfo(Object value, Object genreObjString, Object artistObjString, Object albumObjString) {
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
    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}