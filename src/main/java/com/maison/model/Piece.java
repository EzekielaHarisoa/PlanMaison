package com.maison.model;

import java.util.ArrayList;
import java.util.List;

public class Piece {

    private String nom;
    private String type;

    private PieceDimension pieceDimension;
    private PiecePosition piecePosition;

    private List<Fenetre> fenetres;
    private List<Porte> portes;

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

    //ajout d'element
    public void ajoutPorte(Porte porte) {
        portes.add(porte);
    }
    public void ajoutFenetre(Fenetre fenetre) {
        fenetres.add(fenetre);
    }

    //contructeur
    public Piece(String nom, String type, PieceDimension pieceDimension, PiecePosition piecePosition) {
        this.nom = nom;
        this.type = type;
        this.pieceDimension = pieceDimension;
        this.piecePosition = piecePosition;
        this.portes = new ArrayList<>();
        this.fenetres = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Piece{" +
                "nom='" + nom + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
