/*
 * UCF COP3330 Fall 2021 Assignment 3 Solutions
 * Copyright 2021 Rafael Alvarez-Romero
 */
package ex45test;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

class replace {

    @Test
    public void replaceString() {
        String string = "utilizezezez";
        assertEquals("usezezez", string.replace("utilize", "use"));
    }

    @Test
    public void createString() {
        String tempString = "";
        try {
            tempString = Files.readString(Path.of("/Users/rafal/IdeaProjects/Alvarez-Romero-cop3330-assignment3/src/test/java/assignment3/ex45/input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals("Hello", tempString);
    }

    @Test
    public void saveFile() {
        Path saveFileTo = Path.of("/Users/rafal/IdeaProjects/Alvarez-Romero-cop3330-assignment3/output/output.txt");

        try {
            Files.createFile(saveFileTo);
        } catch (IOException ignored) {}

        String newString = "Hello world";

        try {
            Files.writeString(saveFileTo, newString);
        } catch (IOException ignored) {}
        assertEquals("Hello world", newString);
    }

}