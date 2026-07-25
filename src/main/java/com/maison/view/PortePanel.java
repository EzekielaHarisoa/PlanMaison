package com.maison.view;

import com.maison.model.Mur;
import com.maison.model.PiecePositionDemande;
import com.maison.model.Porte;
import com.maison.model.PortePosition;

import javax.swing.*;
import java.awt.*;

public class PortePanel {
    private JLabel porteTitre;
    private JComboBox portePosition;
    private JButton supprimerPorteButton;
    private JPanel panelPorte;
    private JSpinner porteLargeur;

    public PortePanel() {
        portePosition.setModel(new DefaultComboBoxModel<>(PortePosition.values()));

    }

    public PortePanel(int numero) {
        this();
        porteTitre.setText("Porte " + numero);


    }

    public Porte getPorte() {

        double largeur = ((Number) porteLargeur.getValue()).doubleValue();

        PortePosition position = (PortePosition) portePosition.getSelectedItem();

        return new Porte(largeur, position);

    }

    public JPanel getPanelPorte(){
        System.out.println(panelPorte);
        return panelPorte;
    }
}
