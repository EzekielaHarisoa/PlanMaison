package com.maison.model;

public class Porte {

    private double largeur;
    private PortePosition position;
    private PortePlace place;
    private PorteType type;

    public Porte(double largeur, PortePosition position, PortePlace place) {
        this.largeur = largeur;
        this.position = position;
        this.place = place;
    }

    //getter
    public double getLargeur() {
        return largeur;
    }
    public PortePosition getPosition() {
        return position;
    }
    public PortePlace getPlace() {
        return place;
    }
    public PorteType getType() {
        return type;
    }

    //setter
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }
    public void setPlace(PortePlace place) {
        this.place = place;
    }
    public void setType(PorteType type) {
        this.type = type;
    }
    public void setPosition(PortePosition position) {
        this.position = position;
    }
    @Override
    public String toString() {
        return "Porte largeur=" + largeur + "m position=" + position;
    }
}