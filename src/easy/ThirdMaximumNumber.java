package easy;

/**
 * ClassName: ThirdMaximumNumber.java
 * Author: chenyiAlone
 * Create Time: 2019/8/10 21:52
 * Description: No.414 Third Maximum Number
 * 思路:
 *      1. long 来避免出现 Integer.MIN_VALUE 的时候的情况
 *      2. 少于三个就返回最大的
 *
 * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * Example 1:
 * Input: [3, 2, 1]
 *
 * Output: 1
 *
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 *
 * Output: 2
 *
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 *
 * Output: 1
 *
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 *
 */
public class ThirdMaximumNumber {
    
    public int thirdMax(int[] nums) {
        long[] maxVal = {-(1L << 35), -(1L << 35), -(1L << 35)};
        for (int num : nums) {
            for (int i = 0; i < 3; i++) {
                if (num == maxVal[i]) break;
                if (num > maxVal[i]) {
                    System.arraycopy(maxVal, i, maxVal, i + 1, 2 - i);
                    maxVal[i] = num;
                    break;
                }
            }
        }
        if (maxVal[2] != -(1L << 35)) return (int)maxVal[2];
        return (int)maxVal[0];
    }
    
}