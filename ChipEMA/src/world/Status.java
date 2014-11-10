/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 *
 * @author EMA Studio
 */
public class Status {

    private int chipLeft;

    private int miliSeconds = 0, seconds = 0, minutes = 0;

    public Status(int menit, int detik, int miliDetik, int chipLeft) {
        this.minutes = menit;
        this.seconds = detik;
        this.miliSeconds = miliDetik;
        this.chipLeft = chipLeft;
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
        this.miliSeconds -= milidetik;
        this.calcTime();
    }

    private void calcTime() {
        if (this.miliSeconds == 0 && (this.seconds > 0 || this.minutes > 0)) {
            this.miliSeconds = 59;
            this.seconds--;
        } else {
            this.miliSeconds--;
        }
        if (this.seconds == 0 && this.minutes > 0) {
            this.seconds = 59;
            this.minutes--;
        }
        if (this.miliSeconds == 0 && this.seconds == 0 && this.minutes == 0) {
            this.miliSeconds = this.seconds = this.minutes = 0;
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

}
