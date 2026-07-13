package com.maison.services;

import com.maison.model.*;

public class GenerateurEsquise {

    private static final double marge = 1;

    public void generer(Maison maison) {

        positionnerMaison(maison);

        for (Piece piece : maison.getPieces()) {
            positionnerPiece(piece, maison);
            while(!positionLibre(piece, maison)){

                piece.getPosition().setX(
                        piece.getPosition().getX() + 1
                );

            }
            verifierDansMaison(piece, maison);
        }
        for (Contrainte c : maison.getContraintes()) {
            appliquerContrainte(c);
        }
    }

    private void positionnerPiece(Piece piece, Maison maison) {

        double x = 0;
        double y = 0;

        switch(piece.getPiecePositionDemande()) {
            case NORD:
                x = (maison.getLargeur() - piece.getDimension().getLargeur()) / 2;
                y = marge;
                break;
            case SUD:
                x = (maison.getLargeur() - piece.getDimension().getLargeur()) / 2;
                y = maison.getLongeur() - piece.getDimension().getLongueur() - marge;
                break;
            case EST:
                x = maison.getLargeur() - piece.getDimension().getLargeur() - marge;
                y = (maison.getLongeur() - piece.getDimension().getLongueur()) / 2;
                break;
            case OUEST:
                x = marge;
                y = (maison.getLongeur() - piece.getDimension().getLongueur()) / 2;
                break;
            case CENTRE:
                x = (maison.getLargeur() - piece.getDimension().getLargeur()) / 2;
                y = (maison.getLongeur() - piece.getDimension().getLongueur()) / 2;
                break;
            case NORD_EST:
                x = maison.getLargeur() - piece.getDimension().getLargeur() - marge;
                y = marge;
                break;
            case NORD_OUEST:
                x = marge;
                y = marge;
                break;
            case SUD_EST:
                x = maison.getLargeur() - piece.getDimension().getLargeur() - marge;
                y = maison.getLongeur() - piece.getDimension().getLongueur() - marge;
                break;
            case SUD_OUEST:
                x = marge;
                y = maison.getLongeur() - piece.getDimension().getLongueur() - marge;
                break;
        }

        piece.getPosition().setX((int)x);
        piece.getPosition().setY((int)y);

    }

    private void appliquerContrainte(Contrainte c) {

        Piece p1 = c.getP1();
        Piece p2 = c.getP2();

        double largeurP1 = p1.getDimension().getLargeur();
        double longueurP1 = p1.getDimension().getLongueur();
        double largeurP2 = p2.getDimension().getLargeur();
        double longueurP2 = p2.getDimension().getLongueur();

        switch(c.getDirection()) {
            case EST: p2.getPosition().setX(p1.getPosition().getX() + largeurP1 + marge);
                p2.getPosition().setY(p1.getPosition().getY());
                break;
            case OUEST:
                p2.getPosition().setX(p1.getPosition().getX() - largeurP2 - marge);
                p2.getPosition().setY(p1.getPosition().getY());
                break;
            case NORD:
                p2.getPosition().setX(p1.getPosition().getX());
                p2.getPosition().setY(p1.getPosition().getY() - longueurP2 - marge);
                break;
            case SUD:
                p2.getPosition().setX(p1.getPosition().getX());
                p2.getPosition().setY(p1.getPosition().getY() + longueurP1 + marge);
                break;
        }
    }

    private void positionnerMaison(Maison maison){

        double largeurTerrain = maison.getTerrain().getLargeurTerrain();
        double longueurTerrain = maison.getTerrain().getLongueurTerrain();
        double largeurMaison = maison.getLargeur();
        double longueurMaison = maison.getLongeur();
        double x = 0;
        double y = 0;

        switch(maison.getPosition()){

            case NORD:
                x = (largeurTerrain - largeurMaison) / 2;
                y = marge;
                break;
            case SUD:
                x = (largeurTerrain - largeurMaison) / 2;
                y = longueurTerrain - longueurMaison - marge;
                break;
            case EST:
                x = largeurTerrain - largeurMaison - marge;
                y = (longueurTerrain - longueurMaison) / 2;
                break;
            case OUEST:
                x = marge;
                y = (longueurTerrain - longueurMaison) / 2;
                break;
            case CENTRE:
                x = (largeurTerrain - largeurMaison) / 2;
                y = (longueurTerrain - longueurMaison) / 2;
                break;
            case NORD_OUEST:
                x = marge;
                y = marge;
                break;
            case NORD_EST:
                x = largeurTerrain - largeurMaison - marge;
                y = marge;
                break;
            case SUD_OUEST:
                x = marge;
                y = longueurTerrain - longueurMaison - marge;
                break;
            case SUD_EST:
                x = largeurTerrain - largeurMaison - marge;
                y = longueurTerrain - longueurMaison - marge;
                break;
        }
        x = Math.max(0, x);
        y = Math.max(0, y);

        if (x + largeurMaison > largeurTerrain) {
            x = largeurTerrain - largeurMaison;
        }

        if (y + longueurMaison > longueurTerrain) {
            y = longueurTerrain - longueurMaison;
        }

        maison.setX((int) x);
        maison.setY((int) y);

    }

    private boolean collision(Piece p1, Piece p2) {
        int x1 = (int)p1.getPosition().getX();
        int y1 = (int)p1.getPosition().getY();

        int l1 = (int)p1.getDimension().getLargeur();
        int h1 = (int)p1.getDimension().getLongueur();

        int x2 = (int)p2.getPosition().getX();
        int y2 = (int)p2.getPosition().getY();

        int l2 = (int)p2.getDimension().getLargeur();
        int h2 = (int)p2.getDimension().getLongueur();

        return x1 < x2 + l2 &&
                x1 + l1 > x2 &&
                y1 < y2 + h2 &&
                y1 + h1 > y2;
    }

    private boolean positionLibre(Piece piece, Maison maison) {
        for (Piece autre : maison.getPieces()) {
            if(autre != piece && collision(piece,autre)) {
                return false;
            }
        }
        return true;
    }
    private void verifierDansMaison(Piece piece, Maison maison){

        int x = (int) piece.getPosition().getX();
        int y = (int) piece.getPosition().getY();

        int largeurPiece = (int) piece.getDimension().getLargeur();
        int longueurPiece = (int) piece.getDimension().getLongueur();


        if(x < 0){
            piece.getPosition().setX(0);
        }

        if(y < 0){
            piece.getPosition().setY(0);
        }


        if(x + largeurPiece > maison.getLargeur()){

            piece.getPosition().setX(
                    (int)maison.getLargeur() - largeurPiece
            );

        }

        if(y + longueurPiece > maison.getLongeur()){

            piece.getPosition().setY(
                    (int)maison.getLongeur() - longueurPiece
            );

        }
    }

}