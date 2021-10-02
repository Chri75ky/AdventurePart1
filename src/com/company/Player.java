package com.company;
import java.util.ArrayList;

public class Player {
    private ArrayList<Item> inventory = new ArrayList<>();
    private Room currentRoom = null;

    //Method calls another method that checks if the item is in the room (and deletes it from currentroom) and then calls a method that adds that item to inventory ArrayList
    public void takeItem(String itemToTake){
        Item itemToInventory = currentRoom.removeItem(itemToTake);

        if (itemToInventory != null) {
            addItem(itemToInventory);

        } else {
            System.out.println(Colour.TEXT_RED + "\nThe item '" + Colour.TEXT_CYAN + itemToTake.substring(4) + Colour.TEXT_RED + "' is not in the room." + Colour.TEXT_RESET);
        }
    }

    //Method adds the item to players inventory
    public void addItem(Item itemToInventory) {
        System.out.println(Colour.TEXT_YELLOW + "It is now in your inventory." + Colour.TEXT_RESET);
        inventory.add(itemToInventory);
    }

    //Method checks if 'itemToDrop' is in the inventory - if item is present it calls method that adds item object to the room and then calls method that deletes item object from inventory
    public void dropItem(String itemToDrop) {

        //Removes 'drop' from the word so it can look for only the item name in getName which has suffix 'get [item name]'
        String itemName = itemToDrop.substring(5);

        boolean hasDropped = false;

        for (int i = 0; i <this.inventory.size(); i++) {
            if (this.inventory.get(i).getName().contains(itemName)) {

                System.out.println(Colour.TEXT_YELLOW + "\nYou have dropped '" + Colour.TEXT_CYAN + this.inventory.get(i).getDescription() + Colour.TEXT_YELLOW + "' into the room.");
                currentRoom.addToItem(this.inventory.get(i));
                removeItem(this.inventory.get(i));
                hasDropped = true;
            }
        }

        if (!hasDropped) {
            System.out.println(Colour.TEXT_RED + "\nThe item '" + Colour.TEXT_CYAN + itemName + Colour.TEXT_RED + "' is not in your inventory." + Colour.TEXT_RESET);
        }
    }

    //Method removes the item from players inventory
    public void removeItem (Item itemToInventory) {
        System.out.println(Colour.TEXT_YELLOW +"The item is removed from your inventory." + Colour.TEXT_RESET);
        inventory.remove(itemToInventory);
    }

    //Method returns a stringBuilder with the item objects description in the inventory
    public String showInventory() {
        //Creating stringBuilder object
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < inventory.size(); i++) {
            str.append("(" + (i+1) + ") " + inventory.get(i) + ",\n ");
        }

        str.delete(str.lastIndexOf(","),str.length());
        return Colour.TEXT_YELLOW + "In your backpack you have: " + Colour.TEXT_CYAN + str + Colour.TEXT_RESET;
    }

    //Method that returns ArrayList of items - inventory
    public ArrayList<Item> getInventory(){
        return  inventory;
    }

    //Method sets playerslocation to the selectedRoom when called
    public Room setPlayerLocation(Room selectedRoom) {
        this.currentRoom = selectedRoom;
        return this.currentRoom;
    }
}
