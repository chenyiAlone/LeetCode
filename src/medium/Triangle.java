package medium;

import java.util.List;
/**
 * 
 * ClassName: Triangle
 * @author chenyiAlone  
 * Create Time: 2019/04/18 10:23:53
 * Description: No.120
 * 思路:
 *    1. Up Bottom 
 *        a. 自下而上遍历数组，数组储存的是下一层的状态
 *        b. 当前状态 dp[j] 更新为下一层状态的 min(dp[j], dp[j + 1]) + val;
 *        
 *    2. Bottom Up
 *        a. 自下而上遍历数组，数组储存的是上一层的状态
 *        b. 当前状态 dp[j] 更新为上一状态的 min(dp[j - 1], dp[j]) + val
 *        c. 需要注意边界问题 也就是上一层的 j 和 j - 1 < 0
 *        
 *    3. 将空间压缩为 O(n)
 *    
 *    
 *  Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
    
    For example, given the following triangle
    
    [
         [2],
        [3,4],
       [6,5,7],
      [4,1,8,3]
    ]
    The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
    
    Note:
    
    Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.  
 */
public class Triangle {
    // Bottom Up
    public int minimumTotalBottomUp(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int val = triangle.get(i).get(j);
                if (i == n - 1) {
                    dp[j] = val;
                } else {
                    dp[j] = Math.min(dp[j], dp[j + 1]) + val;
                }
            }
        }
        return dp[0];
    }
    
    
    // up down
    public int minimumTotalUpBottom(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                int val = triangle.get(i).get(j);
                if (j == 0)
                    dp[j] += val;
                else if (j == i) 
                    dp[j] = dp[j- 1] + val;
                else 
                    dp[j] = Math.min(dp[j], dp[j - 1]) + val;
            }
        }
        for (int i = 1; i < n; i++) {
            if (dp[i] < dp[0])
                dp[0] = dp[i];
        }
        return dp[0];
    }
}