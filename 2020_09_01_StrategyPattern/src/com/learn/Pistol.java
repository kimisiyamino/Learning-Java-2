package com.learn;

public class Pistol extends Weapon {

    Pistol(){
        shotBehavior = new ShotAmmo();
        reloadBehavior = new ReloadPistol();
    }

    @Override
    void display() {
        System.out.println("It's Pistol!");
    }


}
