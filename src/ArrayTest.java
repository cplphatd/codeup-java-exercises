import java.util.Arrays;
import java.util.Random;

/**
 * Created by David on 1/11/17.
 */
public class ArrayTest {
    public static void main(String[] args) {
        String[] animals = {"dog", "cat", "pig", "cow"};

        System.out.println(Arrays.toString(animals));

        char[] grades = new char[5];
        Arrays.fill(grades, 0, 4, 'A');
        System.out.println(Arrays.toString(grades));

        int[] array1 = {1, 2, 3, 4};
        int[] array2 = {1, 2, 4, 3};
        System.out.println(Arrays.equals(array1, array2));

        String[] foodJustinLikes = {"hamburger", "pie", "potatoes", "kale", "peanut butter"};
        String[] foodPamLikes = Arrays.copyOf(foodJustinLikes, 3);
        String[] foodNoOneLikes = Arrays.copyOfRange(foodJustinLikes, 3, 5);
        System.out.println(Arrays.toString(foodPamLikes));
        System.out.println(Arrays.toString(foodNoOneLikes));

        String[] students = {"Ron", "John", "Kevin", "Jeff", "Mittsy"};
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        String[] hayStack = new String[100];
        Arrays.fill(hayStack, 0, 50, "hay");
        Arrays.fill(hayStack, 50, 100, "wheat");
        Random rand = new Random();
        int random = rand.nextInt(100);
        hayStack[random] = "needle";
        System.out.println(Arrays.toString(hayStack));

        Arrays.sort(hayStack);

        int index = Arrays.binarySearch(hayStack, "needle");
        System.out.println(index);

        String[] topBondFilms = new String[10];
        topBondFilms[7] = "Quantum of Solace";
        topBondFilms = new String[3];

        System.out.println(Arrays.toString(topBondFilms));

        int [][] spreadSheet = new int[6][6];

        for (int i = 0; i < spreadSheet.length; i += 1) {
            System.out.println("");
            for (int j = 0; j < spreadSheet[i].length; j += 1 ) {
                System.out.print(spreadSheet[i][j] + " ");
            }
        }

        int[][] jaggedArray = new int[5][];

        int[] row1 = new int[3];
        int[] row2 = new int[10];
        int[] row3 = new int[5];
        int[] row4 = new int[7];
        int[] row5 = new int[2];

        jaggedArray[0] = row1;
        jaggedArray[1] = row2;
        jaggedArray[2] = row3;
        jaggedArray[3] = row4;
        jaggedArray[4] = row5;

        System.out.println();
        for (int[] singleArray : jaggedArray) {
            System.out.println(Arrays.toString(singleArray));
        }
    }
}
