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

public class ListMusicView extends JFrame {
    private final JPanel panelList;
    private final JTable table;
    private final DefaultTableModel tableModel;
    private final JButton optionsButton;
    private ListMusicViewListener listener;

    public ListMusicView() {
        panelList = new JPanel(new GridBagLayout());
        panelList.setBackground(UIPalette.COLOR_PRIMARIO.getColor());
        GridBagConstraints c = new GridBagConstraints();

        Font fuente_titulo = Fonts.getBoldFont(50f);
        Font fuente_normal = Fonts.getLightFont(15f);

        JLabel title = new JLabel("Canciones");
        title.setForeground(UIPalette.TEXT_COLOR.getColor());
        title.setFont(fuente_titulo);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 0, 500);
        panelList.add(title, c);

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
        panelList.add(optionsButton, c);

        // JTable
        tableModel = new DefaultTableModel(new Object[]{"Título", "Género", "Autor", "Álbum", "Propietario"}, 0);

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

    public void setSongs(List<Song> songs, String owner) {
        tableModel.setRowCount(0);
        for (Song song : songs) {
            Object[] rowData = {title(song.getTitle()), title(song.getGenre()), title(song.getAuthor()), title(song.getAlbum()), owner};
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

    public JButton getOptionsButton() {
        return optionsButton;
    }

    public JPanel getPanelList() {
        return panelList;
    }

    public void actionLinker(MouseListener mouseListener){
        table.addMouseListener(mouseListener);
    }

    public void setListener(ListMusicViewListener listener) {
        this.listener = listener;
    }

    public void showOptionsDialog() {
        String[] options = {"Añadir música", "Eliminar música"};
        int choice = JOptionPane.showOptionDialog(this, "Seleccione una opción", "Opciones Música", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        if (choice == 0 && listener != null) {
            listener.onAddMusic();
        } else if (choice == 1 && listener != null) {
            listener.onDeleteMusic();
        }
    }
}