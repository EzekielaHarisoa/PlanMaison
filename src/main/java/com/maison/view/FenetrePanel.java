package com.maison.view;

import javax.swing.*;

public class FenetrePanel {
    private JLabel fenetreTitre;
    private JComboBox comboBox1;
    private JButton supprimFenetreButton;
    private JPanel fenetrePanel;

    public FenetrePanel() {

    }
    public FenetrePanel(int numero) {
        this();
        fenetreTitre.setText("Fenetre " + numero);
    }
    public JPanel getFenetrePanel() {
        return fenetrePanel;
    }
}
