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
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JButton ajouterButton;

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
                60,
                terrain,
                MaisonPosition.EST
        );
        Piece nord = new Piece(
                "kela",
                "Chambre",
                new PieceDimension(10,10),
                PiecePositionDemande.NORD
        );
        Piece sud = new Piece(
                "Chambre",
                "Chambre",
                new PieceDimension(10,10),
                PiecePositionDemande.SUD
        );
        Piece est = new Piece(
                "Est",
                "Chambre",
                new PieceDimension(10,18),
                PiecePositionDemande.EST
        );
        Piece ouest = new Piece(
                "Ouest",
                "Chambre",
                new PieceDimension(10,10),
                PiecePositionDemande.OUEST
        );
        Piece nordOuest = new Piece(
                "nordOuest",
                "Salon",
                new PieceDimension(10,15),
                PiecePositionDemande.NORD_EST
        );

        maison.ajoutPiece(nord);
        maison.ajoutPiece(sud);
        maison.ajoutPiece(est);
        maison.ajoutPiece(ouest);
        maison.ajoutPiece(nordOuest);

        nord.ajoutPorte(new Porte(3, PiecePositionDemande.NORD));
        nord.ajoutPorte(new Porte(3, PiecePositionDemande.NORD));
        sud.ajoutPorte(new Porte(3, PiecePositionDemande.SUD));
        est.ajoutPorte(new Porte(3, PiecePositionDemande.EST));
        ouest.ajoutPorte(new Porte(3, PiecePositionDemande.OUEST));

        nordOuest.ajoutFenetre(new Fenetre(2, Mur.NORD));
        nordOuest.ajoutFenetre(new Fenetre(2, Mur.SUD));

        Contrainte c1 = new Contrainte(nord,nordOuest,PieceDirection.EST,PiecePositionTypeRelation.A_COTE);
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
