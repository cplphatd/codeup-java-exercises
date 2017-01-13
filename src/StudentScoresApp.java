import Alviola.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by David on 1/13/17.
 */
public class StudentScoresApp {
    public static void main(String[] args) {
        //Variables
        String studentFirstName;
        String studentLastName;
        int studentScore;
        String userAnswer;

        //Initialize scanner
        Scanner scanner = new Scanner(System.in);

        //Initialize list
        List studentsList = new ArrayList();

        //Initialize student class;
        Student student;

        //Initialize console class;
        Console console = new Console(scanner);

        //Allows user to enter another student if they choose "y"
        do {
            studentFirstName = console.getRequiredString("Enter the student's first name: ");
            studentLastName = console.getRequiredString("Enter the student's last name: ");
            studentScore = console.getInt("Enter the student's score: ");

            studentsList.add(student = new Student(studentFirstName, studentLastName, studentScore));

            userAnswer = console.getChoiceString("Would you like to enter another student? (y/n) ", "y", "n");
        } while (userAnswer.equalsIgnoreCase("y"));

        Collections.sort(studentsList);
        System.out.println(studentsList);
    }
}
