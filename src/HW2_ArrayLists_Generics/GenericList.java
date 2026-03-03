package HW2_ArrayLists_Generics;
import java.util.ArrayList;

class GenericList <T> {
    private ArrayList<T> items;

    public GenericList() {
        items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }

    public T get(int index) {
        return items.get(index);
    }

    public boolean remove(T item) {
        return items.remove(item);
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }

    public boolean contains(T item) {
        return items.contains(item);
    }

    public ArrayList<T> getAll() {
        return new ArrayList<>(items);
    }

    public void addAll(ArrayList<T> other) {
        items.addAll(other);
    }

    public <U extends T> void addAllFrom(GenericList<U> other) {
        items.addAll(other.getAll());
    }

}

class GenericContainer {
    public static void main(String[] args) {

        ArrayList<String> strings = new ArrayList<>();
        strings.add("Dog");
        strings.add("Cat");
        strings.add("Bird");

        ArrayList<String> strings2 = new ArrayList<>();
        strings2.add("Horse");
        strings2.add("Rabbit");
        strings2.add("Cow");

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(42);
        numbers.add(33);
        numbers.add(21);

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("S001", "Melody", "Kim", "melody@university.edu", 3.2, "Computer Science", 2));
        students.add(new Student("S002", "John", "Jones", "john@university.edu", 3.6, "Mathematics", 3));
        students.add(new Student("S003", "Rose", "White", "rose@university.edu", 3.9, "Business", 2));

        ArrayList<Double> doubles = new ArrayList<>();

        // get
        System.out.println("*First element on strings*: " + strings.get(0));
        System.out.println();

        // remove and getAll
        System.out.println("*Removing element 33 from numbers ArrayList*: "
                + numbers.remove(1)); // 33
        System.out.println("*Numbers after remove*: " + numbers);
        System.out.println();

        // size
        System.out.println("*Size of students arraylist:* " + students.size()); // 3
        System.out.println();

        // isEmpty
        System.out.println("*ArrayList students is empty?*: " + strings.isEmpty()); // false
        System.out.println("*ArrayList doubles is empty?*: " + doubles.isEmpty()); // true
        System.out.println();

        // contains
        System.out.println("*ArrayList numbers contains number 33?*:" +
                " " + numbers.contains(33)); // false
        System.out.println();

        // AddAll
        strings.addAll(strings2);
        System.out.println("*After addAll (strings + strings2)*: " + strings);
        System.out.println();

        // addAllFrom
        GenericList<String> list1 = new GenericList<>();
        list1.add("Yellow");
        list1.add("Pink");

        GenericList<String> list2 = new GenericList<>();
        list2.add("White");
        list2.add("Orange");

        list1.addAllFrom(list2);
        System.out.println("*After addAllFrom (list1 + list2)*: " + list1.getAll());
        System.out.println();

    }
}
