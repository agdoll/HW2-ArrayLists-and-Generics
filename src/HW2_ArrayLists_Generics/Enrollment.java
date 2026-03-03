package HW2_ArrayLists_Generics;

public class Enrollment {
    private String enrollmentId;
    private String studentId;
    private String courseCode;
    private String grade;
    private String semester;

    /**
     *  Constructor
     *  Initializes all fields with given values
     */
    public Enrollment(String enrollmentId, String studentId, String courseCode,
                      String grade, String semester) {
        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.grade = grade;
        this.semester = semester;
    }

    /**
     *  Constructor for "EnrollmentManager" method
     */
    public Enrollment(String enrollmentId, String studentId, String courseCode,
                      String semester) {

        this.enrollmentId = enrollmentId;
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.semester = semester;
        this.grade = null;
    }

    /**
     *  Getters and Setters
     */
    public String getEnrollmentId() {return enrollmentId;}
    public void setEnrollmentId(String enrollmentId) {this.enrollmentId = enrollmentId;}
    public String getStudentId() {return studentId;}
    public void setStudentId(String studentId) {this.studentId = studentId;}
    public String getCourseCode() {return courseCode;}
    public void setCourseCode(String courseCode) {this.courseCode = courseCode;}
    public String getGrade() {return grade;}
    public void setGrade(String grade) {this.grade = grade;}
    public String getSemester() {return semester;}
    public void setSemester(String semester) {this.semester = semester;}

    /**
     *  Returns a formatted String of an Enrollment object
     */
    public String toString() {
        return "\nEnrollment ID: " + enrollmentId+
                "\nStudent ID: " + studentId +
                "\nCourse code: " + courseCode +
                "\nGrade: " + grade +
                "\nSemester: " + semester;
    }

    /**
     *  Returns the equivalent points of a letter grade
     */
    public double getGradePoints() {

        if (grade == null) {
            return 0.0;
        }

        switch (grade.toUpperCase()) {
            case "A":
                return 4.0;
            case "B":
                return 3.0;
            case "C":
                return 2.0;
            case "D":
                return 1.0;
            case "F":
                return 0.0;
            default:
                return 0.0;
        }
    }

    /**
     *  Returns true for passing grades A, B, C, and D.
     *  Check: grade null or not passing grade for F.
     */
    public boolean isPassing() {
        if(grade == null) {
            return false;
        }

        if (grade.equalsIgnoreCase("A") ||
                grade.equalsIgnoreCase(("B")) ||
                grade.equalsIgnoreCase("C") ||
                grade.equalsIgnoreCase("D")) {
            return true;
        } else {
            return false;
        }
    }
}
