package presentation.view;

import business.entities.Song;
import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;

public class PlaylistSongsView extends JFrame {
    private final JPanel panelList;
    private final JTable table;
    private final DefaultTableModel tableModel;
    private final JLabel noSongsLabel;

    private final JButton optionsButton;
    private PlaylistSongsViewListener listener;
    private String playlistName;
    private JButton sortAlphaButton;
    private JButton sortByUserButton;

    public PlaylistSongsView() {
        panelList = new JPanel(new GridBagLayout());
        panelList.setBackground(UIPalette.COLOR_PRIMARIO.getColor());
        GridBagConstraints c = new GridBagConstraints();

        Font lightFont = Fonts.getLightFont(15f);

        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 0, 500);

        // JTable
        tableModel = new DefaultTableModel(new Object[]{"Título", "Género", "Autor", "Álbum", "Owner"}, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        ImageIcon icon = new ImageIcon("data/img/boton_mas.png");
        Image img = icon.getImage();

        optionsButton = new JButton(new ImageIcon(img.getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH)));
        optionsButton.setPreferredSize(new Dimension(35, 35));
        optionsButton.setContentAreaFilled(false);
        optionsButton.setFocusPainted(false);
        optionsButton.setBorderPainted(false);
        optionsButton.setOpaque(false);

        // Configuración de los botones de ordenación
        sortAlphaButton = new JButton("Ordenar Alfabéticamente");
        sortAlphaButton.setBackground(UIPalette.TEXT_COLOR.getColor());
//sortAlphaButton.addActionListener(e -> sortSongsAlphabetically());

        sortByUserButton = new JButton("Ordenar por Usuario");
        sortByUserButton.setBackground(UIPalette.TEXT_COLOR.getColor());

        JPanel sortButtonsPanel = new JPanel();
        sortButtonsPanel.add(sortAlphaButton);
        sortButtonsPanel.add(sortByUserButton);

        GridBagConstraints sortButtonsConstraints = new GridBagConstraints();
        sortButtonsConstraints.gridx = 0;
        sortButtonsConstraints.gridy = 0;
        sortButtonsConstraints.gridwidth = 2;
        sortButtonsConstraints.insets = new Insets(0, 0, 20, 0);

        panelList.add(sortButtonsPanel, sortButtonsConstraints);


        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.anchor = GridBagConstraints.NORTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.0;
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(5, 5, 10, 100);
        panelList.add(optionsButton, gridBagConstraints);


        table = new JTable(tableModel);
        table.setFont(lightFont);
        table.setBackground(UIPalette.COLOR_PRIMARIO.getColor());
        table.setForeground(UIPalette.TEXT_COLOR.getColor());
        table.setGridColor(UIPalette.TEXT_COLOR.getColor());
        table.setFont(Fonts.getMediumFont(15f));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setFont(lightFont);
        table.getTableHeader().setForeground(UIPalette.INPUT_TEXT.getColor());
        table.getTableHeader().setBackground(UIPalette.JTABLE_TEXT_COLOR.getColor());
        table.setRowHeight(100);
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBackground(UIPalette.COLOR_PRIMARIO.getColor());
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setPreferredSize(new Dimension(750, 450));
        scrollPane.getViewport().setBackground(UIPalette.ADD_SONG_COLOR.getColor());
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.insets = new Insets(10, 50, 0, 50);
        panelList.add(scrollPane, c);

        // Creación de la etiqueta "No hay canciones"
        noSongsLabel = new JLabel("No hay canciones en la playlist. ¡Añade algunas!");
        noSongsLabel.setFont(lightFont);
        noSongsLabel.setForeground(UIPalette.TEXT_COLOR.getColor());
        noSongsLabel.setHorizontalAlignment(JLabel.CENTER);
        noSongsLabel.setVisible(false);

        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;
        panelList.add(noSongsLabel, c);

        TableColumnModel columnModel = table.getColumnModel();
        int columnCount = columnModel.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            columnModel.getColumn(i).setPreferredWidth(800);
        }

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);
    }

    public JButton getSortAlphaButton() {
        return sortAlphaButton;
    }

    public JButton getSortByUserButton() {
        return sortByUserButton;
    }

    public void addTableMouseListener(MouseListener mouseListener){
        table.addMouseListener(mouseListener);
    }

    public void setSongs(List<Song> songs) {
        SwingUtilities.invokeLater(() -> {
            tableModel.setRowCount(0);
            for (Song song : songs) {
                Object[] rowData = {title(song.getTitle()), title(song.getGenre()), title(song.getAuthor()), title(song.getAlbum()), title(song.getOwner())};
                tableModel.addRow(rowData);
            }
            noSongsLabel.setVisible(tableModel.getRowCount() == 0);
            table.repaint();
            table.revalidate();
        });
    }

    private static String title(String text) {
        String[] words = text.split(" ");
        StringBuilder title =         new StringBuilder();
        for (String word : words) {
            title.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase()).append(" ");
        }
        return title.toString().trim();
    }

    public JPanel getPanelList() {
        return panelList;
    }

    public void setListener(PlaylistSongsViewListener listener) {
        this.listener = listener;
    }

    public void showOptionsDialog() {
        String[] options = {"Add song", "Delete song"};
        int choice = JOptionPane.showOptionDialog(this, "Choose an option", "Playlist's options", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        if (choice == 0 && listener != null) {
            listener.onAddSong();
        } else if (choice == 1 && listener != null) {
            listener.onDeleteSong();
        }
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public JButton getOptionsButton() {
        return optionsButton;
    }

    public void setPlaylistName(String selectedPlaylistName) {
        this.playlistName = selectedPlaylistName;
    }

    public JTable getTable() {
        return table;
    }

    public void deactivateAddButton(boolean b) {
        optionsButton.setEnabled(b);
    }
}
