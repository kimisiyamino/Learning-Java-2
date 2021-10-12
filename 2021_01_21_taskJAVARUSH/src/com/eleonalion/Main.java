package com.eleonalion;

import java.io.*;

public class Main {
    public static String firstFileName;
    public static String secondFileName;

    static{
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));){
            //firstFileName = bufferedReader.readLine();
            //secondFileName = bufferedReader.readLine();
            firstFileName = "1";
            secondFileName = "2";
            System.out.println(System.getProperty("user.dir"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        default void join() throws InterruptedException{}

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{

        private String fullFileName;
        private String fileData;

        public ReadFileThread(){
            fullFileName = "";
            fileData = "";
        }

        public void setFileName(String fullFileName){
            this.fullFileName = fullFileName;
        }

        public String getFileContent(){
            return fileData;
        }


        public void start(){
            super.start();
        }

        @Override
        public void run(){
            try{
                BufferedReader bf = new BufferedReader(new FileReader(fullFileName));
                StringBuilder stringBuilder = new StringBuilder();
                while(bf.ready()){
                    stringBuilder.append(bf.readLine() + " ");
                    if(stringBuilder.toString().contains("\n")){
                        stringBuilder = new StringBuilder(stringBuilder.toString().replace("\n", ""));
                    }
                }
                fileData = stringBuilder.toString();
                bf.close();
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}