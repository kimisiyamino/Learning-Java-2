package com.learn;

public class Crossbow extends Weapon {
    Crossbow(){
        shotBehavior = new ShotArrow();
        reloadBehavior = new ReloadCrossbow();
    }

    @Override
    void display() {
        System.out.println("It's Crossbow!");
    }

}
