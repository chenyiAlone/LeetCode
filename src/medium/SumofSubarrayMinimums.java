package medium;

import java.util.Stack;

/**
 * ClassName: SumofSubarrayMinimums.java
 * Author: chenyiAlone
 * Create Time: 2019/12/9 19:57
 * Description: No.907 Sum of Subarray Minimums
 *
 *
 * Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.
 *
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 *
 *  
 *
 * Example 1:
 *
 * Input: [3,1,2,4]
 * Output: 17
 * Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
 *  
 *
 * Note:
 *
 * 1 <= A.length <= 30000
 * 1 <= A[i] <= 30000
 */
public class SumofSubarrayMinimums {


    public int sumSubarrayMins(int[] A) {
        long ret = 0;
        Stack<Integer> stack = new Stack<>();
        int[] left = new int[A.length], right = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                int pos = stack.pop();
                right[pos] = i - pos - 1;
            }

            left[i] = stack.isEmpty() ? i : (i - stack.peek() - 1);
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int pos = stack.pop();
            right[pos] = A.length - 1 - pos;
        }
        for (int i = 0; i < A.length; i++) {
            ret += + A[i] * (left[i] + 1) * (right[i] + 1);
        }
        return (int)(ret % 1000000007);
    }
}