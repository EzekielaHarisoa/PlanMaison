package com.maison.view;

import com.maison.model.Mur;
import com.maison.model.Porte;

import javax.swing.*;

public class PortePanel {
    private JLabel porteTitre;
    private JComboBox comboBox1;
    private JButton supprimerPorteButton;
    private JPanel panelPorte;

    public PortePanel() {
        comboBox1.setModel(new DefaultComboBoxModel<>(Mur.values()));

    }

    public PortePanel(int numero) {
        this();
        porteTitre.setText("Porte " + numero);

    }

    public JPanel getPanelPorte(){
        System.out.println(panelPorte);
        return panelPorte;
    }
}
