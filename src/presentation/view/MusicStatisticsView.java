package presentation.view;

import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.UIPalette;

import java.awt.*;
import java.util.HashMap;
import javax.swing.*;

public class MusicStatisticsView {
    private HashMap<String, Integer> data;

    private final JPanel contentPane;

    /**
     * Constructor de la vista de estadísticas.
     */
    public MusicStatisticsView() {
        data = new HashMap<>();

        contentPane = new JPanel();
        contentPane.setBackground(UIPalette.COLOR_PRIMARIO.getColor());
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        JPanel chart = new JPanel();
        JLabel titol = new JLabel("Estadistiques");
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

    /**
     * Actualitza les dades de la vista.
     * @param statistics Dades a mostrar.
     */
    public void setData(HashMap<String, Integer> statistics) {
        data = statistics;
        contentPane.removeAll();
        contentPane.setBackground(UIPalette.COLOR_PRIMARIO.getColor());
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        JLabel titol = new JLabel("Estadistiques");
        titol.setForeground(UIPalette.TEXT_COLOR.getColor());
        titol.setFont(Fonts.getBoldFont(50f));

        c.gridx = 0;
        c.gridy = 0;
        c.weighty = 0.0;
        c.insets = new Insets(20, 0, 20, 0);
        contentPane.add(titol, c);
        c.gridy = 1;
        c.weighty = 0.0;
        c.insets = new Insets(0, 0, 0, 0);
        contentPane.add(new BarChartPanel(data), c);
        contentPane.revalidate();
        contentPane.repaint();
    }
}
