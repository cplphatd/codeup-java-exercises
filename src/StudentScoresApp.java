import Alviola.Console;

import java.util.*;

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

        //Initialize list
        List<Student> studentsList = new ArrayList<Student>();

        //Initialize student class;
        Student student;

        //Initialize console class;
        Console console = new Console();

        //Allows user to enter another student if they choose "y"
        do {
            studentFirstName = console.getRequiredString("Enter the student's first name: ");
            studentLastName = console.getRequiredString("Enter the student's last name: ");
            studentScore = console.getIntWithinRange("Enter the student's score: ", 0, 100);

            student = new Student(studentFirstName, studentLastName, studentScore);
            studentsList.add(student);

            userAnswer = console.getChoiceString("Would you like to enter another student? (y/n) ", "y", "n");
        } while (userAnswer.equalsIgnoreCase("y"));

        //Sorts list by last name and then first name
        Collections.sort(studentsList);

        //Prints list
        for (Object eachStudent : studentsList) {
            System.out.println(eachStudent);
        }

//        Code to print with an iterator:
//        Iterator<Student> studentIterator = studentsList.iterator();
//
//        while(studentIterator.hasNext()) {
//            System.out.println(studentIterator.next());
//        }
    }
}
