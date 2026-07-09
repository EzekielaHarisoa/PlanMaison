package com.maison.model;

import java.util.ArrayList;
import java.util.List;

public class Piece {

    private String nom;
    private String type;

    private Dimension dimension;
    private Position position;

    private List<Fenetre> fenetres;
    private List<Porte> portes;

    //getter
    public String getType() {
        return type;
    }
    public String getNom() {
        return nom;
    }
    public Dimension getDimension() {return dimension;}
    public Position getPosition() {
        return position;
    }
    public List<Fenetre> getFenetres() {
        return fenetres;
    }
    public List<Porte> getPortes() {
        return portes;
    }

    //setter
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public void setFenetres(List<Fenetre> fenetres) {
        this.fenetres = fenetres;
    }
    public void setPortes(List<Porte> portes) {
        this.portes = portes;
    }

    //ajout d'element
    public void ajoutPorte(Porte porte) {
        portes.add(porte);
    }
    public void ajoutFenetre(Fenetre fenetre) {
        fenetres.add(fenetre);
    }

    //contructeur
    public Piece( String nom, String type, Dimension dimension, Position position ) {
        this.nom = nom;
        this.type = type;
        this.dimension = dimension;
        this.position = position;
        this.portes = new ArrayList<>();
        this.fenetres = new ArrayList<>();
    }

}
