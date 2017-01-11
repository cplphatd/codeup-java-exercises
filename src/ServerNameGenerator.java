import java.util.Arrays;
import java.util.Random;

/**
 * Created by David on 1/11/17.
 */
public class ServerNameGenerator {
    //Variables
    private String[] arrayOne;
    private String[] arrayTwo;

    //Initialize randomizer
    Random random = new Random();

    public ServerNameGenerator (String[] arrayOne, String[] arrayTwo) {
        this.arrayOne = new String[arrayOne.length];
        this.arrayOne = Arrays.copyOf(arrayOne, arrayOne.length);

        this.arrayTwo = new String[arrayTwo.length];
        this.arrayTwo = Arrays.copyOf(arrayTwo, arrayTwo.length);
    }

    private int randomNumberGenerator (int arrayLength) {
        return random.nextInt(arrayLength);
    }

    public String generateServerName () {
        return arrayOne[randomNumberGenerator(arrayOne.length)] + " " + arrayTwo[randomNumberGenerator(arrayTwo.length)];
    }
}
