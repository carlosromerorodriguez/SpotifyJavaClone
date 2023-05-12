package presentation.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuView extends JFrame {

    private final JPanel menuPanel;
    private final JButton bPlayMusic, bPlaylist, bMusicStatistics, bExit;
    private final JLabel imageLabel;

    public MainMenuView() {
        menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

        bPlayMusic = createButton("Play Music");
        bPlaylist = createButton("Playlist");
        bMusicStatistics = createButton("Music Statistics");
        bExit = createButton("Exit");

        menuPanel.add(bPlayMusic);
        menuPanel.add(bPlaylist);
        menuPanel.add(bMusicStatistics);
        menuPanel.add(bExit);

        imageLabel = new JLabel();
        addImage();
        menuPanel.add(imageLabel);

        addListeners();
        createOptionsMenuFrame(menuPanel);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setActionCommand(text);
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setBackground(Color.GRAY);
        button.setForeground(Color.WHITE);
        return button;
    }

    private void addImage() {
        ImageIcon imageIcon = new ImageIcon("testImage.jpg"); // Reemplaza "testImage.jpg" con tu imagen.
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // Ajusta el tamaño de la imagen.
        imageIcon = new ImageIcon(newimg);
        imageLabel.setIcon(imageIcon);
    }

    private void addListeners() {
        ActionListener actionListener = e -> {
            String command = e.getActionCommand();
            System.out.println(command);
            if ("Exit".equals(command)) {
                System.exit(0);
            }
        };

        bPlayMusic.addActionListener(actionListener);
        bPlaylist.addActionListener(actionListener);
        bMusicStatistics.addActionListener(actionListener);
        bExit.addActionListener(actionListener);
    }

    private void createOptionsMenuFrame(JPanel panel) {
        JFrame frame = new JFrame("MPlayer");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(50, 50); // Ajusta el tamaño de la ventana.
        frame.setVisible(true);
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }
}