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

    public GridDoor() {
        this.nama = "Door";
        this.imgFileName = "image/door.jpg";
        this.isSteppable = true;
        this.isEditable = false; 
    }
}
