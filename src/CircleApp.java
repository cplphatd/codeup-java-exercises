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

        do {
            do {
                System.out.print("Enter the radius (in): ");
                userRadius = sc.nextDouble();

                if (userRadius <= 0) {
                    System.out.println("Enter a radius > 0.");
                }
            } while (userRadius <= 0);

            Circle userCircle = new Circle (userRadius);

            System.out.println("For a circle of radius " + userRadius + "in: ");
            System.out.println("---");

            userCircle.getCircumference();
            System.out.println("Circumference: " + userCircle.getFormattedCircumference() + "in");

            userCircle.getArea();
            System.out.println("Area: " + userCircle.getFormattedArea() + "in");

            do {
                System.out.print("Would you like to calculate another circle? (y/n): ");
                userAnswer = sc.next();

                if (userAnswer.equalsIgnoreCase("y") || userAnswer.equalsIgnoreCase("yes")) {
                    repeat = true;
                } else if (userAnswer.equalsIgnoreCase("n") || userAnswer.equalsIgnoreCase("no")){
                    repeat = false;
                    System.out.println("Thanks for using the Circle App! Circles calculated: " + userCircle.getObjectCount());
                } else {
                    repeat = false;
                }
            } while (!userAnswer.equalsIgnoreCase("y") && !userAnswer.equalsIgnoreCase("yes") && !userAnswer.equalsIgnoreCase("n") && !userAnswer.equalsIgnoreCase("no"));
        } while (repeat);
    }
}
