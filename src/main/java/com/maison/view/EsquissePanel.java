package com.maison.view;

import com.maison.model.*;

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

        g2.setStroke(new BasicStroke(3));
        g2.drawRect(terrainX, terrainY, terrainLargeurPx, terrainLongueurPx);
        g2.setColor(new Color(184,115,51));

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
        g2.setColor(Color.WHITE);
        g2.drawString("MAISON", maisonX + 10, maisonY + 20);
        g2.setStroke(new BasicStroke(1));

        // portes de la maison
        for(Porte porte : maison.getPortesExterrieur()){
            dessinerPorte(
                    g2,
                    porte,
                    maisonX,
                    maisonY,
                    maisonLargeurPx,
                    maisonLongueurPx,
                    echelle
            );
        }

        // fenêtres de la maison
        for(Fenetre fenetre : maison.getFenetres()){
            dessinerFenetre(
                    g2,
                    fenetre,
                    maisonX,
                    maisonY,
                    maisonLargeurPx,
                    maisonLongueurPx,
                    echelle
            );
        }

        //pieces
        for (Piece p : maison.getPieces()) {

            int pieceX = maisonX + (int)(p.getPosition().getX() * echelle);
            int pieceY = maisonY + (int)(p.getPosition().getY() * echelle);

            int pieceLargeurPx = (int)(p.getDimension().getLargeur() * echelle);
            int pieceLongueurPx = (int)(p.getDimension().getLongueur() * echelle);

            g2.setColor(getCouleurPiece(p));

            g2.fillRect(pieceX, pieceY, pieceLargeurPx, pieceLongueurPx);

            g2.setColor(Color.BLACK);

            g2.drawRect(pieceX, pieceY, pieceLargeurPx, pieceLongueurPx);

            String nom = p.getNom();
            String dimensions = p.getDimension().getLongueur() + "m x " + p.getDimension().getLargeur() + "m";
            FontMetrics fm = g2.getFontMetrics();

            int nomX = pieceX + (pieceLargeurPx - fm.stringWidth(nom)) / 2;
            int nomY = pieceY + pieceLongueurPx / 2 - 10;

            int dimX = pieceX + (pieceLargeurPx - fm.stringWidth(dimensions)) / 2;
            int dimY = nomY + 20;

            g2.drawString(nom, nomX, nomY);
            g2.drawString(dimensions, dimX, dimY);

            //dessin des portes
            for(Porte porte : p.getPortesInterrieur()){
                dessinerPorte(g2, porte, pieceX, pieceY, pieceLargeurPx, pieceLongueurPx, echelle);
            }

            //dessin des fenetres
            for(Fenetre fenetre : p.getFenetres()) {
                dessinerFenetre(g2, fenetre, pieceX, pieceY, pieceLargeurPx, pieceLongueurPx, echelle
                );
            }

        }

        dessinerLegende(g2, terrainX + terrainLargeurPx + 50, terrainY + 50);


    }

    private void dessinerCouleurTexte(Graphics2D g2, int x, int y, Color couleur, String texte){

        g2.setColor(couleur);
        g2.fillRect(x + 20, y - 10, 15, 15);

        g2.setColor(Color.BLACK);
        g2.drawString(texte, x + 45, y + 3);
    }

    private void dessinerPorte(Graphics2D g2, Porte porte, int pieceX, int pieceY, int pieceLargeurPx, int pieceLongueurPx, double echelle) {

        int largeurPortePx = (int)(porte.getLargeur() * echelle);

        Color ancienneCouleur = g2.getColor();
        Stroke ancienStroke = g2.getStroke();

        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(5));

        switch(porte.getPosition()) {
            case NORD:
                switch(porte.getPlace()) {
                    case GAUCHE:
                        g2.drawLine(pieceX + 20, pieceY, pieceX + 20 + largeurPortePx, pieceY);
                        break;
                    case MILIEU:
                        g2.drawLine(pieceX + (pieceLargeurPx - largeurPortePx) / 2, pieceY, pieceX + (pieceLargeurPx + largeurPortePx) / 2, pieceY);
                        break;
                    case DROITE:
                        g2.drawLine(pieceX + pieceLargeurPx - largeurPortePx - 20, pieceY, pieceX + pieceLargeurPx - 20, pieceY);
                        break;
                }
                break;
            case SUD:
                switch(porte.getPlace()) {
                    case GAUCHE:
                        g2.drawLine(pieceX + 20, pieceY + pieceLongueurPx, pieceX + 20 + largeurPortePx, pieceY + pieceLongueurPx);
                        break;
                    case MILIEU:
                        g2.drawLine(pieceX + (pieceLargeurPx - largeurPortePx) / 2, pieceY + pieceLongueurPx, pieceX + (pieceLargeurPx + largeurPortePx) / 2, pieceY + pieceLongueurPx);
                        break;
                    case DROITE:
                        g2.drawLine(pieceX + pieceLargeurPx - largeurPortePx - 20, pieceY + pieceLongueurPx, pieceX + pieceLargeurPx - 20, pieceY + pieceLongueurPx);
                        break;
                }
                break;
            case EST:
                switch(porte.getPlace()) {
                    case GAUCHE:
                        g2.drawLine(pieceX + pieceLargeurPx, pieceY + 20, pieceX + pieceLargeurPx, pieceY + 20 + largeurPortePx);
                        break;
                    case MILIEU:
                        g2.drawLine(pieceX + pieceLargeurPx, pieceY + (pieceLongueurPx - largeurPortePx) / 2, pieceX + pieceLargeurPx, pieceY + (pieceLongueurPx + largeurPortePx) / 2);
                        break;
                    case DROITE:
                        g2.drawLine(pieceX + pieceLargeurPx, pieceY + pieceLongueurPx - largeurPortePx - 20, pieceX + pieceLargeurPx, pieceY + pieceLongueurPx - 20);
                        break;
                }
                break;
            case OUEST:
                switch(porte.getPlace()) {
                    case GAUCHE:
                        g2.drawLine(pieceX, pieceY + 20, pieceX, pieceY + 20 + largeurPortePx);
                        break;
                    case MILIEU:
                        g2.drawLine(pieceX, pieceY + (pieceLongueurPx - largeurPortePx) / 2, pieceX, pieceY + (pieceLongueurPx + largeurPortePx) / 2);
                        break;
                    case DROITE:
                        g2.drawLine(pieceX, pieceY + pieceLongueurPx - largeurPortePx - 20, pieceX, pieceY + pieceLongueurPx - 20
                        );
                        break;
                }
                break;
        }

        g2.setColor(ancienneCouleur);
        g2.setStroke(ancienStroke);
    }private void dessinerFenetre(Graphics2D g2, Fenetre fenetre, int pieceX, int pieceY, int pieceLargeurPx, int pieceLongueurPx, double echelle){

        int largeurFenetrePx = (int)(fenetre.getLargeur() * echelle);

        Color ancienneCouleur = g2.getColor();
        Stroke ancienStroke = g2.getStroke();

        g2.setColor(Color.YELLOW);
        g2.setStroke(new BasicStroke(3));

        switch(fenetre.getPosition()){

            case NORD:
                g2.drawLine(
                        pieceX + (pieceLargeurPx - largeurFenetrePx) / 2,
                        pieceY,
                        pieceX + (pieceLargeurPx + largeurFenetrePx) / 2,
                        pieceY
                );
                break;
            case SUD:
                g2.drawLine(
                        pieceX + (pieceLargeurPx - largeurFenetrePx) / 2,
                        pieceY + pieceLongueurPx,
                        pieceX + (pieceLargeurPx + largeurFenetrePx) / 2,
                        pieceY + pieceLongueurPx
                );
                break;
            case EST:
                g2.drawLine(
                        pieceX + pieceLargeurPx,
                        pieceY + (pieceLongueurPx - largeurFenetrePx) / 2,
                        pieceX + pieceLargeurPx,
                        pieceY + (pieceLongueurPx + largeurFenetrePx) / 2
                );
                break;
            case OUEST:
                g2.drawLine(
                        pieceX,
                        pieceY + (pieceLongueurPx - largeurFenetrePx) / 2,
                        pieceX,
                        pieceY + (pieceLongueurPx + largeurFenetrePx) / 2
                );
                break;
        }

        g2.setColor(ancienneCouleur);
        g2.setStroke(ancienStroke);
    }private Color getCouleurPiece(Piece piece) {

        switch (piece.getType()) {

            case CUISINE:
                return new Color(255, 255, 150); // jaune clair

            case SALON:
                return new Color(170, 240, 170); // vert clair

            case CHAMBRE:
                return new Color(150, 200, 255); // bleu clair

            case SDB:
                return new Color(210, 210, 210); // gris clair

            case GARAGE:
                return new Color(255, 200, 120); // orange clair

            default:
                return Color.WHITE;
        }
    }

    private void dessinerLegende(Graphics2D g2, int x, int y) {

        int largeur = 180;
        int hauteur = 260;

        // fond de la légende
        g2.setColor(new Color(245,245,245));
        g2.fillRoundRect(x, y, largeur, hauteur, 15, 15);

        // bordure
        g2.setColor(Color.GRAY);
        g2.drawRoundRect(x, y, largeur, hauteur, 15, 15);


        // titre
        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.BOLD, 16));
        g2.drawString("LÉGENDE", x + 50, y + 30);


        int ligneY = y + 60;


        g2.setFont(new Font("Arial", Font.PLAIN, 13));


        // Porte
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(5));
        g2.drawLine(x + 20, ligneY, x + 50, ligneY);

        g2.setColor(Color.BLACK);
        g2.drawString("Porte", x + 70, ligneY + 5);



        // Fenêtre
        ligneY += 35;

        g2.setColor(Color.YELLOW);
        g2.setStroke(new BasicStroke(4));
        g2.drawLine(x + 20, ligneY, x + 50, ligneY);

        g2.setColor(Color.BLACK);
        g2.drawString("Fenêtre", x + 70, ligneY + 5);



        // Maison
        ligneY += 35;

        g2.setColor(Color.WHITE);
        g2.fillRect(x + 20, ligneY - 10, 30, 20);

        g2.setColor(Color.BLACK);
        g2.drawRect(x + 20, ligneY - 10, 30, 20);

        g2.drawString("Terrain", x + 70, ligneY + 5);



        // Terrain
        ligneY += 35;

        g2.setColor(new Color(184,115,51));
        g2.fillRect(x + 20, ligneY - 10, 30, 20);

        g2.setColor(Color.BLACK);
        g2.drawString("Maison", x + 70, ligneY + 5);



        // Pièces
        ligneY += 35;

        g2.setColor(new Color(150,200,255));
        g2.fillRect(x + 20, ligneY - 10, 30, 20);

        g2.setColor(Color.BLACK);
        g2.drawString("Pièce", x + 70, ligneY + 5);



        // couleurs pièces
        ligneY += 45;

        g2.setFont(new Font("Arial", Font.BOLD, 12));
        g2.drawString("Types :", x + 20, ligneY);


        ligneY += 25;
        g2.setFont(new Font("Arial", Font.PLAIN, 12));

        dessinerCouleurTexte(g2, x, ligneY, new Color(255,255,150), "Cuisine");
        ligneY += 22;

        dessinerCouleurTexte(g2, x, ligneY, new Color(170,240,170), "Salon");
        ligneY += 22;

        dessinerCouleurTexte(g2, x, ligneY, new Color(150,200,255), "Chambre");
        ligneY += 22;

        dessinerCouleurTexte(g2, x, ligneY, new Color(210,210,210), "SDB");
        ligneY += 22;

        dessinerCouleurTexte(g2, x, ligneY, new Color(255,200,120), "Garage");


        g2.setStroke(new BasicStroke(1));
    }
}
