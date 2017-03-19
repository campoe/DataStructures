package datastructures.tree;

/**
 * Created by Coen on 18-3-2017.
 */
public class BinaryTree<T extends Comparable<T>> {

    public Node root;

    public BinaryTree() {
        root = null;
    }

    public boolean contains(T item) {
        Node node = root;
        while (node != null) {
            if (node.item.equals(item)) {
                return true;
            } else if (item.compareTo(node.item) < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }

    public void insert(T item) {
        Node node = new Node(item);
        if (root == null) {
            root = node;
            return;
        }
        Node child = root;
        Node parent;
        while (true) {
            parent = child;
            if (item.compareTo(child.item) < 0) {
                child = child.left;
                if (child == null) {
                    parent.left = node;
                    return;
                }
            } else {
                child = child.right;
                if (child == null) {
                    parent.right = node;
                    return;
                }
            }
        }
    }

    public boolean remove(T item) {
        Node parent = null;
        Node child = root;
        while (child != null) {
            if (item.compareTo(child.item) < 0) {
                parent = child;
                child = child.left;
            } else if (item.compareTo(child.item) > 0) {
                parent = child;
                child = child.right;
            } else {
                break;
            }
        }
        if (child == null) {
            return false;
        }
        if (child.left == null) {
            if (parent == null) {
                root = child.right;
            } else if (item.compareTo(parent.item) < 0) {
                parent.left = child.right;
            } else {
                parent.right = child.right;
            }
        } else {
            Node rightParent = child;
            Node right = child.left;
            while (right.right != null) {
                rightParent = right;
                right = right.right;
            }
            child.item = right.item;
            if (rightParent.right == right) {
                rightParent.right = right.left;
            } else {
                rightParent.left = right.left;
            }
        }
        return true;
    }

    public class Node {

        private T item;
        private Node left;
        private Node right;

        public Node(T item) {
            this.item = item;
            left = null;
            right = null;
        }

    }

}
