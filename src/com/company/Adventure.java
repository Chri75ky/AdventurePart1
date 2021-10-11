package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Adventure {

    //Velkomst og starter spillet op
    public static void main(String[] args) {
        //Intro
        System.out.println(Colour.TEXT_YELLOW + "\nWelcome to the Adventure Game! Enter '" + Colour.TEXT_PURPLE + "help" + Colour.TEXT_YELLOW + "' for more information about the game." + Colour.TEXT_RESET);

        //Method that starts and runs the game
        runGame();
    }


    //Opretter player object
    static Player player = new Player();

    //Opretter nyt Map objekt (som sætter current room til room1)
    static Map map = new Map();

    //Variable der holder styr på hvilket Rum vi er i (og player er i) - startværdi room1.
    static Room selectedRoom = map.getCurrentRoom();


    //Method runs the game
    public static void runGame() {

        //Sets players starting location to selectedRoom (room1)
        player.setPlayerLocation(selectedRoom);
        player.setCurrentHealth(100);

        //Initializing and setting starting weapon as knucles/bare hands
        Weapon knucles = new MeleeWeapon("knucles", "Your weak hands won't do much damage, but it is better than nothing!", 2);
        player.setEquippedItem(knucles);

        //Opretter boolean og string variabel
        Boolean runGame = true;
        String userInput;

        //Opretter scanner object
        Scanner in = new Scanner(System.in);

        //Runs the game
        while (runGame) {
            System.out.print(Colour.TEXT_WHITE + "\nPlease input your next action: " + Colour.TEXT_RESET);
            userInput = in.nextLine();
            userInput = userInput.toLowerCase();

            //De forskellige commands som brugeren kan inputte - hvis command ikke er legal bliver det udskrevet.
            switch (userInput) {
                case "go north", "north", "n":
                    Room getNorth = selectedRoom.getNorth();
                    move("north", getNorth);
                    break;

                case "go south", "south", "s":
                    Room getSouth = selectedRoom.getSouth();
                    move("south", getSouth);
                    break;

                case "go east", "east", "e":
                    Room getEast = selectedRoom.getEast();
                    move("east", getEast);
                    break;

                case "go west", "west", "w":
                    Room getWest = selectedRoom.getWest();
                    move("west", getWest);
                    break;

                case "look", "l":
                    System.out.println("\nLooking around.");
                    look();
                    break;

                case "help", "h":
                    help();
                    break;

                case "exit", "x":
                    System.out.println(Colour.TEXT_WHITE + "Terminating program..." + Colour.TEXT_RESET);
                    runGame = false;
                    break;

                case "inventory", "i":
                    lookInInventory();
                    break;

                case "health", "he":
                    health();
                    break;


                default:
                    if (userInput.contains("take")) {              //Take items from room
                        player.takeItem(userInput);

                    } else if (userInput.contains("drop")) {       //Drops items in room
                        player.dropItem(userInput);

                    } else if (userInput.contains("eat")) {
                        // Use try/catch to look for errors when only writing eat
                        try {
                           String itemToEat = userInput.substring(4);
                           if (itemToEat.length() > 0) {
                               eat(itemToEat);
                           }
                       }catch(StringIndexOutOfBoundsException e) {
                            System.out.println("Can't eat 'nothing'.");
                        }
                    } else if (userInput.contains("equip")){
                        // Use try/catch to look for errors when only writing equip
                        try {
                            String itemToEquip = userInput.substring(6);
                            if (itemToEquip.length() > 0) {
                                equip(itemToEquip);
                            }
                        }catch(IndexOutOfBoundsException e) {
                            System.out.println("Can't equip 'nothing'.");
                        }
                    } else if (userInput.contains("attack")) {
                        attack(userInput);

                    } else {
                        //If userInput dosen't match any commands
                        System.out.println(Colour.TEXT_RED + "\nThe word '" + userInput + "' is not a legal command. Enter '" + Colour.TEXT_PURPLE + "help" + Colour.TEXT_RED + "' for a list of legal commands." + Colour.TEXT_RESET);
                    }
            }
        }
    }


    //Method changes selectedRoom (current room user is in) and sets new playerLocation if the move direction is legal
    public static void move(String direction, Room getDirection) {
        System.out.println("\nGoing " + direction + ".");

        Room requestedRoom = getDirection;
        if (getDirection == null) {
            System.out.println(Colour.TEXT_RED + "You cannot go this way!" + Colour.TEXT_RESET);
        } else {
            selectedRoom = requestedRoom;
            player.setPlayerLocation(selectedRoom);
            look();
        }
    }

    //Method that prints out the name of the room, room description and items in the selectedRoom
    public static void look() {
        System.out.println(Colour.TEXT_YELLOW + "You are now at the: " + selectedRoom.getName());
        System.out.println(selectedRoom.getDescription() + Colour.TEXT_RESET);

        if (selectedRoom.getItemList().size() > 0) {
            System.out.println(selectedRoom.toString());
        } else {
            System.out.println(Colour.TEXT_YELLOW + "There is nothing in this room." + Colour.TEXT_RESET);
        }
    }

    //Method that prints a list of Items in inventory if there is something in the players inventory
    public static void lookInInventory() {
        System.out.println("\nLooking in backpack.");
        if (player.getInventory().isEmpty()) {
            System.out.println("It doesn't seem that you have anything in your backpack.");
        } else {
            //TODO tilføj equipped Item
            System.out.println(player.showInventory());
        }
    }

    //Method prints a list of possible user commands
    public static void help() {
        System.out.println(Colour.TEXT_YELLOW + "\nYou have chosen the help menu, here are the commands you can use in the Adventure Game: \n");
        System.out.println("Enter '" + Colour.TEXT_PURPLE + "go north" + Colour.TEXT_YELLOW + " / " + Colour.TEXT_PURPLE + "north" + Colour.TEXT_YELLOW + " / " + Colour.TEXT_PURPLE + "n" + Colour.TEXT_YELLOW + "' if you wish to go north.");
        System.out.println("Enter '" + Colour.TEXT_PURPLE + "go south" + Colour.TEXT_YELLOW + " / " + Colour.TEXT_PURPLE + "south" + Colour.TEXT_YELLOW + " / " + Colour.TEXT_PURPLE + "s" + Colour.TEXT_YELLOW + "' if you wish to go south.");
        System.out.println("Enter '" + Colour.TEXT_PURPLE + "go west" + Colour.TEXT_YELLOW + " / " + Colour.TEXT_PURPLE + "west" + Colour.TEXT_YELLOW + " / " + Colour.TEXT_PURPLE + "w" + Colour.TEXT_YELLOW + "' if you wish to go west.");
        System.out.println("Enter '" + Colour.TEXT_PURPLE + "go east" + Colour.TEXT_YELLOW + " / " + Colour.TEXT_PURPLE + "east" + Colour.TEXT_YELLOW + " / " + Colour.TEXT_PURPLE + "e" + Colour.TEXT_YELLOW + "' if you wish to go east.");
        System.out.println("Enter '" + Colour.TEXT_PURPLE + "look" + Colour.TEXT_YELLOW + " / " + Colour.TEXT_PURPLE + "l" + Colour.TEXT_YELLOW + "' to look around your surroundings.");
        System.out.println("Enter '" + Colour.TEXT_PURPLE + "take [name of item]" + Colour.TEXT_YELLOW + "' if you wish to take the specific item.");
        System.out.println("Enter '" + Colour.TEXT_PURPLE + "drop [name of item]" + Colour.TEXT_YELLOW + "' if you wish to drop the specific item.");
        System.out.println("Enter '" + Colour.TEXT_PURPLE + "inventory" + Colour.TEXT_YELLOW + " / " + Colour.TEXT_PURPLE + "i" + Colour.TEXT_YELLOW + "' if you wish to take a look in your backpack.");
        System.out.println("Enter '" + Colour.TEXT_PURPLE + "exit" + Colour.TEXT_YELLOW + " / " + Colour.TEXT_PURPLE + "x" + Colour.TEXT_YELLOW + "' to exit the game." + Colour.TEXT_RESET);
        //TODO add health and equip
    }

    // Method gets currentHealth of player and tells user whether they should heal.
    public static void health() {
        int currentHealth = player.getCurrentHealth();
        if (/*currentHealth <= 100 &&*/ currentHealth > 75) {
            System.out.println("Health: " + currentHealth);
            System.out.println("You are in good health, you're free to fight!");
        } else if (currentHealth <= 75 && currentHealth > 50) {
            System.out.println("Health: " + currentHealth);
            System.out.println("You are still in good health, but the " +
                    "next time you get hit you will be low!");
        } else if (currentHealth <= 50 && currentHealth > 25) {
            System.out.println("Health: " + currentHealth);
            System.out.println("You're getting low, you should probably avoid fighting right now.");
        } else if (currentHealth <= 25 && currentHealth > 0) {
            System.out.println("Health: " + currentHealth);
            System.out.println("You're really low, you need to heal yourself, next time you get hit you might die!");
        }
    }
    // Method to eat an item given by user
    public static void eat(String itemToEat) {
        // Check if item is in player inventory
        if (player.isItemInInventory(itemToEat)) {
            try {
                // Check if item is Food
                Player.edibleItems.valueOf(itemToEat.toUpperCase());
                // Create Item to later make Food from player inventory ArrayList
                Item selectedItem = player.getItemInInventory(itemToEat);
                // Get healthPoints of food item and add to player currentHealth
                if (selectedItem instanceof Food) {
                    int healthToAdd = ((Food) selectedItem).getHealthPoints();
                    player.addToCurrentHealth(healthToAdd);
                    System.out.println("You have gained " + healthToAdd + " health from eating " + itemToEat + "!");
                    // Remove eaten item from player inventory
                    player.removeItem(selectedItem);
                    System.out.println("Your current health is now: " + player.getCurrentHealth());
                }
            // If item is not edible (Is not in enum list), tell user
            } catch (IllegalArgumentException e) {
                System.out.println("The item " + itemToEat + " is not edible!");
            }
        } else {
            System.out.println("The item " + itemToEat + " is not in your inventory!");
        }
    }
    public static void equip(String itemToEquip){
        // Check if the item is in player inventory
        if(player.isItemInInventory(itemToEquip)){
            // Check if the item is from the weapon enum
            try{
                Player.weaponsYouCanEquip.valueOf(itemToEquip.toUpperCase());
                Item selectedItem = player.getItemInInventory(itemToEquip);
                // Equip the weapon and remove it from player inventory
                if(selectedItem instanceof Weapon){
                    player.setEquippedItem(selectedItem);
                    System.out.println("The item " + player.getEquippedItem().getName() + " has now been equipped!");
                    player.removeItem(selectedItem);
                }
            } catch(IllegalArgumentException e){
                System.out.println("The item " + itemToEquip + " is not possible to equip!");
            }

        } else {
            System.out.println("The item " + itemToEquip + " is not in your inventory!");
    }

    }

    public static void attack(String input) {






    }
}
