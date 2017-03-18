package datastructures.list;

/**
 * Created by Coen on 18-3-2017.
 */
public class DoublyLinkedList<T> {

    private int size;
    private Node head;

    public DoublyLinkedList() {
        size = 0;
        head = new Node(null);
        head.next = head;
        head.previous = head;
    }

    public void add(int index, T item) {
        Node node = new Node(item);
        Node next = getNode(index);
        Node previous = next.previous;
        node.previous = previous;
        node.next = next;
        next.previous = node;
        previous.next = node;
        size++;
    }

    public void remove(int index) {
        Node node = getNode(index);
        Node previous = node.previous;
        Node next = node.next;
        previous.next = next;
        next.previous = previous;
        size--;
    }

    public T get(int index) {
        return getNode(index).item;
    }

    public Node getNode(int index) {
        Node node = head;
        for (int position = -1; position < index; position++) {
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
        private Node previous;

        public Node(T item) {
            this.item = item;
            next = null;
            previous = null;
        }

    }

}
