// Executor Executors
// ExecutorService
// newFixedThreadPool(2);
// submit(Runnable);
// shutdown();
// awaitTermination(1, TimeUnit.DAYS);
//

package com.eleonoralion;

import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for(int i = 0; i < 10; i++)
            executorService.submit(new Work(i));

        Scanner scanner = new Scanner(System.in);
        //String s = scanner.nextLine();
        //System.out.println(s);

        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Work completed!");
    }
}


class Work implements Runnable{

    private int id;

    public Work(int id){
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(id + " completed " + Thread.currentThread().getName());
    }
}