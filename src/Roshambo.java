/**
 * <p>The <code>Roshambo</code> enumeration provides moves and the associated string values
 * for use with the <code>RoshamboApp</code> class.</p>
 *
 * @author David Ryan Alviola
 * @since 18 January 2017
 */
public enum Roshambo {
    ROCK("rock"),
    PAPER("paper"),
    SCISSORS("scissors");

    private final String selection;

    /**
     * <p>Constructor for the <code>Roshambo</code> enumeration.</p>
     *
     * @param s a string value of the move
     */
    Roshambo (String s) {
        selection = s;
    }

    /**
     * <p>This method can be used to convert enumeration values to string values.</p>
     *
     * @return a string value of the associated enumeration
     */
    public String toString () {
        return this.selection;
    }
}
