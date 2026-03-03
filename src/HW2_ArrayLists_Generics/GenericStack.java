package HW2_ArrayLists_Generics;
import java.util.ArrayList;

public class GenericStack<T> {
    private ArrayList<T> stack;

    public GenericStack() {
        stack = new ArrayList<>();
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public void clear() {
        stack.clear();
    }
}

class Main1 {
    public static void main(String[] args) {

        GenericStack<String> stack = new GenericStack<>();
        stack.push("First");
        stack.push("Second");

        System.out.println(stack.pop());   // Second
        System.out.println(stack.peek());  // First
        System.out.println(stack.size());  // 1
        System.out.println(stack.isEmpty()); // false

        stack.clear();
        System.out.println(stack.isEmpty()); // true
    }
}
