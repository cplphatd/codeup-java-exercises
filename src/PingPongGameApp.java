import java.util.Scanner;

/**
 * Created by David on 1/12/17.
 */
public class PingPongGameApp {
    public static void main(String[] args) {
        //Variables
        String userAnswer;
        boolean repeat;
        boolean swingsMatch;
        int playerSwing;
        int cpuSwing;
        int playerScore;
        int cpuScore;
        int winningScore = 7;
        String playerName;
        String cpuTaunt;

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
                do {
                    System.out.println("---");
                    playerSwing = validator.getIntWithinRange("Swing left(1) or swing right(2)? ", 1, 2);
                    cpuSwing = pingPong.getCpuSwing();
                    swingsMatch = pingPong.compareSwings(playerSwing, cpuSwing);
                    System.out.println("---");
                    if (swingsMatch == true) {
                        System.out.println("CPU returned the ball!");
                    } else {
                        System.out.println("CPU missed!");
                    }
                } while (swingsMatch);

                if (swingsMatch == false) {
                    playerScore += 1;
                    if (playerScore == winningScore) {
                        break;
                    }

                    System.out.println("---");
                    System.out.println("Current score: Player - " + playerScore + " CPU - " + cpuScore);
                    System.out.println("---");
                    System.out.println("Good job! CPU is serving...");
                }

                do {
                    cpuSwing = pingPong.getCpuSwing();
                    System.out.println("---");
                    playerSwing = validator.getIntWithinRange("Swing left(1) or swing right(2)? ", 1, 2);
                    swingsMatch = pingPong.compareSwings(playerSwing, cpuSwing);
                    System.out.println("---");
                    if (swingsMatch) {
                        System.out.println("You returned the ball!");
                    } else {
                        System.out.println("MISS!");
                    }
                } while (swingsMatch);

                if (swingsMatch == false) {
                    cpuScore += 1;
                    if (cpuScore == winningScore) {
                        break;
                    }

                    System.out.println("---");
                    System.out.println(cpuTaunt = pingPong.generateTaunt(playerName));
                    System.out.println("---");
                    System.out.println("Current score: Player - " + playerScore + " CPU - " + cpuScore);
                    System.out.println("---");
                    System.out.println("Bummer. Get ready to serve...");
                }
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

            if (userAnswer.equalsIgnoreCase("y")) {
                repeat = true;
            } else {
                repeat = false;
            }
        } while (repeat);
    }
}
