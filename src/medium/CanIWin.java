package medium;
/**
 * ClassName: CanIWin.java
 * Author: chenyiAlone
 * Create Time: 2019/9/19 22:05
 * Description: No.464 Can I Win
 * 思路:
 *      记忆化搜索
 *
 *
 *
 * In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first causes the running total to reach or exceed 100 wins.
 *
 * What if we change the game so that players cannot re-use integers?
 *
 * For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.
 *
 * Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.
 *
 * You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.
 *
 * Example
 *
 * Input:
 * maxChoosableInteger = 10
 * desiredTotal = 11
 *
 * Output:
 * false
 *
 * Explanation:
 * No matter which integer the first player choose, the first player will lose.
 * The first player can choose an integer from 1 up to 10.
 * If the first player choose 1, the second player can only choose integers from 2 up to 10.
 * The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
 * Same with other integers chosen by the first player, the second player will always win.
 *
 */
public class CanIWin {
    int[] f;

    private int dfs(int status, int maxi, int sum, int dt) {
        if (f[status] != 0)
            return f[status] - 1;
        if (sum >= dt) return 0;

        for (int i = 0; i < maxi; i++) {
            if ((status & (1 << i)) == 0) {
                int t = dfs(status | (1 << i), maxi, sum + i + 1, dt) ^ 1;
                if (t == 1) {
                    f[status] = 2;
                    return 1;
                }
            }
        }
        f[status] = 1;
        return 0;
    }

    public boolean canIWin(int mc, int dt) {
        if (mc  <= 0) return dt == 0;
        if ((mc + 1) * mc / 2 < dt) return false;
        f = new int[1 << mc];
        if (dt == 0) return true;
        return dfs(0, mc, 0, dt) == 1;
    }
}