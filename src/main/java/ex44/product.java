/*
 * UCF COP3330 Fall 2021 Assignment 3 Solutions
 * Copyright 2021 Rafael Alvarez-Romero
 */

/*
create a class that loads in the JSON parser
have a Scanner ask for user input
compare it to the JSON file values
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


    private ArrayList<Map<String, String>> parsingGson() {

        Map<Object, ArrayList<Map<String, String>>> jsonObj = null;

        try {
            Gson gson = new Gson();

            Reader reader = Files.newBufferedReader(input);

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


        do {
            String userInput = sc.nextLine();

            for (Map<String, String> map : mapArray) {

                if (map.containsValue(userInput)) {

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
