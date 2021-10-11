/*
 * UCF COP3330 Fall 2021 Assignment 3 Solutions
 * Copyright 2021 Rafael Alvarez-Romero
 */
package ex44test;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;


class producttest {

    String path = "/Users/rafal/IdeaProjects/Alvarez-Romero-cop3330-assignment3/input/exercise44_input.json";
    Gson gson = new Gson();


    @Test
    public void makeGsonJavaObject() {

        Object object = null;

        try {
            object = gson.fromJson(new FileReader(path), Object.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(object);


    }

    @Test
    void testingGson() {

        try {
            Gson gson = new Gson();

            Reader reader = Files.newBufferedReader(Paths.get(path));

            Map<Object, ArrayList<Map<String, String>>> jsonObj = gson.fromJson(reader, Map.class);

            reader.close();

            System.out.println(jsonObj);

            System.out.println();

            ArrayList<Map<String, String>> mapArray = jsonObj.get("products");

            System.out.println(mapArray);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }


}