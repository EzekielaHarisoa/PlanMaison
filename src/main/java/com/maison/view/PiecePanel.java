package com.maison.view;

import javax.swing.*;
import java.awt.*;

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
    private JButton ajouterUnePorteButton;
    private JButton ajouterUneFenetreButton;
    private JPanel panelListPorte;
    private JPanel portesCard;
    private JScrollPane porteList;
    private JPanel fenetreCard;
    private JPanel fenetreList;
    int nbPorte = 0;

    public PiecePanel(int numero) {
        this();
        titreLabel.setText("Piece " + numero);
    }

    public PiecePanel() {
        panelListPorte.setLayout(
                new BoxLayout(panelListPorte,BoxLayout.Y_AXIS)
        );
        ajouterUnePorteButton.addActionListener(e -> ajouterPorte());
    }

    public JPanel getPanelPiece() {
        System.out.println(panelPiece);
        return panelPiece;
    }

    public void ajouterPorte() {
        nbPorte++;
        PortePanel porte = new PortePanel(nbPorte);
        panelListPorte.add(porte.getPanelPorte());
        panelListPorte.revalidate();
        panelListPorte.repaint();
    }


}