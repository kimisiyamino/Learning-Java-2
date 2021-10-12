// code by eleonoralion
// 17.11.2020
// Reflection 1

package com.eleonoralion;

import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws InterruptedException {
        File[] listRoots = File.listRoots();


        System.out.println("Disks: \n" + listRoots.length+2);


        String path = "C:\\JAVA\\module1";
        String pathDisk = "C:\\";
        File dir = new File(pathDisk);
        File[] listAllFiles = dir.listFiles();

        ArrayList<File> listDir = new ArrayList<>();
        ArrayList<File> listFiles = new ArrayList<>();


        //System.out.println("= = = = = =");
       // printDir(listAllFiles);

        JFrame frame = new JFrame("Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(false);
        frame.setSize(1024, 768);
        frame.setResizable(false);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(150,0,100));

        JTextArea textArea = new JTextArea("");
        textArea.setBackground(new Color(0,0,0));
        textArea.setSelectedTextColor(new Color(255,255,0));
        textArea.setSelectionColor(new Color(0,255,0));
        textArea.setDisabledTextColor(new Color(255,0,0));
        textArea.setCaretColor(new Color(150,0,178));
       // textArea.setEnabled(false);
        textArea.setEditable(false);

        JTextArea textArea2 = new JTextArea("");
        textArea2.setBackground(new Color(255,0,0));
        textArea2.setEditable(false);

        frame.add(panel);
        panel.add(textArea);
        panel.add(textArea2);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    textArea.setText(printRoots(listRoots));
                }
            }
        });

        while(true){
            textArea2.setText(printDir(listAllFiles));
        }
    }



    public static String printDir(File[] listAllFiles){
        StringBuilder stringBuilder = new StringBuilder();
        for(File f : listAllFiles){
            stringBuilder.append(f.getAbsolutePath());
        }

        return stringBuilder.toString();


//        for(File f : listAllFiles){
//            System.out.println(f.getAbsolutePath() + " " + f.getName());
//            if(f.isDirectory()){
//
//            }
//            if(f.isFile()){
//
//            }
//
//        }
    }

    public static String printRoots(File[] listAllFiles){
        StringBuilder stringBuilder = new StringBuilder();
        for(File f : listAllFiles){
            stringBuilder.append(f.getAbsolutePath())
                         .append("\nFree Space: ").append(f.getFreeSpace())
                         .append("\nTotal Space: ").append(f.getTotalSpace())
                         .append("\n");
        }
        return stringBuilder.toString();
    }
}
