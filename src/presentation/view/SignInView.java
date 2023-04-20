package presentation.view;

import presentation.controller.SignInController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInView {
    public static JPanel ventanaSignIn() {

        JPanel panel_signin = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        Font fuente_titol = new Font("Sans-Serif", Font.PLAIN, 35);
        Font fuente_petit = new Font("Sans-Serif", Font.PLAIN, 15);

        panel_signin.setBorder(new EmptyBorder(0, 0, 0, 0));


        JLabel iniciar_sessio = new JLabel("INICIAR SESSIO");
        iniciar_sessio.setFont(fuente_titol);
        c.ipadx = 100;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 2;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(170, 0, 20, 0);
        panel_signin.add(iniciar_sessio, c);

        JLabel nom_correu = new JLabel("NOM O CORREU");
        nom_correu.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 10, 0);
        panel_signin.add(nom_correu, c);

        JTextField jTF_nom_correu = new JTextField();
        jTF_nom_correu.setPreferredSize(new Dimension(120, 30));
        jTF_nom_correu.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 7;
        c.insets = new Insets(0, 0, 10, 0);
        panel_signin.add(jTF_nom_correu, c);

        JLabel contrasenya = new JLabel("CONTRASENYA");
        contrasenya.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        c.insets = new Insets(0, 0, 10, 0);
        panel_signin.add(contrasenya, c);

        JPasswordField jTF_contrasenya = new JPasswordField();
        jTF_contrasenya.setPreferredSize(new Dimension(120, 30));
        jTF_contrasenya.setFont(fuente_petit);
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 7;
        c.insets = new Insets(0, 0, 10, 0);
        panel_signin.add(jTF_contrasenya, c);


        JButton bIniciarSessio = new JButton("INICIAR SESSIO");
        bIniciarSessio.setPreferredSize(new Dimension(50, 30));
        bIniciarSessio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignInController.signInButtonPressed(jTF_nom_correu.getText(), jTF_contrasenya.getPassword());
            }
        });
        c.ipady = 0;
        c.gridx = 0;
        c.gridy = 10;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(20, 220, 0, 0);
        panel_signin.add(bIniciarSessio, c);

        c.ipady = 0;
        c.weighty = 0.2;
        c.gridx = 0;
        c.gridy = 11;
        c.anchor = GridBagConstraints.CENTER;
        panel_signin.add(new JLabel(), c);

        return panel_signin;
    }

}

