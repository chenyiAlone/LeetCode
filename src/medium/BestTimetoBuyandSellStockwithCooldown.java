package medium;
/**
 * ClassName: BestTimetoBuyandSellStockwithCooldown.java
 * Author: chenyiAlone
 * Create Time: 2019/5/26 14:34
 * Description: No.309
 * 思路:
 *      状态分别为
 *
 *          1. 当前没有持有股票：从上一个 没有持有股票 和 cooldown 中取最大值
 *          2. 买股票：从上一个 没有持有股票买当前的股票 和 上一个持有股票 中取最大值
 *          3. 正在休息：持有股票今天卖掉
 *
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 *
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 *
 */
public class BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit(int[] prices) {
        int[] f = {0, 1 << 31, 1 << 31};
        // nothing buy cooldown

        for (int  i : prices) {
            int[] g = new int[3];
            g[0] = Math.max(f[0], f[2]);
            g[1] = Math.max(f[1], f[0] - i);
            g[2] = f[1] + i;
            f[0] = g[0];
            f[1] = g[1];
            f[2] = g[2];
        }
        return Math.max(f[0], Math.max(f[1], f[2]));
    }
}