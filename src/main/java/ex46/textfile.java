/*
 * UCF COP3330 Fall 2021 Assignment 3 Solutions
 * Copyright 2021 Rafael Alvarez-Romero
 */
package ex46;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class textfile {

    private final String systemDir = System.getProperty("user.dir");
    private final Path txtPath = Paths.get(systemDir + "/input/exercise46_input.txt");

    String txtContents;


    public textfile() {
        setTxtContents();
    }

    public String getTxtContents() {
        return txtContents;
    }

    private Path getTxtPath() {
        return txtPath;
    }

    private void setTxtContents() {

        String string = "";
        try {
            string = Files.readString(getTxtPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        string = string.replace("\n", " ");
        txtContents = string;
    }


}