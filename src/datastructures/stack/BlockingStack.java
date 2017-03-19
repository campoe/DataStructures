package datastructures.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Coen on 19-3-2017.
 */
public class BlockingStack<T> {

    private final List<T> list;

    private final Object pushLock = new Object();
    private final Object popLock = new Object();

    public BlockingStack() {
        list = new ArrayList<>();
    }

    private void awaitPush() {
        synchronized (this) {
            if (!isEmpty()) {
                return;
            }
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void clear() {
        list.clear();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T peek() {
        synchronized (popLock) {
            awaitPush();
            return list.get(0);
        }
    }

    public T pop() {
        synchronized (popLock) {
            awaitPush();
            return list.remove(0);
        }
    }

    public T push(T item) {
        synchronized (pushLock) {
            list.add(0, item);
            synchronized (this) {
                notify();
            }
        }
        return item;
    }

    public int size() {
        return list.size();
    }

}
