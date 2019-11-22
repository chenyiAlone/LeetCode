package easy;

/**
 * ClassName: TransposeMatrix.java
 * Author: chenyiAlone
 * Create Time: 2019/11/22 22:05 
 * Description: No.867 Transpose Matrix
 */
public class TransposeMatrix {

    public int[][] transpose(int[][] A) {
        int m = A.length, n = A[0].length;
        int[][] ret = new int[n][m];
        int len = m * n;
        for (int i = 0; i < len; i++)
            ret[i % n][i / n] = A[i / n][i % n];
        return ret;
    }
    
}