package hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * ClassName: WordSearchII.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/8 17:30
 * Description: No.212
 * 思路:
 *      1. DFS + BackTracking + Word Tree
 *      2. if the node that needs to be scanned is not empty, can step into dfs method
 *          if root.edges[c] != null
 *              dfs(root.edges[c])
 *      3. word tree's node use id represent that this node has a word, and id correspond words index
 *          inset(words[index], index)
 *
 *
 *
 *
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 * Example:
 *
 * Input:
 * board = [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 *
 * Output: ["eat","oath"]
 *
 *
 * Note:
 *
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 *
 */
public class WordSearchII {
    private char[][] board = null;
    private String[] words = null;
    private Set<Integer> ans = new HashSet<>();

    private Trie trie = new Trie();

    private int m, n;
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};

    private void dfs(int x, int y, boolean[][] trace, Node root) {
        trace[x][y] = true;
        if (root.id != -1)
            ans.add(root.id);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            boolean flag = 0 <= nx && nx < m
                    && 0 <= ny && ny < n
                    && root.kids[board[nx][ny] - 'a'] != null
                    && !trace[nx][ny];
            if (flag) {
                dfs(nx, ny, trace, root.kids[board[nx][ny] - 'a']);
            }
        }
        trace[x][y] = false;
    }

    public List<String> findWords(char[][] b, String[] w) {
        board = b;
        words = w;
        List<String> res = new ArrayList<>();

        m = b.length;
        if (m == 0)
            return res;
        n = b[0].length;
        if (n == 0)
            return res;

        boolean[][] trace = new boolean[m][n];

        for (int i = 0; i < w.length; i++)
            trie.insert(w[i], i);

        Node root = trie.root;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (root.kids[board[i][j] - 'a'] != null)
                    dfs(i, j, trace, root.kids[board[i][j] - 'a']);
        for (int i : ans)
            res.add(w[i]);
        return res;
    }

    class Node {
        Node[] kids;
        int id = -1;
        private Node() {
            kids = new Node[26];
        }
    }

    class Trie {
        Node root;

        /** Initialize your data structure here. */
        private Trie() {
            root = new Node();
        }

        /** Inserts a word into the trie. */
        private void insert(String word, int index) {
            Node iter = root;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (iter.kids[c] == null)
                    iter.kids[c] = new Node();
                iter = iter.kids[c];
            }
            iter.id = index;
        }
    }
}
