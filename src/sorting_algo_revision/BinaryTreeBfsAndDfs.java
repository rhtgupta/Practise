package sorting_algo_revision;

import revision.CustomBST;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBfsAndDfs {

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

    public void insert(Node root, int data) {
        if (root == null) {
            return;
        }
        if (data < root.data) {
            if (root.left == null) {
                root.left = new Node(data);
            } else {
                insert(root.left, data);
            }
        } else {
            if (root.right == null) {
                root.right = new Node(data);
            } else {
                insert(root.right, data);
            }
        }
    }

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void levelOrder(Node root) {
        if (root != null) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                Node tmp = queue.poll();
                System.out.print(tmp.data + " ");

                if (tmp.left != null) {
                    queue.add(tmp.left);
                }
                if (tmp.right != null) {
                    queue.add(tmp.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(34);
        BinaryTreeBfsAndDfs bst = new BinaryTreeBfsAndDfs();
        bst.insert(root, 12);
        bst.insert(root, 55);
        bst.insert(root, 7);
        bst.insert(root, 33);
        bst.insert(root, 43);
        bst.insert(root, 100);
        bst.insert(root, 22);

        bst.postOrder(root);
    }

}
