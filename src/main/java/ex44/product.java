/*
 * UCF COP3330 Fall 2021 Assignment 3 Solutions
 * Copyright 2021 Rafael Alvarez-Romero
 */

/*
goals:
create a class that loads in the JSON parser
figure out how to use the JSON parser
have a Scanner ask for user input
compare it to the JSON file values somehow
either output the JSON values if there's a match, or print out error and repeat the Scanner question
 */

package ex44;

import com.google.gson.Gson;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class product {

    private final String systemDir = System.getProperty("user.dir");
    private final String inputPath = systemDir + "/input/exercise44_input.json";
    private final Path input = Paths.get(inputPath);
    private final Scanner sc = new Scanner(System.in);


    public product() {
        getUserInput(parsingGson());

    }

    // turns the json file into an arraylist of maps
    private ArrayList<Map<String, String>> parsingGson() {

        Map<Object, ArrayList<Map<String, String>>> jsonObj = null;

        try {
            // create Gson instance
            Gson gson = new Gson();

            // create a reader
            Reader reader = Files.newBufferedReader(input);

            // convert JSON file to map
            jsonObj = gson.fromJson(reader, Map.class);

            reader.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        ArrayList<Map<String, String>> products = null;
        if (jsonObj != null) {
            products = jsonObj.get("products");
        }
        return products;

    }

    private void getUserInput(ArrayList<Map<String, String>> mapArray) {

        // repeat until user input is valid
        do {
            String userInput = sc.nextLine();
            // loops through each map
            for (Map<String, String> map : mapArray) {
                // this is horrible but I'm too tired to fix it
                if (map.containsValue(userInput)) {
                    // goes to a hardcoded printout (it's bad)
                    printOut(map);
                    return;
                }
            }
            System.out.print("That product does not exist in our inventory. " +
                    "\nEnter a product name: ");

        } while (true);

    }

    private void printOut(Map<String, String> map) {
        System.out.printf("%s: %s\n", "Name", map.get("name"));
        System.out.printf("%s: %-2s\n", "Price", map.get("price"));
        System.out.printf("%s: %-1s\n", "Quantity", map.get("quantity"));
    }

}
