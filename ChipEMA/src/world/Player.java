/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import interfaces.Drawable;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import sun.security.action.GetLongAction;

/**
 *
 * @author i13047
 */
public class Player implements Drawable {

    private Point location;
    private boolean isDead;
    private BufferedImage chip;
    private int pixelLocX, pixelLocY;
    public static int ATAS = 0, KANAN = 1, BAWAH = 2, KIRI = 3;

    public int getLocationX() {
        return location.x;
    }

    public Player(int x, int y) {
        this.location = new Point(x, y);
        this.isDead = false;
        URL imgUrl = getClass().getClassLoader().getResource("image/player/ChibiMini.png");
        try {
            this.chip = ImageIO.read(imgUrl);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public BufferedImage getImageChip() {
        return chip;
    }

    public int getLocationY() {
        return location.y;
    }

    public void move(int direction) {
        if (direction == ATAS) {
            this.location.y--;
        } else if (direction == KANAN) {
            this.location.x++;
        } else if (direction == BAWAH) {
            this.location.y++;
        } else if (direction == KIRI) {
            this.location.x--;
        }
    }

    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }

    public boolean isIsDead() {
        return isDead;
    }

    @Override
    public void drawDefault(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
//        g2.drawRect(location.x, location.y,100 , 100);
        g2.drawImage(chip, location.x, location.y, null);
//        BufferedImage img = null;
//        URL imgUrl = getClass().getClassLoader().getResource("image/barrier.jpg");
//        try {
//            img = ImageIO.read(imgUrl);
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        g2.drawImage(img, 0, 0, null);
    }

    @Override
    public void drawAt(Graphics g, int offsetX, int offsetY) {

        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(chip, offsetX, offsetY, null);
    }

}
