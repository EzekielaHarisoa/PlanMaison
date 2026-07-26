package com.maison.view;

import com.maison.model.Fenetre;
import com.maison.model.FenetrePlace;
import com.maison.model.FenetrePosition;

import javax.swing.*;

public class FenetrePanel {

    private JLabel fenetreTitre;
    private JComboBox fenetrePosition;
    private JButton supprimFenetreButton;
    private JPanel fenetrePanel;
    private JSpinner fenetreLargeur;
    private JComboBox placeFenetre;

    public FenetrePanel(int numero) {

        fenetreTitre.setText("Fenetre " + numero);
        fenetrePosition.setModel(new DefaultComboBoxModel(FenetrePosition.values()));

        supprimFenetreButton.addActionListener(e -> {
                    if (onDelete != null) {
                        onDelete.run();
                    }
                }
        );
        placeFenetre.setModel(new DefaultComboBoxModel<>(FenetrePlace.values()));
        fenetreLargeur.setModel( new SpinnerNumberModel(1.0, 0.0, 100.0, 0.1));

    }

    public JPanel getFenetrePanel() {
        return fenetrePanel;
    }

    public Fenetre getFenetre() {
        double largeur = ((Number) fenetreLargeur.getValue()).doubleValue();
        if(largeur <= 0){
            JOptionPane.showMessageDialog(null,
                    "La largeur de la fenetre doit être supérieure à 0.",
                    "Erreur porte",
                    JOptionPane.ERROR_MESSAGE
            );
            return null;
        }

        FenetrePosition position = (FenetrePosition) fenetrePosition.getSelectedItem();
        FenetrePlace place = (FenetrePlace) placeFenetre.getSelectedItem();

        return new Fenetre(largeur,position,place);
    }

    private Runnable onDelete;
    public void setOnDelete(Runnable onDelete) {
        this.onDelete = onDelete;
    }
}
