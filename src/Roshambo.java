/**
 * <p>The <code>Roshambo</code> enumeration provides moves and the associated string values
 * for use with the <code>RoshamboApp</code> class.</p>
 *
 * @author David Ryan Alviola
 * @since 18 January 2017
 */
public enum Roshambo {
    ROCK("rock"),
    PAPER("paper"),
    SCISSORS("scissors");

    private final String selection;

    /**
     * <p>Constructor for the <code>Roshambo</code> enumeration.</p>
     *
     * @param s a string value of the move
     */
    Roshambo (String s) {
        selection = s;
    }

    /**
     * <p>This method can be used to convert enumeration values to string values.</p>
     *
     * @return a string value of the associated enumeration
     */
    public String toString () {
        return this.selection;
    }

    /**
     * <p>Takes in string values of the player and CPU moves then calls the appropriate method depending
     * on the result.</p>
     *
     * @param playerMove string value of the move the player threw
     * @param opponentMove string value of the move the CPU threw
     */
    public static void determineResult (String playerMove, String opponentMove) {
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
}
