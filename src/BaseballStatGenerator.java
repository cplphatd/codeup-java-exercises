import java.util.Arrays;

/**
 * Created by David on 1/11/17.
 */
public class BaseballStatGenerator {
    //Variables
    private double[][] statDisplayArray;

    public BaseballStatGenerator(int rows, int columns) {
        this.statDisplayArray = new double[rows][columns];
    }

    public double calculateBattingAverage (int[] atBatArray) {
        double hits = 0;

        for (int basesEarned : atBatArray) {
            if (basesEarned > 0) {
                hits += 1;
            }
        }

        return hits/atBatArray.length;
    }

    public double calculateSluggingAverage (int[] atBatArray) {
        double totalBases = 0;

        for (int basesEarned : atBatArray) {
            totalBases += basesEarned;
        }

        return totalBases/atBatArray.length;
    }

    public void storeStat(double stat, int row, int column) {
        statDisplayArray[row][column] = stat;
    }

    public void printStatDisplayArray (String rowName, String columnOneName, String columnTwoName) {
        System.out.println(rowName + ": [" + columnOneName + ", " + columnTwoName + "]");

        for (int i = 0; i <= statDisplayArray.length - 1; i += 1) {
            System.out.print("Player " + (i+1) + ": [");
            System.out.printf("%.3f", statDisplayArray[i][0]);
            System.out.print(", ");
            System.out.printf("%.3f", statDisplayArray[i][1]);
            System.out.println("]");
        }
    }
}
