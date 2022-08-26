package revision1;

import sorting_algo_revision.TrieRevision;

public class TrieRevision1 {

    class Node {
        private char c;
        private boolean isWord;
        private Node[] children;

        Node(char c) {
            this.c = c;
            isWord = false;
            children = new Node[26];
        }
    }

    private Node root;

    TrieRevision1() {
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
        if (getNode(word) != null && getNode(word).isWord) {
            return true;
        }
        return false;
    }

    public boolean startsWith(String word) {
        if (getNode(word) != null) {
            return true;
        }
        return false;
    }

    public Node getNode(String word) {
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

    public static void main(String[] args) {
        TrieRevision1 trie = new TrieRevision1();
        trie.insert("pqrs");
        trie.insert("abcd");
        trie.insert("xyz");
        System.out.println("Is Exist :" + trie.isExist("xyz"));
        System.out.println("Is Exist :" + trie.isExist("xyzl"));
        System.out.println("Is Exist :" + trie.startsWith("abc"));
    }

}
