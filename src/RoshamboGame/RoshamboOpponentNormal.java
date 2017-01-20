package RoshamboGame;

import java.util.Random;

/**
 * <p>The <code>RoshamboGame.RoshamboOpponentNormal</code> class is a subclass of the
 * <code>RoshamboGame.RoshamboPlayer</code> class. Behavior for the normal opponent are handled in this class.</p>
 *
 * @author David Ryan Alviola
 * @since 18 January 2017
 */
public class RoshamboOpponentNormal extends RoshamboPlayer {

    /**
     * <p>Constructor</p>
     *
     * @param playerName string value of the player name
     */
    public RoshamboOpponentNormal (String playerName) {
        super(playerName);
    }

    /**
     * <p>Takes in integer values for the minimum and maximum bounds and generates a random integer
     * within and including those values. The random integer is passed into the static <code>decodeRoshambo</code>
     * method and a <code>RoshamboGame.Roshambo</code> value is returned.</p>
     *
     * @return a RoshamboGame.Roshambo value based on the random integer
     */
    Roshambo generateRoshambo () {
    //Initialize randomizer
    Random random = new Random();

    int num = random.nextInt(3) + 1;

    return decodeRoshambo(num);
    }
}
