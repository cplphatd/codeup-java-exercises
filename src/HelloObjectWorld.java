import java.util.Scanner;

/**
 * Created by David on 1/8/17.
 */
public class HelloObjectWorld {
    public static void main(String[] args) {
        //Variables
        String firstName;
        String lastName;
        String email;
        String userAnswer;
        boolean repeat = false;

        //Initialize scanner
        Scanner sc = new Scanner(System.in);

        do {
            System.out.print("Enter the user's first name: ");
            firstName = sc.nextLine();

            System.out.print("Enter the user's last name: ");
            lastName = sc.nextLine();

            System.out.print("Enter the user's email: ");
            email = sc.nextLine();

            Person user = new Person(firstName, lastName, email);

            System.out.println("Hello, " + firstName + " " + lastName + "! We have your email as: " + email);

            do {
                System.out.print("Would you like to enter another user? (y/n) ");
                userAnswer = sc.nextLine();

                if (userAnswer.equalsIgnoreCase("y") || userAnswer.equalsIgnoreCase("yes")) {
                    repeat = true;
                } else {
                    repeat = false;
                }
            } while(!userAnswer.equalsIgnoreCase("y") && !userAnswer.equalsIgnoreCase("n") && !userAnswer.equalsIgnoreCase("yes") && !userAnswer.equalsIgnoreCase("no"));
        } while (repeat);
    }
}
