package com.maison.view;

import com.maison.model.Piece;
import com.maison.model.PieceDimension;
import com.maison.model.PiecePositionDemande;

import javax.swing.*;

public class PiecePanel   {

    private JTextField nomPiece;
    private JComboBox typePiece;
    private JButton supprimerCettePieceButton;
    private JPanel panelPiece;
    private JPanel piece;
    private JLabel titreLabel;
    private JComboBox posiPiece;
    private JButton addButton;
    private JPanel porteList;
    private JPanel fenetreList;
    private JButton addFenetre;
    private JLabel nbrPorte;
    private JLabel nbrFenetre;
    private JScrollPane Portes;
    private JSpinner longPiece;
    private JSpinner largPiece;
    int nbr = 0;


    public PiecePanel(int numero) {
        this();
        titreLabel.setText("Piece " + numero);
    }

    public PiecePanel() {
        porteList.setLayout(
                new BoxLayout(porteList,BoxLayout.Y_AXIS)
        );
        addButton.addActionListener(e -> ajouterPorte());

        fenetreList.setLayout(
                new BoxLayout(fenetreList,BoxLayout.Y_AXIS)
        );
        addFenetre.addActionListener(e -> ajouterFenetre());

        supprimerCettePieceButton.addActionListener(e -> suppressionPiece());

        typePiece.setModel(new DefaultComboBoxModel<>(new String[]{"Cuisine", "Salon", "Chambre", "SDB", "Garage"}));

        posiPiece.setModel(new DefaultComboBoxModel<>(PiecePositionDemande.values()));
    }

    public JPanel getPanelPiece() {
        System.out.println(panelPiece);
        return panelPiece;
    }

    public Piece getPiece(){
        String nom = nomPiece.getText();
        String type = typePiece.getSelectedItem().toString();
        double longueurP = ((Number) longPiece.getValue()).doubleValue();
        double largeurP = ((Number) largPiece.getValue()).doubleValue();
        PiecePositionDemande posiP = (PiecePositionDemande) posiPiece.getSelectedItem();

        return new Piece(nom,type, new PieceDimension(longueurP, largeurP), posiP);
    };

    public void ajouterPorte() {
        nbr++;
        nbrPorte.setText("Nombre = " + nbr);
        PortePanel porte = new PortePanel(nbr);
        porteList.add(porte.getPanelPorte());
        porteList.revalidate();
        porteList.repaint();
    }

    public void ajouterFenetre() {
        nbr++;
        nbrFenetre.setText("Nombre " + nbr);
        FenetrePanel fenetre = new FenetrePanel(nbr);
        fenetreList.add(fenetre.getFenetrePanel());
        fenetreList.revalidate();
        fenetreList.repaint();
    }

     public void suppressionPiece() {
        nbr++;
        PortePanel porte = new PortePanel(nbr);
        fenetreList.remove(nbr);
        fenetreList.revalidate();
        fenetreList.repaint();

     }

}