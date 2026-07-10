package com.maison.model;

public class FenetrePosition {
    private double x;
    private double y;

    public FenetrePosition(double x,double y) {
        this.x = x;
        this.y = y;
    }
    //getter
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    //setter
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

}
