package easy;

/**
 * ClassName: MaxConsecutive.java
 * Author: chenyiAlone
 * Create Time: 2019/9/7 
 * Description: No.485 Max Consecutive Ones
 *
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 *
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 *     The maximum number of consecutive 1s is 3.
 * Note:
 *
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */
public class MaxConsecutiveOnes {

    
    public int findMaxConsecutiveOnes(int[] nums) {
        int ptr = 0, cnt = 0, ret = 0;
        for (int i : nums) {
            if (i == 1) {
                cnt += 1;
                ret = Math.max(ret, cnt);
            } else {
                cnt = 0;
            }
        }
        return ret;
    }
}