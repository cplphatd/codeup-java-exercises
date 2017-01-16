import java.util.Scanner;

/**
 * Created by David on 1/12/17.
 */
public class PingPongGameApp {
    public static void main(String[] args) {
        //Variables
        String userAnswer;
        boolean swingsMatch;
        int playerSwing;
        int cpuSwing;
        int playerScore;
        int cpuScore;
        int winningScore = 7;
        String playerName;
        String cpuTaunt;
        boolean playerHitFirst;

        //Initialize scanner
        Scanner scanner = new Scanner(System.in);

        //Initialize validator
        Validator validator = new Validator(scanner);

        System.out.println("Let's play Ping Pong!");

        //Repeats if user wants to play again
        do {
            System.out.println("---");
            playerName = validator.getRequiredString("Please enter your name: ");
            System.out.println("---");
            System.out.println("First player to 7 wins!");

            //Initialize game
            PingPong pingPong = new PingPong(1, 2);
            playerScore = 0;
            cpuScore = 0;

            do {
                System.out.println("---");
                System.out.println("Your serve...");
                playerSwing = validator.getIntWithinRange("Swing left(1) or swing right(2)? ", 1, 2);
                cpuSwing = pingPong.getCpuSwing();
                playerHitFirst = true;
                do {
                    System.out.println("---");
                    swingsMatch = pingPong.compareSwings(playerSwing, cpuSwing);
                    System.out.println("---");
                    if (playerHitFirst) {
                        if (swingsMatch) {
                            System.out.println("CPU returned the ball!");
                            playerHitFirst = false;
                            cpuSwing = pingPong.getCpuSwing();
                            playerSwing = validator.getIntWithinRange("Swing left(1) or swing right(2)? ", 1, 2);
                        } else {
                            System.out.println("CPU missed!");
                            playerScore += 1;
                        }
                    } else {
                        if (swingsMatch) {
                            System.out.println(playerName + " returned the ball!");
                            playerHitFirst = true;
                            playerSwing = validator.getIntWithinRange("Swing left(1) or swing right(2)? ", 1, 2);
                            cpuSwing = pingPong.getCpuSwing();
                        } else {
                            System.out.println(playerName + " missed the ball...");
                            System.out.println(cpuTaunt = pingPong.generateTaunt(playerName));
                            cpuScore += 1;
                        }
                    }
                } while (swingsMatch);

                if (playerScore == winningScore || cpuScore == winningScore) {
                    break;
                }

                System.out.println("---");
                System.out.println("Current score: Player - " + playerScore + " CPU - " + cpuScore);
                System.out.println("---");
                System.out.println("CPU is serving...");

                cpuSwing = pingPong.getCpuSwing();
                playerHitFirst = false;
                playerSwing = validator.getIntWithinRange("Swing left(1) or swing right(2)? ", 1, 2);
                do {
                    System.out.println("---");
                    swingsMatch = pingPong.compareSwings(playerSwing, cpuSwing);
                    System.out.println("---");
                    if (playerHitFirst) {
                        if (swingsMatch) {
                            System.out.println("CPU returned the ball...");
                            playerHitFirst = false;
                            cpuSwing = pingPong.getCpuSwing();
                            playerSwing = validator.getIntWithinRange("Swing left(1) or swing right(2)? ", 1, 2);
                        } else {
                            System.out.println("CPU missed!");
                            playerScore += 1;
                        }
                    } else {
                        if (swingsMatch) {
                            System.out.println(playerName + " returned the ball!");
                            playerHitFirst = true;
                            playerSwing = validator.getIntWithinRange("Swing left(1) or swing right(2)? ", 1, 2);
                            cpuSwing = pingPong.getCpuSwing();
                        } else {
                            System.out.println(playerName + " missed the ball...");
                            System.out.println(cpuTaunt = pingPong.generateTaunt(playerName));
                            cpuScore += 1;
                        }
                    }
                } while (swingsMatch);

                if (cpuScore == winningScore || playerScore == winningScore) {
                    break;
                }

                System.out.println("---");
                System.out.println("---");
                System.out.println("Current score: Player - " + playerScore + " CPU - " + cpuScore);
                System.out.println("---");
                System.out.println("Get ready to serve...");

            } while (playerScore < winningScore || cpuScore < winningScore );

            System.out.println("---");
            if (playerScore > cpuScore) {
                System.out.println("Congratulations, " + playerName + "! You won!");
            } else {
                System.out.println(playerName + ", you're the worst.");
                System.out.println("Better luck next time...");
            }

            System.out.println("---");
            userAnswer = validator.getChoiceString("Would you like to continue? (y/n): ", "y", "n");
        } while (userAnswer.equalsIgnoreCase("y"));
    }
}
