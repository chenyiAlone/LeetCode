package medium;

import java.util.*;

/**
 * ClassName: WordLadder.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/9 19:26
 * Description: No.127
 * 思路:
 * 1. Dijkstra 求最短路径，构造成邻接矩阵，矩阵中的值为权值，-1 代表此路不通
 * 2. v = min() // 从未被收录的顶点中！！！！！
 * 3. 记得 coll[v] = true;
 * <p>
 * ps：因为 Dijkstra 算法的理解不对，所以浪费了很多时间
 *
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 *
 *
 */
public class WordLadder {
    private int len = -1;
    private int[][] matrix = null;
    private int[] dist = null;
    private boolean[] coll = null;


    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        String[] strs = {"hot", "dot", "dog", "lot", "log", "cog"};
        for (String s : strs) {
            wordList.add(s);
        }
        String beginWord = "hit", endWord = "cog";
        int res = new WordLadder().ladderLength(beginWord, endWord, wordList);
        System.out.println("res: " + res);

    }


    private int diff(String str1, String str2) {
        int cnt = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i))
                cnt++;
            if (cnt > 1)
                break;
        }
        return cnt;
    }


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        len = wordList.size();

        // len:begin
        // len + 1:end
        matrix = new int[len + 2][len + 2];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = -1;
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int tmp = diff(wordList.get(i), wordList.get(j));
                if (tmp <= 1) {
                    matrix[i][j] = tmp;
                    matrix[j][i] = tmp;
                }
            }
            int d = diff(beginWord, wordList.get(i));
            if (d <= 1) {
                matrix[len][i] = d;
//                matrix[i][len] = d;
            }
            d = diff(endWord, wordList.get(i));
            if (d == 0) {
//                matrix[len + 1][i] = d;
                matrix[i][len + 1] = d;
            }
        }
        for (int[] arr : matrix) {
            for (int i : arr) {
                System.out.format("%2d  ", i);
            }
            System.out.println();
        }

        dist = new int[len + 2];
        coll = new boolean[len + 2];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[len][i] != -1) {
                dist[i] = 1 + matrix[len][i];
            }
        }

        coll[len] = true;
        int v = len;

        while (true) {
            v = min(v);
            if (v == -1) {
                break;
            }
            System.out.println("coll, i = " + v);
            coll[v] = true;
            for (int i : dist) {
                System.out.print(i + " ");
            }
            System.out.println();
            for (int i = 0; i < len + 2; i++) {
                if (matrix[v][i] != -1 && !coll[i] && dist[i] > dist[v] + matrix[v][i]) {
                    dist[i] = dist[v] + matrix[v][i];

                }
            }
        }

        return dist[len + 1] > len + 1 ? 0 : dist[len + 1];

    }

    private int min(int v) {
        int index = -1, tmp = -1;
        for (int i = 0; i < len + 2; i++) {
            if (!coll[i]) {
                if (tmp == -1) {
                    index = i;
                    tmp = dist[i];
                } else if (dist[i] < tmp) {
                    tmp = dist[i];
                    index = i;
                }
            }
        }
        return index;
    }
}
