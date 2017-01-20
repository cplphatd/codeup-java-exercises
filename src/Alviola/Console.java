package Alviola;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * A <code>Console</code> streamlines use of <code>PrintStream</code>
 * and <code>System</code> methods by combining the two and performs
 * validation on various forms of user input.
 *
 * @author David Ryan Alviola
 * @since 13 January 2017
 */
public class Console {
    /**
     * <p>A scanner is declared within the <code>Console</code> class to remove the need of
     * passing in a scanner from the main application.</p>
     */
    private Scanner scanner = new Scanner(System.in);

    /**
     * <p>Prints a passed in string.
     * The next input/output occurs on the same line.</p>
     *
     * @param s the string that is to be displayed
     */
    public void print (String s) {
        System.out.print(s);
    }

    /**
     * <p>Prints a passed in string on an entire line.
     * The next input/output occurs on the next line.</p>
     *
     * @param s the string that is to be displayed
     */
    public void println (String s) {
        System.out.println(s);
    }

    /**
     * <p>Prints an empty line.</p>
     */
    public void println () {
        System.out.println();
    }

    /**
     * <p>Prints the passed in prompt and takes in a string from the user.</p>
     *
     * @param prompt a string describing what input is needed from the user
     * @throws IllegalArgumentException if the user input is an empty string
     * @throws NoSuchElementException if no line is found
     * @return the string inputted by the user
     */
    public String getRequiredString (String prompt) {
        String userString;

        print(prompt);

        try {
            userString = scanner.nextLine();

            if (userString.isEmpty()) {
                throw new IllegalArgumentException("ERROR - No response!");
            }
        } catch (NoSuchElementException | IllegalArgumentException e) {
            println(e.getMessage());
            userString = getRequiredString(prompt);
        }

        return userString;
    }

    /**
     * <p>Prints the passed in prompt and accepts one of two choices from the user. Entry of
     * any other string value other than the two choices results in an exception and
     * a recursive call of the method.</p>
     *
     * @param prompt a string that describes the required input from the user
     * @param choiceOne a string that describes the first choice
     * @param choiceTwo a string that describes the second choice
     * @return a string value of the choice selected by the user
     */
    public String getChoiceString (String prompt, String choiceOne, String choiceTwo) {
        String userString;

        print(prompt);

        try {
            userString = scanner.nextLine();

            if (!userString.equalsIgnoreCase(choiceOne) && !userString.equalsIgnoreCase(choiceTwo)) {
                throw new IllegalArgumentException("ERROR - Enter a valid choice!");
            }
        } catch (NoSuchElementException | IllegalArgumentException e) {
            println(e.getMessage());
            userString = getChoiceString(prompt, choiceOne, choiceTwo);
        }

        return userString;
    }

    /**
     * <p>Prints the passed in prompt then accepts a string input from the user. If the string input
     * can be converted to an integer, the integer value is returned.</p>
     *
     * @param prompt a string describing the required input from the user
     * @throws NumberFormatException if the user input cannot be converted to an integer
     * @return the integer value of the user input
     */
    public int getInt (String prompt) {
        int userInt;

        print(prompt);

        try {
            //Accepts string and then parses to int (avoids problems from switching from nextInt to nextLine)
            userInt = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            println("ERROR - Enter an integer!");
            userInt = getInt(prompt);
        }

        return userInt;
    }

    /**
     * <p>Prints a passed in prompt then accepts string input from the user. The value of the
     * input is verified to be between the passed in minimum and maximum values and the integer value
     * is returned if the check is passed.</p>
     *
     * @param prompt a string describing the required input from the user
     * @param min an integer value that is the minimum allowed and is included in the range
     * @param max an integer value that is the maximum allowed and is included in the range
     * @throws IllegalArgumentException if the value is outside of the passed in range
     * @return the integer value of the user input
     */
    public int getIntWithinRange (String prompt, int min, int max) {
        int userInt;

        try {
            userInt = getInt(prompt);   //Call getInt to handle integer check

            if (userInt < min || userInt > max) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            println("ERROR - Value outside of bounds!");
            userInt = getIntWithinRange(prompt, min, max);
        }

        return userInt;
    }

    /**
     * <p>Prints the passed in prompt then accepts a string input from the user. If the string input
     * can be converted to a double, the double value is returned.</p>
     *
     * @param prompt a string describing the required input from the user
     * @throws NumberFormatException if the user input cannot be converted to a double
     * @return the double value of the user input
     */
    public double getDouble (String prompt) {
        double userDouble;

        print(prompt);

        try {
            //Accepts string and then parses to double (avoids problems from switching from nextDouble to nextLine)
            userDouble = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            println("ERROR - Enter a valid number");
            userDouble = getDouble(prompt);
        }

        return userDouble;
    }

    /**
     * <p>Prints a passed in prompt then accepts string input from the user. The value of the
     * input is verified to be between the passed in minimum and maximum values and the double value
     * is returned if the check is passed.</p>
     *
     * @param prompt a string describing the required input from the user
     * @param min a double value that is the minimum allowed and is included in the range
     * @param max a double value that is the maximum allowed and is included in the range
     * @throws IllegalArgumentException if the value is outside of the passed in range
     * @return the double value of the user input
     */
    public double getDoubleWithinRange (String prompt, double min, double max) {
        double userDouble;

        try {
            userDouble = getDouble(prompt); //Call getDouble to handle double check

            if (userDouble < min || userDouble > max) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            println("ERROR - Value outside of bounds!");
            userDouble = getDoubleWithinRange(prompt, min, max);
        }

        return userDouble;
    }
 }
