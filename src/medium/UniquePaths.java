package medium;
/**
 * 
 * ClassName: UniquePaths
 * @author chenyiAlone  
 * Create Time: 2019/03/29 18:23:47
 * Description: No.62
 * 思路:
 *    将题目抽象为一个组合问题，从 m + n 个空中选 n 个向右，C n m+n * C m m
 *    
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
    
    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
    
    How many possible unique paths are there?
    
    
    Above is a 7 x 3 grid. How many possible unique paths are there?
    
    Note: m and n will be at most 100.
    
    Example 1:
    
    Input: m = 3, n = 2
    Output: 3
    Explanation:
    From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
    1. Right -> Right -> Down
    2. Right -> Down -> Right
    3. Down -> Right -> Right
    Example 2:
    
    Input: m = 7, n = 3
    Output: 28   
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        long res = 1;
        if (m < 1 || n < 1)
            return 1;
        m--;
        n--;
        
        if (m < n) {
            //  m = 2  n = 3
            // m = 5
            // n = 2
            // m = 3
            // swap(m, n)
            m = m + n;
            n = m - n;
            m = m - n;
        }
        int j = 1;
        for (int i = m + 1; i <= m + n; i++, j++) {
            res *=  i;
            res /= j;
        }
        return (int)res;        
    }
}