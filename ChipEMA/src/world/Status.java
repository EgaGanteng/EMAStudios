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
public class Status implements ActionListener{
    private int chipLeft;

    private Timer timer;
    private int miliSeconds = 0, seconds = 0, minutes = 0;

    
    public Status(int menit,int detik,int miliDetik,int chipLeft){
        this.minutes = menit;
        this.seconds = detik;
        this.miliSeconds = miliDetik;
        this.chipLeft = chipLeft;
        timer = new Timer(10,this);
        timer.start();
    }
    
    
    /**
     * Method ini adalah untuk mengurangi sisa chip yang terisa dengan parameter yang diberikan.
     * 
     * Contoh:
     * Current Chip = 5;
     * by = 2;
     * Current Chip = 5-2;
     * @param by  
     */
    public void decreaseChip(int by){
        chipLeft-=by;
    }

    public int getChipLeft() {
        return chipLeft;
    }


    /**
     * di run ini akan mengurangi waktunya per detik(menggunakan delay);
     */
    @Override
    public void actionPerformed(ActionEvent e) {
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
                    timer.stop();
                    this.miliSeconds = this.seconds = this.minutes = 0;
                    System.out.println("Waktu Habis!");
                }
                
                if (this.seconds >= 0 && this.minutes > 0 && this.miliSeconds >= 0) {
                    System.out.println(this.minutes + ":" + this.seconds + ":" + this.miliSeconds);
                } else if (this.seconds > 0 && this.miliSeconds >= 0 && this.minutes <= 0) {
                    System.out.println(seconds + ":" + this.miliSeconds);
                } else if (this.seconds == 0 && this.minutes == 0 && this.miliSeconds > 0) {
                    System.out.println(this.miliSeconds);
    }
    }
    
    /**
     * <Method sementara saja>
     * 
     * untuk mencoba klo codingan ini berhasil
     * @param args 
     */
    public static void main(String[] args) {
        JFrame f = new JFrame();
        
        /**
         * Status(int menit,int detik,int miliDetik,int ChipLeft)
         * 
         * silahkan coba ubah" menit, detik dan miliDetik. Kalau ada error kasih tau gw(michael) hehehe^^
         * 
         * Kalau ada compiled error gara" kelas lain klik Run anyway aj.
         */
        Status obj = new Status(0,20,25,5);
    }
}
