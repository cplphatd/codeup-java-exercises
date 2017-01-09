import java.util.Scanner;

/**
 * Created by David on 1/8/17.
 */
public class DiceRollingApp {
    public static void main(String[] args) {
        //Variables
        boolean repeat = false;
        String userAnswer;
        int sides;

        //Initialize scanner
        Scanner sc = new Scanner(System.in);

        do {
            //Will not continue until user enters side value that is >1
            do {
                System.out.print("Enter the number of sides on the dice (>1): ");
                sides = sc.nextInt();
            } while (sides <= 1);

            Dice dieOne = new Dice(sides);
            Dice dieTwo = new Dice(sides);

            System.out.println("You rolled " + dieOne.rollDice(sides) + " and " + dieTwo.rollDice(sides) + "!");

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
