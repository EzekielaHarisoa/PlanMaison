package com.maison.model;

public class Porte {

    private double largeur;
    private PortePosition position;

    public Porte(double largeur, PortePosition position) {
        this.largeur = largeur;
        this.position = position;
    }

    //getter
    public double getLargeur() {
        return largeur;
    }
    public PortePosition getPosition() {
        return position;
    }

    //setter
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }
    public void setPosition(PortePosition position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Porte largeur=" + largeur + "m position=" + position;
    }
}