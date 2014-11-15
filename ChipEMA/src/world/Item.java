/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author Antonius
 */
public abstract class Item {
    protected Point position;
    protected String namaItem;
    protected BufferedImage img;
    protected String imgFileName;
    //protected boolean isReusable;
            
    public Item(int x, int y)
    {
        this.position=new Point(x, y);

    }
    
    public void loadImage()
    {
        URL imgUrl=getClass().getClassLoader().getResource(imgFileName);
        try{
            this.img=ImageIO.read(imgUrl);
        }
        catch(IOException ex){
            ex.printStackTrace();
        }  
    }
    
    public BufferedImage getImage()
    {  
        if(this.img==null){
            loadImage();}
        return this.img;
    }
    
    public int getX()
    {
        return this.position.x;
    }
    
    public int getY()
    {
        return this.position.y;
    }
    
//    public boolean getReusable()
//    {
//        return this.isReusable;
//    }
}
