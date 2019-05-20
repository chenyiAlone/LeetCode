package medium;

import java.util.Arrays;
/**
 * ClassName: LongestIncreasingSubsequence.java
 * Author: chenyiAlone
 * Create Time: 2019/5/20 15:26
 * Description: No.300
 * 思路:
 *      1. 维护一个一个 初始化为 Integer.MAX_VALUE 的数组
 *      2. 更新这个数组中不小于它的元素
 *      3. Binary Search
 *
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 *
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 *
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int[] f = new int[len];
        Arrays.fill(f, Integer.MAX_VALUE);
        int res = 0;
        for (int i = 0; i < len; i++) {
            int l = 0, r = res;
            while (l <= r) {
                int mid = (l + r) >> 1;
                // 1 2 3
                // 2
                if (f[mid] < nums[i])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            f[l] = nums[i];
            res = Math.max(res, l);

        }
        return res + 1;
    }
}