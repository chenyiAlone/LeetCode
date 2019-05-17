package medium;

import java.util.LinkedList;
import java.util.Queue;
/**
 * ClassName: PerfectSquares.java
 * Author: chenyiAlone
 * Create Time: 2019/5/17 14:03
 * Description: No.279
 * 思路:
 *      1. BFS + 从 0 开始生成
 *      2. if (f[m + i * i] == 0) {
 *             f[m + i * i] = f[m] + 1;
 *             queue.offer(m + i * i);
 *         }
 *
 *
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int[] f = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int m = queue.poll();
            for (int i = 1; i * i + m <= n; i++) {
                if (f[i * i + m] == 0) {
                    f[i * i + m] = f[m] + 1;
                    queue.offer((i * i + m));
                }
            }
        }
        return f[n];
    }
}
