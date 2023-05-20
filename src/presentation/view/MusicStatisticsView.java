package presentation.view;

import presentation.view.Utilities.Fonts;

import java.awt.*;
import java.util.HashMap;
import javax.swing.*;

public class MusicStatisticsView {
    private HashMap<String, Integer> data;

    private final JPanel contentPane;

    public MusicStatisticsView() {
        data = new HashMap<>();
        BarChartPanel chartPanel = new BarChartPanel(data);

        contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        JPanel chart = new JPanel();
        chart.add(chartPanel);
        JLabel titol = new JLabel("Estadistiques.");
        titol.setFont(Fonts.getBoldFont(50f));

        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 0.0;
        contentPane.add(titol, c);
        c.gridy = 1;
        c.weighty = 0.0;
        contentPane.add(chart, c);
    }

    public JPanel getContentPane() {
        return contentPane;
    }

    public void setData(HashMap<String, Integer> statistics) {
        data = statistics;
        contentPane.removeAll();
        contentPane.add(new BarChartPanel(data));
        contentPane.revalidate();
        contentPane.repaint();
    }
}
