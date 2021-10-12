package com.kimisi;


import java.io.*;

public class inputTest {
    public static void main(String[] args) throws IOException {
        int i;
        System.out.println((short)'а');
        OutputStream outputStream = new FileOutputStream("C:\\Users\\User\\IdeaProjects\\inputTest\\src\\com\\kimisi\\file");



        for( i = 0; i < 65535; i++)
        {
            outputStream.write(i);

        }
        outputStream.close();


        try {
            while ((i = System.in.read()) != -1) {
                if(i == 10) continue;
                System.out.print( i);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

