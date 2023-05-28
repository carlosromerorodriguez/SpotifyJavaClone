package presentation.view;
import presentation.controller.DeleteMusicController;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import static presentation.view.Utilities.UIPalette.APP_BACKGROUND;
/**
 * Delete music view
 */
public class DeleteMusicView extends JFrame {
    /**
     * Check if the user wants to delete a song
     */
    public static final String DELETE_COMMAND = "DELETE_COMMAND";
    /**
     * Check if the user wants to go back
     */
    public static final String BACK_FROM_DELETE = "BACK_FROM_DELETE";
    /**
     * Check if the user wants to confirm the command
     */
    public static final String CONFIRM_COMMAND = "CONMIRM_COMMAND";
    private final JTextField jTFSongTitle;
    private final JPanel panelDeleteSong;
    private final JButton buttonDelete;
    private final JButton buttonBack;

    /**
     * Getter titulo de la cancion
     * @return titulo de la cancion
     */
    public String getTitle() {
        return jTFSongTitle.getText();
    }

    /**
     * Constructor de la vista de eliminar cancion
     */
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

    /**
     * Link controlador de la vista de eliminar cancion
     * @param actionListener controlador de la vista de eliminar cancion
     */
    public void deleteMusicController(ActionListener actionListener) {
        buttonDelete.addActionListener(actionListener);
    }

    /**
     * Confirmar eliminar cancion
     * @return confirmar eliminar cancion
     */
    public String confirmDelete() {
        int response = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar esta canción permanentemente?");
        return (response == JOptionPane.YES_OPTION) ? CONFIRM_COMMAND : BACK_FROM_DELETE;
    }

    /**
     * Getter panel de eliminar cancion
     * @return panel de eliminar cancion
     */
    public JPanel getPanelDeleteSong() {
        return panelDeleteSong;
    }

    /**
     * Link controlador de la vista de eliminar cancion
     * @param deleteMusicController controlador de la vista de eliminar cancion
     */
    public void backButtonListener(DeleteMusicController deleteMusicController) {
        buttonBack.addActionListener(deleteMusicController);
    }

    /**
     * Error de titulo de cancion
     */
    public void wrongTitleError() {
        JOptionPane.showMessageDialog(this,
                "The title you entered is not valid. Please ensure it meets the requirements and try again.",
                "Invalid Title", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Exito al eliminar cancion
     */
    public void successfulDelete() {
        JOptionPane.showMessageDialog(this,
                "The song has been successfully deleted.",
                "Successful Delete", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Error al eliminar cancion
     */
    public void unsuccessfulDelete() {
        JOptionPane.showMessageDialog(this,
                "The song could not be deleted.",
                "Unsuccessful Delete", JOptionPane.ERROR_MESSAGE);
    }
}