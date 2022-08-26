package thread_revision;

import java.util.LinkedList;
import java.util.Queue;

public class MyCustomBSTRevisionAgain {

    static class Node {
        private int data;
        private Node left;
        private Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node root;

    public void insert(Node root, int data) {
        if (data < root.data) {
            if (root.left != null) {
                root.left = new Node(data);
            } else {
                insert(root.left, data);
            }
        } else {
            if (root.right != null) {
                root.right = new Node(data);
            } else {
                insert(root.right, data);
            }
        }
    }

    public Node search(Node root, int data) {
        Node current = root;
        while (current.data != data) {
            if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tmp = queue.poll();
            System.out.println(tmp.data);

            if (tmp.left != null) {
                queue.add(tmp.left);
            }

            if (tmp.right != null) {
                queue.add(tmp.right);
            }

        }
    }

    public Node remove(Node root, int data) {
        if (root == null) {
            return null;
        }
        if (data < root.data) {
            root.left = remove(root.left, data);
        } else if (data > root.data) {
            root.right = remove(root.right, data);
        } else {
            if (root.left != null && root.right != null) {

            } else if (root.left != null) {

            } else if (root.right != null) {

            } else {
                root = null;
            }
        }
        return root;
    }

}
