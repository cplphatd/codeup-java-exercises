/**
 * <p>The <code>RoshamboOpponentEasy</code> class is a subclass of the
 * <code>RoshamboPlayer</code> class. Behavior for the easy opponent are handled in this class.</p>
 *
 * @author David Ryan Alviola
 * @since 18 January 2017
 */
public class RoshamboOpponentEasy extends RoshamboPlayer {
    /**
     * <p>Ensures the easy opponent always selects ROCK.</p>
     */
    private Roshambo easySelection = generateRoshambo(1, 1);

    /**
     * @return the Roshambo value of the easy opponent's move
     */
    public Roshambo getEasySelection() {
        return easySelection;
    }
}
