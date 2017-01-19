/**
 * Created by David on 1/18/17.
 */
public class RoshamboOpponentNormal extends RoshamboPlayer {
    private Roshambo normalSelection = generateRoshambo(1, 3);

    public Roshambo getNormalSelection() {
        return normalSelection;
    }
}
