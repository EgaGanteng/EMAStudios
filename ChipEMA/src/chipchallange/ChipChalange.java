/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chipchallange;

import controller.Controller;
import java.awt.Dimension;
import javax.swing.JFrame;
import view.Canvas;

/**
 * Method inti yang menjalankan Game.
 * @author Ega Prianto
 */
public class ChipChalange {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        Canvas ra = new Canvas();
        
        f.getContentPane().add("Center", ra);
        f.pack();
        f.setSize(new Dimension(800, 480));
        f.setVisible(true);
    }
}
