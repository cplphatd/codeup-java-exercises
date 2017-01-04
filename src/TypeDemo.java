/**
 * Created by David on 1/3/17.
 */
public class TypeDemo {
    //create variables of every primitive type and print them to the console
    //try to assign a character to a variable that has been declared as an int
    //try to define a variable with the name class
    //initialize a variable, but do not assign it a value, then try and print it to the console

    public static void main(String[] args) {
        byte byteValue = 1;
        short shortValue = 123;
        int intValue = 14;
        long longValue = Long.MAX_VALUE;
        float floatValue = Float.MIN_VALUE;
        double doubleValue = Double.MAX_VALUE;
        char charValue = 'D';
        boolean booleanValue = false;

        System.out.println(byteValue);
        System.out.println(shortValue);
        System.out.println(intValue);
        System.out.println(longValue);
        System.out.println(floatValue);
        System.out.println(doubleValue);
        System.out.println(charValue);
        System.out.println(booleanValue);
    }
}
