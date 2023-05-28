package presentation.view;

import business.entities.Song;
import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.List;
/**
 * AddSongToPlaylistView class
 */
public class AddSongToPlaylistView extends JFrame {
    private final JPanel panelList;
    private final JTable table;
    private final DefaultTableModel tableModel;
    private String playlistName;

    /**
     * Constructor de la la vista de añadir cancion a playlist
     */
    public AddSongToPlaylistView() {
        panelList = new JPanel(new GridBagLayout());
        panelList.setBackground(UIPalette.COLOR_PRIMARIO.getColor());
        GridBagConstraints c = new GridBagConstraints();

        Font lightFont = Fonts.getLightFont(15f);

        // JTable
        tableModel = new DefaultTableModel(new Object[]{"Título", "Género", "Autor", "Álbum", "Owner"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

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
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(10, 50, 60, 50);
        panelList.add(scrollPane, c);

        TableColumnModel columnModel = table.getColumnModel();
        int columnCount = columnModel.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            columnModel.getColumn(i).setPreferredWidth(800);
        }

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);
    }

    /**
     * Método para actualizar la tabla de canciones
     *
     * @param songs Lista de canciones
     */
    public void setSongs(List<Song> songs) {
        tableModel.setRowCount(0);
        for (Song song : songs) {
            Object[] rowData = {title(song.getTitle()), title(song.getGenre()), title(song.getAuthor()), title(song.getAlbum()), title(song.getOwner())};
            tableModel.addRow(rowData);
        }
    }

    private static String title(String text) {
        String[] words = text.split(" ");
        StringBuilder title = new StringBuilder();
        for (String word : words) {
            title.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase()).append(" ");
        }
        return title.toString().trim();
    }

    /**
     * Método para obtener el panel de la lista de canciones
     * @return panel de la lista de canciones
     */
    public JPanel getPanelList() {
        return panelList;
    }


    /**
     * Link de la tabla con el controlador
     * @param mouseListener controlador de la tabla
     */
    public void actionLinker(MouseListener mouseListener){
        table.addMouseListener(mouseListener);
    }

    /**
     * Setter del nombre de la playlist
     * @param playlistName nombre de la playlist
     */
    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    /**
     * Getter del nombre de la playlist
     * @return nombre de la playlist
     */
    public String getPlaylistName() {
        return playlistName;
    }

    /**
     * Método para mostrar un error de canción duplicada
     */
    public void showDuplicateSongError() {
        JOptionPane.showMessageDialog(this, "La canción ya está en la playlist", "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Método para mostrar un mensaje de canción añadida
     */
    public void showSongAddedToPlaylist() {
        JOptionPane.showMessageDialog(this, "Canción añadida a la playlist", "Canción añadida", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método para mostrar un error de canción no seleccionada
     */
    public void showSongNotSelectedError() {
        JOptionPane.showMessageDialog(this, "Selecciona una canción", "Error", JOptionPane.ERROR_MESSAGE);
    }
}