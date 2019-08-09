package easy;
/**
 * ClassName: ArithmeticSlices.java
 * Author: chenyiAlone
 * Create Time: 2019/8/9 23:54
 * Description: No.413 Arithmetic Slices
 * 思路:
 *      根据等差数列的性质 以及 n 个等差数列的子集的个数
 *      3 1
 *      4 3
 *      5 6
 *
 *      sum + 2
 *
 *
 *
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 *
 * For example, these are arithmetic sequence:
 *
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 *
 * 1, 1, 2, 5, 7
 *
 * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 *
 * A slice (P, Q) of array A is called arithmetic if the sequence:
 * A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 *
 * The function should return the number of arithmetic slices in the array A.
 *
 *
 * Example:
 *
 * A = [1, 2, 3, 4]
 *
 * return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 *
 */
public class ArithmeticSlices {
    
    public int numberOfArithmeticSlices(int[] A) {
        int ret = 0, cnt = 0, len;
        if ((len = A.length) < 3) return ret;
        for (int i = 2; i < len; i++) {
            if (A[i - 1] - A[i - 2] == A[i] - A[i - 1]) {
                cnt++;
            } else {
                ret += (cnt + 1) * cnt / 2;
                cnt = 0;
            }
        }
        return ret + (cnt + 1) * cnt / 2;
    }
    
}