package com.company;
import java.util.ArrayList;


public class Player {
    private ArrayList<Item> inventory = new ArrayList<>();

    public void takeItem(String itemToTake, Room currentRoom){
        //TODO Tag item fra rum, slet item fra rummet og placer item i inventory
        currentRoom.removeItem(itemToTake);

    }

    public void dropItem(String itemToDrop){
        //TODO Slet item fra inventory og placer i currentRoom
    }

    public String showInventory(){
        return null;
    }
}
