import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // Стандартные потоки
    static InputStream standardInputStream = System.in;
    static OutputStream standardOutputStream = System.out;
    static PrintStream printOutputStream = new PrintStream(standardOutputStream);
    static PrintStream fileOutputStream1;
    static PrintStream fileOutputStream2;
    static FileInputStream fileInputStream1;
    static FileInputStream fileInputStream2;


    public static void main(String[] args) throws Exception {
        new SystemInputOutput().start();
        System.out.println(System.lineSeparator());
        new SystemIOBytes().start();


    //  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==//


//        Reader inputStreamReader = new InputStreamReader(System.in);
//        System.out.println("Прочитал\t\tПриведение\t\tready?");
//
//        do {
//           int x = inputStreamReader.read();
//            if(x == 10){
//                System.out.println(x + "\t\t\t" + "'\\n'" + "\t\t\t" + Boolean.toString(inputStreamReader.ready()));
//            }else
//                System.out.println(x + "\t\t\t" + (char)x + "\t\t\t" + Boolean.toString(inputStreamReader.ready()));
//        }while(inputStreamReader.ready());

    //  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==//

        // Строка, которую будет считывать
        // Буфер Байтов из этой строки {12 45 23 34 42}
        // Поток байтов
        // Новый поток, принимающий байты
        // Установить новый поток

        String tempString = "string\ngg\njjj\rhaha";
        byte[] bytes2 = tempString.getBytes();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes2);
        InputStream newStream = byteArrayInputStream;
        System.setIn(newStream);

        // Новый поток, принимающий файл
        // Установить новый поток
        // Вывести число доступных байтов в потоке

        InputStream fileStream = new FileInputStream("C:\\Users\\User\\IdeaProjects\\16_10_2020_InputOutput\\src\\file");
        System.setIn(fileStream);
        System.out.println("Число available: "+fileStream.available());

        // Буферизованный ридер/Ридер потока принимающий System-поток
        // Ридер: читать строку до символа \n (x4)

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Строка 1" + bufferedReader.readLine());
        System.out.println("Строка 2" + bufferedReader.readLine());
        System.out.println("Строка 3" + bufferedReader.readLine());
        System.out.println("Строка 4" + bufferedReader.readLine());

        // Установить стандартный поток
        System.setIn(standardInputStream);

        // Буферизованный ридер/Ридер потока принимающий System-поток
        // Цикл выполняем пока...
            // Поток: считать байт
            // System: Вывести байт
        // пока число доступных в потоке байтов не равно 0

        BufferedInputStream bufferedInputStream = new BufferedInputStream(System.in);
        System.out.print("введите что то: ");
        int count = 0;
        do {
            int xx = bufferedInputStream.read();
            System.out.println(String.format("байт %d: %d", ++count, xx));
        }while(bufferedInputStream.available() != 0);

        // === Второй вариант считывания
        //
        // Цикл пока считываемый из потока байт не равен 0
        // System: Вывести байт

//        int x;
//        while((x = bufferedInputStream.read()) != -1)
//            System.out.println(x);
//        }


        //  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==  ==//
//
//            while (bufferedReader.r > 0) {
//                readerFile.read(bytes);}



        InputStream inputStream = new FileInputStream("C:\\Users\\User\\IdeaProjects\\16_10_2020_InputOutput\\src\\file");

        Closeable streamm = new BufferedInputStream(new FileInputStream("C:\\Users\\User\\IdeaProjects\\16_10_2020_InputOutput\\src\\file"));
        Closeable readerr = new InputStreamReader(new FileInputStream("C:\\Users\\User\\IdeaProjects\\16_10_2020_InputOutput\\src\\file"));

        BufferedInputStream streamm0 = (BufferedInputStream)streamm;
        InputStreamReader readerr0 = (InputStreamReader)readerr;

        byte[] bytes0 = new byte[streamm0.available()];
        while (streamm0.available() > 0){
            System.out.println(streamm0.available() + " ");
            streamm0.read(bytes0);
        }
        //System.out.println("streamm0 " + Arrays.toString(bytes0));

        System.out.print("readerr0 ");
        do{
            readerr0.read();
            //System.out.print(" " + readerr0.read() + ",");
        }while (readerr0.ready());


        BufferedReader bufferedReader1 = new BufferedReader(new FileInputStream(InputStream)));
    }
}
