package com.company;

public class Map {
    private final Room currentRoom;

    // Map constructor
    public Map() {
        // Opretter Room objekter
        Room room1 = new Room("Entrance", "You are now at the entrance to KEA. Around you, is the reception and you can see students rushing to their classes.");
        Room room2 = new Room("Canteen", "You are now at the canteen. Here you can relax at the tables and eat your lunch. You can smell the freshly brewed coffee.");
        Room room3 = new Room("Library", "You are now at the library. It's your first time here, feel free to read a book, but remember to be quiet.");
        Room room4 = new Room("Smoking area", "You are now at the smoking area. As the name suggests there are many smokers here.");
        Room room5 = new Room("Class room E436", "Congratulations, you have now arrived at your class room, but a little later than expected. Peter is not happy.");
        Room room6 = new Room("Bicycle basement", "You are now at the bicycle basement. You see a lot of bicycles and students bringing their bicycles, to store them here. Here....Ouch! Watch out!");
        Room room7 = new Room("Ground floor stairs", "You are now at the stairs at the ground floor. Use the stairs to get some exercise before going to class.");
        Room room8 = new Room("Third floor", "You are now at the third floor. You see some classmates. Now you know you're close to class.");
        Room room9 = new Room("Ground floor elevator", "You are at the ground floor elevator. It's okay to be lazy sometimes, go ahead and take the elevator.");

        // Opretter Item objekter til de forskellige rum
        room1.addToItem(new Item("key", "a shiny key. The classic adventure item guys and gals! I just hope we made a place to use it"));
        room2.addToItem(new Food("coffee", "a refreshing cup of coffee, just by smelling the aroma you feel just about able to take on the day", 20));
        room2.addToItem(new Food("apple", "a shiny apple. Shiny enough to impress even the most strict teachers", 15));
        room3.addToItem(new MeleeWeapon("book", "a student book. Do you really need more of a description?", 2, 999));
        room4.addToItem(new MeleeWeapon("lighter", "a lighter someone must have left on the ground, could be useful, if you're a pyromaniac", 8, 999));
        room6.addToItem(new MeleeWeapon("helmet", "a bicycle helmet. It could be used as a shield? I guess? Seriously, who came up with this?", 5, 999));
        room7.addToItem(new Food("cookie", "a well-done-cookie! Turns out taking the healthy choice does make a difference! By making it unhealthy as well", 25));
        room9.addToItem(new Food("bar", "a bland protein bar? Even though it may be a bit bland, at least it's kind of healthy?", 30));
        room8.addToItem(new ShootingWeapon("glock", "a gold-plated glock, an infamous game icon.", 12, 30));

        // Opretter monster Objekter til de forskellige rum
        Weapon claws = new MeleeWeapon("claws", "the dragon's claws, be careful not to cut yourself, they look sharp!", 15, 999);
        room5.addEnemy(new Enemy("dragon", "a fully programmed dragon made of code", 35, claws));
        Weapon smogGun = new ShootingWeapon("smoggun", "a smogGun, upon pressing the trigger, it shoots a thick cloud of toxic smog", 9, 16 );
        room4.addEnemy(new Enemy("smog", "a giant cloud of smog with no clear beginning or end", 32, smogGun));
        Weapon codeSword = new MeleeWeapon("sword", "a sword, it's a physical manifestation of some adventure game in the shape of a sword", 10, 999);
        room3.addEnemy(new Enemy("rogueAI", "an AI who is capable of passing a CAPTCHA, BE AFRAID", 30, codeSword));
        Weapon gunOfSloth = new ShootingWeapon("slothgun", "a slothGun, used against especially slothful people, or by them...", 8, 9);
        room9.addEnemy(new Enemy("sloth", "a sloth? Looks harmle- WAIT IT'S GOT A GUN", 25, gunOfSloth));


        // Sætter Room objekters forbindelse til hinanden
        room1.setEast(room2);
        room1.setSouth(room4);
        room2.setEast(room3);
        room3.setSouth(room6);
        room4.setSouth(room7);
        room5.setSouth(room8);
        room6.setSouth(room9);
        room7.setEast(room8);
        room8.setEast(room9);

        // Sætter currentRoom til Room Object: room1
        currentRoom = room1;
    }

    // Returns the current Room object
    public Room getCurrentRoom() {
        return currentRoom;
    }
}
