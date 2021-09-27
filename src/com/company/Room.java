package com.company;

public class Room {
    private Room north;
    private Room south;
    private Room east;
    private Room west;
    private String description;
    private String name;

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

    public Room getNorth() {
        return north;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public Room getSouth() {
        return south;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public Room getEast() {
        return east;
    }

    public void setEast(Room east) {
        this.east = east;
    }

    public Room getWest() {
        return west;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
