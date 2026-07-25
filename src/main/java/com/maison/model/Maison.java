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
        this.portes = new ArrayList<>();
        this.fenetres = new ArrayList<>();
    }

    //ajout
    public void ajoutPiece(Piece piece) {
        pieces.add(piece);
    }
    public void ajoutContrainte(Contrainte contrainte) { contraintes.add(contrainte); }
    public void ajoutPorte(Porte porte) {
        portes.add(porte);
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
    public List<Porte> getPortes() {
        return portes;
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
    private List<Porte> portes;
    public void setPortes(List<Porte> portes) {
        this.portes = portes;
    }
    public void setFenetres(List<Fenetre> fenetres) {
        this.fenetres = fenetres;
    }

    @Override
    public String toString() {
        return "Maison{ " +
                " nombrePieces=" + pieces.size() +
                '}';
    }

}
