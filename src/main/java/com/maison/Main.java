package com.maison;

import com.maison.view.EsquissePanel;
import com.maison.view.SaisieClient;

import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Saisie Client");

        SaisieClient sc = new SaisieClient();

        sc.setFrameSaisie(frame);

        frame.setContentPane(sc.getSaisieClient1());

        frame.setSize(600,600);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}