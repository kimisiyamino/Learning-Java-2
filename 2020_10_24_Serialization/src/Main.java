import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
      //  Hero h1 = new Hero(100, 666, "Ann", 777);

      //  System.out.println(h1);

      // ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("file")));
     //   oos.writeObject(h1);
     //   oos.writeInt(Hero.count);
        //oos.flush();
    //    oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("file"));

        Hero h2 = (Hero)ois.readObject();
        int p = ois.readInt();
        Hero.count = p;


        ois.close();

        System.out.println(h2);
    }
}


