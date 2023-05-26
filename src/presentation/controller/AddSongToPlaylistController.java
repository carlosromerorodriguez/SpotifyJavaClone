package presentation.controller;

import business.BusinessLogicPlayList;
import business.entities.Song;
import business.exceptions.*;
import presentation.view.ViewsController;
import presentation.view.AddSongToPlaylistView;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSongToPlaylistController implements ActionListener {
    private final BusinessLogicPlayList businessLogicPlayList;
    private final ViewsController viewsController;
    private final AddSongToPlaylistView addSongToPlaylistView;
    public AddSongToPlaylistController(BusinessLogicPlayList businessLogicPlayList, ViewsController viewsController, AddSongToPlaylistView addSongToPlaylistView) {
        this.businessLogicPlayList = businessLogicPlayList;
        this.viewsController = viewsController;
        this.addSongToPlaylistView = addSongToPlaylistView;
        this.addSongToPlaylistView.addSongController(this);
        this.addSongToPlaylistView.getBackButton().addActionListener(e -> viewsController.setPlaylistSongsView());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (AddSongToPlaylistView.ADD_COMMAND.equals(e.getActionCommand())) {
            String title = addSongToPlaylistView.getTitle();
            String genre = addSongToPlaylistView.getGenre();
            String album = addSongToPlaylistView.getAlbum();
            String author = addSongToPlaylistView.getAuthor();
            try {
                businessLogicPlayList.addSongToPlaylist(addSongToPlaylistView.getPlaylistName(), new Song(title, genre, album, author));
            } catch (TitleException ex) {
                addSongToPlaylistView.wrongTitleError();
            } catch (GenreException ex) {
                addSongToPlaylistView.wrongGenreError();
            } catch (AuthorException ex) {
                addSongToPlaylistView.wrongAuthorError();
            } catch (AlbumException ex) {
                addSongToPlaylistView.wrongAlbumError();
            } catch (UrlException ex) {
                addSongToPlaylistView.wrongUrlError();
            }
        }
    }
}