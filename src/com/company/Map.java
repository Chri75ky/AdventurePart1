package com.company;

public class Map {
    private Room currentRoom;

    //Map constructor
    public Map(){
        //Opretter Room objekter
        Room room1 = new Room("Entrance", "You are now at the entrance to KEA. Around you, is the reception and you can see students rushing to their classes.");
        Room room2 = new Room("Canteen", "You are now at the canteen. Here you can relax at the tables and eat your lunch. You can smell the freshly brewed coffee.");
        Room room3 = new Room("Library", "You are now at the library. It's your first time here, feel free to read a book, but remember to be quiet.");
        Room room4 = new Room("Smoking area", "You are now at the smoking area. As the name suggests there are many smokers here.");
        Room room5 = new Room("Class room E436", "Congratulations, you have now arrived at your class room, but a little later than expected. Peter is not happy.");
        Room room6 = new Room("Bicycle basement", "You are now at the bicycle basement. You see a lot of bicycles and students bringing their bicycles, to store them here. Here....Ouch! Watch out!");
        Room room7 = new Room("Ground floor stairs", "You are now at the stairs at the ground floor. Use the stairs to get some exercise before going to class.");
        Room room8 = new Room("Third floor", "You are now at the third floor. You see some classmates. Now you know you're close to class.");
        Room room9 = new Room("Ground floor elevator", "You are at the ground floor elevator. It's okay to be lazy sometimes, go ahead and take the elevator.");

        //Opretter Item objekter til de forskellige rum
        room1.addToItem(new Item("take key", "a shiny key that seems to be the ground floor key"));
        room1.addToItem(new Item("take book", "a student book that may be important for your next class."));
        //TODO Tilføj flere Items

        //Sætter Room objekters forbindelse til hinanden
        room1.setEast(room2);
        room1.setSouth(room4);
        room2.setEast(room3);
        room3.setSouth(room6);
        room4.setSouth(room7);
        room5.setSouth(room8);
        room6.setSouth(room9);
        room7.setEast(room8);
        room8.setEast(room9);

        //Sætter currentRoom til Room Object: room1
        currentRoom = room1;
    }

    //Returns the current Room object
    public Room getCurrentRoom(){
        return currentRoom;
    }
}
