package HW2_ArrayLists_Generics;
import java.util.ArrayList;

public class EnrollmentManager {
    private ArrayList<Enrollment> enrollments;
    private CourseManager courseManager; // reference to CourseManager
    private int enrollmentCounter; // counter for enrollmentsId

    /**
     * Constructor
     *  Initializes all fields with given values
     */
    public EnrollmentManager(CourseManager courseManager) {
        this.enrollments = new ArrayList<>();
        this.courseManager = courseManager;
        this.enrollmentCounter = 1;
    }

    /**
     *  Creates enrollment of a student for a class.
     *  Checks:
     *  A null course as not found, if a course is full, or if student
     *  is already enrolled in course.
     *
     *  Implementation and "error" fixed: enrollmentCounter added
     *  to assign a enrollmentId to each student.
     */
    public void enrollStudent(String studentId, String courseCode, String semester) {
        Course course = courseManager.findCourse(courseCode);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        if (getEnrollmentCount(courseCode) >= course.getMaxEnrollment()) {
            System.out.println("Course full. Cannot enroll.");
            return;
        }

        for (Enrollment e : enrollments) {
            if (e.getStudentId().equals(studentId) && e.getCourseCode().equals(courseCode)) {
                System.out.println("Student already enrolled in this course.");
                return;
            }
        }

        // Assigns a different enrollmentId to each student using a counter
        String enrollmentId = "E" + enrollmentCounter;
        enrollmentCounter++;

        Enrollment enrollment = new Enrollment(enrollmentId, studentId, courseCode, semester);
        enrollments.add(enrollment);

        System.out.println("Enrollment created successfully with ID: " + enrollmentId);
    }


    /**
     *  Removes an enrollment using enrollmentId
     *  checks:
     *  Returns false if enrollmentId given is not found
     */
    public boolean dropEnrollment(String enrollmentId) {

        for (int i = 0; i < enrollments.size(); i++) {
            Enrollment enroll_index = enrollments.get(i);
            if (enroll_index.getEnrollmentId().equals(enrollmentId)) {
                enrollments.remove(i);
                return true;
            }
        }

        return false;
    }

    /**
     *  Returns and finds enrollment by using a enrollmentId
     *  Checks: if not found returns null value
     */
    public Enrollment findEnrollment(String enrollmentId) {

        for (int i = 0; i < enrollments.size(); i++) {
            Enrollment enroll_index = enrollments.get(i);
            if(enroll_index.getEnrollmentId().equals(enrollmentId)) {
                return enroll_index;
            }
        }

        return null;
    }

    /**
     *  Returns an arraylist with all enrollments of a student
     *  using given studentId
     */
    public ArrayList<Enrollment> getEnrollmentsByStudent(String studentId){
        ArrayList<Enrollment> enroll_student = new ArrayList<>();

        for(int i = 0; i < enrollments.size(); i++) {
            Enrollment enroll_index = enrollments.get(i);
            if (enroll_index.getStudentId().equals(studentId)) {
                enroll_student.add(enroll_index);
            }
        }

        return enroll_student;
    }

    /**
     *  Returns an arraylist with all enrollments of a course
     *  using given courseCode
     */
    public ArrayList<Enrollment> getEnrollmentsByCourse(String courseCode) {
        ArrayList<Enrollment> enroll_course = new ArrayList<>();

        for(int i = 0; i < enrollments.size(); i++) {
            Enrollment enroll_index = enrollments.get(i);
            if (enroll_index.getCourseCode().equals(courseCode)) {
                enroll_course.add(enroll_index);
            }
        }

        return enroll_course;
    }

    /**
     *  Assigns letter grade to a student enrolled in a course
     *  using its enrollmentId
     *  Checks:
     *  Invalid grades that are not letter between A and F and
     *  assign a grade null. If enrollmentId provided not exist
     *
     */
    public void assignGrade(String enrollmentId, String grade) {

        if (grade == null) {
            System.out.println("Invalid grade.");
            return;
        }

        grade = grade.toUpperCase();

        if (!grade.equals("A") && !grade.equals("B") &&
                !grade.equals("C") && !grade.equals("D") &&
                !grade.equals("F")) {

            System.out.println("Invalid letter grade. Must be A, B, C, D, or F.");
            return;
        }

        Enrollment e = findEnrollment(enrollmentId);

        if (e == null) {
            System.out.println("Enrollment not found.");
            return;
        }

        e.setGrade(grade);
        System.out.println("Grade assigned successfully.");
    }

    /**
     *  Calculates GPA of student in enrolled course by using studentId
     *  Checks:
     *  If grades are null they are not graded yet and enrollmentId not
     *  found
     */
    public double calculateStudentGpa(String studentId) {
        ArrayList<Enrollment> student_enrollments = getEnrollmentsByStudent(studentId);

        if (student_enrollments.isEmpty()) {
            System.out.println("No enrollments found for student.");
            return 0.0;
        }

        double total_points = 0;
        int graded_courses = 0;

        for (Enrollment e : student_enrollments) {
            if (e.getGrade() != null) {
                total_points += e.getGradePoints();
                graded_courses++;
            }
        }

        if (graded_courses == 0) {
            System.out.println("No grades assigned yet for student.");
            return 0.0;
        }

        double gpa = total_points / graded_courses;
        gpa = Math.round(gpa * 100.0) / 100.0;
        return gpa;
    }

    /**
     *  Returns an arraylist of studentsIds enrolled in given course
     */
    public ArrayList<String> getStudentsInCourse(String courseCode) {

        ArrayList<String> students_course = new ArrayList<>();

        for(int i = 0; i < enrollments.size(); i++) {
            Enrollment enroll_index = enrollments.get(i);
            if(enroll_index.getCourseCode().equals(courseCode)) {
                students_course.add(enroll_index.getStudentId());
            }
        }
        return students_course;
    }

    /**
     *  Returns number of students enrolled in given course
     */
    public int getEnrollmentCount(String courseCode) {
        int num_students = 0;

        for(int i = 0; i < enrollments.size(); i++) {
            Enrollment enroll_index = enrollments.get(i);
            if (enroll_index.getCourseCode().equals(courseCode)) {
                num_students++;
            }
        }

        return num_students;
    }


    /**
     *  Prints all enrollments in the system
     *  Checks:
     *  No enrollments found if arraylist is empty
     */
    public void printAllEnrollments() {
        if (enrollments.isEmpty()) {
            System.out.println("No enrollments found.");
            return;
        }

        for (Enrollment e : enrollments) {
            System.out.println(e);
        }
    }


}
