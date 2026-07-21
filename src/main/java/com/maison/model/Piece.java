package com.maison.model;

import java.util.ArrayList;
import java.util.List;

public class Piece {

    private String nom;
    private String type;

    private PieceDimension pieceDimension;
    private PiecePosition piecePosition;

    private PiecePositionDemande piecePositionDemande;

    private List<Fenetre> fenetres;
    private List<Porte> portes;

    //contructeur
    public Piece(String nom, String type, PieceDimension pieceDimension,PiecePositionDemande piecePositionDemande) {
        this.nom = nom;
        this.type = type;
        this.pieceDimension = pieceDimension;
        this.piecePosition = new PiecePosition(0,0);
        this.piecePositionDemande = piecePositionDemande;
        this.portes = new ArrayList<>();
        this.fenetres = new ArrayList<>();
    }

    //getter
    public String getType() {
        return type;
    }
    public String getNom() {
        return nom;
    }
    public PieceDimension getDimension() {return pieceDimension;}
    public PiecePosition getPosition() {
        return piecePosition;
    }
    public List<Fenetre> getFenetres() {
        return fenetres;
    }
    public List<Porte> getPortes() {
        return portes;
    }
    public PieceDimension getPieceDimension() {
        return pieceDimension;
    }
    public PiecePosition getPiecePosition() {
        return piecePosition;
    }
    public PiecePositionDemande getPiecePositionDemande() {
        return piecePositionDemande;
    }

    //setter
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setDimension(PieceDimension pieceDimension) {
        this.pieceDimension = pieceDimension;
    }
    public void setPosition(PiecePosition piecePosition) {
        this.piecePosition = piecePosition;
    }
    public void setFenetres(List<Fenetre> fenetres) {
        this.fenetres = fenetres;
    }
    public void setPortes(List<Porte> portes) {
        this.portes = portes;
    }
    public void setPiecePosition(PiecePosition piecePosition) {
        this.piecePosition = piecePosition;
    }
    public void setPieceDimension(PieceDimension pieceDimension) {
        this.pieceDimension = pieceDimension;
    }
    public void setPiecePositionDemande(PiecePositionDemande piecePositionDemande) {
        this.piecePositionDemande = piecePositionDemande;
    }

    //ajout d'element
    public void ajoutPorte(Porte porte) {
        portes.add(porte);
    }

    public void ajoutFenetre(Fenetre fenetre) {
        fenetres.add(fenetre);
    }

    @Override
    public String toString(){
        return nom;
    }

}
