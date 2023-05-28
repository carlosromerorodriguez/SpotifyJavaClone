package presentation.view;

import business.entities.Playlist;
import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.ArrayList;
/**
 * PlaylistView class
 */
public class PlaylistView extends JFrame {
    private ArrayList<Playlist> data;
    private final JPanel contentPane;
    private final JTable table;
    private final DefaultTableModel tableModel;
    private final JButton optionsButton;
    private PlayListViewListener playListViewListener;

    /**
     * Constructor de la vista de playlists.
     */
    public PlaylistView() {
        data = new ArrayList<>();

        contentPane = new JPanel(new GridBagLayout());
        contentPane.setBackground(UIPalette.COLOR_PRIMARIO.getColor());
        GridBagConstraints c = new GridBagConstraints();

        Font fuente_titulo = Fonts.getBoldFont(50f);
        Font fuente_normal = Fonts.getLightFont(15f);

        JLabel titol = new JLabel("Playlists");
        titol.setFont(fuente_titulo);
        titol.setForeground(UIPalette.TEXT_COLOR.getColor());
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.weighty = 0.0;
        c.insets = new Insets(0, 0, 0, 500);
        contentPane.add(titol, c);

        ImageIcon icon = new ImageIcon("data/img/boton_mas.png");
        Image img = icon.getImage();
        optionsButton = new JButton(new ImageIcon(img.getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH)));
        optionsButton.setPreferredSize(new Dimension(35, 35));
        optionsButton.setContentAreaFilled(false);
        optionsButton.setFocusPainted(false);
        optionsButton.setBorderPainted(false);
        optionsButton.setOpaque(false);
        c.anchor = GridBagConstraints.NORTHEAST;
        c.weightx = 1.0;
        c.weighty = 0.0;
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(5, 5, 10, 100);
        contentPane.add(optionsButton, c);

        tableModel = new DefaultTableModel(new Object[]{"Nombre", "Creador"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(tableModel);
        table.setFont(fuente_normal);
        table.setBackground(UIPalette.COLOR_PRIMARIO.getColor());
        table.setForeground(UIPalette.TEXT_COLOR.getColor());
        table.setGridColor(UIPalette.TEXT_COLOR.getColor());
        table.setFont(Fonts.getMediumFont(15f));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.getTableHeader().setFont(fuente_normal);
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
        contentPane.add(scrollPane, c);
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
     * Getter de la vista.
     * @return JPanel de la vista.
     */
    public JPanel getContentPane() {
        return contentPane;
    }

    /**
     * Devuelve la playlist seleccionada.
     * @return String con el nombre de la playlist.
     */
    public String getSelectedPlaylistName() {
        int row = table.getSelectedRow();
        if (row == -1) {
            return null;
        }
        return (data.get(row).name());
    }

    /**
     * Setea los datos de la playlist.
     * @param playlists ArrayList con las playlists.
     */
    public void setData(ArrayList<Playlist> playlists) {
        data = playlists;
        tableModel.setRowCount(0);

        for (Playlist playlist : data) {
            Object[] rowData = {title(playlist.name()), title(playlist.owner())};
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
     * Getter del boton de opciones.
     * @return JButton de opciones.
     */
    public JButton getOptionsButton() {
        return optionsButton;
    }

    /**
     * Setea el listener de la vista.
     * @param playListViewListener Listener de la vista.
     */
    public void setListener(PlayListViewListener playListViewListener) {
        this.playListViewListener = playListViewListener;
    }

    /**
     * Dialogo de opciones de playlist.
     */
    public void showOptionsDialog() {
        String[] options = {"Crear playlist", "Eliminar playlist"};
        int choice = JOptionPane.showOptionDialog(contentPane, "Seleccione una opción", "Opciones Playlist", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (choice == 0 && playListViewListener != null) {
            playListViewListener.onAddPlaylist();
        } else if (choice == 1 && playListViewListener != null) {
            playListViewListener.onDeletePlaylist();
        }
    }

    /**
     * Getter de la tabla.
     * @return JTable de la vista.
     */
    public Component getTable() {
        return table;
    }
}
