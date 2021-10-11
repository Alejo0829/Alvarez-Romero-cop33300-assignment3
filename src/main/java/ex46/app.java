/*
 * UCF COP3330 Fall 2021 Assignment 3 Solutions
 * Copyright 2021 Rafael Alvarez-Romero
 */
package ex46;

import java.util.Map;

public class app {
    public static void main(String[] args) {
        wordFF wex46 = new wordFF();

        Map<Integer,String> mapOfWords = wex46.getMap();

        for (Map.Entry<Integer, String> entry : mapOfWords.entrySet()) {
            System.out.printf("%-10s: ", entry.getValue());
            for (int i = 0; i < entry.getKey(); i++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

}