package com.maison.model;

public class Contrainte {

    private Piece p1 ;
    private Piece p2;

    private PieceDirection direction;
    private PiecePositionTypeRelation typeRelation;

    public Contrainte( Piece p1, Piece p2, PieceDirection direction, PiecePositionTypeRelation typeRelation) {
        this.p1 = p1;
        this.p2 = p2;
        this.direction = direction;
        this.typeRelation = typeRelation;
    }

    //getter
    public Piece getP2() {
        return p2;
    }
    public Piece getP1() {
        return p1;
    }
    public PiecePositionTypeRelation getTypeRelation() {
        return typeRelation;
    }
    public PieceDirection getDirection() {
        return direction;
    }

    //setter
    public void setTypeRelation(PiecePositionTypeRelation typeRelation) {
        this.typeRelation = typeRelation;
    }
    public void setP2(Piece p2) {
        this.p2 = p2;
    }
    public void setP1(Piece p1) {
        this.p1 = p1;
    }
        public void setDirection(PieceDirection direction) {
        this.direction = direction;
    }

    @Override
    public  String toString(){
        return p1.getNom() + " " + typeRelation + " " + p2.getNom();
    }

}
