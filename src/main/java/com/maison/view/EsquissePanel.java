package com.maison.view;

import com.maison.model.Terrain;

import javax.swing.*;
import java.awt.*;

public class EsquissePanel extends JPanel {

    private Terrain terrain;

    public EsquissePanel(Terrain terrain) {
        this.terrain = terrain;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        int x = 50;
        int y = 50;

        int largeur = (int) terrain.getLargeurTerrain();
        int longueur = (int) terrain.getLongeurterrain();

        // Dessin du terrain
        g2.drawRect(x, y, largeur, longueur);

        // Informations du terrain
        g2.drawString(
                "Largeur : " + terrain.getLargeurTerrain() + " m",
                x,
                y + longueur + 20
        );

        g2.drawString(
                "Longueur : " + terrain.getLongeurterrain() + " m",
                x,
                y + longueur + 40
        );

        g2.drawString(
                "Surface : " + terrain.getSurface() + " m²",
                x,
                y + longueur + 60
        );
    }
}