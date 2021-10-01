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
        room1.addToItem(new Item("take key", "a shiny key. The classic adventure item guys and gals! I just hope we made a place to use it"));
        room2.addToItem(new Item("take coffee", "a refreshing cup of coffee, just by smelling the aroma you feel just about able to take on the day"));
        room2.addToItem(new Item("take apple", "a shiny apple. Shiny enough to impress even the most strict teachers"));
        room3.addToItem(new Item("take book", "a student book. Do you really need more of a description?"));
        room4.addToItem(new Item("take lighter", "a lighter someone must have left on the ground, could be useful, if you're a pyromaniac"));
        room6.addToItem(new Item("take helmet", "a bicycle helmet. It could be used as a shield? I guess? Seriously, who came up with this?"));
        room7.addToItem(new Item("take cookie", "a well-done-cookie! Turns out taking the healthy choice does make a difference! By making it unhealthy as well"));
        room9.addToItem(new Item("take bar", "a bland protein bar? Even though it may be a bit bland, at least it's kind of healthy?"));

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
