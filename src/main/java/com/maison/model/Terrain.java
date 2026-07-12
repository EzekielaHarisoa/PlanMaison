package com.maison.model;

public class Terrain {

    private double largeurTerrain;
    private double longeurterrain;

    public Terrain(double longeurterrain, double largeurTerrain) {
        this.longeurterrain = longeurterrain;
        this.largeurTerrain = largeurTerrain;
    }

    //getter
    public double getLargeurTerrain() {
        return largeurTerrain;
    }
    public double getLongeurterrain() {
        return longeurterrain;
    }
    public double getSurface() {return longeurterrain * largeurTerrain;}

    //setter
    public void setLongeurterrain(double longeurterrain) {
        this.longeurterrain = longeurterrain;
    }
    public void setLargeurTerrain(double largeurTerrain) {
        this.largeurTerrain = largeurTerrain;
    }

    @Override
    public String toString(){
        return "Terrai : [ longeur = " + longeurterrain + " largeur = " + largeurTerrain + "Surface = "+ getSurface();
    }
}
