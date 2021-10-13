package com.company;

public class Enemy {
    private String name;
    private String description;
    private int currentHealth;
    private Weapon equippedWeapon;


    public Enemy(String name, String description, int currentHealth, Weapon equippedWeapon) {
        this.name = name;
        this.description = description;
        this.currentHealth = currentHealth;
        this.equippedWeapon = equippedWeapon;
    }

    // Method deals damage to monster object
    public int takeDamage(int damageToEnemy) {
        this.currentHealth = this.currentHealth - damageToEnemy;
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

    @Override
    public String toString() {
        return description;
    }
}

