package easy;
/**
 * ClassName: IslandPerimeter.java
 * Author: chenyiAlone
 * Create Time: 2019/9/11 22:02
 * Description: No.463 Island Perimeter
 * 思路:
 *
 *      统计当前的陆地相邻的海的个数即可
 *
 *
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.
 *
 *  
 *
 * Example:
 *
 * Input:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * Output: 16
 *
 *
 */
public class IslandPerimeter {

    private int[] dx = {0, 1, 0, -1};
    private int[] dy = {1, 0, -1, 0};

    private int count(int[][] grid, int x, int y) {
        int m = grid.length, n = grid[0].length;
        int ret = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i], ny = y + dy[i];
            if (0 <= nx && nx < m && 0 <= ny && ny < n && grid[nx][ny] == 1) continue;
            ret++;
        }
        return ret;
    }

    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length, ret = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    ret += count(grid, i, j);
            }
        }
        return ret;
    }

}