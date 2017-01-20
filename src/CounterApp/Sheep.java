package CounterApp;

import Interfaces.Countable;

/**
 * Created by David on 1/20/17.
 */
public class Sheep implements Countable, Cloneable{
    //Instance variables
    private int sheepCounter = 0;
    private String sheepName;

    public Sheep (String sheepName) {
        this.sheepName = sheepName;
    }

    public void incrementCount () {
        sheepCounter += 1;
    }

    public void resetCount () {
        sheepCounter = 0;
    }

    public int getCount () {
        return sheepCounter;
    }

    public String getCountString () {
        return sheepCounter + " " + sheepName;
    }

    public void setSheepName(String sheepName) {
        this.sheepName = sheepName;
    }

    public String getSheepName() {
        return sheepName;
    }

    @Override
    public Object clone () throws CloneNotSupportedException {
        return super.clone();
    }
}
