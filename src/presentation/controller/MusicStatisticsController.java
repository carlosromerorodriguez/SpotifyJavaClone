package presentation.controller;

import business.BusinessLogicSong;
import presentation.view.MusicStatisticsView;
/**
 * Music statistics controller class
 */
public class MusicStatisticsController {
    private final MusicStatisticsView musicStatisticsView;
    private final BusinessLogicSong businessLogicSong;

    /**
     * Music statistics controller
     * @param musicStatisticsView music statistics view
     * @param businessLogicSong business logic song
     */
    public MusicStatisticsController(MusicStatisticsView musicStatisticsView, BusinessLogicSong businessLogicSong) {
        this.musicStatisticsView = musicStatisticsView;
        this.businessLogicSong = businessLogicSong;
    }

    /**
     * Update data in the view
     */
    public void updateData() {
        musicStatisticsView.setData(businessLogicSong.getStatistics());
    }
}
