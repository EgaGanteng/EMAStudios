/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package world.map;

/**
 *
 * @author Antonius
 */
public class GridWater extends Grid{
    
    public GridWater() {
        this.nama = "Water";
        this.isSteppable = true;
        this.isEditable = false; 
        this.imgFileName = "image/water2.jpg";   
    }
}
