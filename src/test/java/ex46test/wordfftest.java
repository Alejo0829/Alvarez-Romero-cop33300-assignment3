/*
 * UCF COP3330 Fall 2021 Assignment 3 Solutions
 * Copyright 2021 Rafael Alvarez-Romero
 */

package ex46test;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class wordfftest {

    @Test
    void testsetTxtContents() {

        String string = "";
        try {
            string = Files.readString(Path.of("/Users/rafal/IdeaProjects/Alvarez-Romero-cop3330-assignment3/src/test/java/ex46test/testing46.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        string = string.replace("\n", " ");

        assertEquals("Hello world", string);
    }

    @Test
    public void testgetAndSplit() {
        String txt = "Hello world";
        System.out.println(Arrays.toString(txt.split(" ")));
    }

    @Test
    public void testgetSingleWords() {
        String[] expected = {"hi"};
        String[] array = {"hi", "hi", "hi"};
        LinkedHashSet<String> temp = new LinkedHashSet<>(Arrays.asList(array));
        String[] actual = temp.toArray(new String[]{});
        assertArrayEquals(expected, actual);
    }


}