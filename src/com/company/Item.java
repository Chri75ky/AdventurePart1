package com.company;

public class Item {
    private final String name;
    private final String description;

    //Item constructor
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //Returns the objects name
    public String getName() {
        return this.name;
    }

    //Returns the objects description
    public String getDescription() {
        return description;
    }

    @Override //Overriding toString to only return objects description
    public String toString() {
        return this.description;
    }
}
