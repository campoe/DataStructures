package datastructures.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Coen on 18-3-2017.
 */
public class Stack<T extends Comparable<T>> {

    private final List<T> list;

    public Stack() {
        list = new ArrayList<>();
    }

    public void clear() {
        list.clear();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T peek() {
        if (size() > 0) {
            return list.get(0);
        }
        return null;
    }

    public T pop() {
        if (size() > 0) {
            return list.remove(0);
        }
        return null;
    }

    public T push(T item) {
        list.add(0, item);
        return item;
    }

    public int search(T item) {
        int i = list.lastIndexOf(item);
        if (i >= 0) {
            return size() - i;
        }
        return -1;
    }

    public int size() {
        return list.size();
    }

}
