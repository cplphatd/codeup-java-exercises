/**
 * <p>The <code>RoshamboOpponentNormal</code> class is a subclass of the
 * <code>RoshamboPlayer</code> class. Behavior for the normal opponent are handled in this class.</p>
 *
 * @author David Ryan Alviola
 * @since 18 January 2017
 */
public class RoshamboOpponentNormal extends RoshamboPlayer {
    /**
     * <p>Randomly selects ROCK, PAPER, or SCISSORS</p>
     */
    private Roshambo normalSelection = generateRoshambo(1, 3);

    /**
     * @return the Roshambo value of the normal opponent's move
     */
    public Roshambo getNormalSelection() {
        return normalSelection;
    }
}
