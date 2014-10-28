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
public class GridFire extends Grid {

    private String imgFileName = "fire.jpg";
    private Object imgUrl;
    
    public GridFire() {
        this.nama = "Fire";
        this.isSteppable = true;
        this.isEditable = false; 
        
        URL imgUrl = getClass().getClassLoader().getResource(imgFileName);
        if(imgUrl ==null){
            System.err.println("Couldn't find file: "+imgFileName);
        }
        else{
            try{
                img = ImageIO.read(imgUrl);
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }
        setPreferredSize(new Dimension(CANVAS_WIDTH,CANVAS_HEIGHT));
    }

    protected void paintComponent(Graphics g, int x,int y) {
        super.paintComponent(g);
        g.drawImage(img, x, y, null); // see javadoc for more info on the parameters            
    }
    
}
