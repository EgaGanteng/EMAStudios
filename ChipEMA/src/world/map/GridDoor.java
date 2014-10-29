/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world.map;

/**
 *
 * @author Michael kinsey
 */
public class GridDoor extends Grid {

    private String imgFileName = "image/door.jpg";
    private Object imgUrl;
    
    public GridDoor() {
        this.nama = "Door";
        this.isSteppable = true;
        this.isEditable = false; 
        
        this.imgUrl = getClass().getClassLoader().getResource(imgFileName);
    }
}
