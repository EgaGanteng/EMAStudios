/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaces;

import java.awt.Graphics;

/**
 * Interface yang digunakan untuk memberikan kemampuan kepada kelas yang mengimplement interface ini mempunyai kemampuan
 * untuk menentukan letak gambar image yang ingin dibuat dan macem - macem image atau grafic yang ingin dibuat
 * @author Garlzend
 */
public interface Drawable {
    /**
     * Method untuk menggambar image di titik 0,0
     * @param g 
     */
    public abstract void drawDefault(Graphics g);
    
    /**
     * Method untuk menggambar image di titik yang ditentukan di param offsetX,offsetY
     * @param g
     * @param offsetX titik koordinat x dimana gambar ingin dibuat
     * @param offsetY titik koordinat y dimana gambar ingin dibuat
     */
    public abstract void drawAt(Graphics g,int offsetX,int offsetY);
}
