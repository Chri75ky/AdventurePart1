package com.company;

import java.util.ArrayList;

public class Room {
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private final String description;
    private final String name;
    private final ArrayList<Item> itemList = new ArrayList<>();
    private final ArrayList<Enemy> enemyList = new ArrayList<>();

    // Room constructor
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Adds item Objects to Room objects Item ArrayList
    public void addToItem(Item item) {
        this.itemList.add(item);
    }

    // Adds enemy Objects to Room objects Item ArrayList
    public void addEnemy(Enemy enemy) {
        this.enemyList.add(enemy);
    }

    // Checks if item is in the room and removes it from this room if it is present and then returns that Item object to Player object
    public Item removeItem(String itemName) {
        for (int i = 0; i < this.itemList.size(); i++) {
            if (this.itemList.get(i).getName().equals(itemName)) {
                Item toPlayer = this.itemList.get(i);
                System.out.println(Colour.TEXT_YELLOW + "\nYou have taken '" + Colour.TEXT_CYAN + this.getItemList().get(i).toString() + Colour.TEXT_YELLOW + "' from the " + this.getName() + "." + Colour.TEXT_RESET);
                this.itemList.remove(i);
                return toPlayer;
            }
        }
        return null;
    }

    // Returns ArrayList of Items in the room
    public ArrayList<Item> getItemList() {
        return this.itemList;
    }

    // Returns ArrayList of Enemy in the room
    public ArrayList<Enemy> getEnemyList() {
        return this.enemyList;
    }

    // Method returns or sets Room objects directions
    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        if (this.north == null) {
            this.north = north;
            north.setSouth(this);
        }
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room north) {
        if (this.south == null) {
            this.south = north;
            south.setNorth(this);
        }
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        if (this.east == null) {
            this.east = east;
            east.setWest(this);
        }
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        if (this.west == null) {
            this.west = west;
            west.setEast(this);
        }
    }

    // Method returns name or description of Room Object
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public void removeEnemy(String enemyName) {

        Weapon weaponToDrop = null;
        for (int i = 0; i < this.enemyList.size(); i++) {
            if (this.enemyList.get(i).getName().equals(enemyName)) {
                weaponToDrop = this.enemyList.get(i).getEquippedWeapon();
                addToItem(weaponToDrop);
                this.enemyList.remove(i);
            }
        }
    }


    public Enemy getEnemy(String enemyName) {

        Enemy enemyToAttack = null;

        for (int i = 0; i < enemyList.size(); i++) {
            if (enemyList.get(i).getName().equals(enemyName)) {
                enemyToAttack = enemyList.get(i);
            }
        }
        return enemyToAttack;
    }


    @Override // Overriding toString to return af stringBuilder with all item Objects descriptions in the room
    public String toString() {

        // Creating stringBuilder object
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < itemList.size(); i++) {
            str.append("(" + (i + 1) + ") " + itemList.get(i) + ",\n ");
        }

        str.delete(str.lastIndexOf(","), str.length());
        return Colour.TEXT_YELLOW + "In the room there is: " + Colour.TEXT_CYAN + str + Colour.TEXT_RESET;
    }

}

