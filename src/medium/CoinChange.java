package medium;

import java.util.Arrays;
/**
 * ClassName: CoinChange.java
 * Author: chenyiAlone
 * Create Time: 2019/5/29 17:17
 * Description: No.322
 * 思路:
 *      1. DP 动态规划，初始化 f[0] 为 0 其余的都为 INF
 *      2. 状态转移方程
 *          f[i] = min{ f[i - coins[j]] + 1, 0 <= j <= coins.len };
 *
 *
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int len = coins.length;
        if (len == 0)
            return -1;
        int[] f = new int[amount + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int v : coins) {
                if (i - v >= 0 && f[i - v] != Integer.MAX_VALUE) {
                    f[i] = Math.min(f[i], f[i - v]);
                }
            }
        }
        return f[amount] == Integer.MAX_VALUE ? -1 : f[amount];
    }
}
