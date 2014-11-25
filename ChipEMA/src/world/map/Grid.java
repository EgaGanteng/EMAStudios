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
    
    /**
     * Method untuk menload image untuk grid yang akan digambar nanti
     */
    public void loadImage() {
        URL imgUrl = getClass().getClassLoader().getResource(imgFileName);
        try {
            this.img = ImageIO.read(imgUrl);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Method untuk mendapatkan image yang digunakan dalam kelas Grid 
     * @return image Kelas Grid
     */
    public BufferedImage getImage() {
        if (this.img == null) {
            loadImage();
        }
        return this.img;
    }

    /**
     * Method untuk mengecek apakah grid dapat dilangkahi oleh chip atau tidak
     * @return true jika dapat dilangkahi oleh chip, false jika tidak
     */
    public boolean isSteppable() {
        return isSteppable;
    }
    
    /**
     * Method untuk mengecek apakah kelas grid dapat diganti tipe gridnya,
     * Seperti grid yang asalnya GridDoor dapat diganti menjadi Grid lantai kosong
     * @return 
     */
    public boolean isEditable() {
        return isEditable;
    }
    
    /**
     * Method untuk mendapatkan nama Grid
     * @return nama Grid
     */
    public String getNama() {
        return nama;
    }
}
