package com.maison.view;

import com.maison.model.Porte;
import com.maison.model.PortePlace;
import com.maison.model.PortePosition;

import javax.swing.*;

public class PortePanel {
    private JLabel porteTitre;
    private JComboBox portePosition;
    private JButton supprimerPorteButton;
    private JPanel panelPorte;
    private JSpinner porteLargeur;
    private JComboBox portePlace;

    public PortePanel() {
        portePosition.setModel(new DefaultComboBoxModel<>(PortePosition.values()));
        supprimerPorteButton.addActionListener(e -> {
            if(onDelete != null) {
                onDelete.run();
            }
        });
        portePlace.setModel(new DefaultComboBoxModel<>(PortePlace.values()));
        porteLargeur.setModel( new SpinnerNumberModel(1.0, 0.0, 100.0, 0.1));

    }

    public PortePanel(int numero) {
        this();
        porteTitre.setText("Porte " + numero);


    }

    public Porte getPorte() {

        double largeur = ((Number) porteLargeur.getValue()).doubleValue();
        PortePlace place = (PortePlace) portePlace.getSelectedItem();
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

        return new Porte(largeur, position, place);

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
