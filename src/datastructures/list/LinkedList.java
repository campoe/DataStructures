package datastructures.list;

/**
 * Created by Coen on 18-3-2017.
 */
public class LinkedList<T> {

    private int size;
    private Node head;

    public LinkedList() {
        size = 0;
        head = new Node(null);
        head.next = head;
    }

    public void add(int index, T item) {
        Node node = new Node(item);
        if (index == 0) {
            node.next = head;
            head = node;
        } else {
            Node p = getNode(index - 1);
            node.next = p.next;
            p.next = node;
        }
        size++;
    }

    public void remove(T item) {
        if (isFirst(item)) {
            head = head.next;
        } else {
            Node node = findBefore(item);
            node.next = node.next.next;
        }
        size--;
    }

    private boolean isFirst(T item) {
        return get(0).equals(item);
    }

    private Node find(T item) {
        for (int i = 1; i < size(); i++) {
            if (get(i).equals(item)) {
                return getNode(i - 1);
            }
        }
        return null;
    }

    private Node findBefore(T item) {
        if (get(0).equals(item)) {
            return null;
        } else {
            return find(item);
        }
    }

    public T get(int index) {
        return getNode(index).item;
    }

    private Node getNode(int index) {
        Node node = head;
        for (int position = 0; position != index; position++) {
            node = node.next;
        }
        return node;
    }

    public int size() {
        return size;
    }

    public class Node {

        private T item;
        private Node next;

        public Node(T item) {
            this.item = item;
            next = null;
        }

    }

}
