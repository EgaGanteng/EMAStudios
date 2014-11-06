/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.awt.Graphics;

/**
 *
 * @author Garlzend
 */
public interface Drawable {
    public abstract void drawDefault(Graphics g);
    
    public abstract void drawAt(Graphics g,int offsetX,int offsetY);
}