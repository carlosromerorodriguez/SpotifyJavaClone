package presentation.view;

import presentation.controller.LogOutController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogOutView {
    private JPanel ventanaEmergenteLogOut(){
        GridLayout gridLayout = new GridLayout(12, 1);
        gridLayout.setVgap(10); // indica los gaps entre las filas

        JPanel panelLogOut = new JPanel();
        panelLogOut.setLayout(gridLayout); // les decimos el diseño que queremos en nuestro panel

        Font titulo = new Font("Sans-Serif", Font.PLAIN, 35);
        Font subtitulo = new Font("Sans-Serif", Font.PLAIN, 15);

        panelLogOut.setBorder(new EmptyBorder(50, 50, 50, 50));
        panelLogOut.revalidate();
        //Jlabel nos crea un texto no editable dentro de nuestra ventana emergente

        JLabel tituloLogout = new JLabel("LOGOUT :(");
        tituloLogout.setFont(titulo); // le metemos la fuente que nos interesa previamente declarada

        JLabel user = new JLabel("USER: ");
        user.setFont(subtitulo); // le metemos la fuente que nos interesa previamente declarada

        JLabel password = new JLabel("PASSWORD: ");
        password.setFont(subtitulo);

        JTextField userText = new JTextField();
        userText.setPreferredSize(new Dimension(120, 30));
        userText.setFont(subtitulo);

        JTextField passwordText = new JTextField();
        passwordText.setPreferredSize(new Dimension(120, 30));
        userText.setFont(subtitulo);

        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton confirmButton = new JButton();
        JButton cancelButton = new JButton();

        confirmButton.setText("CONFIRM :(");
        cancelButton.setText("CANCEL :)");

        confirmButton.setPreferredSize(new Dimension(120, 30));
        cancelButton.setPreferredSize(new Dimension(120, 30));

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LogOutController.removeUser(userText.getText(), passwordText.getText());
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        buttonsPanel.add(confirmButton);
        buttonsPanel.add(cancelButton);

        panelLogOut.add(tituloLogout);
        panelLogOut.add(user);
        panelLogOut.add(userText);
        panelLogOut.add(password);
        panelLogOut.add(passwordText);
        panelLogOut.add(buttonsPanel);

        JFrame frame_prueba = new JFrame();
        frame_prueba.setSize(500,700);
        frame_prueba.getContentPane().add(panelLogOut);
        frame_prueba.setVisible(true);


        return panelLogOut;
    }

    public JPanel logOutButton (JFrame frame) {
        final JPanel[] panel = {new JPanel()};
        JButton button = new JButton(new ImageIcon("src/main/resources/default_user.png"));
        button.setSize(120, 30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel[0] = ventanaEmergenteLogOut();
            }
        });
        frame.add(button);
        frame.setSize(500, 700);
        frame.setVisible(true);
        return panel[0];
    }
}
