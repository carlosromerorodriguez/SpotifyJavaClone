package presentation.controller;

import business.BusinessLogicSong;
import presentation.view.MusicStatisticsView;

public class MusicStatisticsController {
    private final MusicStatisticsView musicStatisticsView;
    private final BusinessLogicSong businessLogicSong;
    public MusicStatisticsController(MusicStatisticsView musicStatisticsView, BusinessLogicSong businessLogicSong) {
        this.musicStatisticsView = musicStatisticsView;
        this.businessLogicSong = businessLogicSong;
    }

    public void updateData() {
        musicStatisticsView.setData(businessLogicSong.getStatistics());
    }
}
