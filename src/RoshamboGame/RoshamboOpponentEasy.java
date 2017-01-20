package RoshamboGame;

/**
 * <p>The <code>RoshamboGame.RoshamboOpponentEasy</code> class is a subclass of the
 * <code>RoshamboGame.RoshamboPlayer</code> class. Behavior for the easy opponent are handled in this class.</p>
 *
 * @author David Ryan Alviola
 * @since 18 January 2017
 */
public class RoshamboOpponentEasy extends RoshamboPlayer {

    /**
     * <p>Constructor</p>
     *
     * @param playerName string value of the player name
     */
    public RoshamboOpponentEasy (String playerName) {
        super(playerName);
    }

    /**
     * @return a <code>RoshamboGame.Roshambo</code> value of <code>ROCK</code>
     */
    Roshambo generateRoshambo() {
        return Roshambo.ROCK;
    }
}
