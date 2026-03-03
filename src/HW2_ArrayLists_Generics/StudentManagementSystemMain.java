package HW2_ArrayLists_Generics;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class StudentManagementSystemMain {
    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);

        StudentManager studentManager = new StudentManager();
        CourseManager courseManager = new CourseManager();
        EnrollmentManager enrollmentManager = new EnrollmentManager(courseManager);

        /**
         * Adding sample data
         */
        // Creating students
        studentManager.addStudent(new Student("S001", "Kristi", "Kent", "kristi@university.edu", 3.5, "Computer Science", 2));
        studentManager.addStudent(new Student("S002", "Douglas", "Graves", "douglas@university.edu", 3.2, "Mathematics", 4));
        studentManager.addStudent(new Student("S003", "Troy", "O'Donnell", "troy@university.edu", 3.8, "Computer Science", 2));
        studentManager.addStudent(new Student("S004", "Sandra", "Rowland", "sandra@university.edu", 4.0, "Psychology", 3));
        studentManager.addStudent(new Student("S005", "Juan", "Velasquez", "juan@university.edu", 3.8, "Nursing", 2));
        studentManager.addStudent(new Student("S006", "Palmer", "Mack", "palmer@university.edu", 3.5, "Psychology", 4));
        studentManager.addStudent(new Student("S007", "Julia", "Davies", "julia@university.edu", 4.0, "Physics", 3));
        studentManager.addStudent(new Student("S008", "Dena", "Tran", "dena@university.edu", 2.3, "Computer Science", 3));
        studentManager.addStudent(new Student("S009", "Adela", "Klein", "adela@university.edu", 3.3, "Nursing", 4));
        studentManager.addStudent(new Student("S010", "Eddie", "Wood", "eddie@university.edu", 3.8, "Mathematics", 3));
        System.out.println();

        // Creating courses
        courseManager.addCourse(new Course("CISC3130", "Data Structures", 3, "Dr. Smith", 30));
        courseManager.addCourse(new Course("MATH1006", "Calculus I", 4, "Dr. Johnson", 25));
        courseManager.addCourse(new Course("TREM2001", "Mass Media", 3, "Eloise Coleman", 20));
        courseManager.addCourse(new Course("BIO1010", "Intro to Biology", 4, "Dr. John", 45));
        courseManager.addCourse(new Course("ENL1005", "Intro to Writing", 3, "Cassandra Wellington", 30));
        System.out.println();

        // Adding prerequisites to some courses
        courseManager.findCourse("CISC3130").addPrerequisite("MATH1006");
        courseManager.findCourse("BIO1010").addPrerequisite("ENL1005");
        courseManager.findCourse("TREM2001").addPrerequisite("ENL1005");

        // Creating enrollments
        enrollmentManager.enrollStudent("S001", "CISC3130", "Fall 2026");
        enrollmentManager.enrollStudent("S003", "CISC3130", "Fall 2026");
        enrollmentManager.enrollStudent("S008", "CISC3130", "Fall 2026");

        enrollmentManager.enrollStudent("S002", "MATH1006", "Fall 2026");
        enrollmentManager.enrollStudent("S010", "MATH1006", "Fall 2026");

        enrollmentManager.enrollStudent("S004", "TREM2001", "Fall 2026");
        enrollmentManager.enrollStudent("S006", "TREM2001", "Fall 2026");

        enrollmentManager.enrollStudent("S005", "BIO1010", "Fall 2026");
        enrollmentManager.enrollStudent("S009", "BIO1010", "Fall 2026");

        enrollmentManager.enrollStudent("S007", "ENL1005", "Fall 2026");
        System.out.println();

        int choice;

        // Menu with options of the management system
        do {
                System.out.println();
                System.out.println("---------STUDENT MANAGEMENT SYSTEM---------");
                System.out.println();
                System.out.println("Menu: ");
                System.out.println("   1.	Add Student");
                System.out.println("   2.	Remove Student");
                System.out.println("   3.	Find Student");
                System.out.println("   4.	List All Students");
                System.out.println("   5.	Add Course");
                System.out.println("   6.	Enroll Student in Course");
                System.out.println("   7.	Assign Grade");
                System.out.println("   8.   Calculate Student GPA");
                System.out.println("   9.   List All Courses");
                System.out.println("   10.  Generate Reports");
                System.out.println("   11.  List of Enrollments");
                System.out.println("   12.  Exit");
                System.out.println();
                System.out.print("Enter your choice: ");
                choice = stdin.nextInt();
                stdin.nextLine();


                switch (choice) {
                    case 1:
                        try {
                            System.out.print("Enter student ID: ");
                            String id = stdin.nextLine();
                            System.out.print("Enter first name: ");
                            String firstName = stdin.nextLine();
                            System.out.print("Enter last name: ");
                            String lastName = stdin.nextLine();
                            System.out.print("Enter email: ");
                            String email = stdin.nextLine();
                            System.out.print("Enter GPA (0.0 - 4.0): ");
                            double gpa = stdin.nextDouble();
                            stdin.nextLine();
                            System.out.print("Enter major: ");
                            String major = stdin.nextLine();
                            System.out.print("Enter year (1-4): ");
                            int year = stdin.nextInt();
                            stdin.nextLine();

                            Student student = new Student(id, firstName, lastName, email, gpa, major, year);
                            studentManager.addStudent(student);
                        } catch (InputMismatchException e) {
                            System.out.println();
                            System.out.println("Error: GPA and Year must be valid numbers.");
                            stdin.nextLine();
                        } catch (Exception e) {
                            System.out.println();
                            System.out.println("Error: Invalid input.");
                        }
                        break;
                    case 2:
                        System.out.print("Enter student ID to remove: ");
                        String removeId = stdin.nextLine().trim();
                        studentManager.removeStudent(removeId);
                        break;

                    case 3:
                        System.out.print("Enter student ID to find: ");
                        String findId = stdin.nextLine().trim();
                        Student found = studentManager.findStudent(findId);
                        if (found != null) {
                            System.out.println(found);
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 4:
                        studentManager.printAllStudents();
                        break;

                    case 5:
                        try {
                            System.out.print("Enter course code: ");
                            String code = stdin.nextLine();
                            System.out.print("Enter course name: ");
                            String name = stdin.nextLine();
                            System.out.print("Enter credits: ");
                            int credits = Integer.parseInt(stdin.nextLine());
                            System.out.print("Enter instructor: ");
                            String instructor = stdin.nextLine();
                            System.out.print("Enter max enrollment: ");
                            int maxEnroll = Integer.parseInt(stdin.nextLine());

                            Course course = new Course(code, name, credits, instructor, maxEnroll);

                            // Ask for course prerequisite
                            System.out.print("Enter a prerequisite course code (or press Enter for none): ");
                            String prereq = stdin.nextLine();

                            if (!prereq.trim().isEmpty()) {
                                course.addPrerequisite(prereq);
                                System.out.println("Prerequisite added: " + prereq);
                            } else {
                                System.out.println("No pre-courses as requisite for this course.");
                            }

                            // Add the course to the manager
                            courseManager.addCourse(course);

                        } catch (NumberFormatException e) {
                            System.out.println("Error: Credits and max enrollment must be numbers.");
                        } catch (Exception e) {
                            System.out.println("Error: Invalid input.");
                        }
                        break;
                    case 6:
                        System.out.print("Enter student ID: ");
                        String studentId = stdin.nextLine().trim();
                        System.out.print("Enter course code: ");
                        String courseCode = stdin.nextLine().trim();
                        System.out.print("Enter semester: ");
                        String semester = stdin.nextLine().trim();
                        enrollmentManager.enrollStudent(studentId, courseCode, semester);
                        break;
                    case 7:
                        System.out.print("Enter enrollment ID: ");
                        String enrollmentId = stdin.nextLine().trim();
                        System.out.print("Enter grade (A-F): ");
                        String grade = stdin.nextLine().trim().toUpperCase();
                        enrollmentManager.assignGrade(enrollmentId, grade);
                        break;

                    case 8:
                        System.out.print("Enter student ID: ");
                        String gpaStudentId = stdin.nextLine().trim();
                        double gpa = enrollmentManager.calculateStudentGpa(gpaStudentId);
                        System.out.println("GPA for " + gpaStudentId + ": " + gpa);
                        break;

                    case 9:  // Extra option for menu added by my own
                        System.out.println();
                        courseManager.printAllCourses();
                        break;

                    case 10:
                        System.out.println("Report options: ");

                        System.out.println("   1.   Student Report");
                        System.out.println("   2.   Course Report");
                        System.out.println("   3.   Major Report");
                        System.out.println("   4.   Honor Roll Report");
                        System.out.println("   5.   All Students Report");
                        System.out.println();
                        System.out.print("Insert report option to display: ");
                        int option = stdin.nextInt();
                        stdin.nextLine();
                        switch (option) {
                            case 1:
                                System.out.print("Enter student ID: ");
                                String StudentId = stdin.nextLine();
                                System.out.println();
                                ReportGenerator.generateStudentReport(StudentId, studentManager, enrollmentManager);
                                break;
                            case 2:
                                System.out.print("Enter course code: ");
                                String course_Code = stdin.nextLine();
                                ReportGenerator.generateCourseReport(course_Code, courseManager, enrollmentManager);
                                break;

                            case 3:
                                System.out.print("Enter major: ");
                                String major = stdin.nextLine();
                                ReportGenerator.generateMajorReport(major, studentManager);
                                break;

                            case 4:
                                System.out.print("Enter minimum GPA: ");
                                try {
                                    double minGpa = Double.parseDouble(stdin.nextLine());
                                    ReportGenerator.generateHonorRollReport(studentManager, minGpa);
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid GPA value.");
                                }
                                break;
                            case 5:
                                studentManager.printAllStudents();
                                break;
                            default:
                                System.out.println("Invalid report option.");
                        }
                        break;
                    case 11:  // Extra option in the menu added by my own
                        System.out.println();
                        enrollmentManager.printAllEnrollments();
                        break;
                    case 12:
                        System.out.println("Existing program...");
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
        } while (choice != 12);

    }
}
