package HW2_ArrayLists_Generics;
import HW1_Vectors_Generics.Product;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class ArrayListVsArrayDemo {
    public static void main(String[] args) {

        ArrayList<Student> studentArrayList = new ArrayList<>();
        Student[] studentArray = new Student[6];

        // Adding elements to both
        studentArrayList.add(new Student("S001", "Melody", "Kim", "melody@university.edu", 3.2, "Computer Science", 2));
        studentArrayList.add(new Student("S002", "John", "Jones", "john@university.edu", 3.8, "Mathematics", 3));
        studentArrayList.add(new Student("S003", "Rose", "White", "rose@university.edu", 3.5, "Computer Science", 2));
        studentArrayList.add(new Student("S004", "Adam", "Brown", "adam@university.edu", 3.9, "Physics", 1));
        studentArrayList.add(new Student("S005", "Roman", "Torres", "roman@university.edu", 3.1, "Business", 2));
        studentArrayList.add(new Student("S006", "Daisy", "Junior", "daisy@university.edu", 2.8, "Physics", 2));

        studentArray[0] = new Student("S001", "Melody", "Kim", "melody@university.edu", 3.2, "Computer Science", 2);
        studentArray[1] = new Student("S002", "John", "Jones", "john@university.edu", 3.8, "Mathematics", 3);
        studentArray[2] = new Student("S003", "Rose", "White", "rose@university.edu", 3.5, "Computer Science", 2);
        studentArray[3] = new Student("S004", "Adam", "Brown", "adam@university.edu", 3.9, "Physics", 1);
        studentArray[4] = new Student("S005", "Roman", "Torres", "roman@university.edu", 3.1, "Business", 2);
        studentArray[5] = new Student("S006", "Daisy", "Junior", "daisy@university.edu", 2.8, "Physics", 2);

        System.out.println("*Original arraylist:*");
        System.out.println();
        for (Student s : studentArrayList) {
            System.out.println(s);
            System.out.println("-------------------------");
        }
        System.out.println();
        System.out.println("*Original array:*");
        System.out.println();
        for (Student s : studentArray) {
            System.out.println(s);
            System.out.println("-------------------------");
        }

        /* If I want to add one more element to the arraylist I can do it
        easily and without any problem using "add()" */
        studentArrayList.add(new Student("S007", "Dante", "Ulrich", "dante@university.edu", 3.7, "Psychology", 3));

        /* But if I want to add one more element to the array I need to resize
        the array to do it because is fixed size.*/

        // Removing elements to both
        studentArrayList.remove(3); // removing Adam
        System.out.println();
        /* I can remove any element that I want from arraylist by using remove()
        * and it will be deleted without any problem. The elements will be moved
        * to the left and the arraylist will reduce their size as I keep removing
        * elements.*/
        System.out.println("ArrayList removing student Adam (middle element):");
        for(Student s: studentArrayList) {
            System.out.println(s);
            System.out.println();
        }

        /*
        I can not remove from array an element of the middle easy because arrays have
         fixed size. Removing an element from the middle could require
          manually shifting all the remaining elements to the left.
         */

        // resize
        /* ArrayList do auto-resize while I add new elements. */
        studentArrayList.add(new Student("S008", "Martina", "Bench", "martina@university.edu", 3.5, "Psychology", 3));

        /* Array to do resize I must create a new array and enter all the
         elements manually. This is a big limitation about arrays because of
         their fixed size. */

        System.out.println("New arraylist size: " + studentArrayList.size());
        System.out.println("Array size: " + studentArray.length);

        // Measure Perfomance
        ArrayList<Student> s_arraylist = new ArrayList<>();
        int num = 10000;
        Student[] s_array = new Student[num];

        // Adding 10,000 students

        // array list
        long startAddingArrayList = System.nanoTime();
        for (int i = 0; i <= 10000; i++) {
           s_arraylist.add(new Student("IdStudent", "Name", "LastName", "name@university.edu", 3.5, "Major", 3));
        }
        long endAddingArrayList = System.nanoTime();
        long TotalAddingTimeArrayList = endAddingArrayList - startAddingArrayList;

        // array
        long startAddingArray = System.nanoTime();
        for(int j = 0; j < s_array.length; j++) {
            s_array[j] = (new Student("IdStudent", "Name", "LastName", "name@university.edu", 3.5, "Major", 3));
        }
        long endAddingArray = System.nanoTime();
        long TotalAddingTimeArray = endAddingArray - startAddingArray;

        // Accessing to 1,000 students
        Random rand = new Random();
        // arraylist
        long startAccesingArrayList = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            s_arraylist.get(rand.nextInt(num));
        }
        long endAccesingArrayList = System.nanoTime();
        Long TotalAccesingTimeArrayList = endAccesingArrayList - startAccesingArrayList;

        // array
        long startAccesingArray = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            Student a =  s_array[rand.nextInt(num)];
        }
        long endAccesingArray = System.nanoTime();
        long TotalAccesingTimeArray = endAccesingArray - startAccesingArray;


        // Results
        System.out.println("-------------------------------------------------");
        System.out.println("         ARRAYLIST AND ARRAY COMPARISON          ");
        System.out.println("-------------------------------------------------");
        System.out.println("ArrayList adding time (10,000 elements): " + TotalAddingTimeArrayList + " ns");
        System.out.println("ArrayList access random students (1,000 elements): " + TotalAccesingTimeArrayList + " ns");
        System.out.println();
        System.out.println("Array add time (10,000 elements): " + TotalAddingTimeArray + " ns");
        System.out.println("Array access random (1,000 elements): " + TotalAccesingTimeArray + " ns");
        System.out.println("-------------------------------------------------");

        /* Summary:
        - Array is better to use when you know how many elements you need to store.
        - ArrayList is better to use when you need flexibility in sizing.
        - ArrayList if you want to perform action like remove or add easier.
        - ArrayList is slower and Array is faster regarding time.
         */
    }
}

