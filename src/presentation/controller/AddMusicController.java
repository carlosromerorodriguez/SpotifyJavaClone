package presentation.controller;

import business.BusinessLogicSong;
import business.exceptions.*;
import persistance.exceptions.RepeatedSongNameException;
import presentation.view.AddMusicView;
import presentation.view.ViewsController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMusicController implements ActionListener {
    private final BusinessLogicSong businessLogicSong;
    private final ViewsController viewsController;
    private final AddMusicView addMusicView;
    private final ListMusicController listMusicController;

    /**
     * Add music controller
     * @param businessLogicSong business logic song
     * @param viewsController views controller
     * @param addMusicView add music view
     * @param listMusicController list music controller
     */
    public AddMusicController(BusinessLogicSong businessLogicSong, ViewsController viewsController, AddMusicView addMusicView, ListMusicController listMusicController) {
        this.businessLogicSong = businessLogicSong;
        this.viewsController = viewsController;
        this.addMusicView = addMusicView;
        this.listMusicController = listMusicController;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(AddMusicView.ADD_COMMAND)) {
            try {
                if (businessLogicSong.registerSong(addMusicView.getTitle(), addMusicView.getGenre(), addMusicView.getAlbum(), addMusicView.getAuthor(), addMusicView.getFile())) {
                    addMusicView.successfulAdd();
                } else {
                    addMusicView.unsuccessfulAdd();
                }
                viewsController.setListMusicView();
                listMusicController.loadSongsFromApi();
            } catch (UrlException ex) {
                addMusicView.wrongUrlError();
            } catch (TitleException ex) {
                addMusicView.wrongTitleError();
            } catch (AuthorException ex) {
                addMusicView.wrongAuthorError();
            } catch (AlbumException ex) {
                addMusicView.wrongAlbumError();
            } catch (GenreException ex) {
                addMusicView.wrongGenreError();
            } catch (RepeatedSongNameException ex) {
                addMusicView.repeatedSongNameError();
            }
        }
        if (e.getActionCommand().equals(AddMusicView.BACK_FROM_ADD)){
            viewsController.setListMusicView();
        }
    }
}