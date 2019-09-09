package medium;
/**
 * ClassName: Pattern.java
 * Author: chenyiAlone
 * Create Time: 2019/9/9 12:22
 * Description: No.456 132 Pattern
 * 思路:
 *      1. mi[] 记录到当前位置的最小的数
 *      2. 从后向前，找到
 *
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.
 *
 * Note: n will be less than 15,000.
 *
 * Example 1:
 * Input: [1, 2, 3, 4]
 *
 * Output: False
 *
 * Explanation: There is no 132 pattern in the sequence.
 * Example 2:
 * Input: [3, 1, 4, 2]
 *
 * Output: True
 *
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 * Example 3:
 * Input: [-1, 3, 2, 0]
 *
 * Output: True
 *
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 *
 *
 */
public class Pattern {

    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        int[] mi = new int[len];
        if (len > 2) mi[0] = nums[0];
        else return false;
        for (int i = 1; i < len; i++) {
            mi[i] = Math.min(nums[i - 1], nums[i]);
        }
        for (int i = len - 1; i > 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[i] && nums[j] > mi[i - 1]) return true;
            }
        }
        return false;
    }
}