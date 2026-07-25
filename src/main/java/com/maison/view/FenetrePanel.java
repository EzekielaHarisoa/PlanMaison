package com.maison.view;

import com.maison.model.Fenetre;
import com.maison.model.FenetrePosition;
import com.maison.model.Porte;

import javax.swing.*;

public class FenetrePanel {
    private JLabel fenetreTitre;
    private JComboBox fenetrePosition;
    private JButton supprimFenetreButton;
    private JPanel fenetrePanel;
    private JSpinner fenetreLargeur;

    public FenetrePanel() {

    }
    public FenetrePanel(int numero) {
        this();
        fenetreTitre.setText("Fenetre " + numero);
        fenetrePosition.setModel(new DefaultComboBoxModel(FenetrePosition.values()));

    }
    public JPanel getFenetrePanel() {
        return fenetrePanel;
    }

    public Fenetre getFenetre() {
        double largeur = ((Number) fenetreLargeur.getValue()).doubleValue();
        FenetrePosition position = (FenetrePosition) fenetrePosition.getSelectedItem();
        return new Fenetre(largeur,position);
    }
}
