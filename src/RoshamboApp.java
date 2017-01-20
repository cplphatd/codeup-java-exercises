import Alviola.Console;

import java.util.Scanner;

/**
 * <p>The <code>RoshamboApp</code> class allows the user to play the game of Roshambo (Rock, Paper, Scissors).
 * The player enters his/her name and chooses a difficulty. The player throws a move and it is compared to the
 * CPU move where the game will end in a win, loss, or draw. Wins and losses are tracked as long as the player
 * chooses to continue.</p>
 *
 * @author David Ryan Alviola
 * @since 18 January 2017
 */
public class RoshamboApp {

    //Initialize validator
    static Console validator = new Console();

    /**
     * <p>Main method for the <code>RoshamboApp</code> class.</p>
     *
     * @param args
     */
    public static void main(String[] args) {
        //Local Variables
        String userAnswer;
        String playerName;

        //Welcome screen
        displayTitle();
        System.out.println("---");
        System.out.println("Welcome to Roshambo!");
        System.out.println("---");

        //Create human player object
        RoshamboPlayerHuman roshamboPlayerHuman = new RoshamboPlayerHuman(validator.getRequiredString("Please enter your name: "));

        //Repeats if user chooses "y"
        do {
            //Select difficulty
            RoshamboPlayer opponent = roshamboPlayerHuman.selectDifficulty();

            //Get player move
            String playerMove = roshamboPlayerHuman.generateRoshambo().toString();

            //Opponent move
            String opponentMove = opponent.generateRoshambo().toString();

            //Compare moves
            System.out.println("---");
            System.out.println(roshamboPlayerHuman.getPlayerName()+ " threw: " + playerMove + ". " + opponent.getPlayerName() + " threw: " + opponentMove + ".");
            Roshambo.determineResult(playerMove, opponentMove);

            //Show score
            showScore();

            System.out.println("---");
            userAnswer = validator.getChoiceString("Would you like to play again? (y/n) ", "y", "n");
            if (userAnswer.equalsIgnoreCase("n")) {
                System.out.println("---");
                System.out.println("Thanks for playing! See you later, " + roshamboPlayerHuman.getPlayerName() + ".");
            }
        } while (userAnswer.equalsIgnoreCase("y"));
    }

    /**
     * <p>Displays the app title in ASCII art.
     * Generated <a href="http://patorjk.com/software/taag/#p=display&f=Graffiti&t=Type%20Something%20">here</a>.</p>
     */
    private static void displayTitle () {
        System.out.println(".______        ______        _______. __    __       ___      .___  ___. .______     ______   \n" +
                "|   _  \\      /  __  \\      /       ||  |  |  |     /   \\     |   \\/   | |   _  \\   /  __  \\  \n" +
                "|  |_)  |    |  |  |  |    |   (----`|  |__|  |    /  ^  \\    |  \\  /  | |  |_)  | |  |  |  | \n" +
                "|      /     |  |  |  |     \\   \\    |   __   |   /  /_\\  \\   |  |\\/|  | |   _  <  |  |  |  | \n" +
                "|  |\\  \\----.|  `--'  | .----)   |   |  |  |  |  /  _____  \\  |  |  |  | |  |_)  | |  `--'  | \n" +
                "| _| `._____| \\______/  |_______/    |__|  |__| /__/     \\__\\ |__|  |__| |______/   \\______/  \n" +
                "                                                                                              ");
    }

    /**
     * <p>Displays the number of session wins and losses.</p>
     */
    private static void showScore () {
        System.out.println("---");
        System.out.println("Wins: " + RoshamboPlayer.getWins() + " Losses: " + RoshamboPlayer.getLosses());
    }
}
