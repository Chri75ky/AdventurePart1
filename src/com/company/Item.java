package com.company;

public class Item {
    private String name;
    private String description;

    //Item constructor
    public Item(String name, String description){
        this.name = name;
        this.description = description;
    }

    //Returns the objects name
    public String getName() {
        return this.name;
    }

    @Override //Overriding toString to only return objects description
    public String toString() {
        return this.description;
    }
}
