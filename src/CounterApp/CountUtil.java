package CounterApp;

import Interfaces.Countable;

/**
 * Created by David on 1/20/17.
 */
public class CountUtil {
    public static void count (Countable c, int maxCount) {

        for (int i = 0; i < maxCount; i += 1) {
            c.incrementCount();
            System.out.println(c.getCountString());
        }

        c.resetCount();
    }
}
