package presentation.view;
import presentation.controller.DeleteSongFromPlaylistController;
import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DeleteSongFromPlaylistView extends JFrame {
    public static final String DELETE_COMMAND = "DELETE_COMMAND";
    public static final String BACK_FROM_DELETE = "BACK_FROM_DELETE";

    private final JTextField jTFSongTitleText;
    private final JTextField jTFPlaylistNameText;
    private final JPanel panelDeleteSong;
    private final JButton buttonDelete;
    private final JButton buttonBack;
    private final JLabel deleteSongTitle;

    /**
     * Getter del titulo de la cancion
     * @return
     */
    public String getTitle() {
        return jTFSongTitleText.getText();
    }

    /**
     * Getter del panel de eliminar cancion
     * @return
     */
    public String getPlaylistName() {
        return jTFPlaylistNameText.getText();
    }

    /**
     * constructor de la vista de eliminar cancion
     */
    public DeleteSongFromPlaylistView() {
        panelDeleteSong = new JPanel(new GridBagLayout());
        panelDeleteSong.setBackground(UIPalette.COLOR_PRIMARIO.getColor());
        GridBagConstraints c = new GridBagConstraints();
        jTFPlaylistNameText = new JTextField("");

        panelDeleteSong.setPreferredSize(new Dimension(500, 500)); // Set preferred size of the panel

        Font boldFont = Fonts.getBoldFont(30f);
        Font mediumFont = Fonts.getMediumFont(15f);

        panelDeleteSong.setBorder(new EmptyBorder(0, 0, 0, 0));

        deleteSongTitle = new JLabel("Delete Song From Playlist " + jTFPlaylistNameText.getText());
        deleteSongTitle.setForeground(UIPalette.TEXT_COLOR.getColor());
        deleteSongTitle.setFont(boldFont);

        JLabel songTitle = new JLabel("Song Title");
        songTitle.setForeground(UIPalette.TEXT_COLOR.getColor());
        songTitle.setFont(mediumFont);

        jTFSongTitleText = new JTextField("");
        jTFSongTitleText.setPreferredSize(new Dimension(200, 30));
        jTFSongTitleText.setFont(mediumFont);

        buttonDelete = new JButton("Delete Song");
        buttonDelete.setActionCommand(DELETE_COMMAND);
        buttonDelete.setPreferredSize(new Dimension(200, 30));
        buttonDelete.setFont(mediumFont);

        buttonBack = new JButton("Back");
        buttonBack.setActionCommand(BACK_FROM_DELETE);
        buttonBack.setPreferredSize(new Dimension(200, 30));
        buttonBack.setFont(mediumFont);

        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 20, 0);
        panelDeleteSong.add(deleteSongTitle, c);

        c.gridx = 0;
        c.gridy = 1;
        c.insets = new Insets(0, 0, 20, 0);
        panelDeleteSong.add(songTitle, c);

        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(0, 0, 20, 0);
        panelDeleteSong.add(jTFSongTitleText, c);

        c.gridx = 0;
        c.gridy = 2;
        c.insets = new Insets(0, 0, 20, 0);
        panelDeleteSong.add(buttonDelete, c);

        c.gridx = 0;
        c.gridy = 3;
        c.insets = new Insets(0, 0, 20, 0);
        panelDeleteSong.add(buttonBack, c);
    }

    /**
     * Setter del nombre de la playlist
     * @param jTFPlaylistNameText
     */
    public void setPlaylistName(String jTFPlaylistNameText) {
        this.jTFPlaylistNameText.setText(jTFPlaylistNameText);
        deleteSongTitle.setText("Delete Song From Playlist " + jTFPlaylistNameText);
    }

    /**
     * Getter del panel de eliminar cancion
     * @return
     */
    public JPanel getPanel() {
        return panelDeleteSong;
    }

    /**
     * Setter del controlador de eliminar cancion
     * @param deleteSongFromPlaylistController
     */
    public void setListener(DeleteSongFromPlaylistController deleteSongFromPlaylistController) {
        buttonDelete.addActionListener(deleteSongFromPlaylistController);
        buttonBack.addActionListener(deleteSongFromPlaylistController);
    }


    /**
     * Mensaje de exito
     * */
    public void successfulDeleteSong() {
        JOptionPane.showMessageDialog(this,
                "The song was successfully deleted from the playlist.",
                "Successful Delete", JOptionPane.INFORMATION_MESSAGE);
    }


    /**
     * Mensaje de error de cancion no existente
     */
    public void notExistingSongError() {
        JOptionPane.showMessageDialog(this,
                "The song you entered does not exist in the playlist. Please check the song title and try again.",
                "Non-existing Song", JOptionPane.ERROR_MESSAGE);
    }
}
