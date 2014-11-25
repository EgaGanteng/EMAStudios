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
 * Kelas untuk menginterpretasikan map permainan dari chip challenge, map digambar berdasarkan level yang diinginkan
 * @author EMA STUDIOS
 */
public class Board implements Drawable {
    
    private Grid[][] map;
    private int level;
    private Stash inventory;
    private Status stats;
    private int gridPlayerLocX, gridPlayerLocY;
    private Vector<Item> items;

    /**
     * Constructor untuk menginisialisasi attribute - attribute dari kelas Board
     * @param level level map yang ingin dibuat
     */
    public Board(int level) {
        this.level = level;
        this.map = new Grid[10][10];
        this.inventory = new Stash();
        this.items = new Vector<Item>();
        this.setMap();
    }
    
    /**
     * Method untuk mendapatkan map permainan saat ini
     * @return map pada saat method dipanggil
     */
    public Grid[][] getMap() {
        return map;
    }

    /**
     * Method untuk mendapatkan level permainan
     * @return level.
     */
    public int getLevel() {
        return level;
    }
    
    /**
     * Method untuk mendapatkan referensi dari objek stash yang digunakan oleh kelas Board ini
     * @return referensi objek stash
     */
    public Stash getInventory() {
        return inventory;
    }
    
    /**
     * Method untuk mendapatkan referensi dari objek status yang digunakan oleh kelas Board ini
     * @return referensi objek status
     */
    public Status getStats() {
        return stats;
    }
    
    @Override
    public void drawDefault(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        int i, j;
        for (i = 0; i < map.length; i++) {
            for (j = 0; j < map[0].length; j++) {
                if(map[i][j]==null)
                    System.out.println(i +" "+j);
                else
                g2.drawImage(map[i][j].getImage(), i * 65, j * 65, null);
            }
        }
        for (i = 0; i < items.size(); i++) {
            g2.drawImage(items.get(i).getImage(), items.get(i).getX() * 65, items.get(i).getY() * 65, null);
        }

    }
    
    /**
     * Method untuk mendapatkan list item apa sajakan yang terdapat di map permainan
     * @return list item yang digunakan di game
     */
    public Vector<Item> getListItemDiMap() {
        return this.items;
    }
    
    /**
     * Method untuk menset map yang akan digunakan dalam permainan nanti, tergantung dari level yang diset
     */
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
            /**
             * 0 1 2 3 4 5 6 7 8 9
             * W A A A A A W W W W 0
             * 1 P F C C C W K F W 1
             * F F F C C C W C F W 2
             * W D W W W C W F F W 3
             * W B W C F C C C C W 4
             * W E W W W C W W W W 5
             * W W W 2 W C C C K W 6
             * W C C C W C C F D W 7
             * W C C C D C C W K W 8
             * W W W W W W W W W W 9
             * 0 1 2 3 4 5 6 7 8 9 
             * Keterangan : -- W = Wall -- C = Chip / Integrated Circuit -- F =
             * Fire -- E = Finnish/Exit -- B = Barrier -- . = Lantai Kosong -- K
             * = Key -- D = Door --A =Air -- C = boot -- P = player
             */

            gridPlayerLocX = 1;
            gridPlayerLocY = 1;
            /**
             * Lantai Kosong
             */
            this.map[8][8] = this.map[8][6] = this.map[7][1] = this.map[1][1] = this.map[3][7] = new GridLantaiKosong(); 
            this.map[0][1] = this.map[3][6] = new GridLantaiKosong();
            
            //Item item yang tersedia di level ini
            items.add(new Key(8,6,Key.KUNCI_BIRU));
            items.add(new Key(7,1,Key.KUNCI_HIJAU));
            items.add(new Key(8,8,Key.KUNCI_MERAH));
            items.add(new Boot(3,6,Boot.SEPATU_API));
            items.add(new Boot(0,1,Boot.SEPATU_AIR));
            
            this.map[4][8] = new GridDoor(GridDoor.PINTU_BIRU); // Door biru di baris 8 kolom 4
            this.map[8][7] = new GridDoor(GridDoor.PINTU_HIJAU);//door biru di baris 7 kolom 8
            this.map[1][3] = new GridDoor(GridDoor.PINTU_MERAH);//door biru di baris 7 kolom 8
            /**
             * IC
             */
            for(int i=1;i<=8;i++){
                this.map[5][i] = new GridIC();
            }
            this.map[1][7] = this.map[1][8] = this.map[2][8] = this.map[3][8] = this.map[3][7] = new GridIC(); 
            this.map[6][8] = this.map[6][7] = this.map[6][6] = this.map[7][6] = this.map[6][4] = new GridIC(); 
            this.map[7][4] = this.map[8][4] = this.map[7][2] = this.map[3][4] = this.map[5][8] = new GridIC();
            this.map[3][1] = this.map[4][1] = this.map[3][2] = this.map[4][2] = this.map[2][7] = new GridIC();
 
            /**
             * Barrier & finish
             */
            this.map[1][4] = new GridBarrier();
            this.map[1][5] = new GridFinish();
            /**
             * Fire
             */
            this.map[0][2] = this.map[1][2] = this.map[2][2] = this.map[2][1] = this.map[7][3] = new GridFire(); 
            this.map[8][3] = this.map[8][2] = this.map[8][1] = this.map[7][7] = this.map[7][8] = new GridFire(); 
            this.map[4][4] = new GridFire();
            
            /**
             * Wall
             */
            for(int i=3;i<=8;i++){
                this.map[0][i] = new GridWall();
            }
            this.map[4][6] = this.map[4][7] = new GridWall();
            this.map[3][5] = this.map[4][5] = this.map[6][5] = this.map[7][5] = this.map[8][5] = new GridWall(); 
            this.map[6][1] = this.map[6][2] = this.map[6][3] = this.map[3][3] = this.map[4][3] = new GridWall();
            this.map[1][6] = this.map[2][6] = this.map[2][5] = this.map[2][4] = this.map[2][3] = new GridWall(); 

            /**
             * Wall di kolom 9 & baris 9
             */
            for(int i=0;i<=9;i++){
                this.map[9][i] = new GridWall();
                this.map[i][9] = new GridWall();
            }
            
            
            /**
             * Wall di baris 0
             */
            this.map[0][0] = this.map[7][8] = new GridWall();
            
            for(int i=6;i<=8;i++){
                this.map[i][0] = new GridWall();
            }
            /**
             * Air di baris 0
             */
            for(int i=1;i<=5;i++){
                this.map[i][0] = new GridWater();
            }
            
            
            
            this.stats = new Status(3, 20, 27,this.level);
            
        } else if (this.level == 4) {
             /**
             * 0 1 2 3 4 5 6 7 8 9
             * W W A A A A W W W W 0
             * W E B F F F . F F W 1
             * W W A A A A W F F W 2
             * W K W W W W W F F W 3
             * W F W W C C D D F W 4
             * W 1 . D C P W W W W 5
             * W W W W C W K K D W 6
             * W 2 . D C C C W C W 7
             * W A C C W K W W C W 8
             * W W W W W W W W W W 9
             * 0 1 2 3 4 5 6 7 8 9 
             * Keterangan : -- W = Wall -- C = Chip / Integrated Circuit -- F =
             * Fire -- E = Finnish/Exit -- B = Barrier -- . = Lantai Kosong -- K
             * = Key -- D = Door --A =Air -- C = boot -- P = player
             */
            this.gridPlayerLocX=5;
            this.gridPlayerLocY=5;
            GridWater gw=new GridWater();
            GridFire gf=new GridFire();
            GridIC gi=new GridIC();
            GridWall gwa=new GridWall();
            GridLantaiKosong glk=new GridLantaiKosong();
            
            this.map[8][1]=gw;
            this.map[8][2]=gi;
            this.map[8][3]=gi;
            this.map[8][4]=gwa;
            this.map[8][5]=glk;
            items.add(new Key(8,5,Key.KUNCI_BIRU));
            this.map[8][6]=gwa;
            this.map[8][7]=gwa;
            this.map[8][8]=gi;
            
            this.map[7][1]=glk;
            this.map[7][2]=gf;
            this.map[7][3]=new GridDoor(GridDoor.PINTU_BIRU);
            this.map[7][4]=gi;
            this.map[7][5]=gi;
            this.map[7][6]=gi;
            this.map[7][7]=gwa;
            this.map[7][8]=gi;
            items.add(new Boot(7,1,Boot.SEPATU_AIR));
            
            this.map[6][1]=gwa;
            this.map[6][2]=gwa;
            this.map[6][3]=gwa;
            this.map[6][4]=gi;
            this.map[6][5]=gwa;
            this.map[6][6]=glk;
            items.add(new Key(6, 6, Key.KUNCI_BIRU));
            this.map[6][7]=glk;
            items.add(new Key(6, 7, Key.KUNCI_MERAH));
            this.map[6][8]=new GridDoor(GridDoor.PINTU_BIRU);
            
            this.map[5][1]=glk;
            items.add(new Boot(5,1,Boot.SEPATU_API));
            this.map[5][2]=glk;
            this.map[5][3]=new GridDoor(GridDoor.PINTU_BIRU);
            this.map[5][4]=gi;
            this.map[5][5]=glk;
            this.map[5][6]=gwa;
            this.map[5][7]=gwa;
            this.map[5][8]=gwa;
            
            this.map[4][1]=gw;
            this.map[4][2]=gwa;
            this.map[4][3]=gwa;
            this.map[4][4]=gi;
            this.map[4][5]=gi;
            this.map[4][6]=new GridDoor(GridDoor.PINTU_MERAH);
            this.map[4][7]=new GridDoor(GridDoor.PINTU_BIRU);
            this.map[4][8]=gf;
            
            this.map[3][1]=glk;
            items.add(new Key(3,1,Key.KUNCI_BIRU));
            this.map[3][2]=gwa;
            this.map[3][3]=gwa;
            this.map[3][4]=gwa;
            this.map[3][5]=gwa;
            this.map[3][6]=gf;
            this.map[3][7]=gf;
            this.map[3][8]=gf;
            
            
            this.map[2][1]=gwa;
            this.map[2][2]=gw;
            this.map[2][3]=gw;
            this.map[2][4]=gw;
            this.map[2][5]=gw;
            this.map[2][6]=gf;
            this.map[2][7]=gf;
            this.map[2][8]=gf;
            
            this.map[1][1]=new GridFinish();
            this.map[1][2]=new GridBarrier();
            this.map[1][3]=gf;
            this.map[1][4]=gf;
            this.map[1][5]=gf;
            this.map[1][6]=glk;
            this.map[1][7]=gf;
            this.map[1][8]=gf;
            
            this.map[0][1]=gwa;
            
            this.map[0][2]=gw;
            this.map[0][3]=gw;
            this.map[0][4]=gw;
            this.map[0][5]=gw;
            this.map[0][6]=gwa;
            this.map[0][7]=gwa;
            this.map[0][8]=gwa;
           
            //wall di kolom 0
            int i,j;
            for(i=0;i<10;i++)
                this.map[i][0] = gwa;
            // di baris 9
            for(i=0;i<10;i++)
                this.map[9][i] = gwa;
            //di kolom 9
            for(i=0;i<10;i++)
                this.map[i][9] = gwa;
            
            stats = new Status(5, 0 , 11, level);
        }
    }
    
    /**
     * Method untuk mendapatkan lokasi koordinat x player pada saat game dimulai
     * @return lokasi koordinat x player pada saat game dimulai
     */
    public int getGridPlayerLocX() {
        return gridPlayerLocX;
    }
    
    /**
     * Method untuk mendapatkan lokasi koordinat y player pada saat game dimulai
     * @return lokasi koordinat y player pada saat game dimulai 
     */
    public int getGridPlayerLocY() {
        return gridPlayerLocY;
    }

    @Override
    public void drawAt(Graphics g, int offsetX, int offsetY) {

    }

}
