/**
 * Created by David on 1/18/17.
 */
public class RoshamboOpponentEasy extends RoshamboPlayer {
    /**
     * <p>Ensures the easy opponent always selects ROCK.</p>
     */
    private Roshambo easySelection = RoshamboPlayer.generateRoshambo(1, 1);

    public Roshambo getEasySelection() {
        return easySelection;
    }
}
