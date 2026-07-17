package com.maison.model;

public class Porte {

    private double largeur;
    private PiecePositionDemande position;

    public Porte(double largeur, PiecePositionDemande position) {
        this.largeur = largeur;
        this.position = position;
    }

    //getter
    public double getLargeur() {
        return largeur;
    }
    public PiecePositionDemande getPosition() {
        return position;
    }

    //setter
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }
    public void setPosition(PiecePositionDemande position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Porte largeur=" + largeur + "m position=" + position;
    }
}