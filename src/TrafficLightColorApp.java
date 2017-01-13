import java.util.Random;
import java.util.Scanner;

/**
 * Created by David on 1/12/17.
 */
public class TrafficLightColorApp {
    public static void main(String[] args) {
        //Variables
        TrafficLightColor currentColor = TrafficLightColor.RED;
        int randomNumber;
        String userAnswer;

        //Initialize scanner
        Scanner scanner = new Scanner(System.in);

        //Initialize randomizer
        Random random = new Random();

        //Initialize validator
        Validator validator = new Validator(scanner);

        do {
            randomNumber = random.nextInt(3);
            switch (randomNumber) {
                case 0:
                    currentColor = TrafficLightColor.RED;
                    break;
                case 1:
                    currentColor = TrafficLightColor.YELLOW;
                    break;
                case 2:
                    currentColor = TrafficLightColor.GREEN;
                    break;
            }

            System.out.print("If the light is " + currentColor + " you should: ");
            makeDrivingDecision(currentColor);

            userAnswer = validator.getChoiceString("Would you like to try again? (y/n) ", "y", "n");
        } while (userAnswer.equalsIgnoreCase("y"));
    }

    public static void makeDrivingDecision (TrafficLightColor color) {
        switch (color) {
            case RED:
                System.out.println("STOP!");
                break;
            case YELLOW:
                System.out.println("Slow down or proceed with caution.");
                break;
            case GREEN:
                System.out.println("Go.");
                break;
            default:
                System.out.println("Congratulations. You caused an accident.");
        }
    }
}
