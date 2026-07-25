package com.maison.view;

import com.maison.model.*;
import com.maison.services.GenerateurEsquise;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class SaisieClient {
    private JPanel SaisieClient1;

    private JLabel terrainLabel;

    private JButton ajouterUnePieceButton;
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
    private JButton actualiserButton;
    private JButton addPorteMaison;
    private JPanel portemaisonList;
    private JButton addFenetreMaison;
    private JPanel denetreMaisonList;
    private JPanel porteCadre;
    private JScrollPane fenetreCadre;
    private List<PiecePanel> pieces = new ArrayList<>();
    private List<Contrainte> contraintes = new ArrayList<>();
    private List<PortePanel> portesMaison = new ArrayList<>();
    private List<FenetrePanel> fenetreMaison = new ArrayList<>();
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

        addPorteMaison.addActionListener(e -> ajouterPorteMaison());
        portemaisonList.setLayout(new BoxLayout(portemaisonList, BoxLayout.Y_AXIS));
        portemaisonList.setLayout(new BoxLayout(portemaisonList, BoxLayout.Y_AXIS));

        addFenetreMaison.addActionListener(e -> ajouterFenetreMaison());
        denetreMaisonList.setLayout(new BoxLayout(denetreMaisonList, BoxLayout.Y_AXIS));
        porteCadre.setPreferredSize(new Dimension(100, 30));
        fenetreCadre.setPreferredSize(new Dimension(100, 30));

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

        piece.setOnPieceChanged(() -> mettreAJourComboPieces());

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

        if(p1 == p2) {
            JOptionPane.showMessageDialog(
                    null,
                    "Une pièce ne peut pas être contrainte avec elle-même"
            );
            return;
        }


        PieceDirection pd = (PieceDirection) contrainteDirection.getSelectedItem();
        PiecePositionTypeRelation pr = (PiecePositionTypeRelation) contrainteRelation.getSelectedItem();

        if(contrainteExisteDeja(p1,p2,pd,pr)){
            JOptionPane.showMessageDialog(null,"Cette contrainte existe déjà");
            return;
        }

        Contrainte c = new Contrainte(p1, p2, pd, pr);
        nbContr++;
        contraintes.add(c);

        ContraintePanel panel = new ContraintePanel(nbContr,c);

        contrainteList.add(panel.getPanelContrainte());

        mettreAJourComboPieces();

        contrainteList.revalidate();
        contrainteList.repaint();

    }

    private boolean contrainteExisteDeja(Piece p1, Piece p2, PieceDirection direction, PiecePositionTypeRelation relation) {

        for(Contrainte c : contraintes) {

            boolean memePiece =
                    c.getP1() == p1 &&
                            c.getP2() == p2;

            boolean memeContrainte =
                    c.getDirection() == direction &&
                            c.getTypeRelation() == relation;


            if(memePiece && memeContrainte) {
                return true;
            }
        }

        return false;
    }

    public void ajouterPorteMaison() {

        PortePanel portePanel = new PortePanel(
                portesMaison.size() + 1
        );

        portesMaison.add(portePanel);

        portemaisonList.add(
                portePanel.getPanelPorte()
        );

        portemaisonList.revalidate();
        portemaisonList.repaint();
        SwingUtilities.getWindowAncestor(portemaisonList)
                .revalidate();
    }

    public void ajouterFenetreMaison() {

        FenetrePanel fenetrePanel = new FenetrePanel(fenetreMaison.size() + 1);

        fenetreMaison.add(fenetrePanel);
        denetreMaisonList.add(fenetrePanel.getFenetrePanel());
        denetreMaisonList.revalidate();
        denetreMaisonList.repaint();
    }

    public void afficheEsquisse() {

        JFrame frame = new JFrame("Esquisse");

        double longueurT = ((Number) longTerrain.getValue()).doubleValue();
        double largeurT = ((Number) largTerrain.getValue()).doubleValue();
        if(longueurT <= 0 || largeurT <= 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "La longueur et la largeur du terrain doivent être supérieures à 0.",
                    "Erreur terrain",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        Terrain terrain = new Terrain(longueurT,largeurT);

        double longueurM = ((Number) longMaison.getValue()).doubleValue();
        double largeurM = ((Number) largMaison.getValue()).doubleValue();
        if(longueurM <= 0 || largeurM <= 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "Les dimensions de la maison doivent être positives.",
                    "Erreur de saisie",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        MaisonPosition positionM = (MaisonPosition) posiMaison.getSelectedItem();

        Maison maison = new Maison(longueurM, largeurM, terrain, positionM);

        for(PortePanel pp : portesMaison) {
            maison.ajoutPorte(pp.getPorte());
        }

        for(FenetrePanel fp : fenetreMaison) {
            maison.ajoutFenetre(fp.getFenetre());
        }

        for(PiecePanel pp : pieces) {

            Piece p = pp.getPiece();
            if(p != null){
                maison.ajoutPiece(p);
            }

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
        System.out.println(
                "Nb portes = " + portesMaison.size()
        );
        System.out.println(
                "Hauteur pref = " +
                        portemaisonList.getPreferredSize().height
        );

    }

}
