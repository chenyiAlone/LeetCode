package medium;

/**  
 * ClassName: SetMatrixZeroes
 * @author chenyiAlone  
 * Create Time: 2019/04/03 17:54:44
 * Description: No.73
 * 思路：
 *    1. 使用 row 和 col 记录一下 martix[i][0] 和 matrix[0][j] (第一排和第一列)中是否含 0 
 *    2. 从 i = 1, j == 1 开始，matrix[i][j] == 0 时将 matrix[0][j] 和 matrix[i][0] 都置为 0
 *    3. 从 j = 1 开始，遍历第一行，如果 matrix[0][j] == 0，将这 col_index == j 一列全部置为 0
 *    4. 从 i = 1 开始，遍历第一列，如果 matrix[i][0] == 0, 将这 row_index == i 一行全部置为 0
 *    5. 如果 row == 0，将第一行全部置为 0，如果 col == 0， 将第一列全部置为 0
 *    
 *   Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

    Example 1:
    
    Input: 
    [
      [1,1,1],
      [1,0,1],
      [1,1,1]
    ]
    Output: 
    [
      [1,0,1],
      [0,0,0],
      [1,0,1]
    ]
    Example 2:
    
    Input: 
    [
      [0,1,2,0],
      [3,4,5,2],
      [1,3,1,5]
    ]
    Output: 
    [
      [0,0,0,0],
      [0,4,5,0],
      [0,3,1,0]
    ]
    Follow up:
    
    A straight forward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution? 
 */   
public class SetMatrixZeroes {
    public static void main(String[] args) {
        
    }
    
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return;
        int n = matrix[0].length;
        if (n == 0)
            return;
        int col = 1;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) 
                col = 0;
        }
        int row = 1;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0)
                row = 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                } 
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row == 0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col == 0) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
