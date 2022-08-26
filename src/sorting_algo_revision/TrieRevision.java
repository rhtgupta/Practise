package sorting_algo_revision;

import ds.Trie;

public class TrieRevision {

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

    TrieRevision() {
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
        if (node != null && node.isWord) {
            return true;
        }
        return false;
    }

    public boolean isStartsWith(String word) {
        Node node = getNode(word);
        if (node != null) {
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
        TrieRevision trie = new TrieRevision();
        trie.insert("pqrs");
        trie.insert("pqss");
        trie.insert("pbnf");

        System.out.println("IsExist : " + trie.isExist("pqfrs"));
    }

}
