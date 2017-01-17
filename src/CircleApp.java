import Alviola.Console;

import java.util.Scanner;

/**
 * Created by David on 1/9/17.
 */
public class CircleApp {
    public static void main(String[] args) {
        //Variables
        boolean repeat = false;
        String userAnswer;
        double userRadius;

        //Initialize scanner
        Scanner sc = new Scanner(System.in);

        //Initialize validator
        Console console = new Console(sc);

        System.out.println("Welcome to the Circle Info Calculator");

        do {
            do {
                System.out.println("---");
                userRadius = console.getDouble("Enter the radius (in): ");

                if (userRadius <= 0) {
                    System.out.println("Enter a radius > 0.");
                }
            } while (userRadius <= 0);

            Circle userCircle = new Circle (userRadius);

            System.out.println("---");
            System.out.println("For a circle of radius " + userRadius + " in...");
            System.out.println("---");

            userCircle.getCircumference();
            System.out.println("Circumference:  " + userCircle.getFormattedCircumference() + " in");

            userCircle.getArea();
            System.out.println("Area:  " + userCircle.getFormattedArea() + " in^2");

            System.out.println("---");
            userAnswer = console.getChoiceString("Would you like to calculate another circle? (y/n): ", "y", "n");

            if (userAnswer.equalsIgnoreCase("n")) {
                System.out.println("---");
                System.out.println("Thanks for using the Circle App! Circles calculated: " + Circle.getObjectCount());
            }
        } while (userAnswer.equalsIgnoreCase("y"));
    }
}
