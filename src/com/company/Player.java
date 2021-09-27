package com.company;

import java.util.ArrayList;

public class Player {
    private ArrayList<Item> inventory = new ArrayList<>();
    Map map = new Map();
    private Room currentRoom;


    public Player(){
        currentRoom = map.getCurrentRoom();
    }
    public void takeItem(String itemToTake){
        //TODO Tag item fra rum, slet item fra rummet og placer item i inventory
        for (int i = 0; i < currentRoom.getItemList().size(); i++) {
            currentRoom.getItemList().get(i);
            if(currentRoom.getItemList().contains(itemToTake)){
                System.out.println("Works");
                //inventory.add(currentRoom.getItemList().contains(itemToTake));
                currentRoom.getItemList().remove(itemToTake);

            }

        }
    }
    public void dropItem(String itemToDrop){
        //TODO Slet item fra inventory og placer i currentRoom
    }
    public String showInventory(){
        return null;
    }
}
