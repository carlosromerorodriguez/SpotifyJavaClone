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
/**
 * ListMusicView class
 */
public class ListMusicView extends JFrame {
    private final JPanel panelList;
    private final JTable table;
    private final JTextField searchField;
    private final DefaultTableModel tableModel;
    private final JButton optionsButton;
    private ListMusicViewListener listener;

    /**
     * Constructor de la vista del repertorio de canciones
     */
    public ListMusicView() {
        panelList = new JPanel(new GridBagLayout());
        panelList.setBackground(UIPalette.COLOR_PRIMARIO.getColor());
        GridBagConstraints c = new GridBagConstraints();

        Font boldFont = Fonts.getBoldFont(50f);
        Font lightFont = Fonts.getLightFont(15f);

        searchField = new JTextField();
        searchField.setFont(Fonts.getBoldFont(20f));
        searchField.setPreferredSize(new Dimension(400, 30));
        searchField.setBackground(UIPalette.COLOR_PRIMARIO.getColor());
        searchField.setForeground(UIPalette.TEXT_COLOR.getColor());
        c.weightx = 1.0;
        c.weighty = 0.1;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.insets = new Insets(10, 10, 20, -350);
        panelList.add(searchField, c);

        JLabel title = new JLabel("Songs List");
        title.setForeground(UIPalette.TEXT_COLOR.getColor());
        title.setFont(boldFont);
        c.weightx = 1.0;
        c.weighty = 0.2;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        c.insets = new Insets(0, 0, 0, 450);
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
        c.weighty = 0.3;
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(-50, 5, 30, 100);
        panelList.add(optionsButton, c);

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
        c.gridy = 3;
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
     * setea las canciones en la tabla
     * @param songs lista de canciones
     */
    public void setSongs(List<Song> songs) {
        tableModel.setRowCount(0);
        for (Song song : songs) {
            Object[] rowData = {title(song.getTitle()), title(song.getGenre()), title(song.getAuthor()), title(song.getAlbum()), title(song.getOwner())};
            tableModel.addRow(rowData);
        }
    }

    /**
     * Crea un titulo con la primera letra de cada palabra en mayuscula
     * @param text texto a convertir
     * @return texto convertido
     */
    private static String title(String text) {
        String[] words = text.split(" ");
        StringBuilder title = new StringBuilder();
        for (String word : words) {
            title.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase()).append(" ");
        }
        return title.toString().trim();
    }

    /**
     * Devuelve boton de opciones
     * @return boton de opciones
     */
    public JButton getOptionsButton() {
        return optionsButton;
    }

    /**
     * Devuelve el panel de la lista
     * @return panel de la lista
     */
    public JPanel getPanelList() {
        return panelList;
    }

    /**
     * Devuelve el texto del campo de busqueda
     * @return texto del campo de busqueda
     */
    public String getSearchText() {
        return searchField.getText();
    }

    /**
     * Añade el action listener al boton de opciones
     */
    public void actionLinker(MouseListener mouseListener){
        table.addMouseListener(mouseListener);
    }

    /**
     * Añade el action listener
     */
    public void setListener(ListMusicViewListener listener) {
        this.listener = listener;
    }

    /**
     * Setea el listener del campo de busqueda
     * @param actionListener listener del campo de busqueda
     */
    public void setSearchFieldListener(ActionListener actionListener) {
        searchField.addActionListener(actionListener);
    }


    /**
     * Muestra el dialogo de opciones
     */
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