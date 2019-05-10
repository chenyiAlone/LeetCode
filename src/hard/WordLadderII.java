package hard;

import javafx.beans.binding.ObjectExpression;

import java.util.*;

/**
 * ClassName: WordLadderII.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/10 12:23
 * Description: No.127
 * 思路:
 *      1. dist[len + 1] : 最短路的终点，逆向 DFS 使用 LinkedList 保存，找 1 也就是 endWord 将 temp 的元素存入 res
 *      2. 这里使用了 SPFA 来实现寻找最短路径，但是 SPFA 并不稳定，最好的选择还是使用 MinHeap + Dijkstra
 *      3. 重复加入了 endWord，通过跳过和 endWord 相同的单词，连接字母差一的单词，用 boolean hasEnd 判断有无结果
 *
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 *
 * Return an empty list if there is no such transformation sequence.
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
 * Output:
 * [
 *   ["hit","hot","dot","dog","cog"],
 *   ["hit","hot","lot","log","cog"]
 * ]
 * Example 2:
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: []
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 */
public class WordLadderII {
    private int len = -1;
    private List<String> words = null;
    private List<List<Integer>> edges = null;

    private int[] dist = null;
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        len = wordList.size();
        words = wordList;   // beginWord + endWord add into words
        words.add(beginWord);
        words.add(endWord);

        edges = new ArrayList<>();
        while (edges.size() < len + 2)
            edges.add(new ArrayList<>());

        boolean hasEnd = false;

        for (int i = 0; i < len + 2; i++) {
            for (int j = i + 1; j < len + 2; j++) {
                if (diff(words.get(i), words.get(j)) == 1) {
                    edges.get(i).add(j);
                    edges.get(j).add(i);
                }
            }
            if (diff(words.get(len + 1), words.get(i)) == 0) {  // 加入了 begin end，省去了冗余的 if
                hasEnd = true;
            }
            /*
            if (diff(words.get(len), words.get(i)) <= 1) {
                edges.get(i).add(len);
                edges.get(len).add(i);
            }
            int tmp = diff(words.get(len + 1), words.get(i));
            if (tmp == 0)   // 判定有无结束单词
                hasEnd = true;
            if (tmp == 1) {     // 其实这里是将与 endWord 差一个字母的单词连上了一条边
                edges.get(i).add(len + 1);  // dog-> cog-> cog(endWord)，相当于 dog-> cog(endWord)
                edges.get(len + 1).add(i);
            }
            */
        }
        for (List<Integer> list : edges) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        if (!hasEnd)
            return res;

        dist = new int[len + 2];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<Integer> que = new LinkedList<>();

        dist[len] = 1;
        que.offer(len);

        while (!que.isEmpty()) {
            int v = que.poll();

            for (int w : edges.get(v)) {
                if (dist[w] > dist[v] + 1) {
                    dist[w] = dist[v] + 1;
                    que.offer(w);
                    if (w == len + 1) {
                        for (int i : dist)
                            System.out.print(i + " ");
                        System.out.println();
                        dfs(len + 1, new LinkedList<>());
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        String[] strs = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = new ArrayList<>(Arrays.asList(strs));

        List<List<String>> res = new WordLadderII().findLadders(beginWord, endWord, wordList);
        System.out.println(res);

    }


    private void dfs(int v, LinkedList<String> temp) {
        temp.push(words.get(v));
        if (dist[v] == 1) {
            List<String> t = new ArrayList<>(temp);
            res.add(t);
        } else {
            for (int w : edges.get(v)) {
                if (dist[w] + 1 == dist[v])
                    dfs(w, temp);
            }
        }
        temp.poll();
    }


    private int diff(String str1, String str2) {
        int cnt = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                cnt++;
                if (cnt > 1)
                    break;
            }
        }
        return cnt;
    }
}

