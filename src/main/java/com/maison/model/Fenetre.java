package com.maison.model;

public class Fenetre {

    private double largeur;
    private FenetrePosition position;

    public Fenetre(double largeur, FenetrePosition position) {
        this.largeur = largeur;
        this.position = position;
    }

    //getter
    public double getLargeur() {
        return largeur;
    }
    public FenetrePosition getPosition() {
        return position;
    }

    //setter
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }
    public void setFenetrePosition(FenetrePosition position) {
        this.position = position;
    }
}