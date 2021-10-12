

package com.eleonoralion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SynchronizedTest {
    List<Integer> list1 = new ArrayList<>();
    List<Integer> list2 = new ArrayList<>();

    int[] array1 = new int[20];
    int[] array2 = new int[20];

    Object lock1 = new Object();
    Object lock2 = new Object();

    public static void main(String[] args){
        SynchronizedTest main = new SynchronizedTest();

        Thread thread1 = new Thread( () -> {
            main.doWorkList();
           // main.doWorkArray(0, 10);
        });

        Thread thread2 = new Thread(main::doWorkList);    //main.doWorkArray(10, 20);

        long startTime = System.currentTimeMillis();

        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        long finishTime = System.currentTimeMillis();

        System.out.println(main.list1.size());
        System.out.println(main.list2.size());

        long time = finishTime-startTime;
        System.out.println("Time: " + time);

       // System.out.println(Arrays.toString(main.array1));
      //  System.out.println(Arrays.toString(main.array2));
    }


    public void addToList1(){
        synchronized(lock1) {
            list1.add(new Random().nextInt(100));
        }
    }

    public void addToList2(){
        synchronized(lock2) {
            list2.add(new Random().nextInt(100));
        }
    }

    public void doWorkList(){
        for(int i = 0 ; i < 10000000; i++){
            addToList1();
            addToList2();
        }
    }



    public void addToArray1(int i){
        array1[i] = new Random().nextInt(100);
        System.out.println(Thread.currentThread().getName() + " add " + array1[i] + "to ONE");
    }

    public void addToArray2(int i){
        array2[i] = new Random().nextInt(100);
        System.out.println(Thread.currentThread().getName() + " add " + array2[i] + "to TWO");
    }

    public void doWorkArray(int i1, int i2){
        for(int i = i1 ; i < i2; i++){
            addToArray1(i);
            addToArray2(i);
        }
    }
}
