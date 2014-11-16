/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import interfaces.Drawable;
import java.awt.Graphics;
import java.awt.Graphics2D;
import world.map.Grid;
import world.map.GridBarrier;
import world.map.GridDoor;
import world.map.GridFinish;
import world.map.GridFire;
import world.map.GridIC;
import world.map.GridLantaiKosong;
import world.map.GridWall;

/**
 *
 * @author i13047
 */
public class Board implements Drawable {

    private Grid[][] map;
    private int level;
    private Stash inventory;
    private Status stats;
    private int gridBarrierLocX, gridBarrierLocY;

    public Grid[][] getMap() {
        return map;
    }

    public int getLevel() {
        return level;
    }

    public Stash getInventory() {
        return inventory;
    }

    public Status getStats() {
        return stats;
    }

    public Board(int level) {
        this.level = level;
        this.map = new Grid[10][10];
        this.inventory = new Stash();
        this.setMap();
    }

    @Override
    public void drawDefault(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int i, j;// 2 sama 5 masih belum bener
        for (i = 0; i < map.length; i++) {
            for (j = 0; j < map[0].length; j++) {
                g2.drawImage(map[i][j].getImage(), i * 65, j * 65, null);
            }
        }

    }

    public void setMap() {
        if (this.level == 1) {
            /**
             * 0 1 2 3 4 5 6 7 8 9
             * W W W W W W W W W W 0
             * W . B C . . W . F W 1
             * W E W . . . W . . W 2
             * W W W W W . W F . W 3
             * W . . C W . . . . W 4
             * W . F W W . W W W W 5
             * W . . . W . . . . W 6
             * W . . . F F . W D W 7
             * W C . . . . . F C W 8
             * W W W W W W W W W W 9
             *
             * Keterangan : -- W = Wall -- C = Chip / Integrated Circuit -- F =
             * Fire -- E = Finnish/Exit -- B = Barrier -- . = Lantai Kosong -- K
             * = Key -- D = Door
             */
            /**
             * Lantai Kosong i baris 8 kolom 2-6
             */
            for (int i = 2; i <= 6; i++) {
                this.map[i][8] = new GridLantaiKosong();
            }
            /**
             * Lantai Kosong di baris 8 kolom 1-3 & Lantai Kosong di baris 7
             * kolom 6
             */
            for (int i = 1; i <= 3; i++) {
                this.map[i][7] = new GridLantaiKosong();
            }
            this.map[6][7] = new GridLantaiKosong();
            /**
             * Lantai Kosong di baris 6 kolom 1-3 & Lantai Kosong di baris 6
             * kolom 5-8
             */
            for (int i = 1; i <= 3; i++) {
                this.map[i][6] = new GridLantaiKosong();
            }
            for (int i = 5; i <= 8; i++) {
                this.map[i][6] = new GridLantaiKosong();
            }
            /**
             * Lantai Kosong di baris 1-5 kolom 5 & Lantai Kosong di baris 5
             * kolom 1
             */
            for (int i = 1; i <= 5; i++) {
                this.map[5][i] = new GridLantaiKosong();
            }
            this.map[1][5] = new GridLantaiKosong();
            /**
             * Lantai Kosong di baris 4 kolom 1-2 & Lantai Kosong di baris 4
             * kolom 6-8
             */
            for (int i = 1; i <= 2; i++) {
                this.map[i][4] = new GridLantaiKosong();
            }
            for (int i = 6; i <= 8; i++) {
                this.map[i][4] = new GridLantaiKosong();
            }
            /**
             * Lantai Kosong di : (1,1),(2,3),(1,4),(2,4),(2,7),(2,8),(3,8)
             */
            this.map[1][1] = this.map[3][2] = this.map[4][1] = this.map[4][2] = this.map[7][2] = this.map[8][2] = this.map[8][3]
                    = new GridLantaiKosong();

            /**
             * Wall
             */
            for (int i = 0; i < map.length; i++) {
                this.map[i][0] = new GridWall(); // Wall Atas
                this.map[i][9] = new GridWall(); // Wall Bawah
            }
            for (int i = 1; i < map.length; i++) {
                this.map[0][i] = new GridWall(); // Wall Kiri
                this.map[9][i] = new GridWall(); // Wall Kanan
            }
            this.map[2][2] = new GridWall();//Wall di baris 2 kolom 2.
            this.map[3][5] = new GridWall();//Wall di baris 5 kolom 3.

            this.map[2][1] = new GridBarrier(); // barrier di baris 1 kolom 2
            this.gridBarrierLocX = 2;
            this.gridBarrierLocY = 1;
            this.map[1][2] = new GridFinish(); // Finnish di baris 2 kolom 1
            this.map[7][1] = new GridLantaiKosong(); // Key di baris 1 kolom 7
            this.map[8][7] = new GridDoor(); // Door di baris 7 kolom 8
            /**
             * Wall di baris 3 kolom 1-4.
             */
            this.map[1][3] = this.map[2][3] = this.map[3][3] = this.map[4][3] = new GridWall();
            /**
             * Wall di baris 1-3 kolom 6.
             */
            this.map[6][1] = this.map[6][2] = this.map[6][3] = new GridWall();
            /**
             * Wall di baris 4-6 kolom 4.
             */
            this.map[4][4] = this.map[4][5] = this.map[4][6] = new GridWall();
            /**
             * Wall di baris 5 kolom 6-8. Wall di baris 7 kolom 7.
             */
            this.map[6][5] = this.map[7][5] = this.map[8][5] = this.map[7][7] = new GridWall();

            /**
             * Fire di: Baris,Kolom : (5,2) , (1,8) , (3,7) , (8,7) ,(7,4) ,
             * (7,5).
             */
            this.map[2][5] = this.map[8][1] = this.map[7][3] = this.map[7][8] = this.map[4][7] = this.map[5][7] = new GridFire();

            /**
             * Integrated Circuit di: Baris,Kolom : (8,1) , (8,8),(4,3),(1,3).
             */
            this.map[1][8] = this.map[8][8] = this.map[3][4] = this.map[3][1] = new GridIC();
            this.stats = new Status(10, 20, 30, 4);
        } else if (this.level == 2) {
            this.map = new Grid[2][2];
            this.map[0][1] = new GridLantaiKosong();
            this.map[1][0] = new GridWall();
            this.map[1][1] = new GridFinish();
            this.map[0][0] = new GridBarrier();
        } else if (this.level == 3) {

        }
    }

    public int getGridBarrierLocX() {
        return gridBarrierLocX;
    }

    public int getGridBarrierLocY() {
        return gridBarrierLocY;
    }

    @Override
    public void drawAt(Graphics g, int offsetX, int offsetY) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
