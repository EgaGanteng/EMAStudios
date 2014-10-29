/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world.map;

import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author i13047
 */
public abstract class Grid{
    protected BufferedImage img;
    protected String nama;
    protected boolean isSteppable;
    protected boolean isEditable;
    public static final int CANVAS_WIDTH = 65;
    public static final int CANVAS_HEIGHT = 65;

    public Grid() {
    }

    
    public BufferedImage getImg(){
        return img;
    }

    public String getNama(){
        return nama;
    }
    
}
