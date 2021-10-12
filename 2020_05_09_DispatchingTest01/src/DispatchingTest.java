import java.util.Arrays;

public class DispatchingTest {
    public static void main(String[] args) {

       Fruit fruit = new Fruit();
       Apple apple = new Apple();
       apple.count = 100;
       Orange orange = new Orange();

       Fruit link = fruit;
       link.toString();
       System.out.println("Link(fruit) Count: " + link.count);

       link = apple;
       link.toString();
       System.out.println("Link(apple) Count: " + link.count);

       link = orange;
       link.toString();
       System.out.println("Link(orange) Count: " + link.count);

        link.count = 50;
        link = fruit;
        System.out.println("Link(fruit 50) Count: " + link.count);


        System.out.println("Orange Count: " + orange.count + " " + orange.getSuperCount());
        System.out.println("Apple count: " + apple.count + " " + apple.getSuperCount());
        System.out.println("Fruit count: ffffff" + fruit.count);
        link = orange;
        System.out.println(link.count);


    }
}

class Fruit{

    public int count = 10;

    public String toString() {
        System.out.println("Fruit");
        return "Fruit";
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

class Apple extends Fruit{

    public int count = 20;

    @Override
    public String toString() {
        System.out.println("Apple");
        return "Apple";
        Integer.compare()ж
    }

    public int getCount() {
        return count;
    }

    public int getSuperCount(){
        return super.count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

class Orange extends Fruit{

    public int count = 30;

    @Override
    public String toString() {
        System.out.println("Orange");
        return "Orange";
    }

    public int getSuperCount(){
        return super.count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
