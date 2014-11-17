/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import interfaces.Drawable;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;
import world.map.Grid;

/**
 *
 * @author i13047
 */
public class Canvas extends JPanel {

    private Controller ctrl;
    private BufferedImage img;
    private AffineTransform at;

    public Canvas() {
        at = new AffineTransform();
        at.scale(0.865, 0.865);
    }

    public void setCtrl(Controller ctrl) {
        this.ctrl = ctrl;
        img = new BufferedImage(1024, 600, BufferedImage.BITMASK);
        addKeyListener(ctrl);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
    }

    public BufferedImage getImg() {
        return img;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        img.getGraphics().setColor(Color.white);
        Graphics2D g2img = (Graphics2D)img.getGraphics();
        g2img.fillRect(0, 0, 1024, 600);
        g2img.setTransform(at);
        ctrl.getAllDrawable()[1].drawDefault(g2img);//board
        ctrl.getAllDrawable()[0].drawAt(g2img,ctrl.getPlayerPixelLocX(),ctrl.getPlayerPixelLocY());//player
        g.drawImage(img, 0, 0, null);
    }
}
