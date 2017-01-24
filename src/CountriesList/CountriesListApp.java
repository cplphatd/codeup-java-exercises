package CountriesList;

import Alviola.Console;

import java.io.IOException;

/**
 * Created by David on 1/23/17.
 */
public class CountriesListApp {
    //Variables
    private static boolean repeat = true;

    //Initialize validator
    private static Console validator = new Console();

    //Initialize CountriesTextFile
    private static CountriesTextFile countriesTextFile = new CountriesTextFile("src/CountriesList", "countries.txt");

    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to the Countries List App!");

        do {
            countriesTextFile.sortFile();
            int userChoice = getUserChoice();
            decodeUserChoice(userChoice);
        } while (repeat);
    }

    private static int getUserChoice () {
        System.out.println("---");
        System.out.println("(1) Display countries");
        System.out.println("(2) Add a new country");
        System.out.println("(3) Delete a country");
        System.out.println("(4) Exit");
        return validator.getIntWithinRange("Enter your choice (1-4): ", 1, 4);
    }

    private static void decodeUserChoice (int userChoice) throws IOException {
        switch (userChoice) {
            case 1:
                countriesTextFile.displayFile();
                break;
            case 2:
                System.out.println("---");
                countriesTextFile.addToFile(validator.getRequiredString("Enter the country name: "));
                break;
            case 3:
                System.out.println("---");
                countriesTextFile.deleteFromFile(validator.getRequiredString("Enter the country name: "));
                break;
            case 4:
                repeat = false;
                System.out.println("---");
                System.out.println("Goodbye! Thanks for using this app!");
                break;
        }
    }
}
