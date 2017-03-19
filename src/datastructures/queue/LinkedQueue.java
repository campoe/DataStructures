package datastructures.queue;

/**
 * Created by Coen on 19-3-2017.
 */
public class LinkedQueue<T extends Comparable<T>> {

    private int size;
    private Node head;
    private Node tail;

    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public T enqueue(T item) {
        Node node = new Node(item);
        if (isEmpty()) {
            head = tail;
        } else {
            tail.next = node;
        }
        tail = node;
        size++;
        return node.item;
    }

    public T dequeue() {
        if (size() > 0) {
            T item = head.item;
            head = head.next;
            size--;
            if (isEmpty()) {
                tail = null;
            }
            return item;
        }
        return null;
    }

    public T peek() {
        if (size() > 0) {
            return head.item;
        }
        return null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }

    public class Node {

        private T item;
        private Node next;

        public Node(T item) {
            this.item = item;
        }

    }

}
