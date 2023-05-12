package presentation.controller;

import business.BusinessLogicSong;
import business.exceptions.TitleException;
import persistance.exceptions.*;
import presentation.view.DeleteMusicView;
import presentation.view.ViewsController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteMusicController implements ActionListener {
    private final DeleteMusicView deleteMusicView;
    private ViewsController viewsController;
    private final BusinessLogicSong businessLogicSong;

    public DeleteMusicController(DeleteMusicView deleteMusicView, BusinessLogicSong businessLogicSong) {
        this.deleteMusicView = deleteMusicView;
        this.businessLogicSong = businessLogicSong;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(DeleteMusicView.DELETE_COMMAND)) {
            String command = deleteMusicView.confirmDelete();
            if (command.equals(DeleteMusicView.CONFIRM_COMMAND)) {
                try {
                    businessLogicSong.deleteSong(deleteMusicView.getTitle());
                } catch (TitleException ex) {
                    deleteMusicView.wrongTitleError();
                }
            } else if (command.equals(DeleteMusicView.BACK_FROM_DELETE)) {
                viewsController.setDeleteMusicView();
            }
        }
        if(e.getActionCommand().equals(DeleteMusicView.BACK_FROM_DELETE)){
            viewsController.setDeleteMusicView();
        }
    }
}