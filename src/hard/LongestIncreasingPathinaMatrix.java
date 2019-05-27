package hard;

import java.util.Arrays;
/**
 * ClassName: LongestIncreasingPathinaMatrix.java
 * Author: chenyiAlone
 * Create Time: 2019/5/27 17:07
 * Description: No.329
 * 思路:
 *      1. DFS + 记忆数组
 *      2. 从每个点向四周搜索，每个点都返回他的相邻四个方向转移过来的最大值
 *
 *
 * Given an integer matrix, find the length of the longest increasing path.
 *
 * From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 *
 * Example 1:
 *
 * Input: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * Example 2:
 *
 * Input: nums =
 * [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 *
 */
public class LongestIncreasingPathinaMatrix {
    private int m, n;
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};
    private int[][] f;


    private int dp(int x, int y, int[][] matrix) {
        if (f[x][y] != -1)
            return f[x][y];
        f[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];

            if (0 <= a && a < m && 0 <= b && b < n && matrix[a][b] < matrix[x][y])
                f[x][y] = Math.max(f[x][y], dp(a, b, matrix) + 1);
        }
        return f[x][y];
    }


    public int longestIncreasingPath(int[][] matrix) {
        if ((m = matrix.length) == 0 || (n = matrix[0].length) == 0)
            return 0;
        int res = 0;
        f = new int[m][n];
        for (int[] arr : f)
            Arrays.fill(arr, -1);

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dp(i, j, matrix));
            }
        return res;
    }
}