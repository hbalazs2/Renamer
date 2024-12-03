package com.example.renamer;

import java.io.File;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Rename {

    private String path;
    private String extension;

    public Rename() {
    }

    public Rename(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public String getExtension() {
        return extension;
    }

    public List<File> renameFiles() {

        File myFolder = new File(getPath());
        List<File> filesToRename = Arrays.asList(myFolder.listFiles());
        String oldDelimiter = "\\.";

        for (File file : filesToRename) {
            String localExtension = file.getName().substring(file.getName().length() - 4);

            if (file.isFile() && !file.getName().equals("extract")) {
                String longFileName = file.getName();
                String[] fileNameParts = longFileName.split(oldDelimiter);
                BigInteger num = new BigInteger(fileNameParts[0].toUpperCase(), 16);
                String newFileName = num + localExtension;
//                File f = new File(myFolder + "/" + newFileName);
//                System.out.println(myFolder + "/" + f.getName());
                file.renameTo(new File(myFolder + "/" + newFileName));
            }
        }
        return filesToRename;
    }
}