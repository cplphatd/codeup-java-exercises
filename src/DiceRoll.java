import java.util.Random;
import java.util.Scanner;

/**
 * Created by David on 1/5/17.
 */
public class DiceRoll {
    public static void main(String[] args) {
        //Variables
        int sides;
        int dieOne;
        int dieTwo;
        boolean repeat = false;
        String userAnswer;

        //Initialize scanner
        Scanner sc = new Scanner(System.in);

        //Initialize random number generator
        Random rand = new Random();

        //Repeats if user chooses to
        do {
            //Will not continue until user enters side value that is >1
            do {
                System.out.print("Enter the number of sides on the dice (>1): ");
                sides = getSides(sc);
            } while (sides <= 1);


            //Will not continue until user types "roll"
            do {
                System.out.print("Type \"roll\" to roll the dice: ");
                userAnswer = sc.next();
            } while (!userAnswer.equalsIgnoreCase("roll"));

            //Roll the dice
            dieOne = generateRandomNumber(rand, sides);
            dieTwo = generateRandomNumber(rand, sides);

            System.out.println("You rolled " + dieOne + " and " + dieTwo);

            //Continues until user enters appropriate response
            do {
                System.out.println("Roll again? (y/n): ");
                userAnswer = sc.next();
                if (userAnswer.equalsIgnoreCase("y") || userAnswer.equalsIgnoreCase("yes")) {
                    repeat = true;
                } else {
                    repeat = false;
                }
            } while (!userAnswer.equalsIgnoreCase("y") && !userAnswer.equalsIgnoreCase("yes") && !userAnswer.equalsIgnoreCase("n") && !userAnswer.equalsIgnoreCase("no"));
        } while (repeat);
    }

    public static int getSides (Scanner anyScanner) {

        return anyScanner.nextInt();
    }

    public static int generateRandomNumber (Random anyRandom, int maxNumber) {
        //.nextInt is inclusive of zero, so the upper bound must have 1 subtracted, then the random number must have 1 added
        return anyRandom.nextInt(maxNumber - 1) + 1;
    }
}
