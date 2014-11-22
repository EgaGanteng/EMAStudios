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
    private StringBuilder chipLeftDisplay;

    public Status(int menit, int detik, int chipLeft) {
        this.minutes = menit;
        this.seconds = detik;
        this.milliseconds = 0;
        this.chipLeft = chipLeft;
        timeDisplay = new StringBuilder();
        chipLeftDisplay = new StringBuilder();
//        timer = new Timer(10,this);
//        timer.start();
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

    public int getChipLeft() {
        return chipLeft;
    }
    
    public void decreaseTimeByMilis(int milidetik){
        this.milliseconds -=milidetik ;
        timeDisplay.delete(0, timeDisplay.length());
        this.calcTime();
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
        if (this.seconds == 0 && this.minutes > 0) {
            this.seconds = 59;
            this.minutes--;
        }
        if (this.milliseconds == 0 && this.seconds == 0 && this.minutes == 0) {
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
        g.setColor(Color.red);
        g.setFont(new Font("VERDANA", Font.BOLD, 40));
        g.drawString(timeDisplay.toString(), 0,40);
        chipLeftDisplay.delete(0, chipLeftDisplay.length());
        if (chipLeft>1) {
            chipLeftDisplay.append("Chip lefts :");
        }else{
            chipLeftDisplay.append("Chip left :");
        }
        chipLeftDisplay.append(chipLeft);
        g.drawString(chipLeftDisplay.toString(), 0, 90);
    }

    @Override
    public void drawAt(Graphics g, int offsetX, int offsetY) {
        g.setColor(Color.red);
        g.setFont(new Font("VERDANA", Font.BOLD, 40));
        g.drawString(timeDisplay.toString(), 0+offsetX,40+offsetY);
        chipLeftDisplay.delete(0, chipLeftDisplay.length());
        if (chipLeft>1) {
            chipLeftDisplay.append("Chip lefts :");
        }else{
            chipLeftDisplay.append("Chip left :");
        }
        chipLeftDisplay.append(chipLeft);
        g.drawString(chipLeftDisplay.toString(), 0+offsetX, 90+offsetY);
    
    }

}
