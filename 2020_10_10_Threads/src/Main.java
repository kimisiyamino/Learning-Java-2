import javax.xml.namespace.QName;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Test thread1 = new Test("ANNA");

        thread1.join();
        Test thread2 = new Test("KATYA");
        System.out.println("gg");
    }
}

class Test extends Thread{

    public Test(String name){
        super(name);
        start();
    }

    public void run(){
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "*");

        }

    }
}
