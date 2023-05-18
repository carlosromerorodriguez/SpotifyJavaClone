package presentation.view;

import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

class BarChartPanel extends JPanel {
    private final HashMap<String, Integer> data;
    private static final int MAX_GENRES = 10;
    private static final int BAR_HEIGHT = 15;
    private static final int MAX_BAR_WIDTH = 400; // Maximum width for the bars
    private static final int SPACING = 10; // Spacing between genre label and bar

    public BarChartPanel(HashMap<String, Integer> data) {
        this.data = data;
        this.setPreferredSize(new Dimension(800, 500));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int maxSongs = getMaxSongs();
        int genresToShow = Math.min(data.size(), MAX_GENRES);
        int barSpacing = (getHeight() - genresToShow * BAR_HEIGHT) / (genresToShow + 1);

        int i = 0;
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            if (i >= genresToShow) {
                break;
            }

            String genre = entry.getKey().toUpperCase();
            int songCount = entry.getValue();
            int barWidth = (int) ((double) songCount / maxSongs * MAX_BAR_WIDTH);

            int x = barSpacing;
            int y = barSpacing * (i + 1) + BAR_HEIGHT * i;

            g.setColor(UIPalette.randomColor());
            g.fillRect(x, y, barWidth, BAR_HEIGHT);

            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(songCount), x + barWidth + SPACING, y + BAR_HEIGHT - 5);

            FontMetrics fm = g.getFontMetrics();
            int genreLabelWidth = fm.stringWidth(genre);
            int genreLabelHeight = fm.getHeight();
            int genreLabelY = y + BAR_HEIGHT / 2 + genreLabelHeight / 2;
            g.drawString(genre, x - genreLabelWidth - SPACING, genreLabelY);

            i++;
        }
    }

    private int getMaxSongs() {
        int maxSongs = Integer.MIN_VALUE;
        for (int songCount : data.values()) {
            if (songCount > maxSongs) {
                maxSongs = songCount;
            }
        }
        return maxSongs;
    }

    public JPanel getPanel() {
        return this;
    }
}