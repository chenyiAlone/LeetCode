package medium;
/**
 * ClassName: NumberofIslands.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/6 16:35
 * Description: No.199
 * 思路:
 *      1. boolean trace[][] 记录当前位置是否已经被标记
 *      2. DFS 每进入一个连通块就将 res += 1;
 *      3. up/ down/ left/ right 四个方向寻找连通点
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 *
 */
public class NumberofIslands {
    private int res = 0;

    private void dfs(int x, int y, char[][] grid, boolean[][] trace) {
        trace[x][y] = true;
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < grid.length && 0 <= ny && ny < grid[0].length && grid[nx][ny] == '1' && !trace[nx][ny])
                dfs(nx, ny, grid, trace);
        }
    }


    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0)
            return 0;
        int n = grid[0].length;
        if (n == 0)
            return 0;

        boolean[][] trace = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!trace[i][j] && grid[i][j] == '1') {
                    dfs(i, j, grid, trace);
                    res++;
                }
            }
        }
        return res;
    }
}