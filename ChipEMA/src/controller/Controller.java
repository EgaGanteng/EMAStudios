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
 *
 * @author i13047
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
    private long startTime;

    public int getPlayerPixelLocX() {
        return playerPixelLocX;
    }

    public int getPlayerPixelLocY() {
        return playerPixelLocY;
    }

    public Controller(Canvas c) {
        isFinish = false;
        this.papan = new Board(1);
        player1 = new Player(6, 8);
        isMoving = false;
        this.playerPixelLocX = player1.getLocationX() * 65;
        this.playerPixelLocY = player1.getLocationY() * 65;
        canvas = c;
        thread = new Thread(this);
        this.drawable = new Drawable[4];
        drawable[0] = this.player1;
        drawable[1] = this.papan;
        drawable[2] = papan.getInventory();
        drawable[3] = papan.getStats();
        startTime = System.currentTimeMillis();
    }

    public void start() {
        isFinish = false;
        thread.start();
    }

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
                            player1.move(Player.ATAS);
                        }
                    } else if (temp.equals("PINTU MERAH")) {
                        if (papan.getInventory().cekInventory(Key.KUNCI_MERAH)) {
                            papan.getMap()[player1.getLocationX()][player1.getLocationY() - 1] = new GridLantaiKosong();
                            player1.move(Player.ATAS);
                        }
                    } else if (temp.equals("PINTU KUNING")) {
                        if (papan.getInventory().cekInventory(Key.KUNCI_KUNING)) {
                            papan.getMap()[player1.getLocationX()][player1.getLocationY() - 1] = new GridLantaiKosong();
                            player1.move(Player.ATAS);
                        }
                    } else if (temp.equals("PINTU HIJAU")) {
                        if (papan.getInventory().cekInventory(Key.KUNCI_HIJAU)) {
                            papan.getMap()[player1.getLocationX()][player1.getLocationY() - 1] = new GridLantaiKosong();
                            player1.move(Player.ATAS);
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
                            player1.move(Player.BAWAH);
                        }
                    } else if (temp.equals("PINTU MERAH")) {
                        if (papan.getInventory().cekInventory(Key.KUNCI_MERAH)) {
                            papan.getMap()[player1.getLocationX()][player1.getLocationY() + 1] = new GridLantaiKosong();
                            player1.move(Player.BAWAH);
                        }
                    } else if (temp.equals("PINTU KUNING")) {
                        if (papan.getInventory().cekInventory(Key.KUNCI_KUNING)) {
                            papan.getMap()[player1.getLocationX()][player1.getLocationY() + 1] = new GridLantaiKosong();
                            player1.move(Player.BAWAH);
                        }
                    } else if (temp.equals("PINTU HIJAU")) {
                        if (papan.getInventory().cekInventory(Key.KUNCI_HIJAU)) {
                            papan.getMap()[player1.getLocationX()][player1.getLocationY() + 1] = new GridLantaiKosong();
                            player1.move(Player.BAWAH);
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
                            player1.move(Player.KANAN);
                        }
                    } else if (temp.equals("PINTU MERAH")) {
                        if (papan.getInventory().cekInventory(Key.KUNCI_MERAH)) {
                            papan.getMap()[player1.getLocationX() + 1][player1.getLocationY()] = new GridLantaiKosong();
                            player1.move(Player.KANAN);
                        }
                    } else if (temp.equals("PINTU KUNING")) {
                        if (papan.getInventory().cekInventory(Key.KUNCI_KUNING)) {
                            papan.getMap()[player1.getLocationX() + 1][player1.getLocationY()] = new GridLantaiKosong();
                            player1.move(Player.KANAN);
                        }
                    } else if (temp.equals("PINTU HIJAU")) {
                        if (papan.getInventory().cekInventory(Key.KUNCI_HIJAU)) {
                            papan.getMap()[player1.getLocationX() + 1][player1.getLocationY()] = new GridLantaiKosong();
                            player1.move(Player.KANAN);
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
                            player1.move(Player.KIRI);
                        }
                    } else if (temp.equals("PINTU MERAH")) {
                        if (papan.getInventory().cekInventory(Key.KUNCI_MERAH)) {
                            papan.getMap()[player1.getLocationX() - 1][player1.getLocationY()] = new GridLantaiKosong();
                            player1.move(Player.KIRI);
                        }
                    } else if (temp.equals("PINTU KUNING")) {
                        if (papan.getInventory().cekInventory(Key.KUNCI_KUNING)) {
                            papan.getMap()[player1.getLocationX() - 1][player1.getLocationY()] = new GridLantaiKosong();
                            player1.move(Player.KIRI);
                        }
                    } else if (temp.equals("PINTU HIJAU")) {
                        if (papan.getInventory().cekInventory(Key.KUNCI_HIJAU)) {
                            papan.getMap()[player1.getLocationX() - 1][player1.getLocationY()] = new GridLantaiKosong();
                            player1.move(Player.KIRI);
                        }
                    }
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        long countTime = startTime;
        int animationTime = 0;
        while (!player1.isIsDead() && !isFinish) {
            long curTime = System.currentTimeMillis();
            int selisih = (int) (curTime - countTime);
            papan.getStats().decreaseTimeByMilis(selisih);
            countTime = curTime;
            listItem = papan.getListItemDiMap();
            if (isMoving) {
                moving();
                animationTime +=selisih;
                if (animationTime >=100) {
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
                if (papan.getStats().getChipLeft() == 0) {
                    papan.getMap()[papan.getGridBarrierLocX()][papan.getGridBarrierLocY()] = new GridLantaiKosong();
                }
            }

            canvas.repaint();
            try {
                Thread.sleep(16);
            } catch (InterruptedException ex) {
            }
        }
    }

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

    public Drawable[] getAllDrawable() {
        return drawable;
    }
}
