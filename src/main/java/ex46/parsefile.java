/*
 * UCF COP3330 Fall 2021 Assignment 3 Solutions
 * Copyright 2021 Rafael Alvarez-Romero
 */
package ex46;

import java.util.Arrays;
import java.util.LinkedHashSet;

public class parsefile {

    textfile tfex46 = new textfile();

    private final String[] parseText;


    public parsefile() {
        this.parseText = getAndSplit();
    }

    private String[] getAndSplit() {
        String txt = tfex46.getTxtContents();
        return txt.split(" ");
    }

    public String[] getParseText() {
        return parseText;
    }

    public String[] getSingleWords(String[] array) {
        LinkedHashSet<String> temp = new LinkedHashSet<>(Arrays.asList(array));
        return temp.toArray(new String[]{});
    }

    private int countDuplicates(String string) {
        int integer = 0;
        for (String word : parseText) {
            if(word.equals(string)) integer++;
        }
        return integer;
    }

    public int[] getEachDuplicate(String[] stringArray) {
        int[] temp = new int[stringArray.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = countDuplicates(stringArray[i]);
        }
        return temp;
    }


}