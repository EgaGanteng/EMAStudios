/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import java.awt.image.BufferedImage;

/**
 *
 * @author Antonius
 */
public class Boot extends Item{
    public final static String SEPATU_API="SEPATU API";
    public final static String SEPATU_AIR="SEPATU AIR";
    
    public Boot(int x, int y,String jenisBoot)
    {
        super(x,y);
        this.namaItem=jenisBoot;
        //this.isReusable=true;
        if(this.namaItem.equals("SEPATU AIR"))
        {
           this.imgFileName="image/key.jpg";
        }
        else if(this.namaItem.equals("SEPATU API"))
        {
            this.imgFileName="image/key.jpg";
        }
    }
    
    public BufferedImage getImage()
    {  
        return this.img;
    }
    
}
