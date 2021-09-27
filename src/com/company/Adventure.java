package com.company;

import java.util.Scanner;

public class Adventure {
    public static void main(String[] args) {
       Room room1 = new Room("Entrance", "You are now at the entrance to KEA. Around you, is the reception and you can see students rushing to their classes.");
        Room room2 = new Room("Canteen", "You are now at the canteen. Here you can relax at the tables and eat your lunch. You can smell the freshly brewed coffee.");
        Room room3 = new Room("Library", "You are now at the library. It's your first time here, feel free to read a book, but remember to be quiet.");
        Room room4 = new Room("Smoking area", "You are now at the smoking area. As the name suggests there are many smokers here.");
        Room room5 = new Room("Class room E436", "Congratulations, you have now arrived at your class room, but a little later than expected. Peter is not happy.");
        Room room6 = new Room("Bicycle basement", "You are now at the bicycle basement. You see a lot of bicycles and students bringing their bicycles, to store them here. Here....Ouch! Watch out!");
        Room room7 = new Room("Ground floor stairs", "You are now at the stairs at the ground floor. Use the stairs to get some exercise before going to class.");
        Room room8 = new Room("Third floor", "You are now at the third floor. You see some classmates. Now you know you're close to class.");
        Room room9 = new Room("Ground floor elevator", "You are at the ground floor elevator. It's okay to be lazy sometimes, go ahead and take the elevator.");

        room1.setEast(room2);
        room1.setNorth(null);
        room1.setWest(null);
        room1.setSouth(room4);

        room2.setEast(room3);
        room2.setNorth(null);
        room2.setWest(room1);
        room2.setSouth(null);

        room3.setEast(null);
        room3.setNorth(null);
        room3.setWest(room2);
        room3.setSouth(room6);

        room4.setEast(null);
        room4.setNorth(room1);
        room4.setWest(null);
        room4.setSouth(room7);

        room5.setEast(null);
        room5.setNorth(null);
        room5.setWest(null);
        room5.setSouth(room8);

        room6.setEast(null);
        room6.setNorth(room3);
        room6.setWest(null);
        room6.setSouth(room9);

        room7.setEast(room8);
        room7.setNorth(room4);
        room7.setWest(null);
        room7.setSouth(null);

        room8.setEast(room9);
        room8.setNorth(room5);
        room8.setWest(room7);
        room8.setSouth(null);

        room9.setEast(null);
        room9.setNorth(room6);
        room9.setWest(room8);
        room9.setSouth(null);



        Room selectedRoom = room1;
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
               System.out.println("Looking around.");
               System.out.println("You are in room: " + selectedRoom.getName());
               System.out.println(selectedRoom.getDescription());
           }
           else if (action.equalsIgnoreCase("help")){
               System.out.println("You have chosen the help menu, here are the commands you can use in the Adventure Game game: ");
               System.out.println();
               System.out.println("Enter 'exit' to exit the game.");
               System.out.println("Enter 'look' to look around your surroundings.");
               System.out.println("Enter 'go north' if you wish to go north.");
               System.out.println("Enter 'go south' if you wish to go south.");
               System.out.println("Enter 'go west' if you wish to go west.");
               System.out.println("Enter 'go east' if you wish to go east.");
               System.out.println();
           }
           if(requestedRoom != null) {
               System.out.println("You are now at: " + requestedRoom.getName());
               selectedRoom = requestedRoom;
               System.out.println(requestedRoom.getDescription());
           }

       }
    }
}
