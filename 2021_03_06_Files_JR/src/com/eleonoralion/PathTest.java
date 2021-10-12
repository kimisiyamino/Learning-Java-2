package com.eleonoralion;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class PathTest {
    Scanner scanner;
    String stringPath;

    public static void main(String[] args) throws IOException {
        new PathTest().start();

//
//            Path path = Paths.get(stringPath);
//
//            System.out.println(path.getFileName());
//            System.out.println(path.getParent());
//
//            System.out.println(Files.exists(path));
//            System.out.println(Files.isDirectory(path));

       // }
       // try {
            //Files.createFile(path);
       // } catch (IOException e) {
       //     e.printStackTrace();
       // }
    }

    PathTest(){
        scanner = new Scanner(System.in);
        stringPath = "C:\\Users\\User\\IdeaProjects\\2021_03_06_Files_JR\\src\\com\\eleonoralion";
    }

    public void start() throws IOException {

        while (true) {
            cls();
            printStart();
            System.out.print("Input: ");
            int input = 0;
            try {
                input = scanner.nextInt();
            }catch (Exception e){
                System.out.println("Only number!");
                new PathTest().start();
            }
            switch (input) {
                case 1:
                    createFile();
                    break;
                case 2:
                    createDir();
                    break;
                case 3:
                    changeDir();
                    break;
                case 4:
                    printDir();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("Only 1-5!");
                    break;

            }

        }
    }

    public void createFile(){

    }
    public void createDir(){}
    public void changeDir(){}

    public void printDir(){
        Path path = Path.of(stringPath);
        try (DirectoryStream<Path> files = Files.newDirectoryStream(path)) {
            for (Path p : files)
                System.out.println(p.getFileName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exit(){
        System.out.println("BB!");
        System.exit(0);
    }

    public void printStart(){
        System.out.println("1. createFile");
        System.out.println("2. createDir");
        System.out.println("3. changeDir");
        System.out.println("4. printDir");
        System.out.println("5. exit");
        System.out.println(stringPath);
    }

    public void cls() throws IOException {
        try {
            new ProcessBuilder("cmd", "/c","cls").inheritIO().start().waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Runtime runtime = Runtime.getRuntime();
            //Process process = runtime.exec("clear");

            //System.out.print("\033[H\033[2J");
            //System.out.flush();

        //System.console().flush();

    }
}
