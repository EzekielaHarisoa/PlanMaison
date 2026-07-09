package com.maison.view;

import javax.swing.*;
import java.awt.*;

public class SaisieClient {
    private JPanel SaisieClient1;

    private JTextField terrainField;
    private JLabel terrainLabel;
    private JTextField maisonField;

    private JButton ajouterUnePieceButton;
    private JButton actualiserButton;
    private JButton genererButton;

    private JPanel panelList;

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
        EsquissePanel ep = new EsquissePanel();
        frame.add(ep);
        frame.setSize(800,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
