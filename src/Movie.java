/**
 * Created by David on 1/17/17.
 */
public class Movie implements Comparable<Movie> {
    //Variables
    private String movieTitle;
    private String movieCategory;

    public Movie (String movieTitle, String movieCategory) {
        this.movieTitle = movieTitle;
        this.movieCategory = movieCategory;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieCategory() {
        return movieCategory;
    }

    @Override
    public int compareTo (Movie m) {
        return movieTitle.compareToIgnoreCase(m.movieTitle);
    }
}
