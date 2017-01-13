import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 1/9/17.
 */
public class Student implements Comparable<Student> {
    private String studentFirstName;
    private String studentLastName;
    private int studentScore;

    public Student (String studentFirstName, String studentLastName, int studentScore) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentScore = studentScore;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public int getStudentScore() {
        return studentScore;
    }

    @Override
    public String toString () {
        return (this.getStudentFirstName() + " " + this.getStudentLastName() +
        "'s Score: " + this.getStudentScore());
    }

    public Student(String studentFirstName, String studentLastName) {
        if (studentFirstName == null || studentLastName == null)
            throw new NullPointerException();
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
    }

    public boolean equals(Object o) {
        if (!(o instanceof Student))
            return false;
        Student n = (Student) o;
        return n.studentFirstName.equals(studentFirstName) && n.studentLastName.equals(studentLastName);
    }

    public int hashCode() {
        return 31*studentFirstName.hashCode() + studentLastName.hashCode();
    }

    public int compareTo(Student n) {
        int lastCmp = studentLastName.compareTo(n.studentLastName);
        return (lastCmp != 0 ? lastCmp : studentFirstName.compareTo(n.studentFirstName));
    }
}
