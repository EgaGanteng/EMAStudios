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

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getChipLeft() {
        return chipLeft;
    }

    public int getTime() {
        return time;
    }
}
