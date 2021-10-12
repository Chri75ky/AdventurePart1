package com.company;

import java.util.ArrayList;

public class Player {
    private final ArrayList<Item> inventory = new ArrayList<>();
    private Room currentRoom = null;
    private int currentHealth;
    private Item equippedItem;

    // Method calls another method that checks if the item is in the room (and deletes it from currentRoom) and then calls a method that adds that item to inventory ArrayList
    public void takeItem(String itemToTake) {

        Item itemToInventory = currentRoom.removeItem(itemToTake);

        if (itemToInventory != null) {
            addItem(itemToInventory);

        } else {
            System.out.println(Colour.TEXT_RED + "\nThe item '" + Colour.TEXT_CYAN + itemToTake.substring(4) + Colour.TEXT_RED + "' is not in the room." + Colour.TEXT_RESET);
        }
    }

    // Method adds the item to players inventory
    public void addItem(Item itemToInventory) {

        System.out.println(Colour.TEXT_YELLOW + "It is now in your inventory." + Colour.TEXT_RESET);
        inventory.add(itemToInventory);
    }

    // Method checks if 'itemToDrop' is in the inventory - if item is present it calls method that adds item object to the room and then calls method that deletes item object from inventory
    public void dropItem(String itemToDrop) {

        boolean hasDropped = false;

        for (int i = 0; i < this.inventory.size(); i++) {
            if (this.inventory.get(i).getName().equals(itemToDrop)) {

                System.out.println(Colour.TEXT_YELLOW + "\nYou have dropped '" + Colour.TEXT_CYAN + this.inventory.get(i).getDescription() + Colour.TEXT_YELLOW + "' into the room.");
                currentRoom.addToItem(this.inventory.get(i));
                removeItem(this.inventory.get(i));
                hasDropped = true;
            }
        }

        if (!hasDropped) {
            System.out.println(Colour.TEXT_RED + "\nThe item '" + Colour.TEXT_CYAN + itemToDrop + Colour.TEXT_RED + "' is not in your inventory." + Colour.TEXT_RESET);
        }
    }

    // Method removes the item from players inventory
    public void removeItem(Item itemToInventory) {
        System.out.println(Colour.TEXT_YELLOW + "The item is removed from your inventory." + Colour.TEXT_RESET);
        inventory.remove(itemToInventory);
    }

    // Method returns a stringBuilder with the item objects description in the inventory
    public String showInventory() {
        // Creating stringBuilder object
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < inventory.size(); i++) {
            str.append("(" + (i + 1) + ") " + inventory.get(i) + ",\n ");
        }

        str.delete(str.lastIndexOf(","), str.length());
        return Colour.TEXT_YELLOW + "In your backpack you have: " + Colour.TEXT_CYAN + str + Colour.TEXT_RESET;
    }

    // Method that returns ArrayList of items - inventory
    public ArrayList<Item> getInventory() {
        return inventory;
    }

    // Method sets playersLocation to the selectedRoom when called
    public Room setPlayerLocation(Room selectedRoom) {
        this.currentRoom = selectedRoom;
        return this.currentRoom;
    }

    // Method returns currentHealth of player
    public int getCurrentHealth() {
        return currentHealth;
    }

    // Method sets currentHealth to a specific value
    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    // Method to add health to player's currentHealth
    public void addToCurrentHealth(int healthPoints) {
        this.currentHealth += healthPoints;
    }

    public enum weaponsYouCanEquip {
        // List of weapons that the player can equip from their inventory
        BOOK, LIGHTER, HELMET, GLOCK
    }

    public enum edibleItems {
        // List of edible items, used to check if items in player inventory are edible
        COFFEE, APPLE, BAR, COOKIE
    }

    // Method to check if an item is in player inventory
    public boolean isItemInInventory(String itemToFind) {
        boolean isInInventory = false;
        for (int i = 0; i < this.inventory.size(); i++) {
            if (this.inventory.get(i).getName().contains(itemToFind)) {
                isInInventory = true;
            }
        }
        return isInInventory;
    }

    // Method to find an Item in player inventory that returns said Item
    public Item getItemInInventory(String itemToFind) {
        Item itemToGet = null;
        for (int i = 0; i < this.inventory.size(); i++) {
            if (this.inventory.get(i).getName().contains(itemToFind)) {
                itemToGet = this.inventory.get(i);
            }
        }
        return itemToGet;
    }


    public void setEquippedItem(Item equippedItem) {   //TODO FJern knuckles fra backpack når de bliver skiftet ud
        // If player already has an equipped weapon, add it back to
        // the player inventory and replace it with the new weapon
        if (this.equippedItem != null) {
            addItem(this.equippedItem);
        }

        this.equippedItem = equippedItem;
    }

    public Item getEquippedItem() {
        return equippedItem;
    }


    // Method deals damage to player object
    public int takeDamage(int enemyDamage) {
        this.currentHealth = this.currentHealth - enemyDamage;
        return this.currentHealth;
    }


    // Method returns the damage player object deals
    public int attack() {

        int damage = 0;
        if (equippedItem instanceof Weapon) {
            damage = ((Weapon) equippedItem).getDamage();
        }
        return damage;
    }
    // Method return enemy object that player wants to attack or are closest to player in the SelectedRoom
    public Enemy enemyToAttack(String input) {

        Enemy enemyToAttack = null;

        //If player wrote attack + 'enemy name' it looks for the enemy name in the arraylist for the room
        if (input.length() >= 7) {
            String enemyName = input.substring(7);

            for (int i = 0; i < currentRoom.getEnemyList().size(); i++) {
                if (currentRoom.getEnemyList().get(i).getName().contains(enemyName)) {
                    enemyToAttack = currentRoom.getEnemyList().get(i);
                } else {
                    System.out.println("The enemy '" + enemyName + "' is not in the room.");
                }
            }
        } else {
            // If input is only 'attack' - it will attack enemy at arrayIndex 0
            if (!currentRoom.getEnemyList().isEmpty()) {
                enemyToAttack = currentRoom.getEnemyList().get(0);

            } else {
                System.out.println("There are no enemies in the room.");
            }
        }

        return enemyToAttack;
    }



}
