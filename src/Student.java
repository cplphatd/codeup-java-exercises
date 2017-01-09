/**
 * Created by David on 1/9/17.
 */
public class Student {
    private String studentFirstName;
    private String studentLastName;
    private int studentAge;

    public Student (String studentFirstName, String studentLastName, int studentAge) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentAge = studentAge;
    }

    public String getStudentFirstName() {
        return studentFirstName;
    }

    public String getStudentLastName() {
        return studentLastName;
    }

    public int getStudentAge() {
        return studentAge;
    }
}
