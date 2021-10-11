package com.company;

public class Enemy {
    String name;
    String description;
    int currentHealth;
    Weapon equippedWeapon;
    //Måske currentRoom TODO


    public Enemy(String name, String description, int currentHealth, Weapon equippedWeapon) {
        this.name = name;
        this.description = description;
        this.currentHealth = currentHealth;
        this.equippedWeapon = equippedWeapon;
    }

    //Method deals damage to monster object
    public int takeDamage (int playerDamage) {
        this.currentHealth =- playerDamage;
        return this.currentHealth;
    }


    //Method returns the damage monster object deals
    public int attack() {
        return equippedWeapon.getDamage();
    }






}
