package presentation.controller;

import business.BusinessLogicMusic;
import business.BusinessLogicSong;
import persistance.exceptions.*;
import presentation.view.ListMusicView;
import presentation.view.ViewsController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class ListMusicController implements MouseListener {
    BusinessLogicMusic businessLogicMusic;
    ViewsController viewsController;
    ListMusicView listMusicView;

    public ListMusicController(ListMusicView listMusicView, BusinessLogicMusic businessLogicMusic, ViewsController viewsController) {
        this.businessLogicMusic = businessLogicMusic;
        this.listMusicView = listMusicView;
        this.viewsController = viewsController;

        // Add the ListMusicController as the MouseListener for the table
        // For example, in the constructor or initialization method:
        // listMusicView.getTable().addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        JTable table = (JTable) e.getSource();

        int clickedRow = table.rowAtPoint(e.getPoint());
        int clickedColumn = table.columnAtPoint(e.getPoint());

        if(clickedColumn == 0){
            Object value = table.getValueAt(clickedRow, clickedColumn);
            Object genere_obj = table.getValueAt(clickedRow, clickedColumn + 1);
            Object artist_obj = table.getValueAt(clickedRow, clickedColumn + 2);
            Object album_obj = table.getValueAt(clickedRow, clickedColumn + 3);

            if (value != null) {
                String nom = value.toString();
                String genere = genere_obj.toString();
                String artist = artist_obj.toString();
                String album = album_obj.toString();
                System.out.println("Clicked cell value: " + nom +" "+ genere +" "+ artist +" "+ album);
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