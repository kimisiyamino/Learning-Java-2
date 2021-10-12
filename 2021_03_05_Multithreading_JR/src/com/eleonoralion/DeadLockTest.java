// Lock
// ReentrantLock
// lock()
// unlock() (try/finally)
// tryLock()
//
//

package com.eleonoralion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockTest {
    public static void main(String[] args) {

        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account());
        accounts.add(new Account());

        Runner runner = new Runner(accounts);

        Thread thread1 = new Thread(runner::useThread1);
        Thread thread2 = new Thread(runner::useThread2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf("Acc1: %d%nAcc2: %d%nAll: %d", accounts.get(0).getBalance(), accounts.get(1).getBalance(), accounts.get(0).getBalance()+accounts.get(1).getBalance());

    }

}

class Runner{

    private final List<Account> accounts;

    Lock lock1 = new ReentrantLock();
    Lock lock2 = new ReentrantLock();

    public Runner(List<Account> accounts){
        this.accounts = accounts;
    }

    public void useThread1(){
        Random randNum = new Random();

//        for(int i = 0 ; i < 10000; i++) {
//            synchronized (accounts) {
//                Account.transfer(accounts.get(0), accounts.get(1), randNum.nextInt(100));
//            }
//        }

        for(int i = 0; i < 10000; i++){
            lock1.lock();
            lock2.lock();
            try{
                Account.transfer(accounts.get(0), accounts.get(1), randNum.nextInt(100));
            }finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }
    public void useThread2(){
        Random randNum = new Random();

//        for(int i = 0 ; i < 10000; i++) {
//            synchronized (accounts) {
//                Account.transfer(accounts.get(1), accounts.get(0), randNum.nextInt(100));
//            }
//        }

        for(int i = 0; i < 10000; i++){
            lock2.lock();
            lock1.lock();
            try{
                Account.transfer(accounts.get(1), accounts.get(0), randNum.nextInt(100));
            }finally {
                lock1.unlock();
                lock2.unlock();
            }
        }


    }
}

/*
        synchronized(Acc1){
            synchronized(Acc2){
                Account.transfer(Acc1, Acc2, );
            }
        }
 */

class Account{
    private int balance = 10000;

    public Account(){

    }

    public Account(int balance){
        this.balance = balance;
    }

    public void deposit(int amount){
        balance += amount;
    }

    public void withdrow(int amount){
        balance -= amount;
    }

    public static final synchronized void transfer(Account a1, Account a2, int amount){
        a1.withdrow(amount);
        a2.deposit(amount);
    }

    public int getBalance(){
        return balance;
    }
}
