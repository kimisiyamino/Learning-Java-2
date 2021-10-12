// ThreadGroup
// ThreadFactory
// ThreadLocal / ThreadLocalRandom
// Executors / ExecutorService
//
//

package com.eleonoralion;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ThreadGroupTest {
    public static void main(String[] args) {
        ThreadGroup threadGroup1 = new ThreadGroup("groupA");
        ThreadGroup threadGroup2 = new ThreadGroup("groupB");

        System.out.println(threadGroup1.getName());

        Thread t1 = new Thread(threadGroup1, new testThread(), "");
        Thread t2 = new Thread(threadGroup1, () -> System.out.println("t2 = " + Thread.currentThread().getThreadGroup()), "");
        Thread t3 = new Thread(() -> System.out.println("t3 = " + Thread.currentThread().getThreadGroup().getName()), "");
        Thread t4 = new Thread(threadGroup1, () -> System.out.println(Thread.currentThread().getThreadGroup().getName()), "");

        Thread t5 = new Thread(threadGroup2, () -> System.out.println("5 = " + Thread.currentThread().getThreadGroup().getName()), "");
        Thread t6 = new Thread(threadGroup2, () -> System.out.println("T6 = " + Thread.currentThread().getThreadGroup().getName()), "");

        Thread t7 = new Thread(threadGroup2, ""){
            @Override
            public void run(){
                System.out.println("T7 = " + getThreadGroup().getName());
            }
        };

        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setName("GigAgaA");
                t.setPriority(1);
                return t;
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(4, threadFactory);

        executorService.submit(t1);
        executorService.submit(t2);
        executorService.submit(t3);
        executorService.submit(t4);
        executorService.submit(t5);
        executorService.submit(t6);
        executorService.submit(t7);

        executorService.shutdownNow();
        try {
            executorService.awaitTermination(1000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ThreadFactory threadFactory1 = Executors.defaultThreadFactory();

    }

    static class testThread implements Runnable{
        @Override
        public void run(){
            System.out.println("t1 = " + Thread.currentThread());
            System.out.println("t1 = " + Thread.currentThread().getThreadGroup());
            System.out.println("t1 = " + Thread.currentThread().getThreadGroup().getName());
            System.out.println("t1 = " + Thread.currentThread().getId());
        }
    }
}
