package medium;
/**
 * ClassName: Searcha2DMatrixII.java
 * Author: chenyiAlone
 * Create Time: 2019/5/15 16:34
 * Description: No.240
 * 思路:
 *      1. binary search row start element
 *      2. bianry search row that start element less than target and end element higher than target
 *
 *
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Example:
 *
 * Consider the following matrix:
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 *
 * Given target = 20, return false.
 */
public class Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0)
            return false;
        int n = matrix[0].length;
        if (n == 0)
            return false;
        boolean res = false;
        int ll = 0, lr = m - 1;
        while (ll <= lr) {
            int mid = (ll + lr) >> 1;
            if (target < matrix[mid][0]) {
                lr = mid - 1;
            } else {
                ll = mid + 1;
            }
        }
        ll = (ll == m) ? m - 1 : (ll < 0 ? 0 : ll);
        while (ll >= 0) {
            if (matrix[ll][n - 1] >= target) {
                int l = 0, r = n - 1;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (matrix[ll][mid] < target) {
                        l = mid + 1;
                    } else if (target < matrix[ll][mid]) {
                        r = mid - 1;
                    } else {
                        return true;
                    }
                }

            }
            ll--;
        }
        return false;
    }
}