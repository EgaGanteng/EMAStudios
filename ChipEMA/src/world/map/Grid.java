/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.map;

import interfaces.Drawable;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author i13047
 */
public abstract class Grid {

    protected BufferedImage img;
    protected String imgFileName;
    protected String nama;
    protected boolean isSteppable;
    protected boolean isEditable;
    public static final int CANVAS_WIDTH = 65;
    public static final int CANVAS_HEIGHT = 65;

    public Grid() {

    }

    public void loadImage() {
        URL imgUrl = getClass().getClassLoader().getResource(imgFileName);
        try {
            this.img = ImageIO.read(imgUrl);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public BufferedImage getImage() {
        if (this.img == null) {
            loadImage();
        }
        return this.img;
    }

    public boolean isSteppable() {
        return isSteppable;
    }

    public boolean isEditable() {
        return isEditable;
    }

    public String getNama() {
        return nama;
    }
}
