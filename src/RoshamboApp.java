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
    //Initialize scanner
    static Scanner scanner = new Scanner (System.in);

    //Initialize validator
    static Console validator = new Console(scanner);

    /**
     * <p>Main method for the <code>RoshamboApp</code> class.</p>
     *
     * @param args
     */
    public static void main(String[] args) {
        //Local Variables
        String userAnswer;

        //Welcome screen
        displayTitle();
        System.out.println("---");
        System.out.println("Welcome to Roshambo!");
        System.out.println("---");

        //Get player info
        RoshamboPlayerInput roshamboPlayerInput = new RoshamboPlayerInput();
        String playerName = roshamboPlayerInput.getPlayerName();

        //Create player object
        RoshamboPlayer roshamboPlayer = new RoshamboPlayer();
        roshamboPlayer.setPlayerName(playerName);

        //Repeats if user chooses "y"
        do {
            //Select difficulty
            RoshamboPlayer opponent = roshamboPlayerInput.selectDifficulty();

            //Get player move
            String playerMove = roshamboPlayerInput.getPlayerRoshambo().toString();

            //Opponent move
            String opponentMove = "";
            if (opponent instanceof RoshamboOpponentEasy) {
                opponentMove = ((RoshamboOpponentEasy) opponent).getEasySelection().toString();
            } else if (opponent instanceof  RoshamboOpponentNormal) {
                opponentMove = ((RoshamboOpponentNormal) opponent).getNormalSelection().toString();
            }

            //Compare moves
            System.out.println("---");
            System.out.println(roshamboPlayer.getPlayerName()+ " threw: " + playerMove + ". CPU threw: " + opponentMove + ".");
            determineResult(playerMove, opponentMove);

            //Show score
            showScore();

            System.out.println("---");
            userAnswer = validator.getChoiceString("Would you like to play again? (y/n) ", "y", "n");
            if (userAnswer.equalsIgnoreCase("n")) {
                System.out.println("---");
                System.out.println("Thanks for playing! See you later, " + roshamboPlayer.getPlayerName() + ".");
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
     * <p>Takes in string values of the player and CPU moves then calls the appropriate method depending
     * on the result.</p>
     *
     * @param playerMove string value of the move the player threw
     * @param opponentMove string value of the move the CPU threw
     */
    private static void determineResult (String playerMove, String opponentMove) {
        switch (playerMove) {
            case "rock":
                switch (opponentMove) {
                    case "paper":
                        loss();
                        break;
                    case "scissors":
                        win();
                        break;
                    default:
                        draw();
                }
                break;
            case "paper":
                switch (opponentMove) {
                    case "rock":
                        win();
                        break;
                    case "scissors":
                        loss();
                        break;
                    default:
                        draw();
                }
                break;
            case "scissors":
                switch (opponentMove) {
                    case "rock":
                        loss();
                        break;
                    case "paper":
                        win();
                        break;
                    default:
                        draw();
                }
                break;
            default:
                System.out.println("Error @ determineResult");
        }
    }

    /**
     * <p>Displays message when player wins. Increases the number of session wins by 1.</p>
     */
    private static void win () {
        System.out.println("---");
        System.out.println("You win!");
        RoshamboPlayer.incrementWins();
    }

    /**
     * <p>Displays message when player loses. Increases the number of session losses by 1.</p>
     */
    private static void loss () {
        System.out.println("---");
        System.out.println("You lose...");
        RoshamboPlayer.incrementLosses();
    }

    /**
     * <p>Displays message when player and CPU draw.</p>
     */
    private static void draw () {
        System.out.println("---");
        System.out.println("Draw.");
    }

    /**
     * <p>Displays the number of session wins and losses.</p>
     */
    private static void showScore () {
        System.out.println("---");
        System.out.println("Wins: " + RoshamboPlayer.getWins() + " Losses: " + RoshamboPlayer.getLosses());
    }
}
