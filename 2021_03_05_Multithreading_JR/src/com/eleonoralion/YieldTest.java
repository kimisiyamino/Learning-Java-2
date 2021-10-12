package com.eleonoralion;

public class YieldTest {
    public static void main(String[] args) throws InterruptedException{
        YIEL y = new YIEL();
        new TestThread(y);
       // Thread.sleep(100);
        new TestThread(y);
        new TestThread(y);
      //  Thread.sleep(100);
    }
}

class TestThread extends Thread{
    YIEL y;
    public TestThread(YIEL y){
        this.y = y;
        start();
    }

    @Override
    public void run() {
        y.go();
    }
}

class YIEL{
    public synchronized void go(){
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + " здаров, пропускаю...");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + " кончил");
    }
}
