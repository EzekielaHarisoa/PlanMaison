package com.maison.view;

import com.maison.model.Contrainte;
import com.maison.model.Piece;
import com.maison.model.PieceDirection;
import com.maison.model.PiecePositionTypeRelation;

import javax.swing.*;

import java.util.List;

public class ContraintePanel {

    private JLabel contrainteTitle;
    private JLabel titlePieceReference;
    private JLabel titlePieceADeplacer;
    private JLabel titleContrainteLabel;
    private JPanel panelContrainte;
    private JButton supprimerContrainte;

    private JComboBox<Piece> pieceReference;
    private JComboBox<Piece> pieceADeplacer;

    private JComboBox<PieceDirection> pieceDirection;
    private JComboBox<PiecePositionTypeRelation> relation;

    private Contrainte contrainte;

    public ContraintePanel(int numero, Contrainte c) {
        this.contrainte = c;
        contrainteTitle.setText("contrainte " + numero);
        titlePieceReference.setText(c.getP1().toString());
        titleContrainteLabel.setText(c.getTypeRelation().toString());
        titlePieceADeplacer.setText(c.getP2().toString());
        supprimerContrainte.addActionListener(e -> {
            if(onDelete != null ) {
                 onDelete.run();
            }
        });

    }

    public Contrainte getContrainte() {
        return contrainte;
    }

    public JPanel getPanelContrainte() {

        return panelContrainte;

    }

    private Runnable onDelete;
    public void setOnDelete(Runnable onDelete) {
        this.onDelete = onDelete;
    }


}
