/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world;

import world.map.Grid;

/**
 *
 * @author i13047
 */
public class Board {
    private Grid[][] map;
    private int level;
    private Stash inventory;
    private Status stats;
    
    public Board(int level){
        this.level = level;
        this.map=new Grid[10][10];
        this.stats=new Status();
        this.inventory=new Stash();
    }
    
    public void setMap()
    {
        if(this.level==1)
        {
            
        }
        else if(this.level==1)
        {
            
        }
        else if(this.level==1)
        {
            
        }
    }
    
}
