import java.util.Random;

/**
 * Created by David on 1/18/17.
 */
public class RoshamboPlayer {
    //Variables
    private String playerName;

    /**
     * <p>Default constructor of <code>RoshamboPlayer</code> class for use by its subclasses.</p>
     */
    protected RoshamboPlayer () {}

    public RoshamboPlayer (String playerName) {
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
}
