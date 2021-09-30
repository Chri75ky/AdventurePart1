package com.company;

import java.util.Scanner;

public class Adventure {

    static Player player = new Player();

    public static void main(String[] args) {
        Map map = new Map();
        map.getCurrentRoom();

        Room selectedRoom = map.getCurrentRoom();
        Room requestedRoom = null;

        Scanner in = new Scanner(System.in);
        String action = "test";
        System.out.println("Welcome to the Adventure Game! Enter 'help' for more information about the game.");
       while(!action.equalsIgnoreCase("exit")) {
           System.out.println("Please input your next action: ");
           action = in.nextLine();
           if (action.equalsIgnoreCase("Go north")) {
               System.out.println("Going north.");
               requestedRoom = selectedRoom.getNorth();
               if(selectedRoom.getNorth() == null){
                   System.out.println("You cannot go this way!");
               }
           } else if (action.equalsIgnoreCase("Go south")) {
               System.out.println("Going south.");
               requestedRoom = selectedRoom.getSouth();
               if(selectedRoom.getSouth() == null){
                   System.out.println("You cannot go this way!");
               }
           } else if (action.equalsIgnoreCase("Go East")) {
               System.out.println("Going east.");
               requestedRoom = selectedRoom.getEast();
               if(selectedRoom.getEast() == null){
                   System.out.println("You cannot go this way!");
               }
           } else if (action.equalsIgnoreCase("Go West")) {
               System.out.println("Going west.");
               requestedRoom = selectedRoom.getWest();
               if(selectedRoom.getWest() == null){
                   System.out.println("You cannot go this way!");
               }
           } else if (action.equalsIgnoreCase("Look")) {
               look(selectedRoom);
           }
           else if (action.equalsIgnoreCase("help")){
               help();
           }
           if(requestedRoom != null) {
               System.out.println("You are now at: " + requestedRoom.getName());
               selectedRoom = requestedRoom;
               System.out.println(requestedRoom.getDescription());
           }

       }
    }

    public static void look(Room selectedRoom){
        System.out.println("Looking around.");
        System.out.println("You are in room: " + selectedRoom.getName());
        System.out.println(selectedRoom.getDescription());

        player.takeItem("take key", selectedRoom);
        player.takeItem("take book", selectedRoom);

        if(selectedRoom.getItemList().size() > 0) {
            System.out.println(selectedRoom.toString());
        }else{
            System.out.println("There is nothing in this room.");
        }
    }


    public static void help(){
        System.out.println("You have chosen the help menu, here are the commands you can use in the Adventure Game game: ");
        System.out.println();
        System.out.println("Enter 'exit' to exit the game.");
        System.out.println("Enter 'look' to look around your surroundings.");
        System.out.println("Enter 'go north' if you wish to go north.");
        System.out.println("Enter 'go south' if you wish to go south.");
        System.out.println("Enter 'go west' if you wish to go west.");
        System.out.println("Enter 'go east' if you wish to go east.");
        System.out.println("take [name of item] if you wish take the specific item.");
        System.out.println();
    }
}
