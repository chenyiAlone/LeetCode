package medium;
/**
 * ClassName: AddandSearchWordDatastructuredesign.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/8 17:15
 * Description: No.211
 * 思路:
 *      1. use boolean check() to DFS tree
 *      2. DFS
 *          if c = '.'
 *              for i = 0 to 25
 *                  if root.edges[i] != null && check()
 *                      return true
 *              return false
 *          else
 *              if root.edges[c] != null
 *                  return check(root.edges[c])
 *
 *
 *
 *
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 *
 * Example:
 *
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 *
 */
public class AddandSearchWordDatastructuredesign {
    private class Node {
        boolean isWord = false;
        Node[] edges;
        private Node() {
            edges = new Node[26];
        }

    }
    private Node root;
    /** Initialize your data structure here. */
    public AddandSearchWordDatastructuredesign() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if ("".equals(word))
            return;
        Node iter = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (iter.edges[index] == null) {
                iter.edges[index] = new Node();
            }
            iter = iter.edges[index];
        }
        iter.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    private boolean check(int index, char[] word, Node root) {
        if (index == word.length)
            return root.isWord;
        if (word[index] == '.') {
            for (int i = 0; i < 26; i++)
                if (root.edges[i] != null && check(index + 1, word, root.edges[i]))
                    return true;
        } else {
            int p = word[index] - 'a';
            if (root.edges[p] != null)
                return check(index + 1, word, root.edges[p]);
        }
        return false;
    }


    public boolean search(String word) {
        return check(0, word.toCharArray(), root);
    }
}
