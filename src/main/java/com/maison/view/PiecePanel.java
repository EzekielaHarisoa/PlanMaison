package com.maison.view;

import javax.swing.*;

public class PiecePanel   {

    private JTextField textField3;
    private JComboBox comboBox1;
    private JButton supprimerCettePieceButton;
    private JPanel panelPiece;
    private JPanel piece;
    private JLabel titreLabel;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox2;
    private JButton addButton;
    private JPanel porteList;
    private JPanel fenetreList;
    private JButton addFenetre;
    private JLabel nbrPorte;
    private JLabel nbrFenetre;
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
    }

    public JPanel getPanelPiece() {
        System.out.println(panelPiece);
        return panelPiece;
    }

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