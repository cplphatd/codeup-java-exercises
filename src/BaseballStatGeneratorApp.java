import java.util.Scanner;

/**
 * Created by David on 1/11/17.
 */
public class BaseballStatGeneratorApp {
    public static void main(String[] args) {
        //Variables
        int numberOfPlayers;
        int numberOfStats = 2;
        int numberAtBats;
        boolean repeat;
        String userAnswer;

        //Initialize scanner
        Scanner scanner = new Scanner(System.in);

        //Initialize validator
        Validator validator = new Validator(scanner);

        System.out.println("Welcome to the Baseball Stat Generator!");
        System.out.println("---");

        do {
            numberOfPlayers = validator.getInt("How many players will you be entering? ");

            //Initialize stat generator
            BaseballStatGenerator statGenerator = new BaseballStatGenerator(numberOfPlayers, numberOfStats);

            //Iterate through each player
            for (int i = 0; i <= numberOfPlayers - 1; i += 1) {

                //Create an atBat array for the player
                numberAtBats = validator.getInt("Enter the number of at bats for Batter " + (i + 1) + ": ");
                int[] atBatArray = generateAtBatArray(numberAtBats);

                //Enter the number of bases earned for each at bat and store in array
                for (int j = 0; j <= atBatArray.length - 1; j += 1) {
                    int basesEarned = validator.getIntWithinRange("Enter the number of bases earned for at bat " + (j+1) + " (0-4): ", 0, 4);
                    storeAtBatResults(basesEarned, j, atBatArray);
                }

                //Calculate the batting and slugging percentage for the player and store in multidimensional array
                double battingAverage = statGenerator.calculateBattingAverage(atBatArray);
                statGenerator.storeStat(battingAverage, i, 0);
                double sluggingAverage = statGenerator.calculateSluggingAverage(atBatArray);
                statGenerator.storeStat(sluggingAverage, i, 1);
            }

            //Generate table
            System.out.println("---");
            statGenerator.printStatDisplayArray("Player #", "Bat%", "Slug%");

            //Ask user if they want to continue
            System.out.println("---");
            userAnswer = validator.getChoiceString("Would you like to generate another display? (y/n): ", "y", "n");
            if (userAnswer.equalsIgnoreCase("y")) {
                repeat = true;
            } else {
                repeat = false;
            }
        } while (repeat);
    }

    private static int[] generateAtBatArray (int numberAtBats) {
        int[] atBatArray = new int[numberAtBats];
        return atBatArray;
    }

    private static void storeAtBatResults (int basesEarned, int atBatIndex, int[] atBatArray) {
        atBatArray[atBatIndex] = basesEarned;
    }
}
