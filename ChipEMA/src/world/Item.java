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
 *  Class yang merepresentasi kan benda-benda yang dapat di gunakan oleh objek chip dalam game chip challange.
 * @author EMA Studios
 */
public abstract class Item {
    protected Point position;
    protected String namaItem;
    protected BufferedImage img;
    protected String imgFileName;
    //protected boolean isReusable;
            
    /**
     * Constructor untuk menginisialisasi Item. Dengan lokasi X dan Y.
     * @param x
     * @param y 
     */
    public Item(int x, int y)
    {
        this.position=new Point(x, y);
    }
    
    /**
     * Method untuk mengambil resource image.
     */
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
    
    /**
     * Method untuk mendapatkan image item.
     * @return Image Item.
     */
    public BufferedImage getImage()
    {  
        if(this.img==null){
            loadImage();}
        return this.img;
    }
    
    /**
     * Getter untuk mendapatkan nilai X.
     * @return x
     */
    public int getX()
    {
        return this.position.x;
    }
    
    /**
     * Getter untuk mendapatkan nilai Y
     * @return y.
     */
    public int getY()
    {
        return this.position.y;
    }
    
//    public boolean getReusable()
//    {
//        return this.isReusable;
//    }
}
