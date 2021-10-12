import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {

//        D:\Java_learning\JAVA_RUSH\from_here\1.txt
//        D:\Java_learning\JAVA_RUSH\from_here\2.txt
        InputStream mainstream = System.in;
        String t = "text in file";
        InputStream i = new InputStream(t);
        System.setIn(i);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //String filename1 = bufferedReader.readLine();
        //String filename2 = bufferedReader.readLine();
        bufferedReader.close();
        FileReader fileReader = new FileReader(t);
        FileWriter fileWriter = new FileWriter(filename2);
        ArrayList<Integer> arrayList = new ArrayList<>();

        while (fileReader.ready()) {
            arrayList.add(fileReader.read());
        }
        fileReader.close();

        for (Integer i : arrayList) {
            if (arrayList.indexOf(i) % 2 != 0) {
                fileWriter.write(i);
            }
        }

        fileWriter.close();
    }
}