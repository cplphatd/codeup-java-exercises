import java.util.Random;

/**
 * Created by David on 1/10/17.
 */
public class HighLow {
    //Variables
    private int numberOfGuesses = 0;
    private int currentNumber;

    //Initialize randomizer
    Random rand = new Random();

    public HighLow (int min, int max) {
        this.currentNumber = generateRandomNumber(min, max);
    }

    private int generateRandomNumber (int min, int max) {
        return rand.nextInt(max) + min;
    }

    public boolean compareGuessToAnswer (int userGuess) {
        numberOfGuesses += 1;

        if (userGuess == currentNumber) {
            System.out.println("---");
            System.out.println("You guessed: " + userGuess + ". GOOD guess!");
            System.out.println("---");
            return true;
        } else if (userGuess < currentNumber) {
            System.out.println("---");
            System.out.println("You guessed: " + userGuess + ". Guess HIGHER!");
            System.out.println("---");
            return false;
        } else {
            System.out.println("---");
            System.out.println("You guessed: " + userGuess + ". Guess LOWER!");
            System.out.println("---");
            return false;
        }
    }

    public int getNumberOfGuesses() {
        return numberOfGuesses;
    }

    public int getCurrentNumber() {
        return currentNumber;
    }
}
