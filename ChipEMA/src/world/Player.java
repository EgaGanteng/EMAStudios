/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import interfaces.Drawable;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import sun.security.action.GetLongAction;

/**
 * Kelas untuk merepresentasikan Chip yang akan digunakan dalam permainan chip challenge ini
 * @author EMA Studios
 */
public class Player implements Drawable {

    private Point location;
    private boolean isDead;
    private BufferedImage[] chip;
    private int animationIteration;
    private int condition;
    public static int ATAS = 0, KANAN = 1, BAWAH = 2, KIRI = 3, IDLE = -1, GOSONG = 4, NYEMPLUNG = 5;

    /**
     * Method untuk mendapakan lokasi X player.
     * @return lokasi x
     */
    public int getLocationX() {
        return location.x;
    }

    /**
     * Constructor ini untuk membuat suatu player baru dengan lokasi x dengan y.
     * @param x koordinat x dimana player dibuat
     * @param y koordinat y dimana player dibuat
     */
    public Player(int x, int y) {
        this.location = new Point(x, y);
        this.isDead = false;
        this.chip = new BufferedImage[11];
        condition = -1;
        URL imgUrl = getClass().getClassLoader().getResource("image/player/ChibiMini.png");
        URL imgUrlKanan1 = getClass().getClassLoader().getResource("image/player/moveRight1.png");
        URL imgUrlKanan2 = getClass().getClassLoader().getResource("image/player/moveRight2.png");
        URL imgUrlKiri1 = getClass().getClassLoader().getResource("image/player/moveLeft1.png");
        URL imgUrlKiri2 = getClass().getClassLoader().getResource("image/player/moveLeft2.png");
        URL imgUrlAtas1 = getClass().getClassLoader().getResource("image/player/moveUp1.png");
        URL imgUrlAtas2 = getClass().getClassLoader().getResource("image/player/moveUp2.png");
        URL imgUrlBawah1 = getClass().getClassLoader().getResource("image/player/moveDown1.png");
        URL imgUrlBawah2 = getClass().getClassLoader().getResource("image/player/moveDown2.png");
        URL imgUrlGosong = getClass().getClassLoader().getResource("image/player/gosong.png");
        URL imgUrlNyemplung = getClass().getClassLoader().getResource("image/player/sink.png");
        animationIteration = 0;
        try {
            this.chip[0] = ImageIO.read(imgUrl);
            this.chip[1] = ImageIO.read(imgUrlKanan1);
            this.chip[2] = ImageIO.read(imgUrlKanan2);
            this.chip[3] = ImageIO.read(imgUrlKiri1);
            this.chip[4] = ImageIO.read(imgUrlKiri2);
            this.chip[5] = ImageIO.read(imgUrlAtas1);
            this.chip[6] = ImageIO.read(imgUrlAtas2);
            this.chip[7] = ImageIO.read(imgUrlBawah1);
            this.chip[8] = ImageIO.read(imgUrlBawah2);
            this.chip[9] = ImageIO.read(imgUrlGosong);
            this.chip[10] = ImageIO.read(imgUrlNyemplung);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method untuk mendapatkan gambar Chip.
     * @return image yang digunakan untuk menggambar chip
     */
    public BufferedImage getImageChip() {
        return chip[animationIteration];
    }

    /**
     * Getter untuk mendapatkan lokasi Y chip
     * @return lokasi y
     */
    public int getLocationY() {
        return location.y;
    }

    /**
     * Method untuk menggerakkan chip ke arah tertentu
     * @param direction contoh= Player.ATAS
     */
    public void move(int direction) {
        if (direction == ATAS) {
            this.location.y--;
            condition = direction;
            animationIteration = 5;
        } else if (direction == KANAN) {
            this.location.x++;
            condition = direction;
            animationIteration = 1;
        } else if (direction == BAWAH) {
            this.location.y++;
            condition = direction;
            animationIteration = 7;
        } else if (direction == KIRI) {
            this.location.x--;
            condition = direction;
            animationIteration = 3;
        }
    }

    /**
     * Method untuk mengiterasikan urutan animasi chip agar berubah ke frame yang selanjutnya
     */
    public void nextFrame() {
        if (condition != IDLE && condition != GOSONG && condition != NYEMPLUNG) {
            animationIteration++;
            if (condition == KANAN) {
                if (animationIteration >= 3) {
                    animationIteration = 1;
                }
            } else if (condition == KIRI) {
                if (animationIteration >= 5) {
                    animationIteration = 3;
                }
            } else if (condition == ATAS) {
                if (animationIteration >= 7) {
                    animationIteration = 5;
                }
            } else if (condition == BAWAH) {
                if (animationIteration >= 9) {
                    animationIteration = 7;
                }
            }
//            System.out.println(animationIteration);
        }
    }

    /**
     * Method untuk menset kondisi player.
     * @param condition contoh Player.GOSONG
     */
    public void setCondition(int condition) {
        this.condition = condition;
        if (condition == IDLE) {
            animationIteration = 0;
        } else if (condition == KANAN) {
            animationIteration = 1;
        } else if (condition == KIRI) {
            animationIteration = 3;
        } else if (condition == ATAS) {
            animationIteration = 5;
        } else if (condition == BAWAH) {
            animationIteration = 7;
        } else if (condition == GOSONG) {
            animationIteration = 9;
        } else if (condition == NYEMPLUNG) {
            animationIteration = 10;
        }
    }

    /**
     * Method untuk mensetPlayer apakah sudah mati atau hidup.
     * @param kondisi apakah player hidup atau tidak
     */
    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }

    /**
     * Method untuk mengetahui apakan player sudah mati atau masih hidup.
     * @return true jika player sudah mati, false jika player belum mati 
     */
    public boolean isIsDead() {
        return isDead;
    }

    @Override
    public void drawDefault(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(chip[animationIteration], 0, 0, null);    }

    @Override
    public void drawAt(Graphics g, int offsetX, int offsetY) {

        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(chip[animationIteration], offsetX, offsetY, null);
    }
}
