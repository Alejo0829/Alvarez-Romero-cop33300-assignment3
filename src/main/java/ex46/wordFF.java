/*
 * UCF COP3330 Fall 2021 Assignment 3 Solutions
 * Copyright 2021 Rafael Alvarez-Romero
 */
package ex46;

import java.util.Collections;
import java.util.TreeMap;

public class wordFF {

    parsefile ptex46 = new parsefile();

    String[] words;
    int[] wordCount;
    TreeMap<Integer, String> wordsMap = new TreeMap<>();

    public TreeMap<Integer, String> getMap() {
        return wordsMap;
    }

    public wordFF() {
        words = ptex46.getSingleWords(ptex46.getParseText());
        wordCount = ptex46.getEachDuplicate(words);
        setMap();
    }

    private void setMap() {
        TreeMap<Integer, String> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < words.length; i++) {
            map.put(wordCount[i], words[i]);
        }
        this.wordsMap = map;
    }

}