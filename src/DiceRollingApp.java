import java.util.Scanner;

/**
 * Created by David on 1/8/17.
 */
public class DiceRollingApp {
    public static void main(String[] args) {
        //Variables
        boolean repeat = false;
        String userAnswer;
        int numberOfSides;

        //Initialize scanner
        Scanner sc = new Scanner(System.in);

        do {
            //Will not continue until user enters side value that is >1
            do {
                System.out.print("Enter the number of sides on the dice (>1): ");
                numberOfSides = sc.nextInt();
            } while (numberOfSides <= 1);

            Dice dieOne = new Dice(numberOfSides);
            Dice dieTwo = new Dice(numberOfSides);

            System.out.println("You rolled " + dieOne.rollDice() + " and " + dieTwo.rollDice() + "!");

            do {
                System.out.print("Would you like to roll the dice again? (y/n) ");
                userAnswer = sc.next();

                if(userAnswer.equalsIgnoreCase("y") || userAnswer.equalsIgnoreCase("yes")) {
                    repeat = true;
                } else {
                    repeat = false;
                }
            } while(!userAnswer.equalsIgnoreCase("y") && !userAnswer.equalsIgnoreCase("n") && !userAnswer.equalsIgnoreCase("yes") && !userAnswer.equalsIgnoreCase("no"));
        } while (repeat);
    }
}
