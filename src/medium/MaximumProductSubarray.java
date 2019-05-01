package medium;
/**
 * ClassName: MaximumProductSubarray.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/1 9:12
 * Description: No.152
 * 思路:
 *      1. minArr 记录连续的最小乘积，maxArr 记录连续的最大乘积，res 记录连续子串中最大的乘积
 *      2. maxArr[i] = max{nums[i], maxArr[i - 1] * nums[i], minArr[i - 1] * nums[i]};
 *         minArr[i] = min{nums[i], minArr[i - 1] * nums[i], maxArr[i - 1] * nums[i]};
 *         res = max{res, maxArr[i]};
 *      3. 条件解析:
 *              主要的不同是因为正负数造成的，因为 nums[i] 可正可负
 *                  负数乘上一个正数变得更小，乘上一个负数变得更大
 *                  正数乘上一个负数变得更小，乘上一个正数变得更大
 *
 *
 *
 *
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 *
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] maxArr = new int[len], minArr = new int[len];
        maxArr[0] = nums[0];
        minArr[0] = nums[0];
        int res = maxArr[0];
        for (int i = 1; i < len; i++) {
            maxArr[i] = Math.max(Math.max(nums[i], minArr[i - 1] * nums[i]), maxArr[i - 1] * nums[i]);
            res = Math.max(res, maxArr[i]);
            minArr[i] = Math.min(Math.min(nums[i], nums[i] * maxArr[i - 1]), minArr[i - 1] * nums[i]);
        }
        return res;
    }
}