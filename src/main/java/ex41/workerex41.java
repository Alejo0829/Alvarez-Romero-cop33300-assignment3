/*
 * UCF COP3330 Fall 2021 Assignment 3 Solutions
 * Copyright 2021 Rafael Alvarez-Romero
 */
package ex41;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class workerex41 {

    String systemDir = System.getProperty("user.dir");
    private final String inputPathString = systemDir + "/input/exercise41_input.txt.txt";


    public Path filePath = Paths.get(inputPathString);
    public Charset charset = StandardCharsets.UTF_8;

    public List<String> employeeList = new ArrayList<>();


    public void setEmployees(List<String> array) {

        try {
            List<String> lines = Files.readAllLines(filePath, charset);
            array.addAll(lines);
        } catch (IOException ignored) {}
    }


    public void organizeEmployees(List<String> array) {
        array.sort(Comparator.comparing(String::toString));
    }


    public void outputText(String filename) {

        System.out.println("New output: ");

        try {

            PrintWriter pr = new PrintWriter(filename);

            for (String s : employeeList) {
                pr.println(s);
                System.out.println(s);
            }
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }

    }


    public workerex41() {

        setEmployees(employeeList);
        organizeEmployees(employeeList);
        String outputPathString = systemDir + "/output/exercise41_output.txt";
        outputText(outputPathString);

    }

}