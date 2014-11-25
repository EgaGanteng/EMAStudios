/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.Controller;
import interfaces.Drawable;
import java.awt.Color;
import java.awt.Font;
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
    private boolean tamat;
    private Font typeFont1,typeFont2;
    
    /**
     * Constructor untuk menginisialisasi attribute - attribute kelas Canvas
     */
    public Canvas() {
        at = new AffineTransform();
        at.scale(0.865, 0.865);
        this.typeFont1=new Font("TIMES NEW ROMAN", Font.BOLD, 50);
        this.typeFont2=new Font("TIMES NEW ROMAN", Font.PLAIN, 35);
        this.tamat=false;
    }
    
    /**
     * Method untuk menset attribute tamat yang berfungsi sebagai pengecek apakah sudah tamat atau belum menjadi true
     */
    public void setTamat()
    {
        this.tamat=true;
    }
    
    /**
     * Method untuk menset Controller manakah yang digunakan di kelas canvas ini
     * @param ctrl referensi attribute Controller yang ingin di set
     */
    public void setCtrl(Controller ctrl) {
        this.ctrl = ctrl;
        img = new BufferedImage(1024, 600, BufferedImage.BITMASK);
        addKeyListener(ctrl);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
    }
    
    /**
     * Method untuk melakukan penggambaran di panel
     * @param g 
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2img = (Graphics2D)img.getGraphics();
        g2img.setColor(Color.white);
        g2img.fillRect(0, 0, 1024, 600);
        g2img.setTransform(at);
        ctrl.getAllDrawable()[1].drawDefault(g2img);//board
        ctrl.getAllDrawable()[0].drawAt(g2img,ctrl.getPlayerPixelLocX(),ctrl.getPlayerPixelLocY());//player
        ctrl.getAllDrawable()[2].drawAt(g2img,650,500);
        ctrl.getAllDrawable()[3].drawAt(g2img,650,0);
        g.drawImage(img, 0, 0, null);
        if(tamat)
        {
            g.fillRect(120, 250, 500, 150);
            g.setColor(Color.blue);
            g.setFont(typeFont2);
            g.drawString("DADAAAH TUGAAAS",200,300);
            g.setColor(Color.RED);
            g.setFont(typeFont1);
            g.drawString("BESAAAARRRRRR",150,360);
        }
            
    }
}
