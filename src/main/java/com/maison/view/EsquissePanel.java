package com.maison.view;

import com.maison.model.Maison;
import com.maison.model.Piece;
import com.maison.model.Porte;
import com.maison.model.Terrain;

import javax.swing.*;
import java.awt.*;

public class EsquissePanel extends JPanel {

    private Terrain terrain;
    private Maison maison;

    public EsquissePanel(Terrain terrain, Maison maison){
        this.terrain = terrain;
        this.maison = maison;
    }

    public double calculerEchelle() {
        double terrainLargeur = (int)terrain.getLargeurTerrain();
        double terrainLongueur= (int)terrain.getLongueurTerrain();

        double echelleX = 900.0 / terrainLargeur;
        double echelleY = 600.0 / terrainLongueur;

        return Math.min(echelleX,echelleY);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g ;
        double echelle = calculerEchelle();

        //terrain
        int terrainX = 50;
        int terrainY = 50;

        int terrainLargeurPx = (int)(terrain.getLargeurTerrain() * echelle);
        int terrainLongueurPx = (int)(terrain.getLongueurTerrain() * echelle);

        g2.drawRect(terrainX, terrainY, terrainLargeurPx, terrainLongueurPx);
        g2.drawString("Largeur : " + terrain.getLargeurTerrain() + "m", terrainX, terrainY + terrainLongueurPx + 20);
        g2.drawString("Longueur : " + terrain.getLongueurTerrain() + "m", terrainX, terrainY + terrainLongueurPx + 40);
        g2.drawString("Surface : " + terrain.getSurface() + "m“", terrainX, terrainY + terrainLongueurPx + 60);
        g2.drawString("TERRAIN", terrainX + terrainLargeurPx  - 30, terrainY + terrainLongueurPx );

        //maison
        int maisonLongueurPx = (int)(maison.getLongeur() * echelle);
        int maisonLargeurPx = (int)(maison.getLargeur() * echelle);

        int maisonX = terrainX + (int)(maison.getX() * echelle );
        int maisonY = terrainY + (int)(maison.getY() * echelle );

        g2.drawRect(maisonX, maisonY, maisonLargeurPx, maisonLongueurPx);
        g2.drawString("MAISON", maisonX + 10, maisonY + 20);

        //pieces
        for (Piece p : maison.getPieces()) {

            int pieceX = maisonX + (int)(p.getPosition().getX() * echelle);
            int pieceY = maisonY + (int)(p.getPosition().getY() * echelle);

            int pieceLargeurPx = (int)(p.getDimension().getLargeur() * echelle);
            int pieceLongueurPx = (int)(p.getDimension().getLongueur() * echelle);

            g2.drawRect(pieceX, pieceY,pieceLargeurPx,  pieceLongueurPx);
            g2.drawString(p.getNom(), pieceX + 10, pieceY + 10);

            //dessin des portes
            for(Porte porte : p.getPortes()){

                dessinerPorte(
                        g2,
                        porte,
                        pieceX,
                        pieceY,
                        pieceLargeurPx,
                        pieceLongueurPx,
                        echelle
                );
            }

        }
        System.out.println("Echelle = " + echelle);



    }

    private void dessinerPorte(
            Graphics2D g2,
            Porte porte,
            int pieceX,
            int pieceY,
            int pieceLargeurPx,
            int pieceLongueurPx,
            double echelle
    ){
        int largeurPortePx =
                (int)(porte.getLargeur() * echelle);

        switch(porte.getPosition()){

            case NORD:

                g2.drawLine(
                        pieceX + (pieceLargeurPx - largeurPortePx) / 2,
                        pieceY,
                        pieceX + (pieceLargeurPx + largeurPortePx) / 2,
                        pieceY
                );

                break;
            case SUD:

                g2.drawLine(
                        pieceX + (pieceLargeurPx - largeurPortePx) / 2,
                        pieceY + pieceLongueurPx,
                        pieceX + (pieceLargeurPx + largeurPortePx) / 2,
                        pieceY + pieceLongueurPx
                );

                break;
            case EST:

                g2.drawLine(
                        pieceX + pieceLargeurPx,
                        pieceY + (pieceLongueurPx - largeurPortePx) / 2,
                        pieceX + pieceLargeurPx,
                        pieceY + (pieceLongueurPx + largeurPortePx) / 2
                );

                break;
            case OUEST:

                g2.drawLine(
                        pieceX,
                        pieceY + (pieceLongueurPx - largeurPortePx) / 2,
                        pieceX,
                        pieceY + (pieceLongueurPx + largeurPortePx) / 2
                );

                break;
        }
    }

}
