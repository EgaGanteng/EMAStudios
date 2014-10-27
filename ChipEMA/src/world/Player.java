/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import sun.security.action.GetLongAction;

/**
 *
 * @author i13047
 */
public class Player{
    
    private Point location;
    private boolean isDead;
    private BufferedImage chip;
    public static int ATAS = 0, KANAN = 1, BAWAH = 2, KIRI = 3;

    public int getLocationX() {
        return location.x;
    }

    public Player(int x,int y) {
        this.location = new Point(x, y);
        this.isDead = false;
    }

    public BufferedImage getImageChip() {
        return chip;
    }

    public int GetLocationY() {
        return location.y;
    }
    
    public void move(int direction) {
        if (direction == ATAS) {
            this.location.y--;
        } else if (direction == KANAN) {
            this.location.x++;
        } else if(direction == BAWAH){
            this.location.y++;
        }else if(direction== KIRI){
            this.location.x--;
        }
    }

    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }

    public boolean isIsDead() {
        return isDead;
    }

}
