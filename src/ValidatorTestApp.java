import java.util.Scanner;

/**
 * Created by David on 1/10/17.
 */
public class ValidatorTestApp {
    public static void main(String[] args) {
        //Variables
        int userInt;
        double userDouble;
        String userString;
        boolean repeat;
        String userAnswer;

        //Initialize scanner
        Scanner sc = new Scanner(System.in);

        //Intialize validator
        Validator validator = new Validator(sc);

        do {
            userInt = validator.getInt("Please enter your favorite number: ");
            System.out.println(userInt + " is a valid number.");
            System.out.println("---");

            userInt = validator.getIntWithinRange("Please enter a number between 1 and 10: ", 1, 10);
            System.out.println(userInt + " is a valid number.");
            System.out.println("---");

            userDouble = validator.getDouble("Please enter a number with a decimal: ");
            System.out.println(userDouble + " is a valid number");
            System.out.println("---");

            userDouble = validator.getDoubleWithinRange("Please enter a number with a decimal between 0.1 and 9.99: ", 0.1, 9.99);
            System.out.println(userDouble + " is a valid number.");
            System.out.println("---");

            userString = validator.getRequiredString("Please enter your favorite quote: ");
            System.out.println("\"" + userString + "\"");
            System.out.println("---");

            userAnswer = validator.getChoiceString("Would you like to validate again? (y/n): ", "y", "n");
            if (userAnswer.equalsIgnoreCase("y")) {
                repeat = true;
            } else {
                repeat = false;
            }
        } while (repeat);
    }
}
