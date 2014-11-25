/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import java.awt.image.BufferedImage;

/**
 * Class ini adalah class yang merepresentasikan Item Sepatu dalam game Chip Challange.
 * @author EMA Studios
 */
public class Boot extends Item{
    public final static String SEPATU_API="SEPATU API";
    public final static String SEPATU_AIR="SEPATU AIR";
    
    /**
     * Constructor untuk meninisialisasi Attribut-attribut dari kelas Boot.
     * @param x lokasi X Boot dibuat
     * @param y lokasi Y Boot dibuat
     * @param jenisBoot untuk menentukan jenis ketahananan sepatu, apakah sepatu tahan air atau sepatu api
     */
    public Boot(int x, int y,String jenisBoot)
    {
        super(x,y);
        this.namaItem=jenisBoot;
        //this.isReusable=true;
        if(this.namaItem.equals("SEPATU AIR"))
        {
           this.imgFileName="image/waterBOOTS.jpg";
        }
        else if(this.namaItem.equals("SEPATU API"))
        {
            this.imgFileName="image/fireBOOTS.jpg";
        }
    }
    
    
}
