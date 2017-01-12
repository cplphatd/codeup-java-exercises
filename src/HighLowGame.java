import java.util.Scanner;

/**
 * Created by David on 1/10/17.
 */
public class HighLowGame {
    public static void main(String[] args) {

        //Variables
        int min = 1;
        int max = 100;
        int userGuess;
        int maxGuess;
        boolean result;
        String userAnswer;
        boolean repeat;

        //Initialize scanner
        Scanner sc = new Scanner(System.in);

        //Initialize validator
        Validator validator = new Validator(sc);

        //Creates new instance of highLow if user wants to play again
        do {
            //Initialize game
            HighLow highLow = new HighLow(min, max);
            maxGuess = 5;

            System.out.println("Hello! Welcome to the High Low Game!");
            System.out.println("---");

            //Get user guess and compare until correct number is guessed
            do {
                System.out.println("Guesses left: " + maxGuess);
                userGuess = validator.getIntWithinRange("Guess a number between 1 and 100: ", min, max);
                result = highLow.compareGuessToAnswer(userGuess);
                maxGuess -= 1;
            } while (!result && maxGuess > 0);

            //Tell user the number of guesses they took
            if (result) {
                System.out.println("Number of guesses: " + highLow.getNumberOfGuesses());
            } else {
                System.out.println("You ran out of guesses.");
                System.out.println("The correct number was: " + highLow.getCurrentNumber());
            }

            //Ask user if they want to play again
            System.out.println("---");
            userAnswer = validator.getChoiceString("Would you like to play again? (y/n): ", "y", "n");
            if (userAnswer.equalsIgnoreCase("y")) {
                repeat = true;
            } else {
                repeat = false;
            }
        } while (repeat);
    }
}
