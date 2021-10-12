import java.io.*;


public class SystemIOBytes {

    OutputStream standardOutputStream = System.out;

    PrintStream printOutputStream = new PrintStream(standardOutputStream);
    static PrintStream fileOutputStream;
    static InputStream fileInputStream;

    static {
        try {
            fileOutputStream = new PrintStream(new File("C:\\Users\\User\\IdeaProjects\\16_10_2020_InputOutput\\src\\file2"));
            fileInputStream = new FileInputStream(new File("C:\\Users\\User\\IdeaProjects\\16_10_2020_InputOutput\\src\\file2"));
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

        long time = System.currentTimeMillis();
        byte[] bytes = new byte[1000000];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte)(Math.random() * 127);
        }
        time = System.currentTimeMillis() - time;
        System.setOut(printOutputStream);
        System.out.println("\nВремя записи буфера байтов: " + time);


        System.setOut(fileOutputStream);
        time = System.currentTimeMillis();

        System.out.write(bytes, 0, bytes.length);

        time = System.currentTimeMillis() - time;
        System.setOut(printOutputStream);
        System.out.println("System.out.write, bytes[]\nВремя записи: " + time);
        return time;
    }


    public static long readFile_SystemIn() throws Exception{
        // Чтение System.in.read

        System.setIn(fileInputStream);
        long time = System.currentTimeMillis();

        byte[] bytes = new byte[System.in.available()];

        while(System.in.available() != 0)
            System.in.read(bytes);
//            if (System.in.available() != bytes.length){
//                bytes = new byte[System.in.available()];
//            }

        //System.out.println(System.in.available() + " " + x);
        //System.out.println(Arrays.toString(bytes));


        time = System.currentTimeMillis() - time;
        System.out.println("System.in.read, bytes[]\nВремя чтения: " + time);
        //   System.in.skip();
        return time;
    }
}
