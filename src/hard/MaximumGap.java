package hard;

import static util.Utils.printArray;

/**
 * ClassName: MaximumGap.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/3 17:47
 * Description:No.164
 * 思路:
 *      1. Cardinality Sort 基数排序
 *      2. 排序原理:
 *          1). 记录数组中最大元素，用于确定外层循环的次数  10 ^ n > max => n 次循环
 *          2). tmp[len] 用于暂存排序后的元素，bucket[10] 作为排序的桶
 *          3). for i = 0 to len - 1    // 记录对应该桶的元素个数
 *                  bucket[(nums[i] / exp) % 10]++
 *          4). for i = 1 to len - 1    // 更新 bucket 中的值为对应的位置 index + 1 = bucket
 *                  bucket[i] += bucket[i - 1];
 *          5). for i = len - 1 to 0    //
 *                  output[bucket[(nums[i] / exp) % 10]] = nums[i];
 *          6). nums[i] = output[i];    // 刷新到原数组
 *
 *
 *
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 *
 * Return 0 if the array contains less than 2 elements.
 *
 * Example 1:
 *
 * Input: [3,6,9,1]
 * Output: 3
 * Explanation: The sorted form of the array is [1,3,6,9], either
 *              (3,6) or (6,9) has the maximum difference 3.
 * Example 2:
 *
 * Input: [10]
 * Output: 0
 * Explanation: The array contains less than 2 elements, therefore return 0.
 * Note:
 *
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * Try to solve it in linear time/space.
 *
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        int len = nums.length;
        if (len < 2)
            return 0;
        printArray(nums);
        cardinalitySort(nums);
        printArray(nums);
        int res = nums[1] - nums[0];
        for (int i = 1; i < len - 1; i++) {
            res = Math.max(res, nums[i + 1] - nums[i]);
        }

        return res;
    }

    private void cardinalitySort(int[] nums) {
        int max = nums[0], len = nums.length;
        for (int i = 1; i < nums.length; i++) {
            if (max < nums[i])
                max = nums[i];
        }
        for (int exp = 1; exp <= max; exp *= 10) {
            int[] tmp = new int[len];
            int[] bucket = new int[10];
            for (int j : nums) {
                bucket[(j / exp)  % 10]++;
            }
            for (int j = 1; j < 10; j++) {
                bucket[j] = bucket[j] + bucket[j - 1];
            }
            for (int j = len - 1; j >= 0; j--) {
                int p = (nums[j] / exp) % 10;
                tmp[bucket[p] - 1] = nums[j];
                bucket[p]--;
            }
            System.arraycopy(tmp, 0, nums, 0, len);
        }
    }
}