package presentation.controller;

import business.BusinessLogicSong;
import business.exceptions.TitleException;
import presentation.view.DeleteMusicView;
import presentation.view.ViewsController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteMusicController implements ActionListener {
    private final DeleteMusicView deleteMusicView;
    private final ViewsController viewsController;
    private final BusinessLogicSong businessLogicSong;
    private final ListMusicController listMusicController;

    /**
     * Delete music controller
     * @param deleteMusicView delete music view
     * @param businessLogicSong business logic song
     * @param viewsController views controller
     * @param listMusicController list music controller
     */
    public DeleteMusicController(DeleteMusicView deleteMusicView, BusinessLogicSong businessLogicSong, ViewsController viewsController, ListMusicController listMusicController) {
        this.deleteMusicView = deleteMusicView;
        this.businessLogicSong = businessLogicSong;
        this.viewsController = viewsController;
        this.listMusicController = listMusicController;
        deleteMusicView.backButtonListener(this);
    }

    /**
     *  Action performed
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(DeleteMusicView.DELETE_COMMAND)) {
            String command = deleteMusicView.confirmDelete();
            if (command.equals(DeleteMusicView.CONFIRM_COMMAND)) {
                try {
                   if (businessLogicSong.deleteSong(deleteMusicView.getTitle())) {
                       deleteMusicView.successfulDelete();
                   } else {
                       deleteMusicView.unsuccessfulDelete();
                   }
                   viewsController.setListMusicView();
                   listMusicController.loadSongsFromApi();
                } catch (TitleException ex) {
                    deleteMusicView.wrongTitleError();
                }
            } else if (command.equals(DeleteMusicView.BACK_FROM_DELETE)) {
                viewsController.setDeleteMusicView();
            }
        } else if (e.getActionCommand().equals(DeleteMusicView.BACK_FROM_DELETE)){
            viewsController.setListMusicView();
        }
    }
}