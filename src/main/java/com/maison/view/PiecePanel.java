package com.maison.view;

import javax.swing.*;

public class PiecePanel   {

    private JTextField textField3;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JComboBox comboBox1;
    private JButton supprimerCettePieceButton;
    private JPanel panelPiece;
    private JPanel piece;
    private JLabel titreLabel;




    public PiecePanel(int numero) {
        titreLabel.setText("Piece " + numero);
    }

    public PiecePanel() {

    }

    public JPanel getPanelPiece() {
        System.out.println(panelPiece);
        return panelPiece;
    }

}