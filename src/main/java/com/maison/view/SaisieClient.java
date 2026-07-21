package com.maison.view;

import com.maison.model.*;
import com.maison.services.GenerateurEsquise;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

public class SaisieClient {
    private JPanel SaisieClient1;

    private JLabel terrainLabel;

    private JButton ajouterUnePieceButton;
    private JButton actualiserButton;
    private JButton genererButton;

    private JPanel panelList;
    private JLabel surfaceTerrainTitre;
    private JLabel labelMaisonPosition;
    private JComboBox contrainteRefference;
    private JComboBox contrainteRelation;
    private JComboBox contrainteSecondPiece;
    private JComboBox contrainteDirection;
    private JButton ajouterContrainteButton;
    private JComboBox posiMaison;
    private JPanel contrainteList;
    private JSpinner longTerrain;
    private JSpinner largTerrain;
    private JSpinner longMaison;
    private JSpinner largMaison;
    private List<PiecePanel> pieces = new ArrayList<>();
    private List<Contrainte> contraintes = new ArrayList<>();

    private int nbPiece = 0;
    private int nbContr = 0;

    public SaisieClient() {
        panelList.setLayout(
                new BoxLayout(panelList,BoxLayout.Y_AXIS)
        );
        contrainteList.setLayout(
                new BoxLayout(contrainteList,BoxLayout.Y_AXIS)
        );
        ajouterUnePieceButton.addActionListener(e -> ajouterPiece());

        genererButton.addActionListener(e -> afficheEsquisse());

        ajouterContrainteButton.addActionListener(e -> ajouterContrainte());

        posiMaison.setModel(new DefaultComboBoxModel<>(MaisonPosition.values()));

        contrainteDirection.setModel(new DefaultComboBoxModel<>(PieceDirection.values()));

        contrainteRelation.setModel(new DefaultComboBoxModel<>(PiecePositionTypeRelation.values()));

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

        pieces.add(piece);
        panelList.add(piece.getPanelPiece());

        mettreAJourComboPieces();

        panelList.revalidate();
        panelList.repaint();

    }

    private void mettreAJourComboPieces(){

        contrainteRefference.removeAllItems();
        contrainteSecondPiece.removeAllItems();

        for(PiecePanel pp : pieces){

            Piece p = pp.getPiece();
            System.out.println("Piece récupérée : " + p);
            if(p != null) {
                contrainteRefference.addItem(p);
                contrainteSecondPiece.addItem(p);

            }
        }
    }

    public void ajouterContrainte() {

        if(contrainteRefference.getSelectedItem()==null || contrainteSecondPiece.getSelectedItem()==null) {
            JOptionPane.showMessageDialog(null, "Choisissez deux pièces");
            return;
        }

        Piece p1 = (Piece) contrainteRefference.getSelectedItem();
        Piece p2 = (Piece) contrainteSecondPiece.getSelectedItem();

        PieceDirection pd = (PieceDirection) contrainteDirection.getSelectedItem();
        PiecePositionTypeRelation pr = (PiecePositionTypeRelation) contrainteRelation.getSelectedItem();

        Contrainte c = new Contrainte(p1, p2, pd, pr);
        nbContr++;
        contraintes.add(c);

        ContraintePanel panel = new ContraintePanel(nbContr,c);

        contrainteList.add(panel.getPanelContrainte());

        mettreAJourComboPieces();

        contrainteList.revalidate();
        contrainteList.repaint();

    }

    public void afficheEsquisse() {

        JFrame frame = new JFrame("Esquisse");

        double longueurT = ((Number) longTerrain.getValue()).doubleValue();
        double largeurT = ((Number) largTerrain.getValue()).doubleValue();

        Terrain terrain = new Terrain(longueurT,largeurT);

        double longueurM = ((Number) longMaison.getValue()).doubleValue();
        double largeurM = ((Number) largMaison.getValue()).doubleValue();
        MaisonPosition positionM = (MaisonPosition) posiMaison.getSelectedItem();

        Maison maison = new Maison(longueurM, largeurM, terrain, positionM);

        for(PiecePanel pp : pieces) {

            Piece p = pp.getPiece();
            maison.ajoutPiece(p);

        }
        for(Contrainte c : contraintes) {

            maison.ajoutContrainte(c);

        }

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
