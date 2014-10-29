/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world.map;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author i13047
 */
public class GridBarrier extends Grid {

    private String imgFileName = "image/barrier.jpg";
    private Object imgUrl;
    public GridBarrier() {
        this.nama = "Barrier";
        this.isSteppable = false;
        this.isEditable = true;
        
        this.imgUrl = getClass().getClassLoader().getResource(imgFileName);
        
    }
}
