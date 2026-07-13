package com.maison.model;

public class Terrain {

    private double largeurTerrain;
    private double longueurTerrain;

    public Terrain(double longueurTerrain, double largeurTerrain) {
        this.longueurTerrain = longueurTerrain;
        this.largeurTerrain = largeurTerrain;
    }

    //getter
    public double getLargeurTerrain() {
        return largeurTerrain;
    }
    public double getLongueurTerrain() {
        return longueurTerrain;
    }
    public double getSurface() {return longueurTerrain * largeurTerrain;}

    //setter
    public void setLongueurTerrain(double longueurTerrain) {
        this.longueurTerrain = longueurTerrain;
    }
    public void setLargeurTerrain(double largeurTerrain) {
        this.largeurTerrain = largeurTerrain;
    }

    @Override
    public String toString(){
        return "Terrain : [ longeur = " + longueurTerrain + " largeur = " + largeurTerrain + "Surface = " + getSurface();
    }
}
