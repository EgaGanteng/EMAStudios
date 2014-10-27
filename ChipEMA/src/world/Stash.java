/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world;

import world.map.Grid;
import world.map.GridLantaiKosong;

/**
 *
 * @author i13047
 */
public class Stash {
    private Grid[][] inventoryList;

    public Stash() {
        inventoryList = new Grid[2][4];
        for (int i = 0; i < inventoryList.length; i++) {
            for (int j = 0; j < inventoryList[i].length; j++) {
                inventoryList[i][j] = new GridLantaiKosong();
            }
        }
        /*
        kayaknya butuh, tempat penyimpanan baru deh,yang buat nyimpen letak2 inventorynya
        biar ntar bisa di ambil
        */
    }
    /**
     * Method untuk menambahkan inventory baru dalam stash
     */
    public void addInventory(){
        
    }
    
    /**
     * Method untuk mengambil Inventory yang ada dalam stash. Method ini juga secara langsung menghilangkan 
     * Inventory yang diambil.
     * @return inventory : Grid
     */
    public Grid takeInventory(){
        return null;
    }
    
    /**
     * Method ini digunakan untuk melihat inventory-inventory yang dimiliki.
     * @return arrayOfGrid : Grid, array dengan ukuran 2x4 yang bersisi
     * barang-barang yang dimiliki.
     */
    public Grid[][] viewInventory(){
        return null;
    }
}
