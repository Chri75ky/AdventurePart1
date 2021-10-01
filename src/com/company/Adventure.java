package com.company;
import java.util.Locale;
import java.util.Scanner;

public class Adventure {

    //Velkomst og starter spillet op
    public static void main(String[] args) {
        //Intro
        System.out.println("Welcome to the Adventure Game! Enter 'help' for more information about the game.");

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

        //Opretter boolean og string variabel
        Boolean runGame = true;
        String userInput;

        //Opretter scanner object
        Scanner in = new Scanner(System.in);

        //Runs the game
        while (runGame == true) {
            System.out.print("\nPlease input your next action: ");
            userInput = in.nextLine();
            userInput = userInput.toLowerCase();

            //De forskellige commands som brugeren kan inputte - hvis command ikke er legal bliver det udskrevet.
            switch(userInput) {
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
                    runGame = false;
                    break;

                case "inventory", "i":
                    lookInInventory();
                    break;

                default:
                    if (userInput.contains("take")) {              //Take items from room
                        player.takeItem(userInput);

                    } else if (userInput.contains("drop")) {       //Drops items in room
                        player.dropItem(userInput);

                    } else {
                        //If userInput dosen't match any commands
                        System.out.println("\nThe word '" + userInput + "' is not a legal command. Enter 'help' for a list of legal commands.");
                    }
            }
        }
    }


    //Method changes selectedRoom (current room user is in) and sets new playerLocation if the move direction is legal
    public static void move(String direction, Room getDirection) {
        System.out.println("\nGoing " + direction + ".");

        Room requestedRoom = getDirection;
        if(getDirection == null){
            System.out.println("You cannot go this way!");
        } else {
            selectedRoom = requestedRoom;
            player.setPlayerLocation(selectedRoom);
            look();
        }
    }

    //Method that prints out the name of the room, room description and items in the selectedRoom
    public static void look(){
        System.out.println("You are in room: " + selectedRoom.getName());
        System.out.println(selectedRoom.getDescription());

        if(selectedRoom.getItemList().size() > 0) {
            System.out.println(selectedRoom.toString());
        }else{
            System.out.println("There is nothing in this room.");
        }
    }

    //Method that prints a list of Items in inventory if there is something in the players inventory
    public static void lookInInventory() {
        System.out.println("\nLooking in backpack.");
        if (player.showInventory().isEmpty()){
            System.out.println("It doesn't seem that you have anything in your backpack.");
        } else {
            System.out.println(player.showInventory());
        }
    }

    //Method prints a list of possible user commands
    public static void help(){
        System.out.println("\nYou have chosen the help menu, here are the commands you can use in the Adventure Game: \n");
        System.out.println("Enter 'exit/x' to exit the game.");
        System.out.println("Enter 'look/l' to look around your surroundings.");
        System.out.println("Enter 'go north/north/n' if you wish to go north.");
        System.out.println("Enter 'go south/south/s' if you wish to go south.");
        System.out.println("Enter 'go west/west/w' if you wish to go west.");
        System.out.println("Enter 'go east/east/e' if you wish to go east.");
        System.out.println("Enter 'take [name of item]' if you wish to take the specific item.");
        System.out.println("Enter 'drop [name of item]' if you wish to drop the specific item.");
        System.out.println("Enter 'inventory/i' if you wish to take a look in your backpack.");
    }
}
