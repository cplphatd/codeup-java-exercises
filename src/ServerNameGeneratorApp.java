import java.util.Scanner;

/**
 * Created by David on 1/11/17.
 */
public class ServerNameGeneratorApp {
    public static void main(String[] args) {
        //Variables
        String[] adjectives = {"Hairless", "Sadistic", "Sexy", "Violent", "Bearded", "Slimy", "Naked", "Drunken", "Vengeful", "Cowardly"};
        String[] nouns = {"Idiot", "Legend", "Kitty", "Tank", "Pistol", "Dragon", "Sandwich", "Tiger", "Laser", "Smartphone", "Sailor"};
        String userAnswer;
        boolean repeat;
        String serverName;

        //Initialize scanner
        Scanner scanner = new Scanner(System.in);

        //Initialize name generator
        ServerNameGenerator serverNameGenerator = new ServerNameGenerator(adjectives, nouns);

        //Initialize validator
        Validator validator = new Validator(scanner);

        System.out.println("Welcome to Server Name Generator 1.0!");

        //Generates another name if user wants to continue
        do {
            System.out.println("---");
            serverName = serverNameGenerator.generateServerName();
            System.out.println("You should name your server: " + serverName);
            System.out.println("---");

            //Asks if user wants to continue
            userAnswer = validator.getChoiceString("Would you like to generate another name? (y/n): ", "y", "n");
            if (userAnswer.equalsIgnoreCase("y")) {
                repeat = true;
            } else {
                repeat = false;
            }
        } while (repeat);

        System.out.println("---");
        System.out.println("Thanks for generating server names!");
    }
}
