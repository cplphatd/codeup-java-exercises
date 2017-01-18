/**
 * Created by David on 1/18/17.
 */
public enum Roshambo {
    ROCK("rock"),
    PAPER("paper"),
    SCISSORS("scissors");

    private final String selection;

    Roshambo (String s) {
        selection = s;
    }

    public String toString () {
        return this.selection;
    }
}
