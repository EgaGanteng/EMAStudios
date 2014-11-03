/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
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
    private Controller ctrl;
    private BufferedImage img;
    public Canvas() {
        ctrl = new Controller(this);
        img = new BufferedImage(1024, 600, BufferedImage.BITMASK);
        Thread thread = new Thread(ctrl);
        thread.start();
    }

    public BufferedImage getImg() {
        return img;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        ctrl.drawAll();
        g.drawImage(img, 0, 0, this);
        img = new BufferedImage(1024, 600, BufferedImage.BITMASK);
    }
}
