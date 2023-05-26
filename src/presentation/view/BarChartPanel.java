package presentation.view;

import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.stream.Collectors;

class BarChartPanel extends JPanel {
    /**
     * The data to display in the bar chart.
     */
    private final HashMap<String, Integer> data;
    /**
     * The maximum number of genres to display.
     */
    private static final int MAX_GENRES = 10;
    /**
     * The height of a bar.
     */
    private static final int BAR_HEIGHT = 15;
    /**
     * The maximum width of a bar. If the number of songs for a genre is greater than this, the bar will be this width
     * and the number of songs will be displayed on the right of the bar.
     */
    private static final int MAX_BAR_WIDTH = 400;
    /**
     * The spacing between the bars.
     */
    private static final int SPACING = 10;
    /**
     * The margin to the left of the bars.
     */
    private static final int MARGIN_LEFT = 100;
    /**
     * The margin to the right of the bars.
     */
    private static final int MARGIN_BOTTOM = 30;
    /**
     * The increment for the y-axis scale.
     */
    private static final int X_AXIS_INCREMENT = 5;

    /**
     * Constructs a new bar chart panel with the given data.
     */
    public BarChartPanel(HashMap<String, Integer> data) {
        this.data = data.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .skip(Math.max(0, data.size() - MAX_GENRES))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e2,
                        LinkedHashMap::new));

        this.setPreferredSize(new Dimension(800, 500 + MARGIN_BOTTOM));
    }

    /**
     * Paints the bar chart on the panel using the data provided in the constructor.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int maxSongs = getMaxSongs();
        int genresToShow = Math.min(data.size(), MAX_GENRES);
        int barSpacing = (getHeight() - genresToShow * BAR_HEIGHT - MARGIN_BOTTOM) / (genresToShow + 1);

        g.setColor(UIPalette.TEXT_COLOR.getColor());
        int maxScale = (maxSongs % 5 == 0) ? maxSongs : (maxSongs / 6) * 5;
        for (int i = 0; i <= maxScale; i += X_AXIS_INCREMENT) {
            int x = MARGIN_LEFT + (int) ((double) i / maxScale * MAX_BAR_WIDTH);
            g.drawLine(x, 0, x, getHeight() - MARGIN_BOTTOM);

            String text = String.valueOf(i);
            FontMetrics fm = g.getFontMetrics();
            int textWidth = fm.stringWidth(text);
            g.drawString(text, x - textWidth / 2, getHeight() - MARGIN_BOTTOM / 2);
        }

        int i = 0;
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            if (i >= genresToShow) {
                break;
            }

            String genre = entry.getKey().toUpperCase();
            int songCount = entry.getValue();
            int barWidth = (int) ((double) songCount / maxScale * MAX_BAR_WIDTH);

            int y = barSpacing * (i + 1) + BAR_HEIGHT * i;

            g.setColor(UIPalette.randomColor());
            g.fillRect(MARGIN_LEFT, y, barWidth, BAR_HEIGHT);

            FontMetrics fm = g.getFontMetrics();
            int genreLabelWidth = fm.stringWidth(genre);
            int genreLabelHeight = fm.getHeight();
            int genreLabelY = y + BAR_HEIGHT / 2 + genreLabelHeight / 2;
            g.setColor(UIPalette.TEXT_COLOR.getColor());
            g.drawString(genre, MARGIN_LEFT - genreLabelWidth - SPACING, genreLabelY);
            g.drawString(String.valueOf(songCount), MARGIN_LEFT + barWidth + SPACING, genreLabelY);

            i++;
        }
        setBackground(UIPalette.COLOR_PRIMARIO.getColor());
    }

    /**
     * Returns the maximum number of songs for a genre.
     */
    private int getMaxSongs() {
        int maxSongs = Integer.MIN_VALUE;
        for (int songCount : data.values()) {
            if (songCount > maxSongs) {
                maxSongs = songCount;
            }
        }
        return maxSongs;
    }
}