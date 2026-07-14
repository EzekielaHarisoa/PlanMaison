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
        Terrain terrain = new Terrain(60,100);
        Maison maison = new Maison(
                40,
                50,
                terrain,
                MaisonPosition.NORD_EST
        );
        Piece cuisine = new Piece(
                "Cuisine",
                "Cuisine",
                new PieceDimension(4,3),
                PiecePositionDemande.SUD
        );

        Piece salleAManger = new Piece(
                "SalleAManger",
                "SalleAManger",
                new PieceDimension(6,5),
                PiecePositionDemande.CENTRE
        );

        maison.ajoutPiece(cuisine);
        maison.ajoutPiece(salleAManger);
        
        GenerateurEsquise generateur = new GenerateurEsquise();

        generateur.generer(maison);
        System.out.println(
                "Maison X = " + maison.getX() + " Y = " + maison.getY()
        );

        for(Piece p : maison.getPieces()){

            System.out.println(
                    p.getNom()
                            + " X=" + p.getPosition().getX()
                            + " Y=" + p.getPosition().getY()
            );
        }

        EsquissePanel ep = new EsquissePanel(terrain, maison);

        frame.add(ep);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }}
