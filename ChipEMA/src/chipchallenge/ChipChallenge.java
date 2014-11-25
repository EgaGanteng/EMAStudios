/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chipchallenge;

import controller.Controller;
import java.awt.Dimension;
import javax.swing.JFrame;
import view.Canvas;

/**
 * Kelas inti yang menjalankan Game.
 * @author EMA STUDIOS
 */
public class ChipChallenge {
    public static void main(String[] args) {
        JFrame f = new JFrame("EMA Chip Challenge");
        Canvas ra = new Canvas();
        Controller ctrl = new Controller(ra);
        ra.setCtrl(ctrl);
        Thread thread = new Thread((Controller)ctrl);
        thread.start();
        f.getContentPane().add("Center", ra);
        f.pack();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(new Dimension(1024, 600));
        f.setVisible(true);
    }
}
