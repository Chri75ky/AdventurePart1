package com.company;

public class Enemy {
    String name;
    String description;
    int currentHealth;
    Weapon equippedWeapon;


    public Enemy(String name, String description, int currentHealth, Weapon equippedWeapon) {
        this.name = name;
        this.description = description;
        this.currentHealth = currentHealth;
        this.equippedWeapon = equippedWeapon;
    }

    // Method deals damage to monster object
    public int takeDamage(int playerDamage) {
        this.currentHealth = this.currentHealth - playerDamage;
        return this.currentHealth;
    }


    // Method returns the damage monster object deals
    public int attack() {
        return equippedWeapon.getDamage();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }
    @Override //TODO lav til stringBuilder
    public String toString() {
        return "Enemy{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
