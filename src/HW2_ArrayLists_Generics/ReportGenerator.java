package HW2_ArrayLists_Generics;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class ReportGenerator {

    public static void generateStudentReport(String studentId, StudentManager sm, EnrollmentManager em) {

        if (studentId == null || studentId.trim().isEmpty()) {
            System.out.println("Invalid student ID.");
            return;
        }

        Student student = sm.findStudent(studentId);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        System.out.println("----- STUDENT REPORT -----");
        System.out.println(student);

        ArrayList<Enrollment> enrollments = em.getEnrollmentsByStudent(studentId);

        if (enrollments == null || enrollments.isEmpty()) {
            System.out.println("No courses enrolled.");
        } else {
            System.out.println("Enrolled Courses:");
            for (Enrollment e : enrollments) {
                System.out.println("Course: " + e.getCourseCode()
                        + " | Grade: " + e.getGrade());
            }
        }

        double gpa = em.calculateStudentGpa(studentId);
        System.out.println("Current GPA: " + gpa);
    }

    public static void generateCourseReport(String courseCode, CourseManager cm, EnrollmentManager em) {

        if (courseCode == null || courseCode.trim().isEmpty()) {
            System.out.println("Invalid course code.");
            return;
        }

        Course course = cm.findCourse(courseCode);

        if (course == null) {
            System.out.println("Course not found.");
            return;
        }

        System.out.println();
        System.out.println("----- COURSE REPORT -----");
        System.out.println(course);

        ArrayList<Enrollment> enrollments = em.getEnrollmentsByCourse(courseCode);

        if (enrollments == null || enrollments.isEmpty()) {
            System.out.println("No students enrolled.");
            return;
        }

        double totalPoints = 0;
        int gradedCount = 0;

        System.out.println();
        System.out.println("Enrolled Students:");

        for (Enrollment e : enrollments) {

            System.out.println("Student ID: " + e.getStudentId()
                    + " | Grade: " + e.getGrade());

            if (e.getGrade() != null) {
                totalPoints += e.getGradePoints();
                gradedCount++;
            }
        }

        if (gradedCount > 0) {
            double average = totalPoints / gradedCount;
            average = Math.round(average * 10.0) / 10.0;
            System.out.println("Average Grade (GPA scale): " + average);
        } else {
            System.out.println("No grades assigned yet.");
        }
    }

    public static void generateMajorReport(String major, StudentManager sm) {

        if (major == null || major.trim().isEmpty()) {
            System.out.println("Invalid major.");
            return;
        }

        ArrayList<Student> students = sm.getStudentsByMajor(major);

        if (students.isEmpty()) {
            return;
        }

        System.out.println();
        System.out.println("----- MAJOR REPORT: " + major + " -----");

        for (Student s : students) {
            System.out.println(s);
            System.out.println();
        }

        double average = sm.getAverageGpaByMajor(major);
        System.out.println("Average GPA: " + average);
    }


    public static void generateHonorRollReport(StudentManager sm, double minGpa) {

        if (minGpa < 0 || minGpa > 4.0) {
            System.out.println("Invalid GPA threshold.");
            return;
        }

        ArrayList<Student> honorStudents = sm.getHonorStudents(minGpa);

        if (honorStudents.isEmpty()) {
            return;
        }

        System.out.println("----- HONOR ROLL (GPA >= " + minGpa + ") -----");

        for (Student s : honorStudents) {
            System.out.println(s);
            System.out.println("-------------------------------");
        }
    }

}

