package medium;
/**
 * 
 * ClassName: UniquePathsII
 * @author chenyiAlone  
 * Create Time: 2019/03/31 14:01:38
 * Description: No.63
 * 思路：
 *    DP
 *    1. 建立一个 arr[m][n], init arr[0][0] = obstacleGird[0][0] == 1 ? 0 : 1;
 *    2. 遍历 arr ,扫描到 arr[i][j] 时，判断右侧元素以及下方元素是否存在 && obstacleGird[][] != 1，更新 arr[i + 1][j] 和 arr[i][j + 1];
 *    3. return arr[m - 1][n - 1];
 *   A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
    
    Now consider if some obstacles are added to the grids. How many unique paths would there be?
    
    An obstacle and empty space is marked as 1 and 0 respectively in the grid.
    
    Note: m and n will be at most 100.
    
    Example 1:
    
    Input:
    [
      [0,0,0],
      [0,1,0],
      [0,0,0]
    ]
    Output: 2
    Explanation:
    There is one obstacle in the middle of the 3x3 grid above.
    There are two ways to reach the bottom-right corner:
    1. Right -> Right -> Down -> Down
    2. Down -> Down -> Right -> Right
 */
public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0,0,0},
                {0,1,0},
                {0,0,0}
                };
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(obstacleGrid));
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m < 1)
            return 0;
        int n = obstacleGrid[0].length;
        if (n < 1)
            return 0;
        int[][] arr = new int[m][n];
        arr[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j != n - 1 && obstacleGrid[i][j + 1] != 1) {
                    arr[i][j + 1] += arr[i][j];
                }
                if (i != m -1 && obstacleGrid[i + 1][j] != 1) {
                    arr[i + 1][j] += arr[i][j];
                }
            }
        }
        return arr[m - 1][n - 1];
    }
}