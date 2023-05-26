package presentation.view;

import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class DeletePlaylistView {
    public static final String DELETE_PLAYLIST_COMMAND = "DELETE_PLAYLIST_COMMAND";
    public static final String BACK_FROM_DELETE_PLAYLIST = "BACK_FROM_DELETE_PLAYLIST";

    private JTextField jTFPlaylistNameText;
    private JPanel panelDeletePlaylist;
    private JButton buttonDelete;
    private JButton buttonBack;
    private GridBagConstraints c;
    private Font fuenteTitol, fuentePetit;

    public String getPlaylistName() {
        return jTFPlaylistNameText.getText();
    }

    public JPanel getPanelAddSong() {
        return panelDeletePlaylist;
    }

    public DeletePlaylistView() {
        setupView();
        setupFonts();
        setupComponents();
    }

    private void setupView() {
        panelDeletePlaylist = new JPanel(new GridBagLayout());
        panelDeletePlaylist.setBackground(UIPalette.COLOR_PRIMARIO.getColor());
        panelDeletePlaylist.setPreferredSize(new Dimension(500, 500)); // Set preferred size of the panel
        panelDeletePlaylist.setBorder(new EmptyBorder(0, 0, 0, 0));

        c = new GridBagConstraints();
    }

    private void setupFonts() {
        fuenteTitol = Fonts.getBoldFont(40f);
        fuentePetit = Fonts.getMediumFont(20f);
    }

    private void setupComponents() {
        setupDeletePlaylistLabel();
        setupPlaylistNameLabel();
        setupPlaylistNameField();
        setupBackButton();
        setupDeleteButton();
    }

    private void setupDeletePlaylistLabel() {
        JLabel delete_playlist = new JLabel("Eliminar Playlist");
        delete_playlist.setForeground(UIPalette.TEXT_COLOR.getColor());
        delete_playlist.setFont(fuenteTitol);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 10, 10, 0);
        panelDeletePlaylist.add(delete_playlist, c);
    }

    private void setupPlaylistNameLabel() {
        JLabel playlistName = new JLabel("Nombre de la Playlist a eliminar:");
        playlistName.setForeground(UIPalette.TEXT_COLOR.getColor());
        playlistName.setFont(fuentePetit);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = new Insets(0, 10, 10, 0);
        panelDeletePlaylist.add(playlistName, c);
    }

    private void setupPlaylistNameField() {
        jTFPlaylistNameText = new JTextField();
        jTFPlaylistNameText.setFont(fuentePetit);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        c.insets = new Insets(0, 10, 10, 0);
        panelDeletePlaylist.add(jTFPlaylistNameText, c);
    }

    private void setupBackButton() {
        buttonBack = new JButton("<");
        buttonBack.setFont(fuentePetit);
        buttonBack.setActionCommand(BACK_FROM_DELETE_PLAYLIST);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.insets = new Insets(0, 50, 0, 150);
        panelDeletePlaylist.add(buttonBack, c);
    }

    private void setupDeleteButton() {
        buttonDelete = new JButton("Eliminar");
        buttonDelete.setFont(fuentePetit);
        buttonDelete.setActionCommand(DELETE_PLAYLIST_COMMAND);
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 50);
        panelDeletePlaylist.add(buttonDelete, c);
    }

    public void deletePlaylistController(ActionListener actionListener) {
        buttonDelete.addActionListener(actionListener);
    }

    public void backPlaylistController(ActionListener actionListener) {
        buttonBack.addActionListener(actionListener);
    }

    public void successfulDeletePlaylist() {
        JOptionPane.showMessageDialog(panelDeletePlaylist,
                "La playlist se ha eliminado correctamente.",
                "Playlist eliminada", JOptionPane.INFORMATION_MESSAGE);
    }

    public void notExistingPlaylistError() {
        JOptionPane.showMessageDialog(panelDeletePlaylist,
                "La playlist no existe.",
                "Error", JOptionPane.ERROR_MESSAGE);
    }
}
