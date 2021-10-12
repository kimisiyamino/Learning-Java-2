package com.learn;

public class NoShot implements ShotBehavior {
    public void shot(){
        System.out.println("No shot");
    }
    public void shot(Bullet bulletType){
        System.out.println("No shot (" + bulletType.name() + " is lost)");
    }
    public void shot(Arrow arrowType){
        System.out.println("No shot (" + arrowType.name() + " is lost)");
    }
}
