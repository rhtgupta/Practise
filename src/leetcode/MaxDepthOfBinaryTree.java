package leetcode;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfBinaryTree {
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
            Node newNode = new Node(data);
            root = newNode;
        } else {
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
    }

    public void levelOrder(Node root) {
        if (root == null) {
            System.out.print("a ");
        } else {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node current = queue.poll();
                System.out.print(current.data + " ");
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

        }
    }

    public void inOrder(Node root) {
        if (root == null) {
            System.out.print("a ");
        } else {

            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        MaxDepthOfBinaryTree obj = new MaxDepthOfBinaryTree();
        Node root = new Node(3);
        obj.insert(root, 9);
        obj.insert(root, 20);
        obj.insert(root, 15);
        obj.insert(root, 7);
        obj.levelOrder(root);
    }

}
