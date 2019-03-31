package medium;
/**
 * 
 * ClassName: MinimumPathSum
 * @author chenyiAlone  
 * Create Time: 2019/03/31 14:28:01
 * Description: No.64
 * 思路:
 *    1. DP 数组 arr[m][n] 保存状态
 *    2. arr[i][j] = Math.min(arr[i - 1][j], arr[i][j - 1]);
 *    3. return arr[m - 1][n - 1];
 *    
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
    
    Note: You can only move either down or right at any point in time.
    
    Example:
    
    Input:
    [
      [1,3,1],
      [1,5,1],
      [4,2,1]
    ]
    Output: 7
    Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int res = 0;
        int m = grid.length;
        if (m < 1)
            return res;
        int n = grid[0].length;
        if (n < 1)
            return res;
        int[][] arr = new int[m][n];
        arr[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    arr[i][j] = grid[i][j] + arr[i][j - 1];
                } else if (j == 0) {
                    arr[i][j] = grid[i][j] + arr[i - 1][j];
                } else {
                    arr[i][j] = grid[i][j] + Math.min(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }
        return arr[m - 1][n - 1];        
    }
}
