package com.maison.model;

public class PiecePosition {

    private double x;
    private double y;

    public PiecePosition(double x, double y){
        this.x = x;
        this.y = y;
    }

    //getter
    public double getY() {
        return y;
    }
    public double getX() {
        return x;
    }

    //setter
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString(){
        return "Position : x =  " + x + " y " + y;
    }

}
