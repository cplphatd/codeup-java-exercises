/**
 * Created by David on 1/9/17.
 */
public class Circle {
    //Variables
    private double userRadius;
    private double circleCircumference;
    private double circleArea;
    private static int circleCounter = 0;

    public Circle (double userRadius) {
        this.userRadius = userRadius;
        this.circleCircumference = getCircumference();
        this.circleArea = getArea();
        circleCounter += 1;
    }

    public double getCircumference () {
        return 2*Math.PI*userRadius;
    }

    public String getFormattedCircumference () {
        double numberCircumference = circleCircumference;

        return formatNumber(numberCircumference);
    }

    public double getArea () {
        return Math.PI*(Math.pow(userRadius, 2));
    }

    public String getFormattedArea () {
        double numberArea = circleArea;

        return formatNumber(numberArea);
    }

    private String formatNumber (double x) {
        String stringX = String.valueOf(x); //Cannot use toString() on primitives

        return stringX.substring(0, stringX.indexOf(".") + 3);
    }

    public static int getObjectCount () {
        return circleCounter;
    }
}
