package medium;

import util.TreeNode;

import java.util.*;
/**
 * ClassName: MostFrequentSubtreeSum.java
 * Author: chenyiAlone
 * Create Time: 2019/9/26 12:05
 * Description: No.508 Most Frequent Subtree Sum
 * 思路:
 *      1. Hash 统计每个子树和的出现次数
 *      2. 将 maxCnt 出现次数最大的所有的子数组加入到结果中
 *
 *
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 *
 * Examples 1
 * Input:
 *
 *   5
 *  /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 *
 *   5
 *  /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 *
 */
public class MostFrequentSubtreeSum {
    private Map<Integer, Integer> map = new HashMap<>();
    private int maxCnt = 0;

    private int dfs(TreeNode root) {
        int sum = 0;
        if (root == null) return sum;
        int l = dfs(root.left);
        int r = dfs(root.right);
        sum = root.val + l + r;
        if (!map.containsKey(sum)) map.put(sum, 0);
        int cnt = map.get(sum) + 1;
        map.put(sum, cnt);
        maxCnt = maxCnt > cnt ? maxCnt : cnt;
        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> list = new ArrayList<>();
        for (Integer i : map.keySet())
            if (map.get(i) == maxCnt)
                list.add(i);
        int[] ret = new int[list.size()];
        for (int i = 0; i < list.size(); i++) ret[i] = list.get(i);
        return ret;
    }
}