import java.util.Random;

/**
 * Created by David on 1/18/17.
 */
public class RoshamboPlayer {
    //Variables
    private String playerName;
    private static int wins;
    private static int losses;

    /**
     * <p>Default constructor of <code>RoshamboPlayer</code> class for use by its subclasses.</p>
     */
    protected RoshamboPlayer () {}

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    protected static Roshambo generateRoshambo (int min, int max) {
        //Initialize randomizer
        Random random = new Random();

        int num = random.nextInt(max) + min;

        return decodeRoshambo(num);
    }

    protected static Roshambo decodeRoshambo (int num) {
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

    public String getPlayerName() {
        return playerName;
    }

    public static int getWins() {
        return wins;
    }

    public static int getLosses() {
        return losses;
    }

    public static void incrementWins() {
        wins += 1;
    }

    public static void incrementLosses() {
        losses += 1;
    }
}
