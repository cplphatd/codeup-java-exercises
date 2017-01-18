import Alviola.Console;

import java.util.Scanner;

/**
 * Created by David on 1/18/17.
 */
public class RoshamboPlayerInput {
    //Initialize scanner
    Scanner scanner = new Scanner(System.in);

    //Initialize validator
    Console validator = new Console(scanner);

    public Roshambo getPlayerRoshambo () {
        int playerSelection = validator.getIntWithinRange("Enter 1-3: ", 1, 3);

        return RoshamboPlayer.decodeRoshambo(playerSelection);
    }
}
