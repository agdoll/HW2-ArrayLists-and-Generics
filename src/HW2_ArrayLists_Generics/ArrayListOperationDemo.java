package HW2_ArrayLists_Generics;
import java.util.*;

class ArrayListOperationDemo {
    public static void main(String[] args) {

        // Convert array to arraylist
        Student[] arr_student1 = {
                new Student("S001", "Melody", "Kim", "melody@university.edu", 3.2, "Computer Science", 2),
                new Student("S002", "John", "Jones", "john@university.edu", 3.6, "Mathematics", 3),
                new Student("S003", "Rose", "White", "rose@university.edu", 3.9, "Business", 2)
        };

        System.out.println("*Original Array:*");
        System.out.println();
        for (Student s : arr_student1) {
            System.out.println(s);
            System.out.println("-------------------------");
        }

        ArrayList<Student> arrlist_student1 = new ArrayList<>(Arrays.asList(arr_student1));

        System.out.println();
        System.out.println("*ArrayList after conversion:*");
        System.out.println();
        for (Student s : arrlist_student1) {
            System.out.println(s);
            System.out.println("-------------------------");
        }

        arrlist_student1.add(new Student("S004", "Lucy",
                "Collen", "lucy@university.edu", 2.1,
                "Fine Arts", 2));
        arrlist_student1.remove(0); // Removing melody

        System.out.println();
        System.out.println("*ArrayList after add a student and remove student:* ");
        System.out.println();
        for (Student s : arrlist_student1) {
            System.out.println(s);
            System.out.println("-------------------------");
        }

        // Convert arrayList to array
        ArrayList<Student> arrlist_student2 = new ArrayList<>();
        arrlist_student2.add(new Student("S001", "Melody", "Kim", "melody@university.edu", 3.2, "Computer Science", 2));
        arrlist_student2.add(new Student("S002", "John", "Jones", "john@university.edu", 1.5, "Nursing", 3));
        arrlist_student2.add(new Student("S003", "Rose", "White", "rose@university.edu", 2.9, "Computer Science", 2));

        Student[] arr_student2 = arrlist_student2.toArray(new Student[0]);

        System.out.println();
        System.out.println("*ArrayList version:* ");
        System.out.println();
        for (Student s : arrlist_student2) {
            System.out.println(s);
            System.out.println("-------------------------");
        }
        System.out.println();
        System.out.println("*Array version:* ");
        System.out.println();
        for (Student s : arr_student2) {
            System.out.println(s);
            System.out.println("-------------------------");
        }

        // Sublist operations
        /* note: sublist is just for arraylists, it does not work with normal arrays  */
        arrlist_student2.add(new Student("S004", "Isabela", "Petrov", "isabela@university.edu", 3.2, "Nursing", 2));
        arrlist_student2.add(new Student("S005", "Maria", "Cruz", "maria@university.edu", 2.3, "Fine Arts", 4));
        arrlist_student2.add(new Student("S006", "Selena", "Perez", "selena@university.edu", 1.7, "Biology", 1));

        System.out.println();
        System.out.println("*ArrayList student before sublist modifications:* ");
        System.out.println();
        for (Student s : arrlist_student2) {
            System.out.println(s);
            System.out.println("-------------------------");
        }
        System.out.println();
        List<Student> sublist = arrlist_student2.subList(0, 4);
        System.out.println("*Sublist content portion from arraylist student:* ");
        System.out.println();
        for (Student s : sublist) {
            System.out.println(s);
            System.out.println("-------------------------");
        }
        System.out.println();

        sublist.remove(0);
        sublist.remove(1);

        System.out.println("*ArrayList student after sublist modifications:* ");
        System.out.println();
        for (Student s : arrlist_student2) {
            System.out.println(s);
            System.out.println("-------------------------");
        }

        /* Note for me: How subList() and removal work in ArrayLists
         ---- subList() is NOT a copy of an arraylist
         * subList(fromIndex, toIndex) creates a view of the original list.
         * Any changes made to the sublist (add, remove, set)
         will affect the original list.

         ---- Indexes shift after removal
         * When you remove an element using remove(index):
         * All elements to the right shift one position left.
         * The list size decreases by 1.

         */

        // Sorting students by GPA
        ArrayList<Student> arrlist_student3 = new ArrayList<>();
        arrlist_student3.add(new Student("S001", "Melody", "Kim", "melody@university.edu", 3.2, "Computer Science", 2));
        arrlist_student3.add(new Student("S002", "John", "Jones", "john@university.edu", 3.8, "Mathematics", 3));
        arrlist_student3.add(new Student("S003", "Rose", "White", "rose@university.edu", 3.5, "Computer Science", 2));
        arrlist_student3.add(new Student("S004", "Adam", "Brown", "adam@university.edu", 3.9, "Physics", 1));

        System.out.println();
        System.out.println("*Original List:*");
        System.out.println();
        for (Student s : arrlist_student3) {
            System.out.println(s);
            System.out.println();
        }

        Collections.sort(arrlist_student3, new StudentGpaDescendingComparator());
        System.out.println();
        System.out.println("*Sorted by GPA descending:*");
        System.out.println();
        for (Student s : arrlist_student3) {
            System.out.println(s);
            System.out.println();
        }

        Collections.sort(arrlist_student3, new StudentLastNameComparator());
        System.out.println();
        System.out.println("Sorted by last name:");
        System.out.println();
        for (Student s : arrlist_student3) {
            System.out.println(s);
            System.out.println("-------------------------");
        }
        System.out.println();
        
        ArrayList<Student> arrlist_student4 = new ArrayList<>();
        arrlist_student4.add(new Student("S001", "Melody", "Kim", "melody@university.edu", 3.2, "Computer Science", 2));
        arrlist_student4.add(new Student("S002", "John", "Jones", "john@university.edu", 3.8, "Mathematics", 3));
        arrlist_student4.add(new Student("S003", "Rose", "White", "rose@university.edu", 3.5, "Computer Science", 2));
        arrlist_student4.add(new Student("S004", "Adam", "Brown", "adam@university.edu", 3.9, "Physics", 1));
        arrlist_student4.add(new Student("S005", "Roman", "Torres", "roman@university.edu", 3.1, "Business", 2));
        arrlist_student4.add(new Student("S006", "Daisy", "Junior", "daisy@university.edu", 2.8, "Physics", 2));
        arrlist_student4.add(new Student("S007", "Margaret", "Styles", "margaret@university.edu", 4.0, "Mathematics", 2));
        arrlist_student4.add(new Student("S008", "Jean", "Gomez", "jean@university.edu", 3.2, "Physics", 1));

        // ArrayList searching
        // Find student
        Student student_to_find = new Student("S003", "Rose",
                "White", "rose@university.edu", 3.5,
                "Computer Science", 2);

        int index_student = arrlist_student4.indexOf(student_to_find);
        System.out.println();
        System.out.println("Index of student is: " + index_student);
        System.out.println();

        // Contains student
        if (arrlist_student4.contains(student_to_find)) {
            System.out.println(student_to_find.getFullName() + " is on the list.");
        }
        System.out.println();

        // Collections.binarySearch()
        // note: I'm using "arrlist_stduent4" sorted by alphabetic order.

        // Sorting using last name
        Collections.sort(arrlist_student4, new StudentLastNameComparator());

        Student student_search = new Student("S004",
                "Adam", "Brown", "adam@university.edu",
                3.9, "Physics", 1);

        // Binary search
        int index = Collections.binarySearch(arrlist_student4,
                student_search, new StudentLastNameComparator());

        if(index >= 0) {
            System.out.println("Student " + student_search.getFullName() +
                    " found at index " + index);
        }
    }
}

class StudentGpaDescendingComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return Double.compare(s2.getGPA(), s1.getGPA());
    }
}

class StudentLastNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getLastName().compareToIgnoreCase(s2.getLastName());
    }
}