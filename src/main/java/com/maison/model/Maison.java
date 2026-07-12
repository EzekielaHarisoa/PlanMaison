package com.maison.model;

import java.util.ArrayList;
import java.util.List;

public class Maison {

    private double largeur;
    private double longueur;

    private List<Piece> pieces;

    private Terrain terrain;

    public Maison(double largeur, double longeur, Terrain terrain) {
        this.largeur = largeur;
        this.longueur = longeur;
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
        return longueur;
    }
    public List<Piece> getPieces() {
        return pieces;
    }
    public Terrain getTerrain() {
        return terrain;
    }
    public double getSurface() {
        return largeur * longueur;
    }

    //setter
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }
    public void setLongeur(double longeur) {
        this.longueur = longeur;
    }
    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }
    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }

    @Override
    public String toString() {
        return "Maison{ " +
                " nombrePieces=" + pieces.size() +
                '}';
    }
}
