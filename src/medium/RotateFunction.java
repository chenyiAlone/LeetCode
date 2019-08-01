package medium;
/**
 * ClassName: RotateFunction.java
 * Author: chenyiAlone
 * Create Time: 2019/8/1 21:36
 * Description: No.396 Rotate Function
 * 思路:
 *      1.
 *
 *
 *
 *
 */
public class RotateFunction {
    
    public int maxRotateFunction(int[] A) {
        int sum = 0, total = 0;
        for (int i = 0; i < A.length; i++) {
            total += A[i];
            sum += A[i] * i;
        }
        int ret = sum;
        for (int i = A.length - 1; i > 0; i--) {
            sum += total - A.length * A[i];
            ret = Math.max(ret, sum);
        }
        return ret;
    }
    
}