package medium;

import java.util.*;
/**
 * ClassName: PacificAtlanticWaterFlow.java
 * Author: chenyiAlone
 * Create Time: 2019/8/14 23:12
 * Description: No.417 Pacific Atlantic Water Flow
 * 思路:
 *      1. 使用两个数组来记录可以从边缘流到的位置
 *      2. BFS 来搜索所有的可以流到该位置的点
 *
 * Given an m x n matrix of non-negative integers representing the height of each unit
 * cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix
 * and the "Atlantic ocean" touches the right and bottom edges.
 *
 * Water can only flow in four directions (up, down, left, or right) from a cell to another
 * one with height equal or lower.
 *
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic
 * ocean.
 *
 * Note:
 *
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 *
 *
 * Example:
 *
 * Given the following 5x5 matrix:
 *
 *   Pacific ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * Atlantic
 *
 * Return:
 *
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses
 * in above matrix).
 *
 *
 */
public class PacificAtlanticWaterFlow {

    private void bfs(int[][] matrix, int[][] ans, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] == 1)
                    queue.offer(new int[]{i, j});
            }
        }
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] a = queue.poll();
            int x = a[0], y = a[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && ans[nx][ny] == 0
                        && matrix[nx][ny] >= matrix[x][y]) {
                    ans[nx][ny] = 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }

    }

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> ret = new ArrayList<>();
        int m, n;
        if ((m = matrix.length) == 0 || (n = matrix[0].length) == 0) return ret;
        int[][] atlantic = new int[m][n], pacific = new int[m][n];
        for (int i = 0; i < m; i++) {
            pacific[i][0] = 1;
            atlantic[i][n - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            pacific[0][i] = 1;
            atlantic[m - 1][i] = 1;
        }
        bfs(matrix, atlantic, m, n);
        bfs(matrix, pacific, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    ret.add(Arrays.asList(i, j));
                }
            }
        }
        return ret;
    }

}