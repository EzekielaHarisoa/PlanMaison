package com.maison.view;

import javax.swing.*;
import java.awt.*;

public class EsquissePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g ;
        g2.drawRect(50,50,150,100);
        g2.drawString("chambre",90,100);
    }

}
