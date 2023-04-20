package main.presentation.view;

import main.presentation.controller.SignInController;
import main.presentation.controller.SignUpController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInView {
    public static JPanel ventanaSignIn(){

        GridLayout gridLayout = new GridLayout(6 ,1);
        gridLayout.setVgap(6);

        JPanel panel_signin = new JPanel();
        panel_signin.setLayout(gridLayout);

        Font fuente_titol = new Font("Sans-Serif", Font.PLAIN, 35);
        Font fuente_petit = new Font("Sans-Serif", Font.PLAIN, 15);

        panel_signin.setBorder(new EmptyBorder(50,50,50,50));

        JLabel iniciar_sessio = new JLabel("INICIAR SESSIO");
        iniciar_sessio.setFont(fuente_titol);

        JLabel nom_correu = new JLabel("NOM O CORREU");
        nom_correu.setFont(fuente_petit);

        JTextField jTF_nom_correu = new JTextField();
        jTF_nom_correu.setPreferredSize(new Dimension(120, 30));
        jTF_nom_correu.setFont(fuente_petit);

        JLabel contrasenya = new JLabel("CONTRASENYA");
        contrasenya.setFont(fuente_petit);

        JPasswordField jTF_contrasenya = new JPasswordField();
        jTF_contrasenya.setPreferredSize(new Dimension(120, 30));
        jTF_contrasenya.setFont(fuente_petit);

        JPanel panelBoto = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton bIniciarSessio = new JButton();
        bIniciarSessio.setText("INICIAR SESSIO");
        bIniciarSessio.setPreferredSize(new Dimension(120, 30));
        bIniciarSessio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignInController.signInButtonPressed(jTF_nom_correu.getText(), jTF_contrasenya.getPassword());
            }
        });
        panelBoto.add(bIniciarSessio);

        panel_signin.add(iniciar_sessio);
        panel_signin.add(nom_correu);
        panel_signin.add(jTF_nom_correu);
        panel_signin.add(contrasenya);
        panel_signin.add(jTF_contrasenya);
        panel_signin.add(panelBoto);


        return panel_signin;
    }

}

