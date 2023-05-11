package business;

import business.entities.MPlayer;
import presentation.view.Utilities.UIPalette;

import javax.swing.*;
import java.awt.*;

public class BusinessLogicMPlayer {
    public static void main(String[] args) {
        JFrame frame = new JFrame("MPlayer");
        frame.setContentPane(new BusinessLogicMPlayer().mPlayerPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private final JPanel mPlayerPanel;
    private MPlayer player;
    private Button bPlayPause, bStop, bIndividualRepetition, bGlobalRepetition;
    private boolean isIndividualRepetition;
    private boolean isGlobalRepetition;

    public BusinessLogicMPlayer() {
        mPlayerPanel = createMPlayerPanel();
        checkWhichButtonWasPressed();
        isIndividualRepetition = false;
        isGlobalRepetition = false;
    }

    private void checkWhichButtonWasPressed() {
        if (bPlayPause != null) {
            bPlayPause.addActionListener(e -> {
                if (player == null) {
                    System.out.println("Play");
                    player = new MPlayer("data/music/skrillex.mp3");
                    player.play(0); // Reproduce desde el principio
                    bPlayPause.setLabel("Pause");
                } else if (player.isPaused()) {
                    System.out.println("Play");
                    player.play(player.getPausePosition());
                    bPlayPause.setLabel("Pause");
                } else {
                    System.out.println("Pause");
                    player.pause();
                    bPlayPause.setLabel("Play");
                }
            });
        }
        if (bStop != null) {
            bStop.addActionListener(e -> {
                System.out.println("Stop");
                if (player != null) {
                    player.stop();
                    player = null;
                    bPlayPause.setLabel("Play");
                }
            });
        }
        if (bIndividualRepetition != null) {
            bIndividualRepetition.addActionListener(e -> {
                System.out.println("Individual Repetition");
                isIndividualRepetition = !isIndividualRepetition;
                System.out.println("Individual Repetition: " + isIndividualRepetition);
            });
        }
        if (bGlobalRepetition != null) {
            bGlobalRepetition.addActionListener(e -> {
                System.out.println("Global Repetition");
                isGlobalRepetition = !isGlobalRepetition;
                System.out.println("Global Repetition: " + isGlobalRepetition);
            });
        }
    }

    private JPanel createMPlayerPanel() {
        JPanel panelMPlayer = new JPanel();
        panelMPlayer.setLayout(new BoxLayout(panelMPlayer, BoxLayout.Y_AXIS));
        panelMPlayer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelMPlayer.setBackground(UIPalette.APP_BACKGROUND.getColor());
        panelMPlayer.add(createPauseContinueStopButton());
        panelMPlayer.add(Box.createRigidArea(new Dimension(0, 10)));
        panelMPlayer.add(createIndividualRepetition());
        panelMPlayer.add(Box.createRigidArea(new Dimension(0, 10)));
        panelMPlayer.add(createGlobalRepetition());
        return panelMPlayer;
    }

    private Component createGlobalRepetition() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBackground(UIPalette.APP_BACKGROUND.getColor());
        bGlobalRepetition = createButton("Global Repetition");
        panel.add(bGlobalRepetition);
        return panel;
    }

    private Component createIndividualRepetition() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBackground(UIPalette.APP_BACKGROUND.getColor());
        bIndividualRepetition = createButton("Individual Repetition");
        panel.add(bIndividualRepetition);
        return panel;
    }

    private Component createPauseContinueStopButton() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.setBackground(UIPalette.APP_BACKGROUND.getColor());
        bPlayPause = createButton("Play");
        bStop = createButton("Stop");
        panel.add(bPlayPause);
        panel.add(Box.createRigidArea(new Dimension(10, 0)));
        panel.add(bStop);
        return panel;
    }

    private Button createButton(String pause) {
        Button button = new Button(pause);
        button.setBackground(UIPalette.APP_BACKGROUND.getColor());
        button.setFont(new Font("Arial", Font.PLAIN, 20));
        return button;
    }
}
