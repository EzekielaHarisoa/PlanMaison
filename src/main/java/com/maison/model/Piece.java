package com.maison.model;

import java.util.ArrayList;
import java.util.List;

public class Piece {

    private String nom;
    private PieceType type;

    private PieceDimension pieceDimension;
    private PiecePosition piecePosition;

    private PiecePositionDemande piecePositionDemande;

    private List<Fenetre> fenetres;
    private List<Porte> portesInterrieur;

    //contructeur
    public Piece(String nom, PieceType type, PieceDimension pieceDimension,PiecePositionDemande piecePositionDemande) {
        this.nom = nom;
        this.type = type;
        this.pieceDimension = pieceDimension;
        this.piecePosition = new PiecePosition(0,0);
        this.piecePositionDemande = piecePositionDemande;
        this.portesInterrieur = new ArrayList<>();
        this.fenetres = new ArrayList<>();
    }

    //getter
    public PieceType getType() {
        return type;
    }
    public String getNom() {
        return nom;
    }
    public PieceDimension getDimension() {return pieceDimension;}
    public PiecePosition getPosition() {
        return piecePosition;
    }
    public List<Fenetre> getFenetres() {
        return fenetres;
    }
    public List<Porte> getPortesInterrieur() {
        return portesInterrieur;
    }
    public PieceDimension getPieceDimension() {
        return pieceDimension;
    }
    public PiecePosition getPiecePosition() {
        return piecePosition;
    }
    public PiecePositionDemande getPiecePositionDemande() {
        return piecePositionDemande;
    }

    //setter
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setType(PieceType type) {
        this.type = type;
    }
    public void setDimension(PieceDimension pieceDimension) {
        this.pieceDimension = pieceDimension;
    }
    public void setPosition(PiecePosition piecePosition) {
        this.piecePosition = piecePosition;
    }
    public void setFenetres(List<Fenetre> fenetres) {
        this.fenetres = fenetres;
    }
    public void setPortesInterrieur(List<Porte> portesInterrieur) {
        this.portesInterrieur = portesInterrieur;
    }
    public void setPiecePosition(PiecePosition piecePosition) {
        this.piecePosition = piecePosition;
    }
    public void setPieceDimension(PieceDimension pieceDimension) {
        this.pieceDimension = pieceDimension;
    }
    public void setPiecePositionDemande(PiecePositionDemande piecePositionDemande) {
        this.piecePositionDemande = piecePositionDemande;
    }

    //ajout d'element
    public void ajoutPorte(Porte porte) {
        portesInterrieur.add(porte);
    }

    //verification collision
    public boolean verifierCollisionPorte(Porte nouvellePorte) {

        for(Porte porte : portesInterrieur) {

            if(porte.getPosition() == nouvellePorte.getPosition()
                    &&
                    porte.getPlace() == nouvellePorte.getPlace()) {

                return true;
            }
        }

        return false;
    }
    public boolean verifierCollisionPorteFenetre(Fenetre nouvelleFenetre) {

        for(Porte porte : portesInterrieur) {

            if(porte.getPosition().name().equals( nouvelleFenetre.getPosition().name())
                    &&
                    porte.getPlace().name().equals( nouvelleFenetre.getPlace().name())) {

                return true;
            }
        }

        return false;
    }
    public boolean verifierCollisionFenetre(Fenetre nouvelleFenetre) {

        for(Fenetre fenetre : fenetres) {

            if(fenetre.getPosition() == nouvelleFenetre.getPosition()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {

        if(nom != null && !nom.isBlank()) {
            return nom;
        }
        return  type.toString();
    }

}
