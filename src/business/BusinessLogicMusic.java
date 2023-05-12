package business;

import business.entities.Music;
import business.entities.Song;
import persistance.SongDAO;
import persistance.exceptions.*;

public class BusinessLogicMusic {
    SongDAO songDAO;

    public BusinessLogicMusic(SongDAO songDAO) {this.songDAO = songDAO;}

    public Music listMusic(){return songDAO.readSongList();}
}
