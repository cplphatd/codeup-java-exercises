import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by David on 1/9/17.
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        //Variables
        String studentFirstName;
        String studentLastName;
        int studentAge;
        boolean repeat;

        //Initialize scanner
        Scanner sc = new Scanner(System.in);

        do {
            studentFirstName = getStudentFirstName(sc);

            studentLastName = getStudentLastName(sc);

            studentAge = getStudentAge(sc);

            Student studentInfo = new Student(studentFirstName, studentLastName, studentAge);

//            showLastEntry(studentInfo.getStudentFirstName(), studentInfo.getStudentLastName());

            repeat = enterAnotherStudent(sc);
        } while (repeat);
    }

    public static String getStudentFirstName (Scanner sc) {
        String studentFirstName;

        System.out.print("Enter the student's first name: ");

        try {
            studentFirstName = sc.nextLine();

            //Checks if first name contains numbers
            if (studentFirstName.contains("0") || studentFirstName.contains("1") || studentFirstName.contains("2")
                    || studentFirstName.contains("3") || studentFirstName.contains("4") || studentFirstName.contains("5")
                    || studentFirstName.contains("6") || studentFirstName.contains("7") || studentFirstName.contains("8")
                    || studentFirstName.contains("8") || studentFirstName.contains("9")) {
                throw new IllegalArgumentException("ERROR - Enter a name with valid characters!");
            }
        } catch (NoSuchElementException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            studentFirstName = getStudentFirstName(sc);
        }

        return studentFirstName;
    }

    public static String getStudentLastName (Scanner sc) {
        String studentLastName;

        System.out.print("Enter the student's last name: ");

        try {
            studentLastName = sc.nextLine();

            if (studentLastName.contains("0") || studentLastName.contains("1") || studentLastName.contains("2")
                    || studentLastName.contains("3") || studentLastName.contains("4") || studentLastName.contains("5")
                    || studentLastName.contains("6") || studentLastName.contains("7") || studentLastName.contains("8")
                    || studentLastName.contains("8") || studentLastName.contains("9")) {
                throw new IllegalArgumentException("ERROR - Enter a name with valid characters!");
            }
        } catch (NoSuchElementException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            studentLastName = getStudentLastName(sc);
        }
        return studentLastName;
    }

    public static int getStudentAge (Scanner sc) {
        int studentAge;

        System.out.print("Enter the student's age: ");

        try {
            studentAge = sc.nextInt();

            //Prevents entering a negative age
            if(studentAge < 0) {
                throw new IllegalArgumentException("ERROR - Enter an age above 0!");
            }
        } catch (InputMismatchException | IllegalArgumentException e) {
            //Prevents skipping next input after nextInt causing infinite loop
            sc.nextLine();

            System.out.println(e.getMessage());
            studentAge = getStudentAge(sc);
        }
        return studentAge;
    }

    public static void showLastEntry (String studentFirstName, String studentLastName, int studentAge) {
        System.out.println("---");
        System.out.println("Student Name: " + studentFirstName + " " + studentLastName);
        System.out.println("Age: " + studentAge);
        System.out.println("---");
    }

    public static boolean enterAnotherStudent (Scanner sc) {
        String userAnswer;

        do {
            System.out.print("Enter another student? (y/n): ");
            userAnswer = sc.next();

            //Prevents skipping next input when entering another student
            sc.nextLine();

            if (userAnswer.equalsIgnoreCase("y") || userAnswer.equalsIgnoreCase("yes")) {
                return true;
            } else {
                return false;
            }
        } while (!userAnswer.equalsIgnoreCase("y") && !userAnswer.equalsIgnoreCase("yes") && !userAnswer.equalsIgnoreCase("n") && !userAnswer.equals("no"));
    }
}
