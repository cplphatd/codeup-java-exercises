import Alviola.Console;

import java.util.Scanner;

/**
 * Created by David on 1/18/17.
 */
public class RoshamboApp {
    //Initialize scanner
    static Scanner scanner = new Scanner (System.in);

    //Initialize validator
    static Console validator = new Console(scanner);

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
            System.out.println("You threw: " + playerMove + ". Your opponent threw: " + opponentMove + ".");
            determineResult(playerMove, opponentMove);

            //Show score
            showScore();

            System.out.println("---");
            userAnswer = validator.getChoiceString("Would you like to play again? (y/n) ", "y", "n");
            if (userAnswer.equalsIgnoreCase("n")) {
                System.out.println("---");
                System.out.println("Thanks for playing! See you later, " + playerName + ".");
            }
        } while (userAnswer.equalsIgnoreCase("y"));



    }

    private static void displayTitle () {
        System.out.println(".______        ______        _______. __    __       ___      .___  ___. .______     ______   \n" +
                "|   _  \\      /  __  \\      /       ||  |  |  |     /   \\     |   \\/   | |   _  \\   /  __  \\  \n" +
                "|  |_)  |    |  |  |  |    |   (----`|  |__|  |    /  ^  \\    |  \\  /  | |  |_)  | |  |  |  | \n" +
                "|      /     |  |  |  |     \\   \\    |   __   |   /  /_\\  \\   |  |\\/|  | |   _  <  |  |  |  | \n" +
                "|  |\\  \\----.|  `--'  | .----)   |   |  |  |  |  /  _____  \\  |  |  |  | |  |_)  | |  `--'  | \n" +
                "| _| `._____| \\______/  |_______/    |__|  |__| /__/     \\__\\ |__|  |__| |______/   \\______/  \n" +
                "                                                                                              ");
    }

    private static void determineResult (String playerMove, String opponentMove) {
        switch (playerMove) {
            case "rock":
                switch (opponentMove) {
                    case "rock":
                        draw();
                        break;
                    case "paper":
                        loss();
                        break;
                    case "scissors":
                        win();
                        break;
                }
                break;
            case "paper":
                switch (opponentMove) {
                    case "rock":
                        win();
                        break;
                    case "paper":
                        draw();
                        break;
                    case "scissors":
                        loss();
                        break;
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
                    case "scissors":
                        draw();
                        break;
                }
                break;
            default:
                System.out.println("Error @ determineResult");
        }
    }

    private static void win () {
        System.out.println("---");
        System.out.println("You win!");
        RoshamboPlayer.incrementWins();
    }

    private static void loss () {
        System.out.println("---");
        System.out.println("You lose...");
        RoshamboPlayer.incrementLosses();
    }

    private static void draw () {
        System.out.println("---");
        System.out.println("Draw.");
    }

    private static void showScore () {
        System.out.println("---");
        System.out.println("Wins: " + RoshamboPlayer.getWins() + " Losses: " + RoshamboPlayer.getLosses());
    }
}
