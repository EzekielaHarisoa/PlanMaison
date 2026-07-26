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
    private JButton addFenetre;
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
                "",
                new PieceDimension(0,0),
                PiecePositionDemande.CENTRE
        );
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

        typePiece.addActionListener(e -> {

            pieceModel.setType(typePiece.getSelectedItem().toString());

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
        fenetreCadre.setPreferredSize(new Dimension(50, 60));

        supprimerCettePieceButton.addActionListener(e -> {
            if(onDelete != null) {
                onDelete.run();
            }
        });


    }

    public JPanel getPanelPiece() {
        System.out.println(panelPiece);
        return panelPiece;
    }

    public Piece getPiece(){

        pieceModel.setNom(nomPiece.getText());
        pieceModel.setType(typePiece.getSelectedItem().toString());

        double longueurP = ((Number) longPiece.getValue()).doubleValue();
        double largeurP = ((Number) largPiece.getValue()).doubleValue();

        if(longueurP < 0 || largeurP < 0){
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

        pieceModel.getPortes().clear();
        for(PortePanel pp : portes) {

            Porte porte = pp.getPorte();

            if(porte != null){
                pieceModel.ajoutPorte(porte);
            }
            else{
                return null;
            }
        }

        pieceModel.getFenetres().clear();
        for(FenetrePanel fp : fenetres) {

            Fenetre fenetre = fp.getFenetre();

            if(fenetre != null){
                pieceModel.ajoutFenetre(fenetre);
            }
            else{
                return null;
            }
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

            nbrPorte.setText("Nombre = " + fenetres.size());

            fenetreList.revalidate();
            fenetreList.repaint();
        });

        fenetres.add(fenetre);
        fenetreList.add(fenetre.getFenetrePanel());
        fenetreList.revalidate();
        fenetreList.repaint();
    }

     public void suppressionPiece() {
        nb1++;
        PortePanel porte = new PortePanel(nb1);
        fenetreList.remove(nb1);
        fenetreList.revalidate();
        fenetreList.repaint();

     }

    private Runnable onDelete;
    public void setOnDelete(Runnable onDelete) {
        this.onDelete = onDelete;
    }
}