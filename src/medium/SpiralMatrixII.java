package medium;
/**
 * 
 * ClassName: SpiralMatrixII
 * @author chenyiAlone  
 * Create Time: 2019/03/27 16:28:12
 * Description: No.59
 * 思路：
 *    1. 方向数组
 *        int[] x = {1, 0, -1, 0};
 *        int[] y = {0, 1, 0, -1};
 *    2. 记录足迹的二维数组
 *        boolean[][] board = new boolean[n][n];
 *    3. 结束判定
 *        boolean flag = 0 <= n_i && n_i < n && 0 <= n_j && n_j < n && !board[n_i][n_j];
 *        flag == false && count > 4 // 四个方向都不能继续前进
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n == 0)
            return null;
        
        int[] x = {1, 0, -1, 0};
        int[] y = {0, 1, 0, -1};
        
        boolean[][] board = new boolean[n][n];
        int[][] matrix = new int[n][n];
        int index = 0;
        int num = 1;
        for (int i = 0, j = 0; ; ) {
            
            matrix[i][j] = num++;
            board[i][j] = true;
            int count = 1;
            while (true) {
                
                int n_i = i + y[index];
                int n_j = j + x[index];

                if (0 <= n_i && n_i < n && 0 <= n_j && n_j < n && !board[n_i][n_j]) {
                    i = n_i;
                    j = n_j;
                    break;
                } else {
                    index = (index + 1) % 4;
                }
                count++;
                if (count > 4)
                    break;
            }
            if (count > 4)
                break;
        }
        return matrix;
    }
}
