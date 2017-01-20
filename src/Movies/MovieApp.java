package Movies;

import Alviola.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>The <code>Movies.MovieApp</code> class prompts the user for an integer input corresponding to
 * a movie category. The method then returns a list of movies belonging to the selected category that
 * is sorted alphabetically.</p>
 *
 * @author David Ryan Alviola
 * @since 17 January 2017
 */
public class MovieApp {
    //Static variables
    private static MovieCategory movieCategory;

    //Initialize Movies.MoviesIO
    private static MoviesIO moviesIO = new MoviesIO();

    //Create array list
    private static List<Movie> moviesList = new ArrayList<>();

    /**
     * <p>Main method for the <code>Movies.MovieApp</code> class.</p>
     *
     * @param args
     */
    public static void main(String[] args) {
        //Local variables
        String userAnswer;
        int userCategory;

        //Initialize validator
        Console validator = new Console();

        //Populate array list and then sort alphabetically
        populateMovieList();
        Collections.sort(moviesList);

        System.out.println("Welcome to the Movies.Movie App!");

        //Repeats if user chooses "y"
        do {
            //Display choices and validate user choice
            printUserChoices();
            userCategory = validator.getIntWithinRange("Choose a category (1-6): ", 1, 6);

            //Set movieCategory
            setCategory(userCategory);

            //Prints results
            printUserQuery(movieCategory.toString());

            //Handling at end of session
            System.out.println("---");
            userAnswer = validator.getChoiceString("Would you like to search for another category? (y/n): ", "y", "n");

            if (userAnswer.equalsIgnoreCase("n")) {
                System.out.println("---");
                System.out.println("Thanks for using the Movies.Movie App!");
            }
        } while (userAnswer.equalsIgnoreCase("y"));
    }

    /**
     * <p>Populates a list with movie objects</p>
     */
    private static void populateMovieList () {
        for (int i = 0; i < 100; i += 1) {
            moviesList.add(i, MoviesIO.getMovie(i+1));
        }
    }

    /**
     * <p>Takes an integer value and sets the variable <code>movieCategory</code> to the associated
     * enumeration.</p>
     *
     * @param userCategory an integer value selected by the user
     */
    private static void setCategory (int userCategory) {
        switch (userCategory) {
            case 1:
                movieCategory = MovieCategory.ANIMATED;
                break;
            case 2:
                movieCategory = MovieCategory.DRAMA;
                break;
            case 3:
                movieCategory = MovieCategory.COMEDY;
                break;
            case 4:
                movieCategory = MovieCategory.HORROR;
                break;
            case 5:
                movieCategory = MovieCategory.MUSICAL;
                break;
            case 6:
                movieCategory = MovieCategory.SCIFI;
            default:
                System.out.println("Error @ getCategory");
        }
    }

    /**
     * <p>Takes a string value for the movie category then iterates through a list of <code>Movies.Movie</code>
     * objects. If the category of the <code>Movies.Movie</code> object matches the desired category, the <code>Movies.Movie</code>
     * object title is printed.</p>
     *
     * @param stringMovieCategory string value of the movie category
     */
    private static void printUserQuery (String stringMovieCategory) {
        System.out.println("---");

        for (Movie movie : moviesList) {
            if (movie.getMovieCategory().equals(stringMovieCategory)) {
                System.out.println(movie.getMovieTitle());
            }
        }
    }

    /**
     * <p>Prints the choices for the user.</p>
     */
    private static void printUserChoices () {
        System.out.println("---");
        System.out.println("(1) Animated");
        System.out.println("(2) Drama");
        System.out.println("(3) Comedy");
        System.out.println("(4) Horror");
        System.out.println("(5) Musical");
        System.out.println("(6) Sci-fi");
        System.out.println("---");
    }
}
