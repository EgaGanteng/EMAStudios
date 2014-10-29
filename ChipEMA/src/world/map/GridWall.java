/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world.map;

import java.awt.Dimension;
import java.awt.Graphics;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import static world.map.Grid.CANVAS_HEIGHT;
import static world.map.Grid.CANVAS_WIDTH;

/**
 *
 * @author i13047
 */
public class GridWall extends Grid {

    private String imgFileName = "image/wall.jpg";
    private Object imgUrl;
    
    public GridWall() {
        this.nama = "Dinding";
        this.isSteppable = false;
        this.isEditable = false;
        
        this.imgUrl = getClass().getClassLoader().getResource(imgFileName);

    }
    
}
