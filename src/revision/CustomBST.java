package revision;

public class CustomBST {

    public static class Node {
        private Node left;
        private Node right;
        private int data;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node root;

    public CustomBST(Node root) {
        this.root = root;
    }

    public void insert(Node node, int data) {
        if (data < node.data) {
            if (node.left != null) {
                insert(node.left, data);
            } else {
                node.left = new Node(data);
            }
        } else if (data > node.data) {
            if (node.right != null) {
                insert(node.right, data);
            } else {
                node.right = new Node(data);
            }
        }
    }

    public Node search(int searchData) {
        Node currentNode = root;
        while (currentNode.data != searchData) {
            if (searchData < currentNode.data) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
            if (currentNode == null) {
                return null;
            }
        }
        return currentNode;
    }

    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }

    public Node delete(Node root, int data) {
        if (root == null) {
            return null;
        } else if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            if (root.left != null && root.right != null) {
                Node temp = root;
                Node minimumNodeInRight = minimumNodeInRight(temp);
                root.data = minimumNodeInRight.data;
                root.right = delete(root.right, minimumNodeInRight.data);
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return root;
    }

    private Node minimumNodeInRight(Node root) {
        if (root.left == null) {
            return root;
        } else {
            return minimumNodeInRight(root.left);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(34);
        CustomBST bst = new CustomBST(root);
        bst.insert(root, 12);
        bst.insert(root, 55);
        bst.insert(root, 7);
        bst.insert(root, 33);
        bst.insert(root, 43);
        bst.insert(root, 100);
        bst.insert(root, 22);

        Node node = bst.search(12);
        System.out.println("left child :" + node.left.data);
        System.out.println("right child :" + node.right.data);
    }

}
