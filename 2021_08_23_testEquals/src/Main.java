abstract class Writer{

    public static void write() {
        System.out.println("Я РОДИТЕЛЬ");
    }

}

class WriterChild extends Writer{

    public static void write() {
        System.out.println("Я РОЕЛЬ");
    }

}



public class Main extends WriterChild{

    public static void write() {
        System.out.println("Я РЕБЕНОК");
    }

    public static void main(String[] args) {
        WriterChild w = new Main();
        w.write();
    }
}
