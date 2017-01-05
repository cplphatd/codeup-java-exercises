import java.util.Scanner;

/**
 * Created by David on 1/4/17.
 */
public class ControlStatementsLoops {
    public static void main(String[] args) {

        //Variables
        byte i = 5;
        byte j = 0;
        byte k = 100;
        long l = 2;
        int m;
        long n;
        int o;
        int userInt;
        long p;
        boolean anotherNumber = false;
        String userAnswer;
        int userGrade;

        //Initialize scanner
        Scanner sc = new Scanner(System.in);

        //Create a varible i that starts at 5.
        //Create a while loop that checks i <= 15 and increment i by 1 inside the loop.
        // Before incrementing i, output each iteration and display results.

        while (i <= 15) {
            System.out.println(i);
            i += 1;
        }

        System.out.println("---");
        //Create a do-while loop that will count by 2's starting with 0 and ending at 100.
        // Follow each number with a new line.

        do {
            System.out.println(j);
            j += 2;
        } while (j <= 100);

        System.out.println();
        //Alter your loop to count backwards by 5's from 100 to -10.
        do {
            System.out.println(k);
            k -= 5;
        } while (k >= -10);

        System.out.println("---");
        //Create a do-while loop that starts at 2, and displays the number squared on each line
        // while the number is less than 1,000,000.

        do {
            System.out.println(l);
            l *= l;
        } while (l < 1000000);

        System.out.println();
        //refactor the previous two exercises to use a for loop instead

        for (m = 100; m >= -10; m -= 5) {
            System.out.println(m);
        }

        System.out.println("---");
        for (n = 2; n < 1000000; n *= n) {
            System.out.println(n);
        }

        System.out.println("---");
        //Write a program that prints the numbers from 1 to 100.
        //For multiples of three print “Fizz” instead of the number
        //For the multiples of five print “Buzz”.
        //For numbers which are multiples of both three and five print “FizzBuzz”.

        for (o = 1; o <= 100; o += 1) {
            if (o % 3 == 0 && o % 5 == 0) {
                System.out.println("FizzBuzz");
            } else if (o % 5 == 0) {
                System.out.println("Buzz");
            } else if (o % 3 == 0) {
                System.out.println("Fizz");
            }else {
                System.out.println(o);
            }
        }

        System.out.println("---");
        //Prompt the user to enter an integer.
        //Display a table of squares and cubes from 1 to the value entered.
        //Ask if the user wants to continue.
        //Assume that the user will enter valid data.
        //Only continue if the user agrees to.

        do {
            System.out.print("Enter your favorite integer: ");
            userInt = sc.nextInt();

            for (p = 1; p <= userInt; p += 1) {
                System.out.printf("%1s %12s %12s", p + ": ", p + "^2 = " + (p * p), p + "^3 = " + (p * p * p));
                System.out.println();
            }

            System.out.println("---");

            do {
                System.out.print("Would you like to enter another integer? (yes/no): ");
                userAnswer = sc.next();
                if (userAnswer.equals("yes")) {
                    anotherNumber = true;
                } else {
                    anotherNumber = false;
                }
            } while (!userAnswer.equalsIgnoreCase("yes") && !userAnswer.equalsIgnoreCase("no"));
        } while (anotherNumber);

        System.out.println("---");
        //Accept a numerical grade from 0 to 100.
        //Display the corresponding letter grade.
        // Prompt the user to continue.
        //Assume that the user will enter valid integers for the grades.
        //The application should only continue if the user agrees to.

        do {
            System.out.print("Please enter a numerical grade (0-100): ");
            userGrade = sc.nextInt();

            if (userGrade <= 1) {
                System.out.println("The letter grade is F-");
            } else if (userGrade > 1 && userGrade < 59) {
                System.out.println("The letter grade is F");
            } else if (userGrade < 60) {
                System.out.println("The letter grade is F+");
            } else if (userGrade <= 61) {
                System.out.println("The letter grade is D-");
            } else if (userGrade > 61 && userGrade < 69) {
                System.out.println("The letter grade is D");
            } else if (userGrade < 70) {
                System.out.println("The letter grade is D+");
            } else if (userGrade <= 71) {
                System.out.println("The letter grade is C-");
            } else if (userGrade > 71 && userGrade < 79) {
                System.out.println("The letter grade is C");
            } else if (userGrade < 80) {
                System.out.println("The letter grade is C+");
            } else if (userGrade <= 81) {
                System.out.println("The letter grade is B-");
            } else if (userGrade > 81 && userGrade < 89) {
                System.out.println("The letter grade is B");
            } else if (userGrade < 90) {
                System.out.println("The letter grade is B+");
            } else if (userGrade <= 91) {
                System.out.println("The letter grade is A-");
            } else if (userGrade > 91 && userGrade < 99) {
                System.out.println("The letter grade is A");
            } else if (userGrade <= 100) {
                System.out.println("The letter grade is A+");
            }

            do {
                System.out.print("Would you like to enter another grade? (yes/no): ");
                userAnswer = sc.next();
            } while (!userAnswer.equalsIgnoreCase("yes") && !userAnswer.equalsIgnoreCase("no"));
        } while (userAnswer.equalsIgnoreCase("yes"));
    }
}
