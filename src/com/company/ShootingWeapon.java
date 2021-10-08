package com.company;

public class ShootingWeapon extends Weapon{
    private int ammo;
    public ShootingWeapon(String name, String description, int ammo, int damage){
        super(name, description, damage);
        this.ammo = ammo;
    }
}
