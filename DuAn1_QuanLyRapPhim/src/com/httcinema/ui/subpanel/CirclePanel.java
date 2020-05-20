package com.httcinema.ui.subpanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CirclePanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
    	g.setColor(getBackground());
    	((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.fillOval(0, 0, g.getClipBounds().width, g.getClipBounds().height);
    }
}