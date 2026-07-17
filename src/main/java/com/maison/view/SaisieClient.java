package com.maison.view;

import com.maison.model.*;
import com.maison.services.GenerateurEsquise;

import javax.swing.*;

public class SaisieClient {
    private JPanel SaisieClient1;

    private JLabel terrainLabel;

    private JButton ajouterUnePieceButton;
    private JButton actualiserButton;
    private JButton genererButton;

    private JPanel panelList;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel surfaceTerrainTitre;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel surfaceMaisonTitre;

    private int nbPiece = 0;

    public SaisieClient() {
        panelList.setLayout(
                new BoxLayout(panelList,BoxLayout.Y_AXIS)
        );
        ajouterUnePieceButton.addActionListener(e -> ajouterPiece());
        genererButton.addActionListener(e -> afficheEsquisse());
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public JPanel getSaisieClient1() {
        return SaisieClient1;
    }

    public void ajouterPiece(){
        nbPiece++;
        PiecePanel piece = new PiecePanel(nbPiece);
        panelList.add(piece.getPanelPiece());
        panelList.revalidate();
        panelList.repaint();
    }

    public void afficheEsquisse() {

        JFrame frame = new JFrame("Esquisse");
        Terrain terrain = new Terrain(60,60);
        Maison maison = new Maison(
                60,
                50,
                terrain,
                MaisonPosition.NORD_EST
        );
        Piece cuisine = new Piece(
                "Cuisine",
                "Cuisine",
                new PieceDimension(10,10),
                PiecePositionDemande.NORD
        );
        Piece salleAManger = new Piece(
                "SalleAManger",
                "SalleAManger",
                new PieceDimension(10,10),
                PiecePositionDemande.EST
        ); Piece chambre = new Piece(
                "chambre",
                "chambre",
                new PieceDimension(10,5),
                PiecePositionDemande.OUEST
        );

        maison.ajoutPiece(cuisine);
        maison.ajoutPiece(salleAManger);
        maison.ajoutPiece(chambre);

        Contrainte c1 = new Contrainte(chambre,cuisine,PieceDirection.NORD,PiecePositionTypeRelation.A_COTE);
        maison.ajoutContrainte(c1);

        GenerateurEsquise generateur = new GenerateurEsquise();

        if(generateur.generer(maison)){

            EsquissePanel ep = new EsquissePanel(terrain, maison);

            frame.add(ep);
            frame.setSize(800,600);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        }
        else{

            JOptionPane.showMessageDialog(
                    null,
                    generateur.getMessageErreur(),
                    "Plan invalide",
                    JOptionPane.ERROR_MESSAGE
            );
        }


    }}
