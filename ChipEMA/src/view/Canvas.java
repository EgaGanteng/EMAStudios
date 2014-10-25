/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author i13047
 */
public class Canvas extends JFrame{
    private BufferedImage myImage;
    public static int WIDTH = 1024;
    public static int HEIGHT = 800;
    
    public Canvas(KeyListener keyListener){
        this.addKeyListener(keyListener);
        JPanel panel = new JPanel();
        panel.setSize(WIDTH, HEIGHT);
        panel.setVisible(true);
        panel.setDoubleBuffered(true);
        this.setSize(WIDTH,HEIGHT);
        this.setVisible(true);
        this.add(panel);
        myImage = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
    }
    
    public Graphics getMyGraphics(){
        return myImage.getGraphics();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(myImage, 0, 0, null);
    }
}
