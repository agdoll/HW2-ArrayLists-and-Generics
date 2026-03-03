package HW2_ArrayLists_Generics;
import java.util.ArrayList;

public class Course {
    private String courseCode;
    private String courseName;
    private int credits;
    private String instructor;
    private int maxEnrollment;
    private ArrayList<String> prerequisites;

    /**
     * Constructor
     * Initializes all fields with given values
     */
    public Course(String courseCode, String courseName, int credits, String instructor,
                  int maxEnrollment) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.credits = credits;
        this.instructor = instructor;
        this.maxEnrollment = maxEnrollment;
        this.prerequisites = new ArrayList<>();
    }

    /**
     * Getters and Setters for private values
     */
    public String getCourseCode() {return courseCode;}
    public void setCourseCode(String courseCode) {this.courseCode = courseCode;}
    public String getCourseName() {return courseName;}
    public void setCourseName(String courseName) {this.courseName = courseName;}
    public int getCredits() {return credits;}
    public void setCredits(int credits) {this.credits = credits;}
    public String getInstructor() {return instructor;}
    public void setInstructor(String instructor) {this.instructor = instructor;}
    public int getMaxEnrollment() {return maxEnrollment;}
    public void setMaxEnrollment(int maxEnrollment) {this.maxEnrollment = maxEnrollment;}


    /**
     *  Returns a formatted String of a Course object
     */
    public String toString() {
        return "Course Code: " + courseCode +
                "\nCourse name: " + courseName +
                "\nCredits: " + credits +
                "\nInstructor: " + instructor +
                "\nMax Enrollment: " + maxEnrollment +
                "\nPrerequisites: " + prerequisites ;
    }

    /**
     *  Adds a course prerequisite to the course's prerequisites list
     */
    public void addPrerequisite(String courseCode) {
        if(!prerequisites.contains(courseCode)) {
            prerequisites.add(courseCode);
        }
    }

    /**
     * Checks if a course is a prerequisite to enroll in another course
     *  Returns true if founds a prerequisite in the course's prerequisite
     *  list, and false if is not found
     */
    public boolean hasPrerequisite(String courseCode) {
        if(prerequisites.contains(courseCode)) {
            return true;
        }
        return false;
    }


    /**
     *  Returns an ArrayList copy with a course prerequisite courses
     */
    public ArrayList<String> getPrerequisites() {
        return new ArrayList<>(prerequisites);
    }

}
