package presentation.view;

import business.BusinessLogicMusic;
import business.entities.Music;
import business.entities.Song;
import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.List;

public class ListMusicView extends JFrame {
    private final JPanel panel_list;

    public ListMusicView(BusinessLogicMusic businessLogicMusic) {
        panel_list = new JPanel(new GridBagLayout());
        panel_list.setBackground(UIPalette.ADD_SONG_COLOR.getColor());
        Music music = businessLogicMusic.listMusic();
        GridBagConstraints c = new GridBagConstraints();

        Font fuente_titulo = Fonts.getBoldFont(50f);
        Font fuente_normal = Fonts.getLightFont(15f);

        JLabel title = new JLabel("Canciones");
        title.setForeground(UIPalette.JTABLE_TEXT_COLOR.getColor());
        title.setFont(fuente_titulo);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(50, 0, 0, 0);
        panel_list.add(title, c);

        // JTable
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Título", "Género", "Autor", "Álbum"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(tableModel);
        table.setFont(fuente_normal);
        table.setForeground(UIPalette.JTABLE_TEXT_COLOR.getColor());
        table.setGridColor(UIPalette.JTABLE_TEXT_COLOR.getColor());
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setFont(fuente_normal);
        table.getTableHeader().setForeground(UIPalette.INPUT_TEXT.getColor());
        table.getTableHeader().setBackground(UIPalette.JTABLE_TEXT_COLOR.getColor());
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getViewport().setBackground(UIPalette.ADD_SONG_COLOR.getColor());

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.insets = new Insets(10, 50, 0, 50);
        panel_list.add(scrollPane, c);

        List<Song> songs = music.getArraySongs();
        for (Song song : songs) {
            Object[] rowData = {song.getTitle(), song.getGenre(), song.getAuthor(), song.getAlbum()};
            tableModel.addRow(rowData);
        }

        TableColumnModel columnModel = table.getColumnModel();
        int columnCount = columnModel.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            columnModel.getColumn(i).setPreferredWidth(200);
        }

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);
    }

    public JPanel getPanel_list() {
        return panel_list;
    }
}