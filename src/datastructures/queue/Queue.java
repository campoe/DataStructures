package datastructures.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Coen on 18-3-2017.
 */
public class Queue<T extends Comparable<T>> {

    private final List<T> list;

    public Queue() {
        list = new ArrayList<>();
    }

    public void clear() {
        list.clear();
    }

    public T dequeue() {
        if (size() > 0) {
            return list.remove(size() - 1);
        }
        return null;
    }

    public T enqueue(T item) {
        list.add(0, item);
        return item;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T peek() {
        if (size() > 0) {
            return list.get(size() - 1);
        }
        return null;
    }

    public int size() {
        return list.size();
    }

}
