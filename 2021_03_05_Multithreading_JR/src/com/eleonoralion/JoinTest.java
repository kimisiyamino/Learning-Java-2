// join()
// getState()
// enum State

package com.eleonoralion;

public class JoinTest {
    private int count;
    Thread thread1;
    Thread thread2;

    public static void main(String[] args) {
        new JoinTest().doWork();
    }

    public synchronized void increment(){
        System.out.println(thread2.getName() + " " + thread2.getState().name());
        count++;
    }

    public void doWork(){
        thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                increment();
            }
        }, "Ann");

        thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                increment();
            }
        }, "Ben");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println(count);
    }
}
