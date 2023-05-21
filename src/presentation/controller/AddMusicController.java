package presentation.controller;

import business.BusinessLogicSong;
import business.exceptions.*;
import presentation.view.AddMusicView;
import presentation.view.ViewsController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMusicController implements ActionListener {
    private final BusinessLogicSong businessLogicSong;
    private final ViewsController viewsController;
    private final AddMusicView addMusicView;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(AddMusicView.ADD_COMMAND)) {
            try {
                businessLogicSong.registerSong(addMusicView.getTitle(), addMusicView.getAuthor(), addMusicView.getAlbum(), addMusicView.getGenre());
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
            }
        }

        if (e.getActionCommand().equals(AddMusicView.BACK_FROM_ADD)){
            viewsController.setListMusicView();
        }
    }

    public AddMusicController(BusinessLogicSong businessLogicSong, ViewsController viewsController, AddMusicView addMusicView) {
        this.businessLogicSong = businessLogicSong;
        this.viewsController = viewsController;
        this.addMusicView = addMusicView;
    }
}