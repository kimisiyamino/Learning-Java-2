package com.learn;

public interface ShotBehavior {
    default void shot(Bullet bulletType){

    }
    default void shot(Arrow arrowType){

    }
    default void shot(){

    }
}
