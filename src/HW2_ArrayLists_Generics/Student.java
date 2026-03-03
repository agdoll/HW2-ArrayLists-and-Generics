package HW2_ArrayLists_Generics;
import HW1_Vectors_Generics.Product;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private String studentId;
    private String firstName;
    private String lastName;
    private String email;
    private double GPA; // 0.0 to 4.0
    private String major;
    private int year; // 1 = Freshman, 2 = Sophomore, 3 = Junior, 4 = Senior

    /**
     *  Constructor
     *  Initializes all fields with given values
     */
    public Student (String studentId, String firstName, String lastName, String email,
                    double GPA, String major, int year){
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.GPA = GPA;
        this.major = major;
        this.year = year;
    }

    /**
     *  Getters and Setters for private fields
     */
    public String getStudentId() {return this.studentId;}
    public void setStudentId(String studentId) { this.studentId = studentId;}
    public String getFirstName() { return this.firstName;}
    public void setFirstName(String firstName) { this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public double getGPA() {return GPA;}
    public void setGPA(double GPA) {this.GPA = GPA;}
    public int getYear() {return year;}
    public void setYear(int year) {this.year = year;}
    public String getMajor() {return major;}
    public void setMajor(String major) {this.major = major;}

    /**
     *  Returns a formatted String of Student objects
     */
    public String toString() {
        return "Student ID: " + studentId +
                "\nFirst name: " + firstName +
                "\nLast name: " + lastName +
                "\nEmail: " + email +
                "\nGPA: " + GPA +
                "\nMajor: " + major +
                "\nYear: " + year;
    }

    /**
     *  Checks and ensures for no studentId duplicates
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Student student = (Student) obj;
        return Objects.equals(studentId, student.studentId);
    }

    /**
     * Generates a hash code based on studentId to ensure unique studentIds
     */
    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }

    /**
     * Returns a student full name
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     * Compares students GPA
     * (Compare students by GPA for use with generic findMax() method inside
     * class "ArrayListUtils")
     */
    @Override
    public int compareTo(Student other) {
        return Double.compare(this.GPA, other.GPA);
    }
}
