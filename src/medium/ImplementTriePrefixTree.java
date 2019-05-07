package medium;
/**
 * ClassName: ImplementTriePrefixTree.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/7 17:48
 * Description: No.208
 * 思路:
 *      1. 构造单词树的节点
 *              Node {
 *                  Node[] kids;    // size = 26;
 *                  boolean isWord;
 *                  public Node() {
 *                      kids = new Node[26];
 *                  }
 *              }
 *      2. root 根节点相当于 guard
 *
 *
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // returns true
 * trie.search("app");     // returns false
 * trie.startsWith("app"); // returns true
 * trie.insert("app");
 * trie.search("app");     // returns true
 * Note:
 *
 * You may assume that all inputs are consist of lowercase letters a-z.
 * All inputs are guaranteed to be non-empty strings.
 *
 */
public class ImplementTriePrefixTree {
    private class Node {
        Node[] kids;
        boolean isWord;
        private Node() {
            kids = new Node[26];
        }
    }
    private Node root;

    /** Initialize your data structure here. */
    public ImplementTriePrefixTree() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node iter = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (iter.kids[c] == null)
                iter.kids[c] = new Node();
            iter = iter.kids[c];
        }
        iter.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node iter = root;
        for (char i : word.toCharArray()) {
            int c = i - 'a';
            if (iter.kids[c] == null)
                return false;
            iter = iter.kids[c];
        }
        return iter.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node iter = root;
        for (int i = 0; i < prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            if (iter.kids[c] == null)
                return false;
            iter = iter.kids[c];
        }
        return true;
    }
}