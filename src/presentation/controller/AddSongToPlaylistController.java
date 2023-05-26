package presentation.controller;

import business.BusinessLogicMusic;
import business.BusinessLogicPlayList;
import business.entities.Song;
import business.exceptions.*;
import persistance.exceptions.DuplicateKeyException;
import presentation.view.AddSongToPlaylistView;
import presentation.view.ViewsController;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddSongToPlaylistController implements MouseListener {
    private final ViewsController viewsController;
    private final BusinessLogicMusic businessLogicMusic;
    private final AddSongToPlaylistView addSongToPlaylistView;
    private final BusinessLogicPlayList businessLogicPlayList;

    public AddSongToPlaylistController(BusinessLogicMusic businessLogicMusic, BusinessLogicPlayList businessLogicPlayList, ViewsController viewsController, AddSongToPlaylistView addSongToPlaylistView) {
        this.viewsController = viewsController;
        this.businessLogicMusic = businessLogicMusic;
        this.addSongToPlaylistView = addSongToPlaylistView;
        this.businessLogicPlayList = businessLogicPlayList;
        addSongToPlaylistView.actionLinker(this);
    }

    public void loadSongsFromApi() {
        addSongToPlaylistView.setSongs(businessLogicMusic.listMusic());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JTable table = (JTable) e.getSource();
        int clickedRow = getClickedRow(e, table);
        int clickedColumn = getClickedColumn(e, table);

        if (clickedColumn == 0) {
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
        Object titleObj = table.getValueAt(clickedRow, clickedColumn);
        Object genreObj = table.getValueAt(clickedRow, clickedColumn + 1);
        Object authorObj = table.getValueAt(clickedRow, clickedColumn + 2);
        Object albumObj = table.getValueAt(clickedRow, clickedColumn + 3);
        Object ownerObj = table.getValueAt(clickedRow, clickedColumn + 4);

        if (titleObj != null && genreObj != null && authorObj != null && albumObj != null && ownerObj != null) {
            addSongToPlaylist(titleObj.toString(), genreObj.toString(), authorObj.toString(), albumObj.toString(), ownerObj.toString());
        } else {
            addSongToPlaylistView.showSongNotSelectedError();
        }

    }

    private void addSongToPlaylist(String title, String genre, String author, String album, String owner) {
        try {
            businessLogicPlayList.addSongToPlaylist(addSongToPlaylistView.getPlaylistName(), new Song(title, genre, author, album, owner));
            addSongToPlaylistView.showSongAddedToPlaylist();
        } catch (DuplicateKeyException e) {
            addSongToPlaylistView.showDuplicateSongError();
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