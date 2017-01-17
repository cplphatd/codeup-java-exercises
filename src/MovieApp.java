import Alviola.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by David on 1/17/17.
 */
public class MovieApp {
    //Static variables
    private static MovieCategory movieCategory;

    //Initialize MoviesIO
    private static MoviesIO moviesIO = new MoviesIO();

    //Create array list
    private static List<Movie> moviesList = new ArrayList<Movie>();

    //Main method
    public static void main(String[] args) {
        //Local variables
        String userAnswer;
        int userCategory;
        String stringMovieCategory;

        //Initialize scanner
        Scanner scanner = new Scanner(System.in);

        //Initialize validator
        Console validator = new Console(scanner);

        //Populate array list and then sort alphabetically
        populateMovieList();
        Collections.sort(moviesList);

        System.out.println("Welcome to the Movie App!");

        //Repeats if user chooses "y"
        do {
            //Display choices and validate user choice
            printUserChoices();
            userCategory = validator.getIntWithinRange("Choose the category your want (1-5): ", 1, 5);

            //Set movieCategory
            setCategory(userCategory);

            //Convert user choice to string (extra step since constructor uses strings for category instead of enum)
            stringMovieCategory = convertUserChoice(movieCategory);

            //Print user query
            printUserQuery(stringMovieCategory);

            System.out.println("---");
            userAnswer = validator.getChoiceString("Would you like to search for another category? (y/n): ", "y", "n");

            if (userAnswer.equalsIgnoreCase("n")) {
                System.out.println("---");
                System.out.println("Thanks for using the Movie App!");
            }
        } while (userAnswer.equalsIgnoreCase("y"));
    }

    public static void populateMovieList () {
        for (int i = 0; i < 100; i += 1) {
            moviesList.add(i, moviesIO.getMovie(i+1));
        }
    }

    public static void setCategory (int userCategory) {
        switch (userCategory) {
            case 1:
                movieCategory = MovieCategory.ANIMATED;
                break;
            case 2:
                movieCategory = MovieCategory.DRAMA;
                break;
            case 3:
                movieCategory = MovieCategory.HORROR;
                break;
            case 4:
                movieCategory = MovieCategory.MUSICAL;
                break;
            case 5:
                movieCategory = MovieCategory.SCIFI;
                break;
            default:
                System.out.println("Error @ getCategory");
        }
    }

    private static String convertUserChoice (MovieCategory movieCategory) {
        switch (movieCategory) {
            case ANIMATED:
                return "animated";
            case DRAMA:
                return "drama";
            case HORROR:
                return "horror";
            case MUSICAL:
                return "musical";
            case SCIFI:
                return "scifi";
            default:
                return "Error @ convertUserChoice";
        }
    }

    private static void printUserQuery (String stringMovieCategory) {
        System.out.println("---");

        for (int i = 0; i < moviesList.size() - 1; i += 1) {
            if (moviesList.get(i).getMovieCategory().equals(stringMovieCategory)) {
                System.out.println(moviesList.get(i).getMovieTitle());
            }
        }
    }

    private static void printUserChoices () {
        System.out.println("---");
        System.out.println("(1) Animated");
        System.out.println("(2) Drama");
        System.out.println("(3) Horror");
        System.out.println("(4) Musical");
        System.out.println("(5) Scifi");
        System.out.println("---");
    }
}
