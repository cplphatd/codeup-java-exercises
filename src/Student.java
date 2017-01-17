/**
 * <p>The <code>Student</code> class takes in string values for student first and last names, and
 * integer values for the student's score.  The values are passed into a constructor to create
 * a student object with those properties.</p>
 *
 * @author David Ryan Alviola
 * @since  9 January 2017
 */
public class Student implements Comparable<Student> {
    private String studentFirstName;
    private String studentLastName;
    private int studentScore;

    /**
     * <p>The constructor for the <code>Student</code> class.</p>
     *
     * @param studentFirstName a string that is the student's first name
     * @param studentLastName a string that is the student's last name
     * @param studentScore an integer that is the student's score
     */
    public Student (String studentFirstName, String studentLastName, int studentScore) {
        this.studentFirstName = studentFirstName;
        this.studentLastName = studentLastName;
        this.studentScore = studentScore;
    }

    /**
     * @return string value of the student's first name
     */
    public String getStudentFirstName() {
        return studentFirstName;
    }

    /**
     * @return string value of the student's last name
     */
    public String getStudentLastName() {
        return studentLastName;
    }

    /**
     * @return integer value of the student's score
     */
    public int getStudentScore() {
        return studentScore;
    }

    /**
     * <p>Overrides the default <code>toString()</code> method to output a legible format of the
     * <code>Student</code> object.</p>
     * @return string value of the Student object
     */
    @Override
    public String toString () {
        return (this.getStudentFirstName() + " " + this.getStudentLastName() +
        " - Score: " + this.getStudentScore());
    }

    /**
     *<p>The remaining methods are used to sort a collection of <code>Student</code> objects by the studentLastName
     * property and then the studentFirstName property.</p>
     *
     * <p>See <a href = "https://docs.oracle.com/javase/tutorial/collections/interfaces/order.html">link</a>
     * for more information and source.</p>
     */
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
