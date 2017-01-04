import java.util.Scanner;

/**
 * Created by David on 1/4/17.
 */
public class ConsoleIOExercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int userInt;
        String userString;
        String userFirstName;
        String userLastName;
        String userMiddleName;
        Double roomLength;
        Double roomWidth;
        Double roomHeight;
        boolean newRoom;
        String userAnswer;

        System.out.print("Enter your favorite integer: ");
        userInt = sc.nextInt();
        System.out.println("You entered: " + userInt);

        //Captures the rest of the line after the integer to prevent skipping next input
        sc.nextLine();

        System.out.print("Enter your favorite quote: ");
        userString = sc.nextLine();
        System.out.println("Your favorite quote is: \"" + userString + "\"");

        System.out.print("Enter your first name: ");
        userFirstName = sc.next();

        System.out.print("Enter your middle name: ");
        userMiddleName = sc.next();

        System.out.print("Enter your last name: ");
        userLastName = sc.next();

        System.out.println("Your full name is: " + userFirstName + " " + userMiddleName + " " + userLastName);

        do {
            System.out.println("Enter the length of the classroom (ft): ");
            roomLength = sc.nextDouble();

            System.out.println("Enter the width of the classroom (ft): ");
            roomWidth = sc.nextDouble();

            System.out.println("Enter the height of the classroom (ft): ");
            roomHeight = sc.nextDouble();

            System.out.println("The perimeter of the classroom is: " + (2 * (roomLength + roomWidth)) + "ft");
            System.out.println("The area of the classroom is: " + (roomLength * roomWidth) + "ft^2");
            System.out.println("The volume of the classroom is: " + (roomHeight * roomLength * roomWidth) + "ft^3");

            do {
                System.out.print("Would you like to measure another room? (yes/no): ");
                userAnswer = sc.next();
                if (userAnswer.equals("yes")) {
                    newRoom = true;
                } else {
                    newRoom = false;
                }
            } while (!userAnswer.equals("yes") && !userAnswer.equals("no"));
        } while (newRoom);
    }
}
