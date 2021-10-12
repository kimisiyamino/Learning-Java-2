// setDaemon(true);
//
//
//
//

package com.eleonoralion;

public class DaemonTest {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            while(true){
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Run");
            }
        });

        t.setDaemon(true);
        t.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
