package HW2_ArrayLists_Generics;
import java.util.ArrayList;

public class GenericQueue<T> {
    private ArrayList<T> queue;

    public GenericQueue() {
        queue = new ArrayList<>();
    }

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.remove(0);  // remove first element
    }

    public T peek() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue.get(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}

class Main2 {
    public static void main(String[] args) {

        GenericQueue<Integer> queue = new GenericQueue<>();

        queue.enqueue(10);
        queue.enqueue(20);

        System.out.println(queue.dequeue()); // 10
        System.out.println(queue.peek());    // 20
        System.out.println(queue.size());    // 1
        System.out.println(queue.isEmpty()); // false
    }
}
