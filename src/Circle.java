/**
 * <p>The <code>Circle</code> class takes a double value as a radius then creates a <code>Circle</code>
 * object and calculates the properties of the circle.</p>
 *
 * @author David Ryan Alviola
 * @since 9 January 2017
 */
public class Circle {
    //Variables
    private double userRadius;
    private double circleCircumference;
    private double circleArea;
    private static int circleCounter = 0;

    /**
     * <p>The constructor for the <code>Circle</code> class.</p>
     *
     * @param userRadius a double that is the value of the circle's radius
     */
    public Circle (double userRadius) {
        this.userRadius = userRadius;
        this.circleCircumference = getCircumference();
        this.circleArea = getArea();
        circleCounter += 1;
    }

    /**
     * <p>Calculates the circumference of the circle based on the radius.</p>
     *
     * @return a double value that is the circumference of the circle
     */
    private double getCircumference () {
        return 2*Math.PI*userRadius;
    }

    /**
     * <p>Formats the circumference to two decimal places</p>
     *
     * @return string value of the circumference formatted to two decimal places
     */
    public String getFormattedCircumference () {
        double numberCircumference = circleCircumference;

        return formatNumber(numberCircumference);
    }

    /**
     * <p>Calculates the area of the circle based on the radius.</p>
     *
     * @return double value that is the area of the circle
     */
    private double getArea () {
        return Math.PI*(Math.pow(userRadius, 2));
    }

    /**
     * <p>Formats the area to two decimal places.</p>
     *
     * @return string value of the area formatted to two decimal places
     */
    public String getFormattedArea () {
        double numberArea = circleArea;

        return formatNumber(numberArea);
    }

    /**
     * <p>Takes a double value and returns a string value formatted to two decimal places.</p>
     *
     * @param x a double number
     * @return string value of double formatted to two decimal places
     */
    private String formatNumber (double x) {
        String stringX = String.valueOf(x); //Cannot use toString() on primitives

        return stringX.substring(0, stringX.indexOf(".") + 3);
    }

    /**
     * <p>Returns the number of <code>Circle</code> objects created.</p>
     *
     * @return an integer value of the number of <code>Circle</code> objects created
     */
    public static int getObjectCount () {
        return circleCounter;
    }
}
