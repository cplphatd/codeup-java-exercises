import java.util.Random;

/**
 * <p>The <code>RoshamboPlayer</code> class takes a string value of the player name and creates
 * a player object. The <code>RoshamboPlayer</code> class handles game behaviors like generating
 * random moves and decoding the integer values to return enumerations.</p>
 *
 * @author David Ryan Alviola
 * @since 18 January 2017
 */
public abstract class RoshamboPlayer {
    //Variables
    private String playerName;
    private static int wins;
    private static int losses;

    /**
     * <p>Default constructor of <code>RoshamboPlayer</code> class for use by its subclasses.</p>
     */
    protected RoshamboPlayer () {}

    /**
     * <p>Setter for <code>playerName</code> variable.</p>
     *
     * @param playerName string value of the player's name
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /**
     *<p>Abstract method to allow different behaviors of <code>generateRoshambo</code> method
     * on the subclasses.</p>
     */
    public abstract Roshambo generateRoshambo ();

    /**
     * <p>Takes in an integer value and returns a corresponding Roshambo value. Defaults to return
     *  <code>ROCK</code>.</p>
     *
     * @param num an integer value
     * @return a Roshambo value
     */
    protected Roshambo decodeRoshambo (int num) {
        switch (num) {
            case 1:
                return Roshambo.ROCK;
            case 2:
                return Roshambo.PAPER;
            case 3:
                return Roshambo.SCISSORS;
            default:
                return Roshambo.ROCK;
        }
    }

    /**
     * @return string value of the player name
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * @return integer value of the number of wins in the session
     */
    public static int getWins() {
        return wins;
    }

    /**
     * @return integer value of the number of losses in the session
     */
    public static int getLosses() {
        return losses;
    }

    /**
     * <p>Increases the number of wins by 1</p>
     */
    public static void incrementWins() {
        wins += 1;
    }

    /**
     * <p>Increases the number of losses by 1</p>
     */
    public static void incrementLosses() {
        losses += 1;
    }
}
