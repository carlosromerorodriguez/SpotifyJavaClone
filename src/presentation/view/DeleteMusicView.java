package presentation.view;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import static presentation.view.Utilities.UIPalette.APP_BACKGROUND;

public class DeleteMusicView extends JFrame {
    public static final String DELETE_COMMAND = "DELETE_COMMAND";
    public static final String BACK_FROM_DELETE = "BACK_FROM_DELETE";
    public static final String CONFIRM_COMMAND = "CONMIRM_COMMAND";
    private final JTextField jTFSongTitle;
    private final JPanel panelDeleteSong;
    private final JButton buttonDelete;
    private final JButton buttonBack;
    public String getTitle() {
        return jTFSongTitle.getText();
    }
    public DeleteMusicView() {
        panelDeleteSong = new JPanel(new GridBagLayout());
        panelDeleteSong.setBackground(APP_BACKGROUND.getColor());
        GridBagConstraints c = new GridBagConstraints();

        Font fuente_titol = new Font("Sans-Serif", Font.PLAIN, 35);
        Font fuente_petit = new Font("Sans-Serif", Font.PLAIN, 15);

        panelDeleteSong.setBorder(new EmptyBorder(0, 0, 0, 0));

        JLabel delete_song = new JLabel("ELIMINAR CANCION");
        delete_song.setForeground(UIPalette.TEXT_COLOR.getColor());
        delete_song.setFont(fuente_titol);
        c.ipadx = 100;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(100, 0, 20, 0);
        panelDeleteSong.add(delete_song, c);

        JLabel title = new JLabel("TITLE OF THE SONG YOU WANT TO DELETE");
        title.setForeground(UIPalette.TEXT_COLOR.getColor());
        title.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 10, 0);
        panelDeleteSong.add(title, c);

        jTFSongTitle = new JTextField();
        jTFSongTitle.setPreferredSize(new Dimension(120, 30));
        jTFSongTitle.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 7;
        c.insets = new Insets(0, 0, 10, 0);
        panelDeleteSong.add(jTFSongTitle, c);

        buttonDelete = new JButton("DELETE");
        buttonDelete.setPreferredSize(new Dimension(50, 30));
        buttonDelete.setActionCommand(DELETE_COMMAND);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 11;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(20, 220, 0, 0);
        panelDeleteSong.add(buttonDelete, c);

        buttonBack = new JButton("<");
        buttonBack.setActionCommand(BACK_FROM_DELETE);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 11;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(20, 0, 0, 220);
        panelDeleteSong.add(buttonBack, c);

        c.ipady = 0;
        c.weighty = 0.2;
        c.gridx = 0;
        c.gridy = 11;
        c.anchor = GridBagConstraints.CENTER;
        panelDeleteSong.add(new JLabel(), c);

    }
    public void deleteMusicController(ActionListener actionListener) {
        buttonDelete.addActionListener(actionListener);
    }
    public String confirmDelete() {
        int response = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar esta cancion permanentemente?");
        if (response == JOptionPane.YES_OPTION) {
            return CONFIRM_COMMAND;
        } else {
            return BACK_FROM_DELETE;
        }
    }

    public JPanel getPanelDeleteSong() {
        return panelDeleteSong;
    }

    public void backDeleteController(ActionListener actionListener) {
        buttonBack.addActionListener(actionListener);
    }
    public void wrongTitleError() {
        JOptionPane.showMessageDialog(this,
                "The title you entered is not valid. Please ensure it meets the requirements and try again.",
                "Invalid Title", JOptionPane.ERROR_MESSAGE);
    }
    /*
    public void wrongUserError() {
        JOptionPane.showMessageDialog(this,
                "The username you entered is not valid. Please ensure it meets the requirements and try again.",
                "Invalid Username", JOptionPane.ERROR_MESSAGE);
    }

     */
}