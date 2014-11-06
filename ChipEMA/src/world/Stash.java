/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package world;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 *
 * @author i13047
 */
public class Stash {
    private HashMap<String,Integer> inventoryList;
    /**
     * digunakan untuk daftar semua item yang ada di dalam stash
     */
    private Vector isiStash;

    public Stash() {
        this.inventoryList=new HashMap<String,Integer>();
            }
        
        /*
        kayaknya butuh, tempat penyimpanan baru deh,yang buat nyimpen letak2 inventorynya
        biar ntar bisa di ambil
        */
    
    /**
     * Method untuk menambahkan inventory baru dalam stash
     */
    public void addInventory(Item item){
        if(!this.inventoryList.containsKey(item.namaItem))
        {
            this.inventoryList.put(item.namaItem,1);
        }
        else
        {
            this.inventoryList.put(item.namaItem,this.inventoryList.get(item.namaItem)+1);
        }
    }
    
    /**
     * Method untuk mengecek apakah di stash ada item yang diinginkan . Method ini juga secara langsung menghilangkan 
     * item yang diambil.
     * @return true jika Item ada di stash , false jika tidak ada
     */
    public boolean cekInventory(String namaItem){
        if(this.inventoryList.containsKey(namaItem))
        {
            if(this.inventoryList.get(namaItem)==1)
            {
                this.inventoryList.remove(namaItem);
            }
            else
            {
                this.inventoryList.put(namaItem,this.inventoryList.get(namaItem)-1);
            }     
            return true;
        }
        else
        {  
            return false;
        }
    }
    
    /**
     * Method ini digunakan untuk melihat inventory-inventory yang dimiliki.
     */
    public Vector viewInventory(){
        Set set=this.inventoryList.entrySet();
        Iterator i = set.iterator();
        this.isiStash=new Vector();
        while(i.hasNext()){
          Map.Entry me = (Map.Entry)i.next();
          for(int j=0;j<(int)me.getValue();j++)
          {
              if(((String)me.getKey()).contains("KUNCI"))
              {
                  this.isiStash.add(new Key(0,0,(String)me.getKey()));
              }
              
          }
          //System.out.println(me.getKey() + " : " + me.getValue() );
        }
        return this.isiStash;
    }
}
