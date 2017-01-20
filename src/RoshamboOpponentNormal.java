import java.util.Random;

/**
 * <p>The <code>RoshamboOpponentNormal</code> class is a subclass of the
 * <code>RoshamboPlayer</code> class. Behavior for the normal opponent are handled in this class.</p>
 *
 * @author David Ryan Alviola
 * @since 18 January 2017
 */
public class RoshamboOpponentNormal extends RoshamboPlayer {

    public RoshamboOpponentNormal (String playerName) {
        super(playerName);
    }

    /**
     * <p>Takes in integer values for the minimum and maximum bounds and generates a random integer
     * within and including those values. The random integer is passed into the static <code>decodeRoshambo</code>
     * method and a <code>Roshambo</code> value is returned.</p>
     *
     * @return a Roshambo value based on the random integer
     */
    public Roshambo generateRoshambo () {
    //Initialize randomizer
    Random random = new Random();

    int num = random.nextInt(3) + 1;

    return decodeRoshambo(num);
    }
}
