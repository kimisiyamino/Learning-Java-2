package com.learn;

public class NoReload implements ReloadBehavior {
    public void reload(){
        System.out.println("No reload.");
    }
}
