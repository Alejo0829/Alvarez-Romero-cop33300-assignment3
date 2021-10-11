/*
 * UCF COP3330 Fall 2021 Assignment 3 Solutions
 * Copyright 2021 Rafael Alvarez-Romero
 */
package ex43;

/*
Goals:
Have a List of Strings (ArrayList<String>)
Have a default output folder path (in this case, ex43/website/)
Create a single scanner method that takes in any input as a String (it's the user's fault for being stupid)
and places it in the List.
-Extra goal (not required): Ask to verify the input by doing another input scan and compare it to the previous one
have a method for each:
generating a folder based on the site name
generating folders within .website/websitename/ folder (if "Y" is input for JavaScript/CSS)
generate an index.html file in the .website/websitename/ folder with site name in <title> and author name in <meta>
for generator methods: output each time a folder is created
Questions:
Site name:
Author:
Do you want a JavaScript folder?
Do you want a CSS folder?
output each creation
 */


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class website {

    String systemDir = System.getProperty("user.dir");
    private final String outputPathString = systemDir + "/output/website/";

    private final Scanner sc = new Scanner(System.in);

    private final List<String> inputs = new ArrayList<>();


    private void getInputs(String[] questions) {
        for (String question : questions) {
            System.out.print(question);
            inputs.add(sc.nextLine());
        }
    }


    private void generateFolder(String userInput, String folderName) {

        if (userInput.equals("Y")) {
            Path newFolder = Paths.get(outputPathString + folderName);
            try {
                Files.createDirectory(newFolder);
                System.out.println("Created " + newFolder);
            } catch (IOException ignored) {}
        }

    }

    private void generateIndex(String websiteName, String authorName) {

        Path indexFile = Paths.get(outputPathString + "index.html");
        try {
            Files.createFile(indexFile);
        } catch (IOException ignored) {}

        try {
            FileWriter fWriter = new FileWriter(indexFile.toString());
            BufferedWriter writer = new BufferedWriter(fWriter);
            writer.write("<title>" + websiteName + "</title>");
            writer.newLine();
            writer.write("<meta>" + authorName + "</meta>");
            writer.close();
        } catch (IOException ignored) {}

    }

    public website() {

        String[] questions = {
                "Site name: ",
                "Author: ",
                "Do you want a JavaScript folder? (Y/N) ",
                "Do you want a CSS folder? (Y/N) "
        };
        getInputs(questions);
        generateFolder("Y", ""); // creates website folder if you don't already have one
        generateFolder("Y", inputs.get(0));
        generateIndex(inputs.get(0), inputs.get(1));
        generateFolder(inputs.get(2), "js");
        generateFolder(inputs.get(3), "css");

    }


}