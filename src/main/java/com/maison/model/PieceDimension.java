package com.maison.model;

public class PieceDimension {
    private double longueur;
    private double largeur;

    public PieceDimension(double longueur, double largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
    }

    //getter
    public double getLongueur() {
        return longueur;
    }
    public double getLargeur() {
        return largeur;
    }

    //setter
    public void setLongueur(double longeur) {
        this.longueur = longeur;
    }
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

}
