/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world.map;

import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author Michael kinsey
 */
public class GridDoor extends Grid {
    public final static String PINTU_BIRU="PINTU BIRU";
    public final static String PINTU_MERAH="PINTU MERAH";
    public final static String PINTU_KUNING="PINTU KUNING";
    public final static String PINTU_HIJAU="PINTU HIJAU";
    
    
    public GridDoor(String warnaPintu) {
        this.nama = warnaPintu;
        if(this.nama.equals("PINTU BIRU"))
        {
            this.imgFileName="image/doorBlue.jpg";
        }
        else if(this.nama.equals("PINTU MERAH"))
        {
            this.imgFileName="image/doorRed.jpg";
        }
        else if(this.nama.equals("PINTU KUNING"))
        {
            this.imgFileName="image/doorYellow.jpg";
        }
        else if(this.nama.equals("PINTU HIJAU"))
        {
            this.imgFileName="image/doorGreen.jpg";
        }
        this.isSteppable = false;
        this.isEditable = true; 
    }
}
