package ds;

public class Trie {

    public class Node {
        private char c;
        private Node[] children;
        private boolean isWord;

        Node(char c) {
            this.c = c;
            isWord = false;
            children = new Node[26];
        }
    }

    Node root;

    Trie() {
        root = new Node('\0');
    }

    public void insert(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new Node(c);
            }
            current = current.children[c - 'a'];
        }
        current.isWord = true;
    }

    public boolean isExist(String word) {
        Node node = getNode(word);
        if (node != null && node.isWord == true) {
            return true;
        }
        return false;
    }

    private Node getNode(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.children[c - 'a'] == null) {
                return null;
            }
            current = current.children[c - 'a'];
        }
        return current;
    }

    public boolean startsWith(String word) {
        Node node = getNode(word);
        if (node != null) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("pqrs");
        trie.insert("pqss");
        trie.insert("pbnf");

        System.out.println("IsExist : "+trie.startsWith("pb"));
    }

}
