package com.maison.model;

public class Fenetre {

    private double largeur;
    private FenetrePosition position;
    private double distanceMur;

    public FenetrePlace getPlace() {
        return place;
    }

    public void setPlace(FenetrePlace place) {
        this.place = place;
    }

    public void setPosition(FenetrePosition position) {
        this.position = position;
    }

    private FenetrePlace place;

    public Fenetre(double largeur, FenetrePosition position, FenetrePlace place) {
        this.largeur = largeur;
        this.position = position;
        this.place = place;
    }

    //getter
    public double getLargeur() {
        return largeur;
    }
    public FenetrePosition getPosition() {
        return position;
    }
    public double getDistanceMur() {
        return distanceMur;
    }

    //setter
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }
    public void setFenetrePosition(FenetrePosition position) {
        this.position = position;
    }
    public void setDistanceMur(double distanceMur) {
        this.distanceMur = distanceMur;
    }

}