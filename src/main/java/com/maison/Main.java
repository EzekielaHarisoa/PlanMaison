package com.maison;

import com.maison.view.EsquissePanel;
import com.maison.view.SaisieClient;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Saisie Client");

        SaisieClient formulaire = new SaisieClient();

        frame.setContentPane(formulaire.getSaisieClient1());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


    }
}