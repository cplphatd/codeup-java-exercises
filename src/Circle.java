/**
 * Created by David on 1/9/17.
 */
public class Circle {
    //Variables
    double userRadius;
    public static int circleCounter = 0;

    public Circle (double userRadius) {
        this.userRadius = userRadius;
        circleCounter += 1;
    }

    public double getCircumference () {
        return 2*Math.PI*this.userRadius;
    }

    public String getFormattedCircumference () {
        double numberCircumference = getCircumference();

        return formatNumber(numberCircumference);
    }

    public double getArea () {
        return Math.PI*(Math.pow(this.userRadius, 2));
    }

    public String getFormattedArea () {
        double numberArea = getArea();

        return formatNumber(numberArea);
    }

    private String formatNumber (double x) {
        String stringX = String.valueOf(x); //Cannot use toString() on primitives

        return stringX.substring(0, stringX.indexOf(".") + 3);
    }

    public static int getObjectCount () {
        return
                circleCounter;
    }
}
