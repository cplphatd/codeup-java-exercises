package Alviola;

import java.util.Scanner;

/**
 * Created by David on 1/13/17.
 */
public class ConsoleTestApp {
    public static void main(String[] args) {
        //Variables
        int userInt;
        double userDouble;
        String userString;
        String userAnswer;

        //Initialize scanner
        Scanner scanner = new Scanner(System.in);

        //Initialize console
        Console console = new Console();

        do {
            userInt = console.getInt("Please enter your favorite number: ");
            console.println(userInt + " is a valid number.");
            console.println("---");

            userInt = console.getIntWithinRange("Please enter a number between 1 and 10: ", 1, 10);
            console.println(userInt + " is a valid number.");
            console.println("---");

            userDouble = console.getDouble("Please enter a number with a decimal: ");
            console.println(userDouble + " is a valid number");
            console.println("---");

            userDouble = console.getDoubleWithinRange("Please enter a number with a decimal between 0.1 and 9.99: ", 0.1, 9.99);
            console.println(userDouble + " is a valid number.");
            console.println("---");

            userString = console.getRequiredString("Please enter your favorite quote: ");
            console.println("\"" + userString + "\" - You");
            console.println("---");

            userAnswer = console.getChoiceString("Would you like to validate again? (y/n): ", "y", "n");
        } while (userAnswer.equals("y"));
    }
}
