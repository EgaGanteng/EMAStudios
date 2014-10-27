/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import sun.security.action.GetLongAction;

/**
 *
 * @author i13047
 */
public class Player implements Runnable{

    private Point location;

    public int getLocationX() {
        return location.x;
    }
    public int GetLocationY(){
        return location.y;
    }
    
    public void move(int direction){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
