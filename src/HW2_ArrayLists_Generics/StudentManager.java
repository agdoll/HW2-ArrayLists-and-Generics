package HW2_ArrayLists_Generics;
import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> students;

    /**
     *  Constructor
     *  Creates a new empty ArrayList to store students
     */
    public StudentManager() {
        this.students = new ArrayList<>();
    }

    /**
     *  Adds a new student to Student Manager
     *  Checks:
     *  Null StudentId, null last name and null first name of a student,
     *  avoids adding already existing students in the system, and checks
     *  for a empty StudentId, first name, and last name.
     */
    public void addStudent(Student student) {

        if (student == null
                || student.getStudentId() == null
                || student.getStudentId().trim().isEmpty()
                || student.getFirstName() == null
                || student.getFirstName().trim().isEmpty()
                || student.getLastName() == null
                || student.getLastName().trim().isEmpty()) {
            System.out.println("Error: Student not valid.");
            return;
        }

        for (Student s : students) {
            if (s.getStudentId().equals(student.getStudentId())) {
                System.out.println("Error: Cannot add Student. Student with ID " + student.getStudentId() + " already exists.");
                return;
            }
        }

        students.add(student);
        System.out.println("Student " + student.getFullName() + " added successfully.");
    }

    /**
     *  Removes a student from Student Manager using a given studentId
     *  Checks:
     *  Invalid studentIds as empty, and null studentIds. Checks also
     *  for not found (not existing) studentIds in the system.
     */
    public void removeStudent(String studentId) {

        if (studentId == null || studentId.trim().isEmpty()) {
            System.out.println("Error: Not a valid student ID.");
            return;
        }

        Student studentToRemove = null;

        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(studentId)) {
                studentToRemove = s;
                break;
            }
        }

        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Student removed successfully.");
        } else {
            System.out.println("Student not found in the system.");
        }
    }

    /**
     *  Finds and returns a student in the Manager System using studentId
     *  If not found returns null
     */
    public Student findStudent(String studentId) {
        System.out.println();
        for(int i = 0; i < students.size(); i++) {
            Student studentindex = students.get(i);
            if(studentindex.getStudentId().equalsIgnoreCase(studentId)) {
                return studentindex;
            }
        }
        return null;
    }

    /**
     *  Returns an Arraylist with all student from a given major
     *  Checks:
     *  A no existing major
     */
    public ArrayList<Student> getStudentsByMajor(String major) {
        ArrayList<Student> students = new ArrayList<>();

        for (int i = 0; i < this.students.size(); i++) {
            Student student_index = this.students.get(i);
            if (student_index.getMajor().equalsIgnoreCase(major)) {
                students.add(student_index);
            }
        }

        if(students.isEmpty()) {
            System.out.println("No students found for major " + major + ".");
        }
        return students;
    }

    /**
     *  Returns an ArrayList with all students in given university year
     */
    public ArrayList<Student> getStudentsByYear(int year){
        ArrayList<Student> students_year = new ArrayList<>();

        for (int i = 0; i < students.size(); i++) {
            Student student_index = students.get(i);
            if (student_index.getYear() == year) {
                students_year.add(student_index);
            }
        }

        return students_year;
    }

    /**
     *  Returns an Arraylist with a list of all honor students with a GPA
     *  higher or equal to given minGPA
     */
    public ArrayList<Student> getHonorStudents(double minGpa) {
        ArrayList<Student> students_honor = new ArrayList<>();

        for(int i = 0; i < students.size(); i++) {
            Student student_index = students.get(i);
            if(student_index.getGPA() >= minGpa) {
                students_honor.add(student_index);
            }
        }
        return students_honor;
    }

    /**
     *  Returns average GPA of all students
     */
    public double getAverageGpa() {
        double sum_GPA = 0;
        double num_students = 0;

        for (int i = 0; i < students.size(); i++) {
            Student student_index = students.get(i);
            sum_GPA += student_index.getGPA();
            num_students++;
        }

        double average = sum_GPA / num_students;
        average = Math.round(average * 10.0) / 10.0;

        return average;
    }

    /**
     *  Returns average GPA of all students of given major
     */
    public double getAverageGpaByMajor(String major) {
        ArrayList<Student> students_major = new ArrayList<>(getStudentsByMajor(major));
        int num_students = students_major.size();
        double GPA_major = 0;

        if (students_major.isEmpty()) {
            return 0.0;
        }

        for (int i = 0; i < students_major.size(); i++) {
            Student student_index = students_major.get(i);
            GPA_major += student_index.getGPA();
        }

        double average = GPA_major / num_students;
        average = Math.round(average * 10.0) / 10.0;

        return average;
    }

    /**
     *  Prints a formatted table with principal information of all students
     */
    public void printAllStudents() {

        if(students.isEmpty()) {
            System.out.println("No students found in the system.");
        }

        System.out.printf("%-6s %-12s %-12s %-25s %-20s %-5s %-4s\n",
                "ID", "First Name", "Last Name", "Email", "Major", "GPA", "Year");

        for (Student s : students) {
            System.out.printf("%-6s %-12s %-12s %-25s %-20s %-5.2f %-4d\n",
                    s.getStudentId(),
                    s.getFirstName(),
                    s.getLastName(),
                    s.getEmail(),
                    s.getMajor(),
                    s.getGPA(),
                    s.getYear());;
        }
    }

    /**
     *  Return number of total students in Student Manager
     */
    public int getTotalStudents() {
        return students.size();
    }

    /**
     *  Returns an arraylist with all existing majors
     */
    public ArrayList<String> getAllMajors() {
        ArrayList<String> majors = new ArrayList<>();

        for (Student student_index : students) {
            if (!majors.contains(student_index.getMajor())) {
                majors.add(student_index.getMajor());
            }
        }

        return majors;
    }
}
