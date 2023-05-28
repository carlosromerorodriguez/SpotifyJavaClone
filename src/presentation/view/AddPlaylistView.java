package presentation.view;

import presentation.view.Utilities.Fonts;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddPlaylistView {
    public static final String ADD_PLAYLIST_COMMAND = "ADD_PLAYLIST_COMMAND";
    public static final String BACK_FROM_ADD_PLAYLIST = "BACK_FROM_ADD_PLAYLIST";

    private JTextField jTFPlaylistNameText;
    private JPanel panelAddPlaylist;
    private JButton buttonAdd;
    private JButton buttonBack;
    private GridBagConstraints c;
    private Font fuenteTitol, fuentePetit;

    /**
     * Getter del nombre de la playlist
     * @return nombre de la playlist
     */
    public String getPlaylistName() {
        return jTFPlaylistNameText.getText();
    }

    /**
     * Getter del panel de añadir playlist
     * @return panel de añadir playlist
     */
    public JPanel getPanelAddSong() {
        return panelAddPlaylist;
    }

    /**
     * Añadir playlist view
     */
    public AddPlaylistView() {
        setupView();
        setupFonts();
        setupComponents();
    }

    private void setupView() {
        panelAddPlaylist = new JPanel(new GridBagLayout());
        panelAddPlaylist.setBackground(UIPalette.COLOR_PRIMARIO.getColor());
        panelAddPlaylist.setPreferredSize(new Dimension(500, 500)); // Set preferred size of the panel
        panelAddPlaylist.setBorder(new EmptyBorder(0, 0, 0, 0));

        c = new GridBagConstraints();
    }

    private void setupFonts() {
        fuenteTitol = Fonts.getBoldFont(40f);
        fuentePetit = Fonts.getMediumFont(20f);
    }

    private void setupComponents() {
        setupAddPlaylistLabel();
        setupPlaylistNameLabel();
        setupPlaylistNameField();
        setupBackButton();
        setupAddButton();
    }

    private void setupAddPlaylistLabel() {
        JLabel add_playlist = new JLabel("Crear Playlist");
        add_playlist.setForeground(UIPalette.TEXT_COLOR.getColor());
        add_playlist.setFont(fuenteTitol);
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(0, 10, 10, 0);
        panelAddPlaylist.add(add_playlist, c);
    }

    private void setupPlaylistNameLabel() {
        JLabel playlistName = new JLabel("Nombre de la nueva Playlist:");
        playlistName.setForeground(UIPalette.TEXT_COLOR.getColor());
        playlistName.setFont(fuentePetit);
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = new Insets(0, 10, 10, 0);
        panelAddPlaylist.add(playlistName, c);
    }

    private void setupPlaylistNameField() {
        jTFPlaylistNameText = new JTextField();
        jTFPlaylistNameText.setFont(fuentePetit);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 3;
        c.insets = new Insets(0, 10, 10, 0);
        panelAddPlaylist.add(jTFPlaylistNameText, c);
    }

    private void setupBackButton() {
        buttonBack = new JButton("<");
        buttonBack.setFont(fuentePetit);
        buttonBack.setActionCommand(BACK_FROM_ADD_PLAYLIST);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.insets = new Insets(0, 50, 0, 150);
        panelAddPlaylist.add(buttonBack, c);
    }

    private void setupAddButton() {
        buttonAdd = new JButton("Crear");
        buttonAdd.setFont(fuentePetit);
        buttonAdd.setActionCommand(ADD_PLAYLIST_COMMAND);
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 0, 50);
        panelAddPlaylist.add(buttonAdd, c);
    }

    /**
     * Añadir controlador de la playlist
     * @param actionListener controlador de la playlist
     */
    public void addPlaylistController(ActionListener actionListener) {
        buttonAdd.addActionListener(actionListener);
    }

    /**
     * Añadir controlador de volver a la playlist
     * @param actionListener controlador de volver a la playlist
     */
    public void backPlaylistController(ActionListener actionListener) {
        buttonBack.addActionListener(actionListener);
    }

    /**
     * Mostrar error de nombre repetido
     */
    public void repeatPlaylistNameError() {
        JOptionPane.showMessageDialog(panelAddPlaylist,
                "Ya existe una playlist con ese nombre. Por favor, ingrese otro nombre.",
                "Nombre repetido", JOptionPane.ERROR_MESSAGE);
    }
}