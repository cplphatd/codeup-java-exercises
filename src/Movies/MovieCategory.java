package Movies;

/**
 * <p>The <code>Movies.MovieCategory</code> enumeration provides movie categories and the associated
 * string values for use with the <code>Movies.MovieApp</code> class.</p>
 *
 * @author David Ryan Alviola
 * @since 17 January 2017
 */
public enum MovieCategory {
    ANIMATED ("animated"),
    COMEDY ("comedy"),
    DRAMA ("drama"),
    HORROR ("horror"),
    SCIFI ("scifi"),
    MUSICAL ("musical");

    private final String stringCategory;

    /**
     * <p>Constructor for the <code>Movies.MovieCategory</code> enumeration.</p>
     *
     * @param s a string value of the category
     */
    MovieCategory (String s) {
        stringCategory = s;
    }

    /**
     * <p>This method can be used to convert enumeration values to string values.</p>
     *
     * @return a string value of the associated constant
     */
    public String toString () {
        return this.stringCategory;
    }
}
