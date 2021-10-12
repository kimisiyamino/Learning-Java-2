package com.learn;

public class ModelWeapon extends Weapon{
    ModelWeapon(){
        shotBehavior = new NoShot();
        reloadBehavior = new NoReload();
    }

    @Override
    void display() {
        System.out.println("It's test weapon");
    }
}
