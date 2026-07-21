package com.maison.view;

import javax.swing.*;

public class ContraintePanel {
    private JLabel contrainteTitle;
    private JLabel pieceReference;
    private JLabel pieceADeplacer;
    private JLabel contrainteLabel;
    private JPanel panelContrainte;

    public ContraintePanel(int numero) {
        contrainteTitle.setText("contrainte " + numero);
    }

    public JPanel getPanelContrainte() {
        return panelContrainte;
    }
}
