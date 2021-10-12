public class Main {
    public static void main(String[] args) {
        new Stopwatch().onCreate();
    }
}

class Stopwatch{

    long firstTime, secondTime, pastTime;


    public void onCreate(){
        Thread thread = new Thread(runnable);
        thread.start();

        firstTime = System.currentTimeMillis();

        onStart();
    }

    public void onStart(){

    }

    public void onStop(){


    }

    public void onDestroy(){

    }

    Runnable runnable = new Runnable() {
        boolean runningThread = true;

        @Override
        public void run() {
            while (runningThread) {
//https://www.youtube.com/watch?v=SH8U5a5NQAU&t=11s
// https://steamcommunity.com/id/wrthy/
                secondTime = System.currentTimeMillis();
                pastTime = 9_223_372_036_854_700_000L;

                int millis =    (int) ((    (long)pastTime % 1000) / 10) ;
                int sec =       (int) ((    (long)pastTime / 1000) % 60) ;


                int min =       (int) (     (long)pastTime / (60000)    % 60);
                long hours =      (     (long)pastTime / (long)3600000);


                System.out.printf("%d:%02d:%02d:%02d", hours, min, sec, millis);
                System.out.print(System.lineSeparator());
            }
        }
    };
}