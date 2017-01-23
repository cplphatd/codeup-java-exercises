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
        System.out.println("---");

        do {
            int userChoice = getUserChoice();
            decodeUserChoice(userChoice);
        } while (repeat);
    }

    private static int getUserChoice () {
        System.out.println("(1) Display countries");
        System.out.println("(2) Add a new country");
        System.out.println("(3) Exit");
        return validator.getIntWithinRange("Enter your choice (1-3): ", 1, 3);
    }

    private static void decodeUserChoice (int userChoice) throws IOException {
        switch (userChoice) {
            case 1:
                countriesTextFile.displayFile();
                break;
            case 2:
                countriesTextFile.addToFile(validator.getRequiredString("Enter the country name: "));
                break;
            case 3:
                repeat = false;
                System.out.println("Goodbye! Thanks for using this app!");
                break;
        }
    }
}
