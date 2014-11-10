/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import interfaces.Drawable;
import java.awt.Graphics;
import java.awt.event.KeyListener;
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

    public Canvas() {
    }

    public void setCtrl(Controller ctrl) {
        this.ctrl = ctrl;
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
        img = new BufferedImage(1024, 1000, BufferedImage.BITMASK);
        ctrl.getAllDrawable()[1].drawDefault(img.getGraphics());
        g.drawImage(img, 0, 0, null);
    }
}
