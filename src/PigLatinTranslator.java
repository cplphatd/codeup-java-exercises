import java.util.Scanner;

/**
 * Created by David on 1/5/17.
 */
public class PigLatinTranslator {
    public static void main(String[] args) {
        //Variables
        boolean repeat = false;
        String userWord;
        String translatedWord;
        String userAnswer;

        //Initialize scanner
        Scanner sc = new Scanner(System.in);

        //Repeats if the user wants to
        do {
            System.out.print("Please enter a word to translate: ");
            userWord = getWord(sc);

            translatedWord = translateWord(userWord);
            System.out.println(translatedWord);

            do {
                System.out.print("Would you like to translate another word? (y/n) ");
                userAnswer = sc.next();
                if (userAnswer.equalsIgnoreCase("y") || userAnswer.equalsIgnoreCase("yes")) {
                    repeat = true;
                } else {
                    repeat = false;
                }
            } while (!userAnswer.equalsIgnoreCase("yes") && !userAnswer.equalsIgnoreCase("no") && !userAnswer.equalsIgnoreCase("y") && !userAnswer.equalsIgnoreCase("n"));
        } while (repeat);
    }

    public static String getWord (Scanner anyScanner) {
        return anyScanner.next();
    }

    public static String translateWord (String anyString) {
        int vowelCounter = 0;
        anyString = makeLowerCase(anyString);

        if (anyString.indexOf("a") == 0 || anyString.indexOf("e") == 0 || anyString.indexOf("i") == 0 || anyString.indexOf("o") == 0 || anyString.indexOf("u") == 0) {
            return anyString + "-way";
        } else if (anyString.indexOf("u") > 0 && vowelCounter == 0) {
                vowelCounter += 1;
                return anyString.substring(anyString.indexOf("u") + 1) + anyString.substring(0, anyString.indexOf("u") + 1) + "-ay";
            } else if (anyString.indexOf("i") > 0 && vowelCounter == 0) {
                vowelCounter += 1;
                return anyString.substring(anyString.indexOf("i") + 1) + anyString.substring(0, anyString.indexOf("i") + 1) + "-ay";
            } else if (anyString.indexOf("o") > 0 && vowelCounter == 0) {
                vowelCounter += 1;
                return anyString.substring(anyString.indexOf("o") + 1) + anyString.substring(0, anyString.indexOf("o") + 1) + "-ay";
            } else if (anyString.indexOf("a") > 0 && vowelCounter == 0) {
                vowelCounter += 1;
                return anyString.substring(anyString.indexOf("a") + 1) + anyString.substring(0, anyString.indexOf("a") + 1) + "-ay";
            } else if (anyString.indexOf("e") > 0 && vowelCounter == 0){
                vowelCounter += 1;
                return anyString.substring(anyString.indexOf("e") + 1) + anyString.substring(0, anyString.indexOf("e") + 1) + "-ay";
            } else {
                return anyString + " cannot be translated";
        }
    }

    public static String makeLowerCase (String anyString) {
        return anyString.toLowerCase();
    }
}
