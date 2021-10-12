package com.learn;

public class september01_01 {
    public static void main(String[] args) {

        Weapon glock = new Pistol();
        AmmoBehavior pistolAmmo = Bullet.PistolAmmo;

        glock.shot(pistolAmmo);
        glock.display();
        glock.reload();

        Weapon crossbow = new Crossbow();
        AmmoBehavior arrows = Arrow.SimpleArrow;
        crossbow.display();
        crossbow.shot(arrows);
        arrows = Arrow.PoisonArrow;
        crossbow.shot(arrows);
        crossbow.reload();

        Weapon testWeapon = new ModelWeapon();
        AmmoBehavior testBullets = Bullet.MachinegunAmmo;
        testWeapon.display();
        testWeapon.shot(testBullets);
        testWeapon.setShotBehavior(new ShotAmmo());
        testWeapon.shot(testBullets);
        testWeapon.reload();

        ReloadCrossbow rc = new ReloadCrossbow();
        testWeapon.setReloadBehavior(rc);
        testWeapon.reload();
    }
}