import java.util.Random;

/**
 * Created by David on 1/8/17.
 */
public class Dice {
    //Variables
    int numberOfSides;

    //Only constructor name should be capitalized
    public Dice (int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }

    public int rollDice () {
        //Initialize randomizer
        Random rand = new Random();

        //.nextInt is inclusive of zero and exclusive of the max, so  the random number must have 1 added
        return rand.nextInt(numberOfSides) + 1;
    }
}
