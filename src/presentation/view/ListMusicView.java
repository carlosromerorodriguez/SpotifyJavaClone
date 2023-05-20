    package presentation.view;

    import business.BusinessLogicMusic;
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
        private final JPanel panel_list;
        private final JTable table;

        public ListMusicView(BusinessLogicMusic businessLogicMusic) {
            panel_list = new JPanel(new GridBagLayout());
            panel_list.setBackground(UIPalette.COLOR_PRIMARIO.getColor());
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
            panel_list.add(title, c);

            // JTable
            DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Título", "Género", "Autor", "Álbum"}, 0) {
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
            panel_list.add(scrollPane, c);

            List<Song> songs = businessLogicMusic.listMusic();
            for (Song song : songs) {
                Object[] rowData = {title(song.getTitle()), title(song.getGenre()), title(song.getAuthor()), title(song.getAlbum())};
                tableModel.addRow(rowData);
            }

            TableColumnModel columnModel = table.getColumnModel();
            int columnCount = columnModel.getColumnCount();
            for (int i = 0; i < columnCount; i++) {
                columnModel.getColumn(i).setPreferredWidth(800);
            }

            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            table.setDefaultRenderer(Object.class, centerRenderer);
        }

        public static String title(String text) {
            String[] words = text.split(" ");
            StringBuilder title = new StringBuilder();
            for (String word : words) {
                title.append(word.substring(0, 1).toUpperCase()).append(word.substring(1).toLowerCase()).append(" ");
            }
            return title.toString();
        }

        public JPanel getPanelList() {
            return panel_list;
        }

        public void actionLinker(MouseListener mouseListener){
            table.addMouseListener(mouseListener);
        }
    }