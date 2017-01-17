/**
 * <p>The <code>Movie</code> class takes string values for movie title and category then creates
 * an object with those properties.</p>
 *
 * @author David Ryan Alviola
 * @since 17 January 2017
 */
public class Movie implements Comparable<Movie> {
    //Variables
    private String movieTitle;
    private String movieCategory;

    /**
     * <p>Contstructor for <code>Movie</code> class.</p>
     *
     * @param movieTitle string value for the title of the movie
     * @param movieCategory string value for the category of the movie
     */
    public Movie (String movieTitle, String movieCategory) {
        this.movieTitle = movieTitle;
        this.movieCategory = movieCategory;
    }

    /**
     * @return string value of the movie object's title
     */
    public String getMovieTitle() {
        return movieTitle;
    }

    /**
     * @return string value of the movie object's category
     */
    public String getMovieCategory() {
        return movieCategory;
    }

    /**
     * <p>Method to implement <code>Comparable</code> interface. Sorts a list of objects alphabetically</p>
     *
     * @param m an object
     * @return integer value for <code>Sort</code> method
     */
    @Override
    public int compareTo (Movie m) {
        return movieTitle.compareToIgnoreCase(m.movieTitle);
    }
}
