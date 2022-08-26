package thread_revision;

public class TrieRevisionAgain {

    class Node {
        private char c;
        private Node[] children;
        private boolean isWord;

        Node(char c) {
            this.c = c;
            children = new Node[26];
            isWord = false;
        }

    }

    Node root;

    TrieRevisionAgain() {
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

    public boolean isWordExist(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.children[c - 'a'] == null) {
                return false;
            }
            current = current.children[c - 'a'];
        }
        return current.isWord;
    }

}

