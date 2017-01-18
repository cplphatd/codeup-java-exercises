import Alviola.Console;

import java.util.Scanner;

/**
 * Created by David on 1/18/17.
 */
public class RoshamboPlayerInput {
    //Initialize scanner
    Scanner scanner = new Scanner(System.in);

    //Initialize validator
    Console validator = new Console(scanner);

    public String getPlayerName () {
        return validator.getRequiredString("Please enter your name: ");
    }

    public Roshambo getPlayerRoshambo () {
        System.out.println("---");
        System.out.println("(1) Rock");
        System.out.println("(2) Paper");
        System.out.println("(3) Scissors");
        System.out.println("---");
        int playerSelection = validator.getIntWithinRange("Enter your move (1-3): ", 1, 3);

        return RoshamboPlayer.decodeRoshambo(playerSelection);
    }

    public RoshamboPlayer selectDifficulty () {
        System.out.println("---");
        System.out.println("(1) Easy");
        System.out.println("(2) Normal");
        System.out.println("---");
        int difficulty = validator.getIntWithinRange("Please select your difficulty: ", 1, 2);

        if (difficulty == 1) {
            return new RoshamboOpponentEasy();
        } else {
            return new RoshamboOpponentNormal();
        }
    }
}
