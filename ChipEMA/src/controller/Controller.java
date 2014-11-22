/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import interfaces.Drawable;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Canvas;
import world.Board;
import world.Boot;
import world.Item;
import world.Key;
import world.Player;
import world.Stash;
import world.Status;
import world.map.GridLantaiKosong;

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
    private boolean isFinish;
    private int playerPixelLocX, playerPixelLocY;
    private Thread thread;
    private Drawable[] drawable;
    private Vector<Item> listItem;
    private boolean isMoving;

    public int getPlayerPixelLocX() {
        return playerPixelLocX;
    }

    public int getPlayerPixelLocY() {
        return playerPixelLocY;
    }

    public Controller(Canvas c) {
        isFinish = false;
        this.papan = new Board(1);
        stat = papan.getStats();
        player1 = new Player(6, 8);
        isMoving = false;
        this.playerPixelLocX = player1.getLocationX() * 65;
        this.playerPixelLocY = player1.getLocationY() * 65;
        inventory = papan.getInventory();
        canvas = c;
        thread = new Thread(this);
        this.drawable = new Drawable[2];
        drawable[0] = this.player1;
        drawable[1] = this.papan;
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
                }
                else
                {
                    String temp=papan.getMap()[player1.getLocationX()][player1.getLocationY()-1].getNama();
                    if(temp.equals("PINTU BIRU"))
                    {
                        if(inventory.cekInventory(Key.KUNCI_BIRU))
                        {
                            papan.getMap()[player1.getLocationX()][player1.getLocationY()-1] = new GridLantaiKosong();
                            player1.move(Player.ATAS);
                        }
                    }
                    else if(temp.equals("PINTU MERAH"))
                    {
                        if(inventory.cekInventory(Key.KUNCI_MERAH))
                        {
                            papan.getMap()[player1.getLocationX()][player1.getLocationY()-1] = new GridLantaiKosong();
                            player1.move(Player.ATAS);
                        }
                    }
                    else if(temp.equals("PINTU KUNING"))
                    {
                        if(inventory.cekInventory(Key.KUNCI_KUNING))
                        {
                            papan.getMap()[player1.getLocationX()][player1.getLocationY()-1] = new GridLantaiKosong();
                            player1.move(Player.ATAS);
                        }
                    }
                    else if(temp.equals("PINTU HIJAU"))
                    {
                        if(inventory.cekInventory(Key.KUNCI_HIJAU))
                        {
                            papan.getMap()[player1.getLocationX()][player1.getLocationY()-1] = new GridLantaiKosong();
                            player1.move(Player.ATAS);
                        }
                    }
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (papan.getMap()[player1.getLocationX()][player1.getLocationY() + 1].isSteppable()) {
                    player1.move(Player.BAWAH);
                    isMoving = true;
                }
                else
                {
                    String temp=papan.getMap()[player1.getLocationX() ][player1.getLocationY()+1].getNama();
                    if(temp.equals("PINTU BIRU"))
                    {
                        if(inventory.cekInventory(Key.KUNCI_BIRU))
                        {
                            papan.getMap()[player1.getLocationX() ][player1.getLocationY()+1] = new GridLantaiKosong();
                            player1.move(Player.BAWAH);
                        }
                    }
                    else if(temp.equals("PINTU MERAH"))
                    {
                        if(inventory.cekInventory(Key.KUNCI_MERAH))
                        {
                            papan.getMap()[player1.getLocationX() ][player1.getLocationY()+1] = new GridLantaiKosong();
                            player1.move(Player.BAWAH);
                        }
                    }
                    else if(temp.equals("PINTU KUNING"))
                    {
                        if(inventory.cekInventory(Key.KUNCI_KUNING))
                        {
                            papan.getMap()[player1.getLocationX() ][player1.getLocationY()+1] = new GridLantaiKosong();
                            player1.move(Player.BAWAH);
                        }
                    }
                    else if(temp.equals("PINTU HIJAU"))
                    {
                        if(inventory.cekInventory(Key.KUNCI_HIJAU))
                        {
                            papan.getMap()[player1.getLocationX() ][player1.getLocationY()+1] = new GridLantaiKosong();
                            player1.move(Player.BAWAH);
                        }
                    }
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (papan.getMap()[player1.getLocationX() + 1][player1.getLocationY()].isSteppable()) {
                    player1.move(Player.KANAN);
                    isMoving = true;
                }
                else
                {
                    String temp=papan.getMap()[player1.getLocationX() +1][player1.getLocationY()].getNama();
                    if(temp.equals("PINTU BIRU"))
                    {
                        if(inventory.cekInventory(Key.KUNCI_BIRU))
                        {
                            papan.getMap()[player1.getLocationX()+1][player1.getLocationY()] = new GridLantaiKosong();
                            player1.move(Player.KANAN);
                        }
                    }
                    else if(temp.equals("PINTU MERAH"))
                    {
                        if(inventory.cekInventory(Key.KUNCI_MERAH))
                        {
                            papan.getMap()[player1.getLocationX()+1][player1.getLocationY()] = new GridLantaiKosong();
                            player1.move(Player.KANAN);
                        }
                    }
                    else if(temp.equals("PINTU KUNING"))
                    {
                        if(inventory.cekInventory(Key.KUNCI_KUNING))
                        {
                            papan.getMap()[player1.getLocationX()+1][player1.getLocationY()] = new GridLantaiKosong();
                            player1.move(Player.KANAN);
                        }
                    }
                    else if(temp.equals("PINTU HIJAU"))
                    {
                        if(inventory.cekInventory(Key.KUNCI_HIJAU))
                        {
                            papan.getMap()[player1.getLocationX()+1][player1.getLocationY()] = new GridLantaiKosong();
                            player1.move(Player.KANAN);
                        }
                    }
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (papan.getMap()[player1.getLocationX() - 1][player1.getLocationY()].isSteppable()) {
                    player1.move(Player.KIRI);
                    isMoving = true;
                }
                else
                {
                    String temp=papan.getMap()[player1.getLocationX() -1][player1.getLocationY()].getNama();
                    if(temp.equals("PINTU BIRU"))
                    {
                        if(inventory.cekInventory(Key.KUNCI_BIRU))
                        {
                            papan.getMap()[player1.getLocationX() -1][player1.getLocationY()] = new GridLantaiKosong();
                            player1.move(Player.KIRI);
                        }
                    }
                    else if(temp.equals("PINTU MERAH"))
                    {
                        if(inventory.cekInventory(Key.KUNCI_MERAH))
                        {
                            papan.getMap()[player1.getLocationX() -1][player1.getLocationY()] = new GridLantaiKosong();
                            player1.move(Player.KIRI);
                        }
                    }
                    else if(temp.equals("PINTU KUNING"))
                    {
                        if(inventory.cekInventory(Key.KUNCI_KUNING))
                        {
                            papan.getMap()[player1.getLocationX() -1][player1.getLocationY()] = new GridLantaiKosong();
                            player1.move(Player.KIRI);
                        }
                    }
                    else if(temp.equals("PINTU HIJAU"))
                    {
                        if(inventory.cekInventory(Key.KUNCI_HIJAU))
                        {
                            papan.getMap()[player1.getLocationX() -1][player1.getLocationY()] = new GridLantaiKosong();
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
        while (!player1.isIsDead() && !isFinish) {
            listItem=papan.getListItemDiMap();
            if (isMoving) {
                moving();
            } else {
                if (papan.getMap()[player1.getLocationX()][player1.getLocationY()].getNama().equals("Fire")) {
                    if(!inventory.cekInventory(Boot.SEPATU_API)){
                        player1.setIsDead(true);}
                }
                if (papan.getMap()[player1.getLocationX()][player1.getLocationY()].getNama().equals("Water")) {
                    if(!inventory.cekInventory(Boot.SEPATU_AIR)){
                        player1.setIsDead(true);}
                }
                if (papan.getMap()[player1.getLocationX()][player1.getLocationY()].getNama().equals("Finish")) {
                    isFinish = true;
                }
                if (papan.getMap()[player1.getLocationX()][player1.getLocationY()].getNama().equals("IC")) {
                    stat.decreaseChip(1);
                    System.out.println(stat.getChipLeft());
                    papan.getMap()[player1.getLocationX()][player1.getLocationY()] = new GridLantaiKosong();
                }
                
                for(int i=0;i<listItem.size();i++)
                {
                    if(listItem.get(i).getX()==player1.getLocationX() && listItem.get(i).getY()==player1.getLocationY())
                    {
                        inventory.addInventory(listItem.get(i));
                        listItem.remove(i);
                    }
                }
                if (stat.getChipLeft() == 0) {
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
        if (this.playerPixelLocX >player1.getLocationX() * 65) {
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
