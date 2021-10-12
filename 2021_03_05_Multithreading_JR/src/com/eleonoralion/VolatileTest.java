package com.eleonoralion;

import java.util.Scanner;

public class VolatileTest {
    public static void main(String[] args) {

        ThreadTest threadIvanImp = new ThreadTest();
        Thread threadIvan = new Thread(threadIvanImp, "Поток Иван");

        System.out.println(threadIvan.getState().name());
        threadIvan.start();
        System.out.println(threadIvan.getState().name());

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        threadIvanImp.stopThread();
        System.out.println(threadIvan.getState().name());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(threadIvan.getState().name());

    }
}



class ThreadTest implements Runnable{
    private boolean isRunning = true;

    @Override
    public void run(){
        while(isRunning){
            try {
                System.out.println(Thread.currentThread().getName() + " isRunning");
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " stopped");
    }

    public void stopThread() {
        isRunning = false;
    }
}
