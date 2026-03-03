package HW2_ArrayLists_Generics;
import java.util.ArrayList;
import java.util.Objects;

public class Pair <K,V>{
    private K first;
    private V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    public K getFirst() {
        return first;
    }

    public void setFirst(K first) {
        this.first = first;
    }

    public V getSecond() {
        return second;
    }

    public void setSecond(V second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "First: " + first + "\nSecond: " + second;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Pair)) return false;

        Pair<?, ?> other = (Pair<?, ?>) obj;

        return Objects.equals(first, other.first) &&
                Objects.equals(second, other.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}

class MainPair {
    public static void main(String[] args) {

        ArrayList<Pair<String, Double>> courseGrades = new ArrayList<>();

        courseGrades.add(new Pair<>("CISC3130", 3.5));
        courseGrades.add(new Pair<>("MATH1006", 4.0));
        courseGrades.add(new Pair<>("BIO1505", 2.8));

        System.out.println("Course Grades:");
        for (Pair<String, Double> pair : courseGrades) {
            System.out.println(pair);
        }

        ArrayList<Pair<Student, Course>> enrollments = new ArrayList<>();

        Student s1 = new Student("S001", "Melody", "Kim", "melody@university.edu", 3.2, "Computer Science", 2);
        Student s2 = new Student("S002", "John", "Jones", "john@university.edu", 3.6, "Mathematics", 3);

        Course c1 = new Course("TREM.2021", "Media Literacy", 3, "Amina Hash-min", 20);
        Course c2 = new Course("ART.3400", "Art History", 3, "Mia Rosamund", 30);

        enrollments.add(new Pair<>(s1, c1));
        enrollments.add(new Pair<>(s1, c2));
        enrollments.add(new Pair<>(s2, c2));

        System.out.println();
        System.out.println("Enrollments:");
        for (Pair<Student, Course> enrollment : enrollments) {
            System.out.println(enrollment.getFirst().getFirstName() +
                            " enrolled in " +
                            enrollment.getSecond().getCourseName()
            );
        }
    }
}

