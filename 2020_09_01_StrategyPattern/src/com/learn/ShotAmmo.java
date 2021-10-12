package com.learn;

public class ShotAmmo implements  ShotBehavior {
    public void shot(Bullet bylletType){
        switch(bylletType){
            case PistolAmmo: System.out.println("Pistol SHOT!"); break;
            case ShotgunAmmo: System.out.println("Shotgun SHOT!"); break;
            case MachinegunAmmo: System.out.println("Machinegun SHOT!"); break;
        }
    }

}
