/**
 * Created by David on 1/17/17.
 */
public enum MovieCategory {
    ANIMATED ("animated"), DRAMA ("drama"), HORROR ("horror"), SCIFI ("scifi"), MUSICAL ("musical");

    private final String stringCategory;

    MovieCategory (String s) {
        stringCategory = s;
    }

    public String toString () {
        return this.stringCategory;
    }
}
