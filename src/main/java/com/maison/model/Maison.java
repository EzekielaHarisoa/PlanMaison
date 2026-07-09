package com.maison.model;

import java.util.ArrayList;
import java.util.List;

public class Maison {

    private double largeur;
    private double longeur;

    private List<Piece> pieces;

    private Terrain terrain;

    public Maison(double largeur, double longeur, Terrain terrain) {
        this.largeur = largeur;
        this.longeur = longeur;
        this.terrain = terrain;
        this.pieces = new ArrayList<>();
    }

    //ajout piece
    public void ajoutPiece(Piece piece) {
        pieces.add(piece);
    }

    //getter
    public double getLargeur() {
        return largeur;
    }
    public double getLongeur() {
        return longeur;
    }
    public List<Piece> getPieces() {
        return pieces;
    }

    //setter
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }
    public void setLongeur(double longeur) {
        this.longeur = longeur;
    }
    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    @Override
    public String toString() {
        return "Maison{ " +
                " nombrePieces=" + pieces.size() +
                '}';
    }

}
