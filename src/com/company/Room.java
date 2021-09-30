package com.company;

import java.util.ArrayList;

public class Room {
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private String description;
    private String name;
    private ArrayList<Item> itemList = new ArrayList<>();

    public Room(Room north, Room south, Room east, Room west){
    this.north = north;
    this.south = south;
    this.east = east;
    this.west = west;
    }
    public Room(String name, String description){
        this.name = name;
        this.description = description;
    }
    public void addToItem(Item item){
        itemList.add(item);

    }



    public void removeItem(String itemName) {
        for (int i = 0; i < this.itemList.size(); i++) {
            if (this.itemList.get(i).getName().contains(itemName)) {
                this.itemList.remove(i);
            }
        }
    }


    public ArrayList<Item> getItemList(){
        return itemList;
    }
    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north){
        if (this.north == null){
            this.north = north;
            north.setSouth(this);
        }
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room north){
        if (this.south == null){
            this.south = north;
            south.setNorth(this);
        }
    }
    public Room getEast() {
        return east;
    }
    public void setEast(Room east){
        if (this.east == null){
            this.east = east;
            east.setWest(this);
        }
    }
    public Room getWest() {
        return west;
    }
    public void setWest(Room west){
        if (this.west == null){
            this.west = west;
            west.setEast(this);
        }
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        String temp = "";
        for (int i = 0; i < itemList.size(); i++) {
            temp += itemList.get(i) + ", ";
        }
        return "In the room there is " + temp;
    }
}

