package com.maison.model;

public class PieceDimension {
    private double longeur;
    private double largeur;

    public PieceDimension(double longeur, double largeur) {
        this.longeur = longeur;
        this.largeur = largeur;
    }

    //getter
    public double getLongeur() {
        return longeur;
    }
    public double getLargeur() {
        return largeur;
    }

    //setter
    public void setLongeur(double longeur) {
        this.longeur = longeur;
    }
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

}
