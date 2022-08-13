package com.company;

public class Trie {

    private Node root;

    public Trie() {
        root = new Node('\0');
    }
    private void insertWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new Node(c);
            curr = curr.children[c - 'a'];

        }
        curr.isWord = true;

    }
    private boolean searchWord(String word) {
     return true;
    }
    private boolean startsWith(String prefix ) {
     return true;
    }

    class Node {
    public char c;
    public boolean isWord = false;
    public Node[] children;

    public Node(char c) {
         this.c = c;
         isWord = false;
         children = new Node[26];

        }

    }
}
