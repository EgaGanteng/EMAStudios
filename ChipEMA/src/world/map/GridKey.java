/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world.map;

import java.awt.Color;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author Michael kinsey
 */
public class GridKey extends Grid {
    
    public GridKey() {
        this.nama = "Key";
        this.isSteppable = true;
        this.isEditable = false;
        this.imgFileName = "image/key.jpg";
        URL imgUrl=getClass().getClassLoader().getResource(imgFileName);
        try{
            this.img=ImageIO.read(imgUrl);
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}

