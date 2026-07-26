package com.maison.model;

import java.util.ArrayList;
import java.util.List;

public class Maison {

    private double largeur;
    private double longeur;

    private int x;
    private int y;

    private List<Piece> pieces;
    private List<Contrainte> contraintes;



    private Terrain terrain;
    private MaisonPosition position;

    public Maison(double longeur, double largeur, Terrain terrain, MaisonPosition position) {
        this.longeur = longeur;
        this.largeur = largeur;
        this.terrain = terrain;
        this.position = position;
        this.pieces = new ArrayList<>();
        this.contraintes = new ArrayList<>();
        this.portesExterrieur = new ArrayList<>();
        this.fenetres = new ArrayList<>();
    }

    //ajout
    public void ajoutPiece(Piece piece) {
        pieces.add(piece);
    }
    public void ajoutContrainte(Contrainte contrainte) { contraintes.add(contrainte); }
    public void ajoutPorte(Porte porte) {
        portesExterrieur.add(porte);
    }
    public void ajoutFenetre(Fenetre fenetre) {
        fenetres.add(fenetre);
    }

    //getter
    public double getLargeur() {
        return largeur;
    }
    public double getLongeur() {
        return longeur;
    }
    public List<Piece> getPieces() {
        return pieces;
    }
    public List<Contrainte> getContraintes() { return  contraintes; }
    public Terrain getTerrain() {
        return terrain;
    }
    public MaisonPosition getPosition() {
        return position;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public List<Porte> getPortesExterrieur() {
        return portesExterrieur;
    }
    public List<Fenetre> getFenetres() {
        return fenetres;
    }

    //setter
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }
    public void setLongeur(double longeur) {
        this.longeur = longeur;
    }
    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }
    public void setContraintes(List<Contrainte> contraintes) {
        this.contraintes = contraintes;
    }
    public void setPosition(MaisonPosition position) {
        this.position = position;
    }
    private List<Fenetre> fenetres;
    private List<Porte> portesExterrieur;
    public void setPortesExterrieur(List<Porte> portesExterrieur) {
        this.portesExterrieur = portesExterrieur;
    }
    public void setFenetres(List<Fenetre> fenetres) {
        this.fenetres = fenetres;
    }

    public boolean verifierCollisionPorteMaison(Porte portePiece) {

        for(Porte porteMaison : getPortesExterrieur()) {

            if(portePiece.getPosition() == porteMaison.getPosition()
                    &&
                    portePiece.getPlace() == porteMaison.getPlace()) {

                return true;
            }
        }
        return false;
    }

    public boolean verifierCollisionPorteFenetreMaison(Fenetre nouvelleFenetre) {

        for(Porte porte : portesExterrieur) {

            if(porte.getPosition().name()
                    .equals(nouvelleFenetre.getPosition().name())
                    &&
                    porte.getPlace().name().equals(nouvelleFenetre.getPlace().name()) ) {

                return true;
            }
        }


        return false;
    }

    public boolean verifierCollisionPorteFenetre(Porte porte, Fenetre fenetre) {
        return porte.getPosition().name().equals(fenetre.getPosition().name())
                && porte.getPlace().name().equals( fenetre.getPlace().name());
    }

    @Override
    public String toString() {
        return "Maison{ " +
                " nombrePieces=" + pieces.size() +
                '}';
    }

}
