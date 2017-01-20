package CounterApp;

import Interfaces.Countable;

/**
 * Created by David on 1/20/17.
 */
public class Alligator implements Countable {
    //Instance variables
    private int alligatorCount = 0;

    public void incrementCount () {
        alligatorCount += 1;
    }

    public void resetCount () {
        alligatorCount = 0;
    }

    public int getCount () {
        return alligatorCount;
    }

    public String getCountString () {
        return alligatorCount + " alligator";
    }
}
