package medium;
/**
 * ClassName: MaxAreaofIsland.java
 * Author: chenyiAlone
 * Create Time: 2019/10/25 18:00
 * Description: No.695 Max Area of Island
 *
 *
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)
 *
 * Example 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
 * Example 2:
 *
 * [[0,0,0,0,0,0,0,0]]
 * Given the above grid, return 0.
 * Note: The length of each dimension in the given grid does not exceed 50.
 *
 */
public class MaxAreaofIsland {
    
    private int ret;
    private int sum;
    private int[] dx = {1, 0, -1, 0};
    private int[] dy = {0, 1, 0, -1};

    private void dfs(int x, int y, int[][] grid, boolean[][] trace) {
        trace[x][y] = true;
        sum++;
        ret = Math.max(ret, sum);
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (0 <= nx && nx < grid.length && 0 <= ny && ny < grid[0].length && grid[nx][ny] == 1 && !trace[nx][ny])
                dfs(nx, ny, grid, trace);
        }

    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] trace = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1 && !trace[i][j]) {
                    sum = 0;
                    dfs(i, j, grid, trace);
                }
        }
        return ret;
    }
    
}
