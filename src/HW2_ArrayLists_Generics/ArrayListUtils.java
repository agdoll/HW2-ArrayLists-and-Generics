package HW2_ArrayLists_Generics;
import HW1_Vectors_Generics.VectorComparisonDemo;

import java.util.ArrayList;
import java.util.Vector;

public class ArrayListUtils {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("Rose");
        names.add("Kevin");
        names.add("Lucy");
        names.add("Isabella");
        names.add("Jeremy");

        ArrayList<Integer> ages = new ArrayList<>();
        ages.add(24);
        ages.add(30);
        ages.add(20);
        ages.add(28);
        ages.add(38);

        ArrayList<Student> Students = new ArrayList<>();
        Students.add(new Student("S001", "Melody", "Kim", "melody@university.edu", 3.2, "Computer Science", 2));
        Students.add(new Student("S002", "John", "Jones", "john@university.edu", 3.6, "Mathematics", 3));
        Students.add(new Student("S003", "Rose", "White", "rose@university.edu", 3.9, "Business", 2));
        Students.add(new Student("S004", "Isabela", "Petrov", "isabela@university.edu", 3.2, "Nursing", 2));
        Students.add( new Student("S005", "Maria", "Cruz", "maria@university.edu", 2.3, "Fine Arts", 4));
        Students.add(new Student("S006", "Selena", "Perez", "selena@university.edu", 1.7, "Biology", 1));

        // Swap
        swap(names, 0, 1);  // index 0 = Kevin, index 1 = Rose
        for (String n : names) {
            System.out.println(n);
        }
        System.out.println();

        // FindMax
        Integer maxAge = findMax(ages);   // 38
        System.out.println("*Max age:* " + maxAge);
        System.out.println();

        // Filter
        ArrayList<Student> highGPA = filter(Students, new MyPredicate<Student>() {
            @Override
            public boolean test(Student s) {
                return s.getGPA() >= 3.5;   // Filtering by student GPA
            }
        });

        System.out.println("*Students with GPA 3.5 or higher:*");
        for (Student s : highGPA) {
            System.out.println(s);
            System.out.println();

        }

        // Reverse
        System.out.println("*ArrayList names original:* ");
        for(String n: names) {
            System.out.println(n);
        }
        System.out.println();

        reverse(names);
        System.out.println("*ArrayList names reversed:* ");
        for(String n: names) {
            System.out.println(n);
        }

        // Merge
        ArrayList<String> more_names = new ArrayList<>();
        more_names.add("Lirios");
        more_names.add("Keyla");
        more_names.add("Luan");
        more_names.add("Tiara");
        more_names.add("Leon");
        ArrayList<String> list_merged = merge(names, more_names);
        System.out.println();
        System.out.println("*ArrayList merged:* ");
        System.out.println(list_merged);

        // sum
        double result1 = sum(ages);
        System.out.println("*Sum of ArrayList ages*: " + result1); // 140.0
        System.out.println();
        //

        // average
        double result2 = average(ages);
        System.out.println("*Average of ArrayList*: " + result2); // 28.0
        System.out.println();

        // filter above
        ArrayList<Integer> filtered = filterAbove(ages, 25);
        System.out.println("*Ages above 25*: " + filtered); // [30, 28, 38]
        System.out.println();

        // Wildcard Upper Bounded
        ArrayList<Double> salaries = new ArrayList<>();
        salaries.add(2500.5);
        salaries.add(3000.0);
        salaries.add(1800.75);

        double sumSalaries = sumNumbers(salaries);
        System.out.println("*Wildcard sum (salaries)*: " + sumSalaries);
        System.out.println();

        // Wildcard Lower bounded
        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<Number> numberList = new ArrayList<>();
        ArrayList<Object> objectList = new ArrayList<>();

        addNumbers(intList);
        addNumbers(numberList);
        addNumbers(objectList);

        System.out.println("*Integer list after addNumbers:* " + intList);
        System.out.println("*Number list after addNumbers:* " + numberList);
        System.out.println("*Object list after addNumbers:* " + objectList);
        System.out.println();

        // Wildcard Bounded
        System.out.println("*Printing names with wildcard:*");
        printList(names);

        System.out.println("*Printing students with wildcard:*");
        printList(Students);


    }

    public static <T> void swap(ArrayList<T> list, int index1, int index2) {
       T temp = list.get(index1);
       list.set(index1, list.get(index2));
       list.set(index2, temp);
    }

    public static <T extends Comparable<T>> T findMax(ArrayList<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }

        T max = list.get(0);

        for (T element_index : list) {
            if (element_index.compareTo(max) > 0) {
                max = element_index;
            }
        }

        return max;
    }

    public static <T> ArrayList<T> filter(ArrayList<T> list, MyPredicate<T> condition) {

        ArrayList<T> result = new ArrayList<>();

        for (T element : list) {
            if (condition.test(element)) {
                result.add(element);
            }
        }

        return result;
    }

    public static <T> void reverse(ArrayList<T> list) {
        int start = 0;
        int end = list.size() - 1;

        while(start < end) {
            T temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);

            // moves the position pointer
            start++;
            end--;
        }
    }

    public static <T> ArrayList<T> merge(ArrayList<T> list1, ArrayList<T> list2) {
        ArrayList<T> merged = new ArrayList<>();

        for(T one : list1) {
            merged.add(one);
        }

        for(T two : list2) {
            merged.add(two);
        }

        return merged;
    }

    // Bounded Generic methods

    public static <T extends Number> double sum(ArrayList<T> numbers){
        double sum = 0.0;
        for (T num : numbers) {
            sum += num.doubleValue();
        }
        return sum;
    }


    public static <T extends Number> double average(ArrayList<T> numbers) {
        if (numbers.isEmpty()) {
            return 0.0; // avoid division by zero
        }
        double s = sum(numbers);
        return s / numbers.size();
    }

    public static <T extends Number & Comparable<T>> ArrayList<T> filterAbove
            (ArrayList<T> numbers, T threshold) {
        ArrayList<T> result = new ArrayList<>();

        for (T num : numbers) {
            if (num.compareTo(threshold) > 0) {
                result.add(num);
            }
        }
        return result;
    }

    // Wildcard methods

    // Upper bounded
    public static double sumNumbers(ArrayList<? extends Number> numbers) {
        double sum = 0.0;
        for (Number num : numbers) {
            sum += num.doubleValue();
        }
        return sum;
    }

    // Lower bounded
    public static void addNumbers(ArrayList<? super Integer> list) {
        list.add(10);
        list.add(20);
        list.add(30);
    }

    // Unbounded
    public static void printList(ArrayList<?> list) {
        for (Object obj : list) {
            System.out.println(obj);
            System.out.println();
        }
    }

    /* Summary
    -- Upper bounded: when you only need to get values out or produce values.
    - Idea: You don't need to add values, just the values already inside.
    (ex: returning a calculation).
    -- Lower bounded: when you need to add elements into the
    list safely, by restricting the unknown type to be a specific
    type or one its superclasses.
     -- Unbounded: when the type does not matter for the logic of the method.
     */


}

interface MyPredicate<T> {
    boolean test(T element);
}


