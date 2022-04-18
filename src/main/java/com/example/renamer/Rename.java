package com.example.renamer;

import java.io.File;
import java.util.Arrays;
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
        String oldDelimiter = "_";
        String newDelimiter = "-";

        for (File file : filesToRename) {
            String localExtension = file.getName().substring(file.getName().length() - 4);

            if (file.isFile() && file.getName().contains(oldDelimiter) && localExtension.equals(getExtension())) {
                // getting the original(long) file name
                String longFileName = file.getName();
                // splitting long file name to separated parts by underscores
                String[] fileNameParts = longFileName.split(oldDelimiter);
                // building the new filename
                String newFileName = fileNameParts[1] + newDelimiter + fileNameParts[0];
                //System.out.println(longFileName);
                //System.out.println(newFileName);
                // renaming the file
                file.renameTo(new File(getPath() + "\\" + newFileName + getExtension()));
            }
        }
        return filesToRename;
    }
}