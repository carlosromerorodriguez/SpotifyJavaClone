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
    private JTextField jTF_song_title;
    private JPanel panel_delete_song;
    private JButton button_delete;
    private JButton button_Back;
    public String getTitle() {
        return jTF_song_title.getText();
    }
    public DeleteMusicView() {

        panel_delete_song = new JPanel(new GridBagLayout());
        panel_delete_song.setBackground(APP_BACKGROUND.getColor());
        GridBagConstraints c = new GridBagConstraints();

        Font fuente_titol = new Font("Sans-Serif", Font.PLAIN, 35);
        Font fuente_petit = new Font("Sans-Serif", Font.PLAIN, 15);

        panel_delete_song.setBorder(new EmptyBorder(0, 0, 0, 0));

        JLabel delete_song = new JLabel("ELIMINAR CANCION");
        delete_song.setForeground(UIPalette.TEXT_COLOR.getColor());
        delete_song.setFont(fuente_titol);
        c.ipadx = 100;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(100, 0, 20, 0);
        panel_delete_song.add(delete_song, c);

        JLabel title = new JLabel("TITLE OF THE SONG YOU WANT TO DELETE");
        title.setForeground(UIPalette.TEXT_COLOR.getColor());
        title.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 10, 0);
        panel_delete_song.add(title, c);

        jTF_song_title = new JTextField();
        jTF_song_title.setPreferredSize(new Dimension(120, 30));
        jTF_song_title.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 7;
        c.insets = new Insets(0, 0, 10, 0);
        panel_delete_song.add(jTF_song_title, c);

        button_delete = new JButton("DELETE");
        button_delete.setPreferredSize(new Dimension(50, 30));
        button_delete.setActionCommand(DELETE_COMMAND);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 11;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(20, 220, 0, 0);
        panel_delete_song.add(button_delete, c);

        button_Back = new JButton("<");
        button_Back.setActionCommand(BACK_FROM_DELETE);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 11;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(20, 0, 0, 220);
        panel_delete_song.add(button_Back, c);

        c.ipady = 0;
        c.weighty = 0.2;
        c.gridx = 0;
        c.gridy = 11;
        c.anchor = GridBagConstraints.CENTER;
        panel_delete_song.add(new JLabel(), c);

    }
    public void deleteMusicController(ActionListener actionListener) {
        button_delete.addActionListener(actionListener);
    }
    public String confirmDelete() {
        int response = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar esta cancion permanentemente?");
        if (response == JOptionPane.YES_OPTION) {
            return CONFIRM_COMMAND;
        } else {
            return BACK_FROM_DELETE;
        }
    }

    public JPanel getPanel_delete_song() {
        return panel_delete_song;
    }

    public void backDeleteController(ActionListener actionListener) {
        button_Back.addActionListener(actionListener);
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