package medium;

import java.util.ArrayList;
import java.util.List;
/**
 * ClassName: LexicographicalNumbers.java
 * Author: chenyiAlone
 * Create Time: 2019/7/27 22:20
 * Description: No.386 Lexicographical Numbers
 * 思路:
 *      1. dfs 给每一位填值
 *      2. 处理前导零，使用枚举第一位来解决
 *
 *
 * Given an integer n, return 1 - n in lexicographical order.
 *
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 *
 * Please optimize your algorithm to use less time and space. The input size may be as large as 5,000,000.
 *
 */
public class LexicographicalNumbers {
    private int max;
    private List<Integer> ans = new ArrayList<>();

    private void dfs(int number, int depth, int len) {
        if (number > max) return;
        if (number != 0) ans.add(number);
        if (depth == len) {
            return;
        }
        for (int i = 0; i < 10; i++) {
            dfs(number * 10 + i, depth + 1, len);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        this.max = n;
        int len = 0;
        for (int i = n; i > 0; i /= 10) len++;
        for (int first = 1; first < 10; first++)
            dfs(first, 1, len);
        return ans;
    }
}
