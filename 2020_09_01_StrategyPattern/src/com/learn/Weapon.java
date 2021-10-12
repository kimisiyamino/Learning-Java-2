package com.learn;

public abstract class Weapon {
    ShotBehavior shotBehavior;
    ReloadBehavior reloadBehavior;

    int ammoCount;

    public void shot(AmmoBehavior ammoBehavior){
        if(ammoBehavior instanceof Bullet){
            shotBehavior.shot((Bullet)ammoBehavior);
        }else if(ammoBehavior instanceof Arrow){
            shotBehavior.shot((Arrow)ammoBehavior);
        }else{
            shotBehavior.shot();
        }

    }
    public void reload(){
        reloadBehavior.reload();
    }

    public void setShotBehavior(ShotBehavior shotBehavior){
        this.shotBehavior = shotBehavior;
    }

    public void setReloadBehavior(ReloadBehavior reloadBehavior){
        this.reloadBehavior = reloadBehavior;
    }


    abstract void display();
}
