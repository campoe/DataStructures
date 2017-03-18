package datastructures.stack;

/**
 * Created by Coen on 18-3-2017.
 */
public class LinkedStack<T> {

    private int size;
    private Node head;

    public LinkedStack() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T push(T item) {
        Node node = new Node(item);
        node.next = head;
        head = node;
        size++;
        return node.item;
    }

    public T pop() {
        if (size() > 0) {
            Node node = head;
            head = head.next;
            size--;
            return node.item;
        }
        return null;
    }

    public T peek() {
        if (size() > 0) {
            return head.item;
        }
        return null;
    }

    public int search(T item) {
        int i = lastIndexOf(item);
        if (i >= 0) {
            return size() - i;
        }
        return -1;
    }

    public int lastIndexOf(T item) {
        Node node = head;
        int position = -1;
        for (int i = 0; i < size(); i++) {
            node = node.next;
            if (node.item.equals(item)) {
                position = i;
            }
        }
        return position;
    }

    public class Node {

        private T item;
        private Node next;

        public Node(T item) {
            this.item = item;
        }

    }

}
