/*
 * UCF COP3330 Fall 2021 Assignment 3 Solutions
 * Copyright 2021 Rafael Alvarez-Romero
 */
package ex43test;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class websitetest {

    private final Scanner sc = new Scanner(System.in);
    private final String outputPathString =
            "/Users/rafal/IdeaProjects/Alvarez-Romero-cop3330-assignment3/input/website/";
    private List<String> inputs = new ArrayList<>();

    private final String[] questions = {
            "Site name: ",
            "Author: ",
            "Do you want a JavaScript folder? ",
            "Do you want a CSS folder? "
    };

    @Test
    public void getInputs() {

        for (String question : questions) {
            System.out.print(question);
            System.out.print("YES\n");
            inputs.add("YES");
        }
        System.out.println(inputs);
    }

    @Test
    public void generateFolder()  {

        String folderName = "website";

        Path folder = Paths.get(outputPathString + folderName);

        try {
            Files.createDirectory(folder);
        } catch (IOException ignored) {

        }

    }

    @Test
    public void generateIndex() throws IOException{

        Path indexfile = Paths.get(outputPathString + "index.html");
        Files.createFile(indexfile);

        FileWriter fWriter;
        BufferedWriter writer;
        try {
            fWriter = new FileWriter(indexfile.toString());
            writer = new BufferedWriter(fWriter);
            writer.write("<title>" + "websiteName" + "</title>");
            writer.newLine();
            writer.close();
        } catch (Exception e) {

        }

    }

}