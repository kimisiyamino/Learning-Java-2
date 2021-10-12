package com.kimisi;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        // uestionFileOutputStream q = new QuestionFileOutputStream(new QuestionFileOutputStream(new QuestionFileOutputStream(new QuestionFileOutputStream(new QuestionFileOutputStream()))));

        //
        //BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("gavno"));


        PrintStream myPrintStream = new PrintStream("D:\\testAVAVAVAVAVAVVAVA.txt");
        System.setOut(myPrintStream);

        PrintStream p = System.out;

        p.println("это должно быть в файле где то");


    }
}
