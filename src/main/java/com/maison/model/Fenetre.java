package com.maison.model;

public class Fenetre {

    private double largeur;
    private Mur mur;

    public Fenetre(double largeur, Mur mur) {
        this.largeur = largeur;
        this.mur = mur;
    }

    //getter
    public double getLargeur() {
        return largeur;
    }
    public Mur getMur() {
        return mur;
    }

    //setter
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }
    public void setMur(Mur mur) {
        this.mur = mur;
    }
}