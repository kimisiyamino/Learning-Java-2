import java.util.ArrayList;
import java.util.List;

public class synchronizedTest{
    public static void main(String[] args) {
        new Work().go();
    }
}

class Work{

    private int x;
    private int y;
    final List<Integer> list1 = new ArrayList<>();
    final List<Integer> list2 = new ArrayList<>();

    long time;
    long startTime;
    long pastTime;

    List<Integer> listInteger = new ArrayList<>();

    public void increment(){
        synchronized (list1) {
            for (int i = 0; i < 100000; i++) {
                listInteger.add(0, i);
                //System.out.println(Thread.currentThread().getName() + " x: " + x);
            }
            time = System.currentTimeMillis();
            time-=startTime;
            System.out.println(Thread.currentThread().getName() + " completed x. " + (time/1000) + " seconds, " + (time%1000));
        }
        synchronized (list2) {
            for (int i = 0; i < 100000; i++) {
                listInteger.add(0, i);
                //System.out.println(Thread.currentThread().getName() + " y: " + y);
            }
            time = System.currentTimeMillis();
            time-=startTime;
            System.out.println(Thread.currentThread().getName() + " completed y. " + (time/1000) + " seconds, " + (time%1000));
        }

    }

    public void go(){
        startTime = System.currentTimeMillis();

        Thread thread01 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });
        Thread thread02 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment();
            }
        });

        thread01.setName("Вова");
        thread02.setName("Дима");

        thread01.start();
        thread02.start();

        try {
            thread01.join();
            thread02.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pastTime = System.currentTimeMillis();

        System.out.println(x + " " + y);
        System.out.println("Время программы:" + (pastTime - startTime));

    }
}
