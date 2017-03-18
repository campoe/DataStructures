package datastructures.tree;

/**
 * Created by Coen on 18-3-2017.
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void clear() {
        root = null;
    }

    public boolean contains(T item) {
        return contains(item, root);
    }

    private boolean contains(T item, Node node) {
        while (node != null) {
            if (item.compareTo(node.item) < 0) {
                node = node.left;
            } else if (item.compareTo(node.item) > 0) {
                node = node.right;
            } else {
                return true;
            }
        }
        return false;
    }

    public T findMax() {
        return findMax(root).item;
    }

    private Node findMax(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    public T findMin() {
        return findMin(root).item;
    }

    private Node findMin(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void insert(T item) {
        root = insert(item, root);
    }

    private Node insert(T item, Node node) {
        if (node == null) {
            node = new Node(item);
        } else if (item.compareTo(root.item) == 0) {
            return node;
        } else if (item.compareTo(root.item) < 0) {
            node.left = insert(item, node.left);
        } else {
            node.right = insert(item, node.right);
        }
        return node;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void remove(T item) {
        root = remove(item, root);
    }

    private Node remove(T item, Node node) {
        if (node == null) {
            return root;
        } else if (item.compareTo(node.item) < 0) {
            node.left = remove(item, node.left);
        } else if (item.compareTo(node.item) > 0) {
            node.right = remove(item, node.right);
        } else if (node.left != null && node.right != null) {
            node.item = findMin(node.right).item;
            node.right = removeMin(node.right);
        } else if (node.left != null) {
            node = node.left;
        } else {
            node = node.right;
        }
        return node;
    }

    public void removeMax() {
        root = removeMax(root);
    }

    private Node removeMax(Node node) {
        if (node.right != null) {
            node.right = removeMax(node.right);
            return node;
        } else {
            return node.left;
        }
    }

    public void removeMin() {
        root = removeMin(root);
    }

    private Node removeMin(Node node) {
        if (node.left != null) {
            node.left = removeMin(node.left);
            return node;
        } else {
            return node.right;
        }
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
