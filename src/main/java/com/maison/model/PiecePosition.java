package com.maison.model;

public class PiecePosition {

    private int x;
    private int y;

    public PiecePosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    //getter
    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }

    //setter
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString(){
        return "Position : x =  " + x + " y " + y;
    }

}
