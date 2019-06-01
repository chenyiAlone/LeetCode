package hard;
/**
 * ClassName: PatchingArray.java
 * Author: chenyiAlone
 * Create Time: 2019/6/1 22:16
 * Description: No.330
 * 思路:
 *      1. 前缀和
 *      2. 从 1, 2, 4 想拼出 4 必须加上3
 *
 * Given a sorted positive integer array nums and an integer n, add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements in the array. Return the minimum number of patches required.
 *
 * Example 1:
 *
 * Input: nums = [1,3], n = 6
 * Output: 1
 * Explanation:
 * Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
 * Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
 * Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
 * So we only need 1 patch.
 * Example 2:
 *
 * Input: nums = [1,5,10], n = 20
 * Output: 2
 * Explanation: The two patches can be [2, 4].
 * Example 3:
 *
 * Input: nums = [1,2,2], n = 5
 * Output: 0
 *
 */
public class PatchingArray {
    public int minPatches(int[] nums, int n) {
        if (n <= 0)
            return 0;
        int res = 0;
        long preSum = 0;



        for (int i = 0; i < nums.length && preSum < n; i++) {
            while (nums[i] > preSum + 1  && preSum < n) {
                res += 1;
                preSum += preSum + 1;
            }
            preSum += nums[i];
        }
        while (preSum < n) {
            res += 1;
            preSum += preSum + 1;
        }
        return res;
    }
}
