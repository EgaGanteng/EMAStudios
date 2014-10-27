/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Canvas;
import world.Board;
import world.Player;
import world.Stash;
import world.Status;

/**
 *
 * @author i13047
 */
public class Controller implements Runnable, KeyListener {

    private Canvas canvas;
    private Player player1;
    private Board papan;
    private Status stat;
    private Stash inventory;
    private boolean isRunning;
    private Thread thread;
    private Graphics g;

    public Controller() {
        isRunning = false;
        g = canvas.getMyGraphics();
        canvas = new Canvas(this);
        thread = new Thread(this);
    }

    public void start() {
        isRunning = true;
        thread.start();
    }

    public void stop() {
        this.isRunning = false;
        try {
            this.thread.join();
        } catch (InterruptedException ex) {
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        while (isRunning) {
//        }
    }

}
