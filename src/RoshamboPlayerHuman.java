import Alviola.Console;

import java.util.Scanner;

/**
 * <p>The <code>RoshamboPlayerInput</code> class handles a majority of the player input methods
 * for a session of Roshambo.</p>
 *
 * @author David Ryan Alviola
 * @since 18 January 2017
 */
public class RoshamboPlayerHuman extends RoshamboPlayer{
    //Initialize validator
    Console validator = new Console();

    /**
     * <p>Prompts user for a string value of the player name and sets the value <code>playerName</code></p>
     *
     */
//    public void setPlayerName () {
//        playerName = validator.getRequiredString("Please enter your name: ");
//    }

    public RoshamboPlayerHuman (String playerName) {
        super(playerName);
    }

    /**
     * <p>Displays Roshambo choices then prompts user for integer value representing choice.</p>
     *
     * @return a Roshambo value corresponding to the chosen integer value
     */
    public Roshambo generateRoshambo () {
        System.out.println("---");
        System.out.println("(1) Rock");
        System.out.println("(2) Paper");
        System.out.println("(3) Scissors");
        System.out.println("---");
        int playerSelection = validator.getIntWithinRange("Choose your weapon (1-3): ", 1, 3);

        return decodeRoshambo(playerSelection);
    }

    /**
     * <p>Prompts the user for an integer value corresponding to the desired difficulty.</p>
     *
     * @return a RoshamboPlayer subclass object corresponding to the chosen difficulty
     */
    public RoshamboPlayer selectDifficulty () {
        System.out.println("---");
        System.out.println("(1) Easy");
        System.out.println("(2) Normal");
        System.out.println("---");
        int difficulty = validator.getIntWithinRange("Please select your difficulty: ", 1, 2);

        if (difficulty == 1) {
            return new RoshamboOpponentEasy("Rocky");
        } else {
            return new RoshamboOpponentNormal("Apollo");
        }
    }
}
