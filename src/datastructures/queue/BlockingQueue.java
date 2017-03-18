package datastructures.queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Coen on 18-3-2017.
 */
public class BlockingQueue<T extends Comparable<T>> {

    private final List<T> list;

    private final Object enqueueLock = new Object();
    private final Object dequeueLock = new Object();

    public BlockingQueue() {
        list = new ArrayList<>();
    }

    private void awaitEnqueue() {
        synchronized (this) {
            if (list.isEmpty()) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void clear() {
        list.clear();
    }

    public T dequeue() {
        synchronized (dequeueLock) {
            awaitEnqueue();
            return list.remove(0);
        }
    }

    public T enqueue(T item) {
        synchronized (enqueueLock) {
            list.add(item);
            synchronized (this) {
                notify();
            }
        }
        return item;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public T peek() {
        synchronized (dequeueLock) {
            awaitEnqueue();
            return list.get(0);
        }
    }

    public int size() {
        return list.size();
    }

}
