package com.example.renamer;

import java.awt.*;
import java.io.File;
import java.util.Collections;
import java.util.List;

public class Print {

    public int printFiles(List<File> filesToPrint) {

        Desktop desktop = Desktop.getDesktop();
        int counter = 0;
        Collections.sort(filesToPrint);
        for (File file : filesToPrint) {
            if (file.isFile()) {
                try {
                    desktop.print(file);
                    counter++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return counter;
    }
}