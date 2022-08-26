package ds;

public class MyBST {

    public static class Node {
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
        if (data < root.data) {
            if (root.left != null) {
                insert(root.left, data);
            } else {
                root.left = new Node(data);
            }
        } else if (data >= root.data) {
            if (root.right != null) {
                insert(root.right, data);
            } else {
                root.right = new Node(data);
            }
        }
    }

    public Node search(Node root, int searchData) {
        if (root == null) {
            return null;
        }
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

    public void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.println(root.data);
            inOrder(root.right);
        }
    }

    public void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.data);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data);
        }
    }

    /*public Node deleteNode(Node root, int value) {
        if (root == null)
            return null;
        if (root.data > value) {
            root.left = deleteNode(root.left, value);
        } else if (root.data < value) {
            root.right = deleteNode(root.right, value);

        } else {
            // if nodeToBeDeleted have both children
            if (root.left != null && root.right != null) {
                Node temp = root;
                // Finding minimum element from right
                Node minNodeForRight = minimumElement(temp.right);
                // Replacing current node with minimum node from right subtree
                root.data = minNodeForRight.data;
                // Deleting minimum node from right now
                root.right = deleteNode(root.right, minNodeForRight.data);

            }
            // if nodeToBeDeleted has only left child
            else if (root.left != null) {
                root = root.left;
            }
            // if nodeToBeDeleted has only right child
            else if (root.right != null) {
                root = root.right;
            }
            // if nodeToBeDeleted do not have child (Leaf node)
            else
                root = null;
        }
        return root;
    }

    // Get minimum element in binary search tree
    public Node minimumElement(Node root) {
        if (root.left == null)
            return root;
        else {
            return minimumElement(root.left);
        }
    }*/

    public Node delete(Node root, int data) {
        if (root == null) {
            return null;
        } else if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            if (root.left != null && root.right != null) {
                Node tmp = root;
                Node minimumNodeInRight = minimumNodeInRight(root.right);
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

    public Node minimumNodeInRight(Node root) {
        if (root.left == null) {
            return root;
        } else {
            return minimumNodeInRight(root.left);
        }
    }


    public static void main(String[] args) {
        Node root = new Node(45);
        MyBST tree = new MyBST();
        tree.insert(root, 12);
        tree.insert(root, 67);
        tree.insert(root, 6);
        tree.insert(root, 23);
        tree.insert(root, 50);
        tree.insert(root, 80);
        tree.insert(root, 3);
        tree.insert(root, 9);
        tree.insert(root, 18);
        tree.insert(root, 33);
        tree.insert(root, 49);
        tree.insert(root, 100);

//        tree.postOrder(root);
        /*Node node = tree.search(root, 45);
        System.out.println("Left :" + node.left.data);
        System.out.println("Right :" + node.right.data);*/

        Node node = tree.delete(root, 12);
        System.out.println("Left :" + node.left.data);
        System.out.println("Right :" + node.right.data);
    }


}
