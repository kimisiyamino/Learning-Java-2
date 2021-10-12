package com.eleonoralion;

import java.io.File;
import java.nio.file.Path;

public class FileTest {

    public static void main(String[] args) {
        File dirBin = new File(System.getProperty("user.dir") + "\\src\\bin");

        System.out.println(dirBin.getPath());
        System.out.println(dirBin.getAbsolutePath());
        System.out.println(dirBin.getParent());
        System.out.println(dirBin.getName());

        for(File f : dirBin.listFiles()){
            System.out.println(f.getName());
        }

        File fileMsss = new File(System.getProperty("user.dir") + "\\src\\bin\\mess.txt");

        Path path = fileMsss.toPath();

        System.out.println(path.getFileName());

    }
}
