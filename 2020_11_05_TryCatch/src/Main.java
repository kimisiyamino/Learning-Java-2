import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(baos));
        PrintWriter
        try(bf; bw){
            String in = bf.readLine();
            bw.write(in);
            System.out.println(baos);
            System.out.println(baos);
        }catch(IOException e) {
            e.printStackTrace();
        }

        BufferedReader r = new BufferedReader(new FileInputStream(new File("path")));
        Writer
        System.out.println(baos);
    }
}
