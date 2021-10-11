/*
 * UCF COP3330 Fall 2021 Assignment 3 Solutions
 * Copyright 2021 Rafael Alvarez-Romero
 */

/*
put input file in same directory as program
load it into a string
use a string parse method to find all usages of the word
use another method to replace all instances of the word
print out the new string
ask the user for an output filename
output the file by creating a new text file and writing the new string
 */

package ex45;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class replace {

    private final String systemDir = System.getProperty("user.dir");
    private final Path inputPath = Paths.get(systemDir + "/input/exercise45_input.txt");


    private String createString() {
        String tempString = "";
        try {
            tempString = Files.readString(inputPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tempString;
    }

    private String replaceString(String string) {
        return string.replace("utilize", "use");
    }


    private void saveFile(String fileName, String newString) {
        Path saveFileTo = Paths.get(systemDir + "/output/" + fileName + ".txt");

        try {
            Files.createFile(saveFileTo);
        } catch (IOException ignored) {}

        try {
            Files.writeString(saveFileTo, newString);
        } catch (IOException ignored) {}
    }

    public replace() {
        Scanner sc = new Scanner(System.in);

        String oldStr = createString();
        String newStr = replaceString(oldStr);

        System.out.println(newStr);
        System.out.print("\nWhat would you like to name the file? ");

        saveFile(sc.nextLine(), newStr);
    }

}