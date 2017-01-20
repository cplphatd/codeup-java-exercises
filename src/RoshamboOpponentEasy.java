/**
 * <p>The <code>RoshamboOpponentEasy</code> class is a subclass of the
 * <code>RoshamboPlayer</code> class. Behavior for the easy opponent are handled in this class.</p>
 *
 * @author David Ryan Alviola
 * @since 18 January 2017
 */
public class RoshamboOpponentEasy extends RoshamboPlayer {

    public RoshamboOpponentEasy (String playerName) {
        super(playerName);
    }

    /**
     * @return a <code>Roshambo</code> value of <code>ROCK</code>
     */
    public Roshambo generateRoshambo() {
        return Roshambo.ROCK;
    }
}
