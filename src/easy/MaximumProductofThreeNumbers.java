package easy;

import java.util.Arrays;

/**
 * ClassName: MaximumProductofThreeNumbers.java
 * Author: chenyiAlone
 * Create Time: 2019/12/14 18:29
 * Description: No.628 Maximum Product of Three Numbers
 *
 *
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: 6
 *  
 *
 * Example 2:
 *
 * Input: [1,2,3,4]
 * Output: 24
 *  
 *
 * Note:
 *
 * The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 * Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 *
 */
public class MaximumProductofThreeNumbers {

    public int maximumProduct(int[] nums) {
        int[] max = {-1, -1, -1}, min = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (max[0] == -1 || nums[i] > nums[max[0]]) {
                max[2] = max[1];    max[1] = max[0];    max[0] = i;
            } else if (max[1] == -1 || nums[i] > nums[max[1]]) {
                max[2] = max[1];    max[1] = i;
            } else if (max[2] == -1 || nums[i] > nums[max[2]]) {
                max[2] = i;
            }
            if (min[0] == -1 || nums[i] < nums[min[0]]) {
                min[1] = min[0];    min[0] = i;
            } else if (min[1] == -1 || nums[i] < nums[min[1]]) {
                min[1] = i;
            }
        }
        return Math.max(nums[min[0]] * nums[min[1]] * nums[max[0]], nums[max[0]] * nums[max[1]] * nums[max[2]]);
    }

    public int maximumProductNLogN(int[] nums) {
        Arrays.sort(nums);
        int ret = Integer.MIN_VALUE;
        ret = Math.max(ret, nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
        ret = Math.max(ret, nums[nums.length - 1] * nums[nums.length - 2] * nums[0]);
        ret = Math.max(ret, nums[0] * nums[1] * nums[nums.length - 1]);
        return ret;
    }


}