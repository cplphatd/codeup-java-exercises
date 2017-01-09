import java.util.Random;

/**
 * Created by David on 1/8/17.
 */
public class Dice {
    //Variables
    int numberOfSides;

    public Dice (int sides) {
        this.numberOfSides = sides;
    }

    public static int rollDice (int sides) {
        //Initialize randomizer
        Random rand = new Random();

        //.nextInt is inclusive of zero, so the upper bound must have 1 subtracted, then the random number must have 1 added
        return rand.nextInt(sides - 1) + 1;
    }
}
