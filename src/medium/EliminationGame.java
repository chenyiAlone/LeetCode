package medium;
/**
 * ClassName: EliminationGame.java
 * Author: chenyiAlone
 * Create Time: 2019/7/28 22:54
 * Description: No.390 Elimination Game
 * 思路:
 *      1. DFS + direct 代表方向进行模拟
 *
 *
 *
 * There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.
 *
 * Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.
 *
 * We keep repeating the steps again, alternating left to right and right to left, until a single number remains.
 *
 * Find the last number that remains starting with a list of length n.
 *
 * Example:
 *
 * Input:
 * n = 9,
 * 1 2 3 4 5 6 7 8 9
 * 2 4 6 8
 * 2 6
 * 6
 *
 * Output:
 * 6
 *
 */
public class EliminationGame {
    
    private int dfs(int len, boolean direct) {
        if (len == 1) return 1;
        if (direct) {
            int ans = dfs(len / 2, false);
            return ans * 2;
        } else {
            if (len % 2 == 0) {
                int ans = dfs(len / 2, true);
                return ans * 2 - 1;
            } else {
                int ans = dfs(len / 2, true);
                return ans * 2;
            }
        }
    }

    public int lastRemaining(int n) {
        return dfs(n, true);
    }

}