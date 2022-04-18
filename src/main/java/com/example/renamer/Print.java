package com.example.renamer;

import java.awt.*;
import java.io.File;
import java.util.List;

public class Print {

    public int printFiles(List<File> filesToPrint) {

        Desktop desktop = Desktop.getDesktop();
        int counter = 0;
        for (File file : filesToPrint) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
                try {
                    //desktop.print(file);
                    System.out.println(file.getName());
                    counter++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return counter;
    }
}