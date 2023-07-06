package com.example.renamer;

import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Print {

    public int printFiles(List<File> filesToPrint) {

        Desktop desktop = Desktop.getDesktop();
        int counter = 0;
        File[] filesToPrintArr = new File[filesToPrint.size()];
        for (int i = 0; i < filesToPrintArr.length; i++) {
            filesToPrintArr[i] = filesToPrint.get(i);
        }

        try {
            Arrays.sort(filesToPrintArr);
            System.out.println("SORTED");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("NOT SORTED");
        }
        for (File file : filesToPrintArr) {
            if (file.isFile()) {
                try {
                    desktop.print(file);
                    System.out.println(file.getName() + " is printed");
                    counter++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return counter;
    }
}