package datastructures.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Coen on 18-3-2017.
 */
public class SelfOrganizingList<T> {

    private List<Node> list;

    public SelfOrganizingList() {
        list = new ArrayList<>();
    }

    public void clear() {
        list.clear();
    }

    public T get(int index) {
        return list.get(index).item;
    }

    public int getCount(int index) {
        return list.get(index).count;
    }

    public void insert(T item) {
        list.add(new Node(item));
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void remove(int index) {
        list.remove(index);
    }

    public void remove(T item) {
        for (int i = 0; i < list.size(); i++) {
            Node node = list.get(i);
            if (node.item.equals(item)) {
                list.remove(node);
            }
        }
    }

    public boolean contains(T item) {
        boolean contains = false;
        Node node = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).item.equals(item)) {
                node = list.get(i);
                contains = true;
                break;
            }
        }
        if (contains) {
            int index = list.indexOf(node);
            node.count++;
            int i;
            for (i = index - 1; i >= 0; i--) {
                Node p = list.get(i);
                if (p.count > node.count) {
                    break;
                }
            }
            i++;
            list.set(i, node);
        }
        return contains;
    }

    public int size() {
        return list.size();
    }

    public class Node {

        private T item;
        private int count;

        public Node(T item) {
            this.item = item;
            count = 0;
        }

        public boolean equals(Node node) {
            return item.equals(node.item);
        }

    }

}
