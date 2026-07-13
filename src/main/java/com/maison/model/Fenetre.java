package com.maison.model;

public class Fenetre {

    private double longeur;
    private double largeur;
    private FenetrePosition fenetrePosition;

    public Fenetre(double longeur, double largeur, FenetrePosition fenetrePosition) {
        this.longeur = longeur;
        this.largeur = largeur;
        this.fenetrePosition = fenetrePosition;
    }

    //getter
    public double getLargeur() {
        return largeur;
    }
    public double getLongeur() {
        return longeur;
    }
    public FenetrePosition getFenetrePosition() {
        return fenetrePosition;
    }

    //setter
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }
    public void setLongeur(double longeur) {
        this.longeur = longeur;
    }
    public void setFenetrePosition(FenetrePosition fenetrePosition) {this.fenetrePosition = fenetrePosition;}

    @Override
    public String toString() {
        return "Fenetre : [ longeur = " + longeur + " largeur = " + largeur + "position = " + fenetrePosition;
    }


}
