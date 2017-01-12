import java.util.Random;

/**
 * Created by David on 1/12/17.
 */
public class PingPong {
    //Variables
    private int min;
    private int max;
    private int cpuSwing;
    private int tauntNumber;

    //Initialize randomizer
    Random random = new Random();

    PingPong (int min, int max) {
        this.min = min;
        this.max = max;
    }

    private int generateRandomNumber () {
        return random.nextInt(max) + min;
    }

    public int getCpuSwing() {
        cpuSwing = generateRandomNumber();
        return cpuSwing;
    }

    public boolean compareSwings (int playerSwing, int cpuSwing) {
        if (playerSwing == cpuSwing) {
            return true;
        } else {
            return false;
        }
    }

    public String generateTaunt (String playerName) {
        tauntNumber = random.nextInt(4);

        if (tauntNumber == 0) {
            return "Is that the best you got, " + playerName + "?";
        } else if (tauntNumber == 1) {
            return "You're going down, " + playerName + "!";
        } else if (tauntNumber == 2) {
            return playerName + ", my grandma is better at Ping Pong than you.";
        } else if (tauntNumber == 3) {
            return playerName + ", I wasn't even trying that time!";
        }
        return "";
    }
}
