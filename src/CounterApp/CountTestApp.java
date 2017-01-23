package CounterApp;

/**
 * Created by David on 1/20/17.
 */
public class CountTestApp {
    public static void main(String[] args) throws CloneNotSupportedException {
        //Create alligator object
        Alligator alligator = new Alligator();

        //Count three alligator objects
        System.out.println("Counting three alligators...");
        CountUtil.count(alligator, 3);

        //Create sheep object
        Sheep sheep = new Sheep("Blackie");

        //Count two sheep objects
        System.out.println("---");
        System.out.println("Counting two sheep...");
        CountUtil.count(sheep, 2);

        //Clone sheep object (since .clone() returns an object, the result is casted to <code>Sheep</code>)
        Sheep clone = (Sheep) sheep.clone();

        //Rename clone
        clone.setSheepName("Blanca");

        //Count three clone objects
        System.out.println("---");
        System.out.println("Counting three clones...");
        CountUtil.count(clone, 3);

        //Count one sheep object
        sheep.resetCount();
        System.out.println("---");
        System.out.println("Counting one sheep...");
        CountUtil.count(sheep, 1);
    }
}
