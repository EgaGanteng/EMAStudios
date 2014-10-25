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
    }
    
    public void addInventory(){
        
    }
    
    public Grid getInventory(){
        return null;
    }
    
}
