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
        supprimerPorteButton.addActionListener(e -> {
            if(onDelete != null) {
                onDelete.run();
            }
        });

    }

    public PortePanel(int numero) {
        this();
        porteTitre.setText("Porte " + numero);


    }

    public Porte getPorte() {

        double largeur = ((Number) porteLargeur.getValue()).doubleValue();
        if(largeur <= 0){

            JOptionPane.showMessageDialog(
                    null,
                    "La largeur de la porte doit être supérieure à 0.",
                    "Erreur porte",
                    JOptionPane.ERROR_MESSAGE
            );
            return null;
        }

        PortePosition position = (PortePosition) portePosition.getSelectedItem();

        return new Porte(largeur, position);

    }

    public JPanel getPanelPorte(){
        System.out.println(panelPorte);
        return panelPorte;
    }

    private Runnable onDelete;
    public void setOnDelete(Runnable onDelete) {
        this.onDelete = onDelete;
    }

}
