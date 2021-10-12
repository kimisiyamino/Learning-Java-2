package com.eleonoralion;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;

public class WalkDirExamples {
    public static void main(String[] args) {

        // 1 Queue
        Queue<File> queue = new LinkedList<>();
        List<String> list = new LinkedList<>();

        while (!queue.isEmpty()) {
            for (File temp : Objects.requireNonNull(queue.poll().listFiles())) {
                if (temp.isFile() && temp.length() <= 50) {
                    list.add(temp.getAbsolutePath());
                } else if (temp.isDirectory()) {
                    queue.add(temp);
                }
            }
        }

        // 2 Recursion
        // public void processFilesFromFolder(){
        File folder = new File("path");
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries)
        {
            if (entry.isDirectory())
            {
                //processFilesFromFolder(entry);
                continue;
            }
            // иначе вам попался файл, обрабатывайте его!
        }

        // 3 Stream API

        try {
            Files.walk(Paths.get("ваш каталог тут"))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 4 JavaRush Task
/*
        class Solution {
            public void main(String[] args) {
                String path = args[0];
                String resultFileAbsolutePath = args[1];
                try {
                    File resultFile = new File(resultFileAbsolutePath);
                    File dest = new File(resultFile.getParentFile() + "/allFilesContent.txt");
                    if (FileUtils.isExist(dest)) {
                        FileUtils.deleteFile(dest);
                    }
                    FileUtils.renameFile(resultFile, dest);

                    Map<String, byte[]> fileTree = getFileTree(path);
                    try (FileOutputStream fileOutputStream = new FileOutputStream(dest)) {
                        for (byte[] bytes : fileTree.values()) {
                            fileOutputStream.write(bytes);
                            fileOutputStream.write("\n".getBytes());
                        }
                    }
                } catch (IOException ignored) {
                }
            }

            public Map<String, byte[]> getFileTree(String root) throws IOException {
                Map<String, byte[]> result = new TreeMap<>();

                EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
                Files.walkFileTree(Paths.get(root), options, 20, new GetFiles(result));

                return result;
            }

            class GetFiles extends SimpleFileVisitor<Path> {
                private Map<String, byte[]> result;

                public GetFiles(Map<String, byte[]> result) {
                    this.result = result;
                }

                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
                    File file = path.toFile();
                    if (file.isFile()) {
                        if (file.length() <= 50) {
                            result.put(path.getFileName().toString(), Files.readAllBytes(path));
                        }
                    }
                    return super.visitFile(path, basicFileAttributes);
                }
            }
        }
*/

        // Чтение файла

        byte[] bytes = new byte[0];
        try {
            bytes = Files.readAllBytes(Paths.get("path"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String content = new String(bytes, StandardCharsets.UTF_8);

    }
}
