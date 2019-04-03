package medium;

/**  
 * ClassName: Searcha2DMatrix
 * @author chenyiAlone  
 * Create Time: 2019/04/03 18:16:46
 * Description: No.74
 * 思路：
 *   1. m = matrix.length 行数，n = matrix[0].length 列数
 *   2. lo = 0, hi = m * n - 1;
 *   3. mid = (lo + hi) >> 1; // !注意 >> 的优先级低，外层还有计算必须加括号
 *   4. key = matrix[mid / n][mid % n];     // 使用 mid 和 n 计算出所在的 row 和 col  
 *  
 */   
public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;
        int lo = 0, hi = m * n - 1;
        while (lo <= hi) {
            int  mid = (hi + lo) >> 1;
            int key = matrix[mid / n][mid % n];
            if (key < target) {
                lo = mid + 1;
            } else if (target < key) {
                hi = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
