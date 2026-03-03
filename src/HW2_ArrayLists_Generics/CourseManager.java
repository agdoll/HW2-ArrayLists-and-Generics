package HW2_ArrayLists_Generics;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CourseManager {
    ArrayList<Course> courses;

    public CourseManager() {
        courses = new ArrayList<>();
    }

    /**
     * Adds a course to CourseManager
     * Checks:
     * Invalid course code and duplicated courses
     *
     */
    public void addCourse(Course course) {
        if (course == null || course.getCourseCode() == null || course.getCourseCode().trim().isEmpty()) {
            System.out.println("Error: Invalid course.");
            return;
        }

        // Check for duplicate courseCode
        for (Course c : courses) {
            if (c.getCourseCode().equalsIgnoreCase(course.getCourseCode())) {
                System.out.println("Error: Course with code " + course.getCourseCode() + " already exists.");
                return;
            }
        }

        courses.add(course);
        System.out.println("Course " + course.getCourseName() + " added successfully.");
    }

    /**
     * Returns and finds a course using courseCode
     * checks: course null
     */
    public Course findCourse(String courseCode) {
        if (courseCode == null || courses.isEmpty()) {
            return null;
        }


        for (int i = 0; i < courses.size(); i++) {
            Course course_index = courses.get(i);
            if (course_index.getCourseCode().equals(courseCode)) {
                return course_index;
            }
        }

        return null;
    }

    /**
     * Returns all courses by instructor
     */
    public ArrayList<Course> getCoursesByInstructor(String instructor) {
        ArrayList<Course> instructor_course = new ArrayList<>();

        for (int i = 0; i < courses.size(); i++) {
            Course index_course = courses.get(i);
            if (index_course.getInstructor().equalsIgnoreCase(instructor)) {
                instructor_course.add(index_course);
            }
        }

        return null;
    }


    /**
     *  Returns courses available to enroll
     *  Checks:
     *  If student passed all prerequisites, and if is not already enrolled in
     *  a course
     */
    public ArrayList<Course> getAvailableCourses(String studentId,
                                                 StudentManager studentManager,
                                                 EnrollmentManager enrollmentManager) {
        ArrayList<Course> available_course = new ArrayList<>();

        for (int i = 0; i < courses.size(); i++) {
            Course course_index = courses.get(i);
            boolean enrolled = false;
            ArrayList<Enrollment> students_enrollments = enrollmentManager.getEnrollmentsByStudent(studentId);

            for (Enrollment e : students_enrollments) {
                if (e.getCourseCode().equals(course_index.getCourseCode())) {
                    enrolled = true;
                    break;
                }
            }
            if (enrolled) continue;


            boolean prereqsMet = true;
            for (String prereqCode : course_index.getPrerequisites()) {
                boolean passed = false;
                for (Enrollment e : students_enrollments) {
                    if (e.getCourseCode().equals(prereqCode) && e.isPassing()) {
                        passed = true;
                        break;
                    }
                }
                if (!passed) {
                    prereqsMet = false;
                    break;
                }
            }
            if (prereqsMet) {
                available_course.add(course_index);

            }
        }

        return available_course;
    }

    /**
     * Prints all courses
     * Checks:
     * Empty courses arrayList
     */
    public void printAllCourses() {
        if (courses.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }

        for (Course c : courses) {
            System.out.println(c);
            System.out.println();
        }
    }

    /**
     * Returns the total of courses in the arraylist
     */
    public int getTotalCourses() {
        return courses.size();
    }
}



