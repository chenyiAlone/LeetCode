package medium;

import java.util.Arrays;

/**
 * ClassName: OnesandZeros.java
 * Author: chenyiAlone
 * Create Time: 2019/9/15 15:56
 * Description: No.474 Ones and Zeros
 * 思路:
 *      1. 动态规划的 0/1 背包问题
 *      2. f[i][j] 记录 i 个 0 和 j 个 1 能拼成多少个字符串
 *
 *
 * In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.
 *
 * For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.
 *
 * Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.
 *
 * Note:
 *
 * The given numbers of 0s and 1s will both not exceed 100
 * The size of given string array won't exceed 600.
 *  
 *
 * Example 1:
 *
 * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * Output: 4
 *
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
 *  
 *
 * Example 2:
 *
 * Input: Array = {"10", "0", "1"}, m = 1, n = 1
 * Output: 2
 *
 * Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 *
 */

public class OnesandZeros {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] f = new int[m + 1][n + 1];
        for (int[] arr : f) Arrays.fill(arr, -1);
        f[0][0] = 0;
        int ret = 0;
        for (String s : strs) {
            int[] cnt = {0, 0};
            for (char c : s.toCharArray()) cnt[c - '0']++;
            int zeros = cnt[0], ones = cnt[1];
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    if (f[i - zeros][j - ones] >= 0) {
                        f[i][j] = Math.max(f[i][j], f[i - zeros][j - ones] + 1);
                        ret = Math.max(ret, f[i][j]);
                    }
                }
            }
        }
        return ret;
    }
}