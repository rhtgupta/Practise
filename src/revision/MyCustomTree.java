package revision;

public class MyCustomTree {

    static class Node {
        private Node left;
        private Node right;
        private int data;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    Node root;

    MyCustomTree(Node root) {
        this.root = root;
    }

    public void insert(Node root, int data) {
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

    public Node search(int data, Node root) {
        Node current = root;
        if (current == null) {
            return null;
        }
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

    public Node delete(Node root, int data) {
        if (root == null) {
            return null;
        }
        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            if (root.left != null && root.right != null) {
                Node tmp = root;
                Node minValueNodeOnRight = minValueNodeOnRight(tmp.right, data);
                root.data = minValueNodeOnRight.data;
                root.right = delete(root.right, minValueNodeOnRight.data);
            } else if (root.left != null) {
                root.left = root;
            } else if (root.right != null) {
                root.right = root;
            } else {
                root = null;
            }
        }
        return root;
    }

    private Node minValueNodeOnRight(Node root, int data) {
        if (root.left == null) {
            return root;
        } else {
            return minValueNodeOnRight(root.right, data);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(56);
        MyCustomTree tree = new MyCustomTree(root);

        tree.insert(root, 30);
        tree.insert(root, 80);
        tree.insert(root, 20);
        tree.insert(root, 100);
        tree.insert(root, 44);
        tree.insert(root, 60);
        tree.insert(root, 70);
        tree.insert(root, 35);

        Node node = tree.search(60, root);
        if (node.left == null) {
            System.out.println("null");
        } else {
            System.out.println(node.left.data);
        }
        if (node.right == null) {
            System.out.println("null");
        } else {
            System.out.println(node.right.data);
        }
//        System.out.println("Left : " + node.left == null ? "null" : node.left.data);
//        System.out.println("Right : " + node.right == null ? "null" : node.right.data);
    }

}
