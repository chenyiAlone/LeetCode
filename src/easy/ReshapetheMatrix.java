package easy;

/**
 * ClassName: ReshapetheMatrix.java
 * Author: chenyiAlone
 * Create Time: 2019/12/6 22:07
 * Description: No.566 Reshape the Matrix
 */
public class ReshapetheMatrix {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length, m = nums[0].length;
        if (r * c != n * m) return nums;
        int[][] ret = new int[r][c];
        int index = 0;
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < m; j++, index++)
                ret[index / c][index % c] = nums[i][j]; 
        return ret;
    }
    
}