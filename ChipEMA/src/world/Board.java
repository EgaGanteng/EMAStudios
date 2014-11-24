/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import interfaces.Drawable;
import java.awt.*;
import java.util.Vector;
import world.map.*;

/**
 *
 * @author i13047
 */
public class Board implements Drawable {

    private Grid[][] map;
    private int level;
    private Stash inventory;
    private Status stats;
    private int gridPlayerLocX, gridPlayerLocY;
    private Vector<Item> items;

    /**
     * Method untuk mendapatkan map.
     *
     * @return map
     */
    public Grid[][] getMap() {
        return map;
    }

    /**
     * Method untuk mendapatkan level
     *
     * @return level.
     */
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
        this.items = new Vector<Item>();
        this.setMap();
    }

    @Override
    public void drawDefault(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int i, j;
        for (i = 0; i < map.length; i++) {
            for (j = 0; j < map[0].length; j++) {
                g2.drawImage(map[i][j].getImage(), i * 65, j * 65, null);
            }
        }
        for (i = 0; i < items.size(); i++) {
            g2.drawImage(items.get(i).getImage(), items.get(i).getX() * 65, items.get(i).getY() * 65, null);
        }

    }

    public Vector<Item> getListItemDiMap() {
        return this.items;
    }

    public void setMap() {
        if (this.level == 1) {
            /**
             * 0 1 2 3 4 5 6 7 8 9
             * W W W W W W W W W W 0
             * W . B C . . W . F W 1
             * W E W . . . W . . W 2
             * W W W W W . W F . W 3
             * W C . C W . . . . W 4
             * W C F W W . W W W W 5
             * W K . . W . . . . W 6
             * W . . . F A . W D W 7
             * W C . . . . . F C W 8
             * W W W W W W W W W W 9
             *
             * Keterangan : -- W = Wall -- C = Chip / Integrated Circuit -- F =
             * Fire -- E = Finnish/Exit -- B = Barrier -- . = Lantai Kosong -- K
             * = Key -- D = Door --A =Air -- C = boot --
             */
            /**
             * Lantai Kosong i baris 8 kolom 2-6
             */

            //Item item yang tersedia di level ini
            items.add(new Key(1, 6, Key.KUNCI_BIRU));
            items.add(new Boot(1, 5, Boot.SEPATU_API));
            items.add(new Boot(1, 4, Boot.SEPATU_AIR));

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
            this.gridPlayerLocX = 6;
            this.gridPlayerLocY = 8;
            this.map[1][2] = new GridFinish(); // Finnish di baris 2 kolom 1
            this.map[7][1] = new GridLantaiKosong(); // Key di baris 1 kolom 7
            this.map[8][7] = new GridDoor(GridDoor.PINTU_BIRU); // Door di baris 7 kolom 8
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
            this.map[2][5] = this.map[8][1] = this.map[7][3] = this.map[7][8] = this.map[4][7] = new GridFire();
            this.map[5][7] = new GridWater();
            /**
             * Integrated Circuit di: Baris,Kolom : (8,1) , (8,8),(4,3),(1,3).
             */
            this.map[1][8] = this.map[8][8] = this.map[3][4] = this.map[3][1] = new GridIC();
            this.stats = new Status(10, 20, 4, this.level);

        } else if (this.level == 2) {
            this.map = new Grid[10][10];
            GridWall wall = new GridWall();
            GridFire api = new GridFire();
            GridWater water = new GridWater();
            GridIC IC = new GridIC();
            GridLantaiKosong lantaiKosong = new GridLantaiKosong();
            map[0][0] = wall;
            for (int i = 1; i <= 8; i++) {
                for (int j = 1; j <= 8; j++) {
                    map[i][j] = lantaiKosong;
                }
            }
            for (int i = 1; i < map.length; i++) {
                map[i][0] = map[0][i] = map[9][i] = map[i][9] = wall;
            }
            for (int i = 5; i <= 8; i++) {
                map[i][2] = wall;
            }
            map[6][3] = map[6][4] = map[7][4] = map[6][6] = wall;
            for (int i = 6; i <= 8; i++) {
                map[i][7] = wall;
            }
//            map[1][1] = map[1][8] = map[6][1] = map[7][3] =  lantaiKosong;
            items.add(new Boot(1, 1, Boot.SEPATU_AIR));
            items.add(new Key(1, 8, Key.KUNCI_MERAH));
            items.add(new Boot(6, 1, Boot.SEPATU_API));
            items.add(new Key(7, 3, Key.KUNCI_BIRU));
            stats = new Status(10, 10, 3, level);
            map[6][8] =map[3][6] =map[4][4] = IC;
            gridPlayerLocX = 8;
            gridPlayerLocY = 8;
            map[5][1] = new GridBarrier();
            map[7][1] = new GridDoor(GridDoor.PINTU_BIRU);
            map[8][1] = new GridFinish();
            map[6][5] = new GridDoor(GridDoor.PINTU_MERAH);
            map[2][1] = map[3][1] = map[1][2] = map[2][2] = map[3][2] = map[1][3] = map[2][3] = api;
            map[1][6] = map[2][6] = map[1][7] = map[2][7] = map[3][7] = map[2][8] = map[3][8] = map[8][4] = water;
            
        } else if (this.level == 3) {
            throw new UnsupportedOperationException("blum jadi");
        }
    }

    public int getGridPlayerLocX() {
        return gridPlayerLocX;
    }

    public int getGridPlayerLocY() {
        return gridPlayerLocY;
    }

    @Override
    public void drawAt(Graphics g, int offsetX, int offsetY) {

    }

}
