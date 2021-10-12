import java.io.*;

public class SystemInputOutput {

    OutputStream standardOutputStream = System.out;

    PrintStream printOutputStream = new PrintStream(standardOutputStream);
    static PrintStream fileOutputStream;
    static InputStream fileInputStream;

    static {
        try {
            fileOutputStream = new PrintStream(new File("C:\\Users\\User\\IdeaProjects\\16_10_2020_InputOutput\\src\\file1"));
            fileInputStream = new FileInputStream(new File("C:\\Users\\User\\IdeaProjects\\16_10_2020_InputOutput\\src\\file1"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void start() throws Exception{
        writeFile_SystemOut();
        readFile_SystemIn();
    }

    public long writeFile_SystemOut() throws Exception{
        // Запись System.out.write

        System.setOut(fileOutputStream);
        long time = System.currentTimeMillis();

        for(int i = 1; i <= 1000000; i++){
            //if(i % 10 == 0)
            //    System.out.write(10);
            //else
            System.out.write(i);
        }

        time = System.currentTimeMillis() - time;
        System.setOut(printOutputStream);
        System.out.println("System.out.write\nВремя записи: " + time);
        return time;
    }

    public static long readFile_SystemIn() throws Exception{
        // Чтение System.in.read

        System.setIn(fileInputStream);
        long time = System.currentTimeMillis();

        int x;
        //byte[] bytes = new byte[4];
        do{
            x = System.in.read();
            // if (System.in.available() != bytes.length){
            //    bytes = new byte[System.in.available()];
            // }

            //System.out.println(System.in.available() + " " + x);
            //System.out.println(Arrays.toString(bytes));
        }while(System.in.available() != 0);

        time = System.currentTimeMillis() - time;
        System.out.println("System.in.read\nВремя чтения: " + time);
        //   System.in.skip();
        return time;
    }
}
