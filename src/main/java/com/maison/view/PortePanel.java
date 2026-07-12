package com.maison.view;

import javax.swing.*;

public class PortePanel {
    private JComboBox comboBox1;
    private JLabel titrePorte;
    private JPanel panelPorte;
    private JButton supprimerButton;

    public PortePanel() {

    }
    public PortePanel(int numero) {
        this();
        titrePorte.setText("port " + numero );
    }

    public JPanel getPanelPorte() {
        System.out.println(panelPorte);
        return panelPorte;
    }
}
