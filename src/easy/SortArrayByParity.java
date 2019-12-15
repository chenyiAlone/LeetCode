package easy;

/**
 * ClassName: SortArrayByParity.java
 * Author: chenyiAlone
 * Create Time: 2019/12/15 19:41 
 * Description: No.905 Sort Array By Parity
 */
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        for (int i = 0, j = A.length - 1; i < j; ) {
            if (A[i] % 2 == 1) {
                int t = A[j];
                A[j] = A[i];
                A[i] = t;
                j--;
            } else 
                i++;
        }
        return A;
    }
    
}