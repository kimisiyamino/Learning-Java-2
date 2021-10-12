import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        new Philosopher("", 0).start();
    }
}

class Philosopher implements Runnable {
    int id;
    String name;

    boolean leftFork;
    boolean rightFork;

    char leftForkID;
    char rightForkID;

    int hunger;
    String state = "think";

    public void start(){
        Forks forks = new Forks();

        Philosopher buddhaPhilosopher = new Philosopher("Buddha", 1);
        Philosopher aristotlePhilosopher = new Philosopher("Aristotle", 2);
        Philosopher platoPhilosopher = new Philosopher("Plato", 3);
        Philosopher pythagorasPhilosopher = new Philosopher("Pythagoras", 4);
        Philosopher socratesPhilosopher = new Philosopher("Socrates", 5);

        System.out.println(buddhaPhilosopher);
        System.out.println(aristotlePhilosopher);
        System.out.println(platoPhilosopher);
        System.out.println(pythagorasPhilosopher);
        System.out.println(socratesPhilosopher);

        System.out.print(System.lineSeparator());

        Thread buddhaThread = new Thread(buddhaPhilosopher);
        buddhaThread.start();

        Thread aristotleThread = new Thread(aristotlePhilosopher);
        aristotleThread.start();

        Thread platoThread = new Thread(platoPhilosopher);
        platoThread.start();

        Thread pythagorasThread = new Thread(pythagorasPhilosopher);
        //pythagorasThread.start();

        Thread socratesThread = new Thread(socratesPhilosopher);
        //socratesThread.start();
    }

    public Philosopher(String name, int id){
        this.id = id;
        this.name = name;
        this.hunger = 10;
        this.state = "think";



        this.leftForkID = getForkID(id, "LEFT");
        this.rightForkID = getForkID(id, "RIGHT");
    }

    public char getForkID(int id, String arm){
        char f = ' ';
        if(arm.equals("LEFT"))
            switch(id){
                case 1: f = Forks.forksList.get(1); break;
                case 2: f = Forks.forksList.get(2); break;
                case 3: f = Forks.forksList.get(3); break;
                case 4: f = Forks.forksList.get(4); break;
                case 5: f = Forks.forksList.get(0); break;
            }
        if(arm.equals("RIGHT"))
            switch(id){
                case 1: f = Forks.forksList.get(0); break;
                case 2: f = Forks.forksList.get(1); break;
                case 3: f = Forks.forksList.get(2); break;
                case 4: f = Forks.forksList.get(3); break;
                case 5: f = Forks.forksList.get(4); break;
            }
        return f;
    }

    public String getState(){


        return null;
    }

    @Override
    public void run() {
        System.out.println(this.name + " сел за стол.");
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(state.equals("think") && Forks.forksList.contains(this.leftForkID) && !leftFork){
                takeFork("LEFT");
            }else if(leftFork) {
                break;
            }else{
                System.out.println(this.name + " : нет левой вилки(");
            }

            if(state.equals("think") && Forks.forksList.contains(this.rightForkID) && !rightFork){
                takeFork("RIGHT");
            }else if(rightFork) {
                break;
            }else{
                System.out.println(this.name + " : нет правой вилки(");
            }

            if(leftFork && rightFork){
                state = "eat";
                System.out.println(this.name + " ест.");
            }



            if(hunger <= 0 ){
                dead();
                break;
            }
        }
    }

    public void takeFork(String arm){
        synchronized(this) {
            if(arm.equals("LEFT")) {
                if(Forks.forksList.contains(this.leftForkID)) {
                    this.leftFork = true;
                    System.out.println(this.name + " взял левую вилку: " + this.leftForkID);
                    Forks.forksList.set(Forks.forksList.indexOf(this.leftForkID), '0');

                    System.out.println(Forks.forksList);
                }
            }else if(arm.equals("RIGHT")){
                if(Forks.forksList.contains(this.rightForkID)) {
                    this.rightFork = true;
                    System.out.println(this.name + " взял правую вилку: " + this.rightForkID);
                    Forks.forksList.set(Forks.forksList.indexOf(this.rightForkID), '0');

                    System.out.println(Forks.forksList);
                }
            }
        }
    }

    public void dead() {
        System.out.println(this.name + " умер");
    }

    @Override
    public String toString() {
        return "Philosopher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", leftFork=" + leftFork +
                ", rightFork=" + rightFork +
                ", leftForkID=" + leftForkID +
                ", rightForkID=" + rightForkID +
                ", hunger=" + hunger +
                ", state='" + state + '\'' +
                '}';
    }
}

class Forks{
    static volatile List<Character> forksList = new ArrayList<>();

    public Forks(){
        forksList.add('a');
        forksList.add('b');
        forksList.add('c');
        forksList.add('d');
        forksList.add('e');
    }


}