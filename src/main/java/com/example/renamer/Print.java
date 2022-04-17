package com.example.renamer;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class Print {

    private String path;

    public Print() {
    }

    public Print(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public int printFiles(List<File> filesToPrint) {
        //String path = "test/";
        //SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        //System.out.println("this is the path: " + this.path);
        //File myFolder = new File(this.path);
        //List<File> filesToPrint = List.of(myFolder.listFiles());
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

                /* System.out.println(dateFormat.format(file.lastModified()));
                System.out.println(file.getName());
                System.out.println(file.canExecute());
                System.out.println(desktop.isSupported(Desktop.Action.PRINT)); */
            }
        }
        return counter;
    }


}
