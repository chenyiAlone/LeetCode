package medium;
/**
 * ClassName: WiggleSubsequence.java
 * Author: chenyiAlone
 * Create Time: 2019/5/24 13:54
 * Description: No.376
 * 思路:
 *      1. 去重!
 *      2. len < 2，return len
 *      3. return 中间所有的顶点数 + 2
 *
 *
 *
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative. The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.
 *
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative. In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.
 *
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence. A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.
 *
 * Example 1:
 *
 * Input: [1,7,4,9,2,5]
 * Output: 6
 * Explanation: The entire sequence is a wiggle sequence.
 * Example 2:
 *
 * Input: [1,17,5,10,13,15,10,5,16,8]
 * Output: 7
 * Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
 * Example 3:
 *
 * Input: [1,2,3,4,5,6,7,8,9]
 * Output: 2
 * Follow up:
 * Can you do it in O(n) time?
 *
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int[] tmp = new int[nums.length];
        int p = 0;
        for (int i = 0; i < nums.length; i ++) {
            tmp[p] = nums[i];
            p ++;
            while (i < nums.length - 1 && nums[i] == nums[i + 1])
                i ++;

        }
        nums = tmp;
        if (p < 2)
            return p;
        int res = 2;
        for (int i = 1; i < p - 1; i ++) {
            int a = nums[i - 1], b = nums[i], c = nums[i + 1];
            if (a < b && b > c)
                res ++;
            else if (a > b && b < c)
                res ++;
        }
        return res;
    }
}