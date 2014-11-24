/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import interfaces.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 * Class Stash adalah kelas untuk merepresentasikan tempat item item yang dimiliki oleh chip.
 * @author EMA Studios
 */
public class Stash implements Drawable {

    private HashMap<String, Integer> inventoryList;
    /**
     * digunakan untuk daftar semua item yang ada di dalam stash
     */
    private Vector isiStash;
    private Font font;

    public Stash() {
        this.inventoryList = new HashMap<String, Integer>();
        isiStash = new Vector();
        font = new Font("VERDANA", Font.BOLD, 40) ;
    }

    
    /**
     * Method untuk menambahkan inventory baru dalam stash
     */
    public void addInventory(Item item) {
        if (!this.inventoryList.containsKey(item.namaItem)) {
            this.inventoryList.put(item.namaItem, 1);
        } else {
            this.inventoryList.put(item.namaItem, this.inventoryList.get(item.namaItem) + 1);
        }
        updateInventory();
    }

    /**
     * Method untuk mengecek apakah di stash ada item yang diinginkan . Method
     * ini juga secara langsung menghilangkan item yang diambil.
     *
     * @return true jika Item ada di stash , false jika tidak ada
     */
    public boolean cekInventory(String namaItem) {
        if (this.inventoryList.containsKey(namaItem)) {
            if (namaItem.contains("KUNCI")) {
                if (this.inventoryList.get(namaItem) == 1) {
                    this.inventoryList.remove(namaItem);
                } else {
                    this.inventoryList.put(namaItem, this.inventoryList.get(namaItem) - 1);
                }
            }
            updateInventory();
            return true;
        } else {
            return false;
        }
    }

    private void updateInventory() {
        Set set = this.inventoryList.entrySet();
        Iterator i = set.iterator();
        this.isiStash.removeAllElements();
        while (i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();
            for (int j = 0; j < (int) me.getValue(); j++) {
                if (((String) me.getKey()).contains("KUNCI")) {
                    this.isiStash.add(new Key(0, 0, (String) me.getKey()));
                } else if (((String) me.getKey()).contains("SEPATU")) {
                    this.isiStash.add(new Boot(0, 0, (String) me.getKey()));
                }

            }
            //System.out.println(me.getKey() + " : " + me.getValue() );
        }
    }

    /**
     * Method ini digunakan untuk melihat inventory-inventory yang dimiliki.
     */
    public Vector viewInventory() {
        return isiStash;
    }

    @Override
    public void drawDefault(Graphics g) {

        for (int i = 0; i < isiStash.size(); i++) {
            Item item = (Item) isiStash.get(i);
            g.drawImage(item.getImage(), i * 65, i, null);
        }

    }

    @Override
    public void drawAt(Graphics g, int offsetX, int offsetY) {
        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString("Inventory :", offsetX, offsetY+45);
        for (int i = 0; i < isiStash.size(); i++) {
            Item item = (Item) isiStash.get(i);
            g.drawImage(item.getImage(), i * 65 + offsetX, i + offsetY+50, null);
        }
    }
}
