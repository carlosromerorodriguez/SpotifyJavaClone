package main.presentation.view;

import main.presentation.controller.SignUpController;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpView {
    public static JPanel ventanaSignUp(){

        GridLayout gridLayout = new GridLayout(10 ,1);
        gridLayout.setVgap(10);

        JPanel panel_signup = new JPanel();
        panel_signup.setLayout(gridLayout);

        Font fuente_titol = new Font("Sans-Serif", Font.PLAIN, 35);
        Font fuente_petit = new Font("Sans-Serif", Font.PLAIN, 15);

        panel_signup.setBorder(new EmptyBorder(50,50,50,50));

        JLabel registrarse = new JLabel("REGISTRARSE");
        registrarse.setFont(fuente_titol);

        JLabel correu = new JLabel("CORREU");
        correu.setFont(fuente_petit);

        JTextField jTF_Correu = new JTextField();
        jTF_Correu.setPreferredSize(new Dimension(120, 30));
        jTF_Correu.setFont(fuente_petit);

        JLabel nom_usuari = new JLabel("NOM USUARI");
        nom_usuari.setFont(fuente_petit);

        JTextField jTF_nom_usuari = new JTextField();
        jTF_nom_usuari.setPreferredSize(new Dimension(120, 30));
        jTF_nom_usuari.setFont(fuente_petit);

        JLabel contrasenya = new JLabel("CONTRASENYA");
        contrasenya.setFont(fuente_petit);

        JPasswordField jTF_contrasenya = new JPasswordField();
        jTF_contrasenya.setPreferredSize(new Dimension(120, 30));
        jTF_contrasenya.setFont(fuente_petit);

        JLabel conf_contrasenya = new JLabel("CONFIRMACIÓ CONTRASENYA");
        conf_contrasenya.setFont(fuente_petit);

        JPasswordField jTF_conf_contrasenya = new JPasswordField();
        jTF_conf_contrasenya.setMaximumSize(new Dimension(200, 7));
        jTF_conf_contrasenya.setFont(fuente_petit);

        JPanel panelBoto = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton bRegistre = new JButton();
        bRegistre.setText("REGISTRARSE");
        bRegistre.setPreferredSize(new Dimension(120, 30));
        bRegistre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpController.registerButtonPressed();
            }
        });
        panelBoto.add(bRegistre);

        panel_signup.add(registrarse);
        panel_signup.add(correu);
        panel_signup.add(jTF_Correu);
        panel_signup.add(nom_usuari);
        panel_signup.add(jTF_nom_usuari);
        panel_signup.add(contrasenya);
        panel_signup.add(jTF_contrasenya);
        panel_signup.add(conf_contrasenya);
        panel_signup.add(jTF_conf_contrasenya);
        panel_signup.add(panelBoto);


        return panel_signup;
    }

}
