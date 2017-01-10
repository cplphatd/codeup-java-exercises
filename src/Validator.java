import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by David on 1/10/17.
 */
public class Validator {
    //Variables

    //Declare scanner
    Scanner sc;

    public Validator (Scanner sc) {
        this.sc = sc;
    }

    public int getInt (String prompt) {
        int userInt;

        System.out.print(prompt);

        try {
            userInt = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            userInt = getInt(prompt);
        }

        return userInt;
    }

    public int getIntWithinRange (String prompt, int min, int max) {
        int userInt;

        System.out.print(prompt);

        try {
            userInt = sc.nextInt();

            if (userInt < min || userInt > max) {
                throw new IllegalArgumentException("ERROR - Value outside of bounds!");
            }
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            userInt = getIntWithinRange(prompt, min, max);
        }

        return userInt;
    }

    public double getDouble (String prompt) {
        double userDouble;

        System.out.print(prompt);

        try {
            userDouble = sc.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            userDouble = getDouble(prompt);
        }

        return userDouble;
    }

    public double getDoubleWithinRange (String prompt, double min, double max) {
        double userDouble;

        System.out.print(prompt);

        try {
            userDouble = sc.nextDouble();

            if (userDouble < min || userDouble > max) {
                throw new IllegalArgumentException("ERROR - Value outside of bounds!");
            }
        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            userDouble = getDoubleWithinRange(prompt, min, max);
        }

        return userDouble;
    }

    public String getRequiredString (String prompt) {
        String userString;

        System.out.print(prompt);

        try {
            userString = sc.next();

            if (userString.equals("/n") || userString.contains(" ")) {
                throw new IllegalArgumentException("ERROR - No response or contains spaces!")
            }
        } catch (NoSuchElementException | IllegalStateException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            userString = getRequiredString(prompt);
        }

        return userString;
    }

    public String getChoiceString (String prompt, String choiceOne, String choiceTwo) {
        String userString;

        System.out.print(prompt);

        try {
            userString = sc.next();

            if (!userString.equalsIgnoreCase(choiceOne) && !userString.equalsIgnoreCase(choiceTwo)) {
                throw new IllegalArgumentException("ERROR - Enter a valid choice!");
            }
        } catch (NoSuchElementException | IllegalStateException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            userString = getChoiceString(prompt, choiceOne, choiceTwo);
        }

        return userString;
    }
}
