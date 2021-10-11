package com.company;

public abstract class Weapon extends Item{
    private final int damage;
    private int ammo;
    public Weapon(String name, String description, int damage, int ammo){
        super(name, description);
        this.damage = damage;
        this.ammo = ammo;

    }
    public int getDamage(){
        return this.damage;
    }
    public int usesLeft(){
        return this.ammo;
    }

    public void ammoUsed() {
        this.ammo --;
    }

}
