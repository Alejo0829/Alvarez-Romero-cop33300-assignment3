/*
 * UCF COP3330 Fall 2021 Assignment 3 Solutions
 * Copyright 2021 Rafael Alvarez-Romero
 */
package ex41test;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


class employeestest41 {

    ex41.workerex41 ex41 = new ex41.workerex41();

    List<String> array = new ArrayList<>();

    @Test
    void readText() {
        try {
            List<String> lines = Files.readAllLines(ex41.filePath, ex41.charset);
            array.addAll(lines);
        } catch (IOException ignored) {}
        System.out.println(array);
    }

    @Test
    public void organizeEmployees() {
        array.clear();
        array.add("Z");
        array.add("A");
        array.sort(Comparator.comparing(String::toString));
        System.out.println(array);
    }


}
