package presentation.view;

import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import java.awt.*;

class BarChartPanel extends JPanel {
    private final int[] data;
    private static final int BAR_WIDTH = 5; // Width of each bar
    private static final int BORDER_RADIUS = 25; // Border radius for rounded corners

    public BarChartPanel(int[] data) {
        this.data = data;
        this.setPreferredSize(new Dimension(800, 500));
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        int barHeight = getHeight() / data.length - 10; // Adjusted bar height
        int maxValue = getMaxValue();

        for (int i = 0; i < data.length; i++) {
            int value = data[i];
            int barWidth = (int) ((double) value / maxValue * getWidth());

            int x = 50;
            int y = i * (barHeight - 50); // Adjusted y-coordinate

            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(value), 10, y + barHeight -80);

            g.setColor(UIPalette.randomColor());
            g.fillRoundRect(x, y, barWidth - 100, barHeight -80, BORDER_RADIUS, 0);

        }
    }

    private int getMaxValue() {
        int maxValue = Integer.MIN_VALUE;
        for (int value : data) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    public JPanel getPanel(){
        return this;
    }
}
