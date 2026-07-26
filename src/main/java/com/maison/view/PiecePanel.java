package com.maison.view;

import com.maison.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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
    private JLabel nbrPorte;
    private JLabel nbrFenetre;
    private JScrollPane porteCadre;
    private JSpinner longPiece;
    private JSpinner largPiece;
    private JScrollPane fenetreCadre;
    private Piece pieceModel;
    private List<PortePanel> portes = new ArrayList<>();
    private List<FenetrePanel> fenetres = new ArrayList<>();

    int nb1 = 0;
    int nb2 = 0;

    private Runnable onPieceChanged;

    public void setOnPieceChanged(Runnable onPieceChanged) {
        this.onPieceChanged = onPieceChanged;
    }

    public PiecePanel(int numero) {
        this();
        titreLabel.setText("Piece " + numero);
    }

    public PiecePanel() {
        pieceModel = new Piece(
                "",
                PieceType.CUISINE,
                new PieceDimension(0,0),
                PiecePositionDemande.CENTRE
        );

        porteList.setLayout(new BoxLayout(porteList,BoxLayout.Y_AXIS));

        addButton.addActionListener(e -> ajouterPorte());

        typePiece.setModel(new DefaultComboBoxModel<>(PieceType.values()));

        typePiece.addActionListener(e -> {

            pieceModel.setType((PieceType) typePiece.getSelectedItem());
            if(onPieceChanged != null) {
                onPieceChanged.run();
            }
        });

        posiPiece.setModel(new DefaultComboBoxModel<>(PiecePositionDemande.values()));

        posiPiece.addActionListener(e -> {

            pieceModel.setPiecePositionDemande(
                    (PiecePositionDemande) posiPiece.getSelectedItem()
            );
        });

        porteCadre.setPreferredSize(new Dimension(20, 60));

        supprimerCettePieceButton.addActionListener(e -> {
            if(onDelete != null) {
                onDelete.run();
            }
        });

        longPiece.setModel(  new SpinnerNumberModel(1.0, 0.0, 100.0, 0.1));

        largPiece.setModel(  new SpinnerNumberModel(1.0, 0.0, 100.0, 0.1));


    }

    public JPanel getPanelPiece() {
        System.out.println(panelPiece);
        return panelPiece;
    }

    public Piece getPiece(){

        pieceModel.setNom(nomPiece.getText());
        pieceModel.setType((PieceType) typePiece.getSelectedItem());

        double longueurP = ((Number) longPiece.getValue()).doubleValue();
        double largeurP = ((Number) largPiece.getValue()).doubleValue();

        if(longueurP <= 0 || largeurP <= 0){
            JOptionPane.showMessageDialog(
                    null,
                    "La longueur et la largeur de la pièce doivent être supérieures à 0.",
                    "Erreur pièce",
                    JOptionPane.ERROR_MESSAGE
            );
            return null;
        }

        pieceModel.setDimension(new PieceDimension(longueurP, largeurP));

        pieceModel.setPiecePositionDemande((PiecePositionDemande) posiPiece.getSelectedItem());

        pieceModel.getPortesInterrieur().clear();

        for(PortePanel pp : portes) {

            Porte porte = pp.getPorte();

            if(porte == null){
                return null;
            }
            if(pieceModel.verifierCollisionPorte(porte)){

                JOptionPane.showMessageDialog(
                        null,
                        "Cette porte entre en collision avec une autre porte.",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE
                );

                return null;
            }
            pieceModel.ajoutPorte(porte);

        }

        return pieceModel;
    }

    public void ajouterPorte() {
        nb1++;
        nbrPorte.setText("Nombre = " + nb1);

        PortePanel porte = new PortePanel(nb1);

        porte.setOnDelete(() -> {

            portes.remove(porte);
            porteList.remove(porte.getPanelPorte());

            nbrPorte.setText("Nombre = " + portes.size());

            porteList.revalidate();
            porteList.repaint();
        });

        portes.add(porte);
        porteList.add(porte.getPanelPorte());

        porteList.revalidate();
        porteList.repaint();
    }

    public void ajouterFenetre() {
        nb2++;
        nbrFenetre.setText("Nombre " + nb2);

        FenetrePanel fenetre = new FenetrePanel(nb2);

        fenetre.setOnDelete(() -> {

            fenetres.remove(fenetre);
            fenetreList.remove(fenetre.getFenetrePanel());

            nbrFenetre.setText("Nombre = " + fenetres.size());

            fenetreList.revalidate();
            fenetreList.repaint();
        });

        fenetres.add(fenetre);
        fenetreList.add(fenetre.getFenetrePanel());
        fenetreList.revalidate();
        fenetreList.repaint();
    }

    private Runnable onDelete;
    public void setOnDelete(Runnable onDelete) {
        this.onDelete = onDelete;
    }
}