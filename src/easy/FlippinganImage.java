package easy;

/**
 * ClassName: FlippinganImage.java
 * Author: chenyiAlone
 * Create Time: 2019/11/16 19:03
 * Description: No.832 FlippinganImage
 */
public class FlippinganImage {

    public int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0, k = A[0].length - 1; j <= k; j++, k--) {
                int t = A[i][j] ^ 1;
                A[i][j] = A[i][k] ^ 1;
                A[i][k] = t;
            }
        }
        return A;
    }

}