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
public class GridKey extends Grid {

    private String imgFileName = "image/key.jpg";
    private Object imgUrl;
    
    public GridKey() {
        this.nama = "Key";
        this.isSteppable = true;
        this.isEditable = false; 
        
        this.imgUrl = getClass().getClassLoader().getResource(imgFileName);
    }
}

