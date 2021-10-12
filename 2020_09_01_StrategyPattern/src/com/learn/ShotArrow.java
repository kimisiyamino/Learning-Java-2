package com.learn;

public class ShotArrow implements  ShotBehavior{
    public void shot(Arrow arrowType){
        switch (arrowType){
            case SimpleArrow: System.out.println("Simple arrow SHOT!"); break;
            case FireArrow: System.out.println("FIRE arrow SHOT!");break;
            case PoisonArrow: System.out.println("Poison arrow SHOT!"); break;
        }

    }
}
