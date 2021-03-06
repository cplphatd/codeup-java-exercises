import java.util.Scanner;

/**
 * Created by David on 1/5/17.
 */
public class MethodsExercise {
    public static void main(String[] args) {
        //Variables
        double firstUserNumber;
        double secondUserNumber;
        String userOperation;
        boolean repeat = false;
        String userAnswer;

        //Initialize scanner
        Scanner sc = new Scanner(System.in);

        //Repeats if user wants to continue
        do {
            System.out.println("--ONLY NUMBERS 1-59 ARE VALID FOR FACTORIAL--");
            System.out.print("Please enter the first number or the number you would like to factorial: ");
            firstUserNumber = sc.nextDouble();

            System.out.print("Please enter the second number (enter any number if performing factorial): ");
            secondUserNumber = sc.nextDouble();

            //Continues to ask for operation until user enters appropriate symbol
            do {
                System.out.print("Please enter the operation (+,-,*,/, %, !): ");
                userOperation = sc.next();
            }
            while (!userOperation.equals("+") && !userOperation.equals("-") && !userOperation.equals("*") && !userOperation.equals("/") && !userOperation.equals("%") && !userOperation.equals("!"));

            //Uses the operation to determine which method to call
            switch (userOperation) {
                case "+":
                    System.out.println(firstUserNumber + " " + userOperation + " " + secondUserNumber + " = " + addNumbers(firstUserNumber, secondUserNumber));
                    break;
                case "-":
                    System.out.println(firstUserNumber + " " + userOperation + " " + secondUserNumber + " = " + subtractNumbers(firstUserNumber, secondUserNumber));
                    break;
                case "*":
                    System.out.println(firstUserNumber + " " + userOperation + " " + secondUserNumber + " = " + multiplyNumbers(firstUserNumber, secondUserNumber));
                    break;
                case "/":
                    if (secondUserNumber == 0) {
                        System.out.println("Cannot divide by zero.");
                    } else {
                        System.out.println(firstUserNumber + " " + userOperation + " " + secondUserNumber + " = " + divideNumbers(firstUserNumber, secondUserNumber));
                    }
                    break;
                case "%":
                    System.out.println(firstUserNumber + " " + userOperation + " " + secondUserNumber + " = " + modulusNumbers(firstUserNumber, secondUserNumber));
                    break;
                case "!":
                    //Checks if valid value for factorial is used
                    if (firstUserNumber > 0 && firstUserNumber <= 59) {
                        System.out.println(firstUserNumber + " " + userOperation + " = " + factorialNumber(firstUserNumber, secondUserNumber));
                    } else {
                        System.out.println("Please enter a number within the factorial range.");
                    }
                    break;
                default:
                    System.out.println("Error. Try again.");
            }

            //Continues until user enters y or n
            do {
                System.out.println("Would you like to perform another calculation? (y/n)");
                userAnswer = sc.next();
                if (userAnswer.equalsIgnoreCase("y")) {
                    repeat = true;
                } else {
                    repeat = false;
                }
            } while (!userAnswer.equalsIgnoreCase("y") && !userAnswer.equalsIgnoreCase("n"));
        } while (repeat);
    }

    public static double addNumbers (double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }

    public static double subtractNumbers (double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }

    public static double multiplyNumbers (double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;
    }

    public static double divideNumbers (double firstNumber, double secondNumber) {
        return firstNumber / secondNumber;
    }

    public static double modulusNumbers (double firstNumber, double secondNumber) {
        return firstNumber % secondNumber;
    }

    public static long factorialNumber (double firstNumber, double secondNumber) {
        long factorial = 1;
        secondNumber = firstNumber;

        for (firstNumber = 1; firstNumber <= secondNumber ; firstNumber += 1) {
            factorial *= firstNumber;
        }

        return factorial;
    }
}

