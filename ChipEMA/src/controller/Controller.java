/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import interfaces.Drawable;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.logging.*;
import view.Canvas;
import world.*;
import world.map.*;

/**
 * Class ini adalah Controller untuk game ChipChallage.
 * @author ChipEMA
 */
public class Controller implements Runnable, KeyListener {

    private Canvas canvas;
    private Player player1;
    private Board papan;
    private boolean isFinish;
    private int playerPixelLocX, playerPixelLocY;
    private Thread thread;
    private Drawable[] drawable;
    private Vector<Item> listItem;
    private boolean isMoving;
    private int curLevel;
    private long startTime;

    /**
     * Getter untuk mendapatkan lokasi pixel Y player
     * @return lokasi Y
     */
    public int getPlayerPixelLocX() {
        return playerPixelLocX;
    }

    /**
     * Getter untuk mendapatkan lokasi pixel X player
     * @return lokasi X
     */
    public int getPlayerPixelLocY() {
        return playerPixelLocY;
    }

    /**
     * Constructor untuk meninisiasi awal dalam constructor
     * 
     * @param c Canvas
     */
    public Controller(Canvas c) {
        curLevel = 4;
        canvas = c;
        this.drawable = new Drawable[4];
        init();
    }

    /**
     * Method untuk meningisialisasi Attribut-attributnya.
     */
    private void init() {
        isFinish = false;
        this.papan = new Board(this.curLevel);
        player1 = new Player(papan.getGridPlayerLocX(), papan.getGridPlayerLocY());
        this.papan = new Board(this.curLevel);
        isMoving = false;
        this.playerPixelLocX = player1.getLocationX() * 65;
        this.playerPixelLocY = player1.getLocationY() * 65;
        thread = new Thread(this);
        drawable[0] = this.player1;
        drawable[1] = this.papan;
        drawable[2] = papan.getInventory();
        drawable[3] = papan.getStats();
        startTime = System.currentTimeMillis();
    }

    /**
     * Method untuk memulai Thread
     */
    public void start() {
        isFinish = false;
        thread.start();
    }

    /**
     * Method untuk memberhentikan Thread
     */
    public void stop() {
        this.isFinish = true;
        try {
            this.thread.join();
        } catch (InterruptedException ex) {
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        try {
            if (e.getKeyCode() == e.VK_ESCAPE) {
                init();
            }
            if (!isMoving) {

                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    if (papan.getMap()[player1.getLocationX()][player1.getLocationY() - 1].isSteppable()) {
                        player1.move(Player.ATAS);
                        isMoving = true;
                    } else {
                        String temp = papan.getMap()[player1.getLocationX()][player1.getLocationY() - 1].getNama();
                        if (temp.equals("PINTU BIRU")) {
                            if (papan.getInventory().cekInventory(Key.KUNCI_BIRU)) {
                                papan.getMap()[player1.getLocationX()][player1.getLocationY() - 1] = new GridLantaiKosong();
                            }
                        } else if (temp.equals("PINTU MERAH")) {
                            if (papan.getInventory().cekInventory(Key.KUNCI_MERAH)) {
                                papan.getMap()[player1.getLocationX()][player1.getLocationY() - 1] = new GridLantaiKosong();
                            }
                        } else if (temp.equals("PINTU KUNING")) {
                            if (papan.getInventory().cekInventory(Key.KUNCI_KUNING)) {
                                papan.getMap()[player1.getLocationX()][player1.getLocationY() - 1] = new GridLantaiKosong();
                            }
                        } else if (temp.equals("PINTU HIJAU")) {
                            if (papan.getInventory().cekInventory(Key.KUNCI_HIJAU)) {
                                papan.getMap()[player1.getLocationX()][player1.getLocationY() - 1] = new GridLantaiKosong();
                            }
                        } else if (temp.equals("Barrier")) {
                            if (papan.getStats().getChipLeft() == 0) {
                                papan.getMap()[player1.getLocationX()][player1.getLocationY() - 1] = new GridLantaiKosong();
                            }
                        }
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (papan.getMap()[player1.getLocationX()][player1.getLocationY() + 1].isSteppable()) {
                        player1.move(Player.BAWAH);
                        isMoving = true;
                    } else {
                        String temp = papan.getMap()[player1.getLocationX()][player1.getLocationY() + 1].getNama();
                        if (temp.equals("PINTU BIRU")) {
                            if (papan.getInventory().cekInventory(Key.KUNCI_BIRU)) {
                                papan.getMap()[player1.getLocationX()][player1.getLocationY() + 1] = new GridLantaiKosong();
                            }
                        } else if (temp.equals("PINTU MERAH")) {
                            if (papan.getInventory().cekInventory(Key.KUNCI_MERAH)) {
                                papan.getMap()[player1.getLocationX()][player1.getLocationY() + 1] = new GridLantaiKosong();
                            }
                        } else if (temp.equals("PINTU KUNING")) {
                            if (papan.getInventory().cekInventory(Key.KUNCI_KUNING)) {
                                papan.getMap()[player1.getLocationX()][player1.getLocationY() + 1] = new GridLantaiKosong();
                            }
                        } else if (temp.equals("PINTU HIJAU")) {
                            if (papan.getInventory().cekInventory(Key.KUNCI_HIJAU)) {
                                papan.getMap()[player1.getLocationX()][player1.getLocationY() + 1] = new GridLantaiKosong();
                            }
                        } else if (temp.equals("Barrier")) {
                            if (papan.getStats().getChipLeft() == 0) {
                                papan.getMap()[player1.getLocationX()][player1.getLocationY() + 1] = new GridLantaiKosong();
                            }
                        }
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    if (papan.getMap()[player1.getLocationX() + 1][player1.getLocationY()].isSteppable()) {
                        player1.move(Player.KANAN);
                        isMoving = true;
                    } else {
                        String temp = papan.getMap()[player1.getLocationX() + 1][player1.getLocationY()].getNama();
                        if (temp.equals("PINTU BIRU")) {
                            if (papan.getInventory().cekInventory(Key.KUNCI_BIRU)) {
                                papan.getMap()[player1.getLocationX() + 1][player1.getLocationY()] = new GridLantaiKosong();
                            }
                        } else if (temp.equals("PINTU MERAH")) {
                            if (papan.getInventory().cekInventory(Key.KUNCI_MERAH)) {
                                papan.getMap()[player1.getLocationX() + 1][player1.getLocationY()] = new GridLantaiKosong();
                            }
                        } else if (temp.equals("PINTU KUNING")) {
                            if (papan.getInventory().cekInventory(Key.KUNCI_KUNING)) {
                                papan.getMap()[player1.getLocationX() + 1][player1.getLocationY()] = new GridLantaiKosong();
                            }
                        } else if (temp.equals("PINTU HIJAU")) {
                            if (papan.getInventory().cekInventory(Key.KUNCI_HIJAU)) {
                                papan.getMap()[player1.getLocationX() + 1][player1.getLocationY()] = new GridLantaiKosong();
                            }
                        } else if (temp.equals("Barrier")) {
                            if (papan.getStats().getChipLeft() == 0) {
                                papan.getMap()[player1.getLocationX() + 1][player1.getLocationY()] = new GridLantaiKosong();
                            }
                        }
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    if (papan.getMap()[player1.getLocationX() - 1][player1.getLocationY()].isSteppable()) {
                        player1.move(Player.KIRI);
                        isMoving = true;
                    } else {
                        String temp = papan.getMap()[player1.getLocationX() - 1][player1.getLocationY()].getNama();
                        if (temp.equals("PINTU BIRU")) {
                            if (papan.getInventory().cekInventory(Key.KUNCI_BIRU)) {
                                papan.getMap()[player1.getLocationX() - 1][player1.getLocationY()] = new GridLantaiKosong();
                            }
                        } else if (temp.equals("PINTU MERAH")) {
                            if (papan.getInventory().cekInventory(Key.KUNCI_MERAH)) {
                                papan.getMap()[player1.getLocationX() - 1][player1.getLocationY()] = new GridLantaiKosong();
                            }
                        } else if (temp.equals("PINTU KUNING")) {
                            if (papan.getInventory().cekInventory(Key.KUNCI_KUNING)) {
                                papan.getMap()[player1.getLocationX() - 1][player1.getLocationY()] = new GridLantaiKosong();
                            }
                        } else if (temp.equals("PINTU HIJAU")) {
                            if (papan.getInventory().cekInventory(Key.KUNCI_HIJAU)) {
                                papan.getMap()[player1.getLocationX() - 1][player1.getLocationY()] = new GridLantaiKosong();
                            }
                        } else if (temp.equals("Barrier")) {
                            if (papan.getStats().getChipLeft() == 0) {
                                papan.getMap()[player1.getLocationX() - 1][player1.getLocationY()] = new GridLantaiKosong();
                            }
                        }
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException a) {

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     * Method yang akan di jalankan ketika Thread di Start
     */
    @Override
    public void run() {
        try {
            long countTime = startTime;
            int animationTime = 0;
            while (!player1.isIsDead() && !isFinish) {
                long curTime = System.currentTimeMillis();
                int selisih = (int) (curTime - countTime);
                papan.getStats().decreaseTimeByMilis(selisih);
                countTime = curTime;
                listItem = papan.getListItemDiMap();

                if (papan.getMap()[player1.getLocationX()][player1.getLocationY()].getNama().equals("IC")) {
                    papan.getStats().decreaseChip(1);
//                    System.out.println(stat.getChipLeft());
                    papan.getMap()[player1.getLocationX()][player1.getLocationY()] = new GridLantaiKosong();
                }
                for (int i = 0; i < listItem.size(); i++) {
                    if (listItem.get(i).getX() == player1.getLocationX() && listItem.get(i).getY() == player1.getLocationY()) {
                        papan.getInventory().addInventory(listItem.get(i));
                        listItem.remove(i);
                    }
                }
                if (isMoving) {
                    moving();
                    animationTime += selisih;
                    if (animationTime >= 100) {
//                    System.out.println("a");
                        player1.nextFrame();
                        animationTime = 0;
                    }
                } else {
                    animationTime = 0;
                    player1.setCondition(Player.IDLE);
                    if (papan.getMap()[player1.getLocationX()][player1.getLocationY()].getNama().equals("Fire")) {
                        if (!papan.getInventory().cekInventory(Boot.SEPATU_API)) {
                            player1.setIsDead(true);
                            player1.setCondition(Player.GOSONG);
                        }
                    }
                    if (papan.getMap()[player1.getLocationX()][player1.getLocationY()].getNama().equals("Water")) {
                        if (!papan.getInventory().cekInventory(Boot.SEPATU_AIR)) {
                            player1.setIsDead(true);
                            player1.setCondition(Player.NYEMPLUNG);
                        }
                    }
                    if (papan.getMap()[player1.getLocationX()][player1.getLocationY()].getNama().equals("Finish")) {
                        isFinish = true;
                    }

                }

                canvas.repaint();
                try {
                    Thread.sleep(16);
                } catch (InterruptedException ex) {
                }
            }
            if (isFinish) {
                this.curLevel++;
                if (this.curLevel < 5) {
                    init();
                    run();
                } else {
                    canvas.setTamat();
                    canvas.repaint();
                    this.stop();
                }
            } else if (player1.isIsDead()) {
                init();
                run();
            }
        } catch (ArrayIndexOutOfBoundsException a) {

        }
    }

    /**
     * Method untuk menggerakkan player
     */
    public void moving() {
        if (this.playerPixelLocX > player1.getLocationX() * 65) {
            this.playerPixelLocX -= 5;
        } else if (this.playerPixelLocX < player1.getLocationX() * 65) {
            this.playerPixelLocX += 5;
        }
        if (this.playerPixelLocY > player1.getLocationY() * 65) {
            this.playerPixelLocY -= 5;
        } else if (this.playerPixelLocY < player1.getLocationY() * 65) {
            this.playerPixelLocY += 5;
        }
        if (this.playerPixelLocX == player1.getLocationX() * 65 && this.playerPixelLocY == player1.getLocationY() * 65) {
            this.isMoving = false;
        }
    }

    /**
     * Method untuk mendapatakan object2 yang dapat digambar.
     * @return 
     */
    public Drawable[] getAllDrawable() {
        return drawable;
    }
}
