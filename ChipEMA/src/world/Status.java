/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world;

/**
 *
 * @author i13047
 */
public class Status implements Runnable {
    private int chipLeft;
    private int time;

    /**
     * di run ini akan mengurangi waktunya per detik(menggunakan delay);
     */
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        
    }

    public int getChipLeft() {
        return chipLeft;
    }

    public int getTime() {
        return time;
    }
}
