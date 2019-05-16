package easy;

import java.util.Arrays;

/**
 * ClassName: MissingNumber.java
 * Author: chenyiAlone
 * Create Time: 2019/5/16 10:39
 * Description: No.268
 * 思路:
 *      一、
 *          1. targetSum 为不缺数字的和，sum 为数组实际的和
 *          2. return targetSum - Sum
 *      二、
 *          1. sort array
 *          2. binary search 第一个num[i] 大于 i
 *
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 *
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *
 */
public class MissingNumber {
    public int missingNumberBySum(int[] nums) {
        long len = nums.length;
        long targetSum = 0, sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            targetSum += i + 1;
        }
        return (int)(targetSum - sum);
    }

    public int missingNumberByBinarySearch(int[] nums) {
        Arrays.sort(nums);
        int  l = 0, r = nums.length -1;
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] > mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;

    }
}