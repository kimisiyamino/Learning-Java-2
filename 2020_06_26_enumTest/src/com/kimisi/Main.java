package com.kimisi;

public class Main {
    public static void main(String[] args) {
        Weapon machinegun = Weapon.AK47;
        //System.out.println(Weapon.valueOf("SHOTGUN"));

        //System.out.println(Weapon.USP.ordinal());

        //Thread r = new Thread(Weapon.GRENADE);
        //r.start();

        System.out.println(Weapon.AK47 instanceof Weapon);
        System.out.println(Weapon.AK47 instanceof Enum);
        Weapon.AK47.x = 10;
        Weapon.M16.x = 20;
        System.out.println(Weapon.AK47.x);
        System.out.println(Weapon.M16.x);
    }



}

enum Weapon implements Runnable{
    AK47,
    M16,
    GLOCK18,
    USP,
    SHOTGUN(1),
    GRENADE;

    int x;

    Weapon(){
        System.out.println("Создан " + this.name());
    }
    Weapon(int x){
        System.out.println("Создан " + this.name() + x);
    }

    @Override
    public void run() {
        System.out.println("новый поток");
    }
}