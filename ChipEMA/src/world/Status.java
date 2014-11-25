/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import interfaces.Drawable;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author EMA Studio
 */
public class Status implements Drawable{

    private int chipLeft;

    private int milliseconds = 0, seconds = 0, minutes = 0;
    private StringBuilder timeDisplay;
    private BufferedImage panel;
    private StringBuilder chipLeftDisplay;
    private Font displayFont;
    private String levelDisplay;
    
    /**
     * Constuctor yang digunakan untuk menginisialisasi attribute - attibute kelas status
     */
    public Status(int menit, int detik, int chipLeft,int level) {
        this.minutes = menit;
        this.seconds = detik;
        this.milliseconds = 0;
        this.chipLeft = chipLeft;
        timeDisplay = new StringBuilder();
        levelDisplay = "Level : " + level;
        chipLeftDisplay = new StringBuilder();
        URL imgUrl = getClass().getClassLoader().getResource("image/panelStatus.png");
        displayFont = new Font("VERDANA", Font.BOLD, 40);
        try {
            panel = ImageIO.read(imgUrl);
//        timer = new Timer(10,this);
//        timer.start();
        } catch (IOException ex) {
            Logger.getLogger(Status.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method ini adalah untuk mengurangi sisa chip yang terisa dengan parameter
     * yang diberikan.
     *
     * Contoh: Current Chip = 5; by = 2; Current Chip = 5-2;
     *
     * @param by
     */
    public void decreaseChip(int by) {
        chipLeft -= by;
    }

    /**
     * Method untuk mendapatkan jumlah chip yang tersisa di permainan
     * @return jumlah chip yang tersisa di permainan
     */
    public int getChipLeft() {
        return chipLeft;
    }
    
    
    public void decreaseTimeByMilis(int milidetik){
        this.milliseconds -=milidetik ;
        timeDisplay.delete(0, timeDisplay.length());
        this.calcTime();
        timeDisplay.append("Time : ");
        timeDisplay.append(minutes);
        timeDisplay.append(':');
        timeDisplay.append(seconds);       
    }

    private void calcTime() {
        if (this.milliseconds <= 0 && (this.seconds > 0 || this.minutes > 0)) {
            this.milliseconds = 999;
            this.seconds--;
        } else {
            this.milliseconds--;
        }
        if (this.seconds < 0 && this.minutes > 0) {
            this.seconds = 59;
            this.minutes--;
        }
        if (this.milliseconds < 0 && this.seconds < 0 && this.minutes < 0) {
            this.milliseconds = this.seconds = this.minutes = 0;
//            System.out.println("Waktu Habis!");
        }

//        if (this.seconds >= 0 && this.minutes > 0 && this.miliSeconds >= 0) {
//            System.out.println(this.minutes + ":" + this.seconds + ":" + this.miliSeconds);
//        } else if (this.seconds > 0 && this.miliSeconds >= 0 && this.minutes <= 0) {
//            System.out.println(seconds + ":" + this.miliSeconds);
//        } else if (this.seconds == 0 && this.minutes == 0 && this.miliSeconds > 0) {
//            System.out.println(this.miliSeconds);
//        }
    }

    @Override
    public void drawDefault(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawImage(panel, 0, 0, null);
        g.setFont(displayFont);
        g.drawString(levelDisplay, 90, 120);
        g.drawString(timeDisplay.toString(), 90,170);
        chipLeftDisplay.delete(0, chipLeftDisplay.length());
        if (chipLeft>1) {
            chipLeftDisplay.append("Chip lefts :");
        }else{
            chipLeftDisplay.append("Chip left :");
        }
        chipLeftDisplay.append(chipLeft);
        g.drawString(chipLeftDisplay.toString(), 90, 220);
    }

    @Override
    public void drawAt(Graphics g, int offsetX, int offsetY) {
        g.setColor(Color.BLACK);
        g.drawImage(panel, offsetX, offsetY, null);
        g.setFont(displayFont);
        g.drawString(levelDisplay, 90+offsetX, 120+offsetY);
        g.drawString(timeDisplay.toString(), 90+offsetX,170+offsetY);
        chipLeftDisplay.delete(0, chipLeftDisplay.length());
        if (chipLeft>1) {
            chipLeftDisplay.append("Chip lefts :");
        }else{
            chipLeftDisplay.append("Chip left :");
        }
        chipLeftDisplay.append(chipLeft);
        g.drawString(chipLeftDisplay.toString(), 90+offsetX, 220+offsetY);
    
    }

}
