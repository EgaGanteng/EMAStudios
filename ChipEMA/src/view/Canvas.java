/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import interfaces.Drawable;
import interfaces.Modelled;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author i13047
 */
public class Canvas extends JPanel {

    private Modelled ctrl;
    private BufferedImage img;

    public Canvas() {

    }

    public void setCtrl(Modelled ctrl) {
        this.ctrl = ctrl;
    }

    public BufferedImage getImg() {
        return img;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        img = new BufferedImage(1024, 600, BufferedImage.BITMASK);
        ctrl.getAllDrawable()[0].drawDefault(img.getGraphics());
        g.drawImage(img, 0, 0, this);
    }
}
