package medium;

import java.util.Random;
/**
 * ClassName: ShuffleanArray.java
 * Author: chenyiAlone
 * Create Time: 2019/7/23 22:26
 * Description: No.384 Shuffle an Array
 * 思路:
 *      1. clone 加速复制
 *      2. shuffle 每次将当前元素随机跟前面的一个进行交换
 *
 *
 * Shuffle a set of numbers without duplicates.
 *
 * Example:
 *
 * // Init an array with set 1, 2, and 3.
 * int[] nums = {1,2,3};
 * Solution solution = new Solution(nums);
 *
 * // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
 * solution.shuffle();
 *
 * // Resets the array back to its original configuration [1,2,3].
 * solution.reset();
 *
 * // Returns the random shuffling of array [1,2,3].
 * solution.shuffle();
 */
public class ShuffleanArray {
    private int[] nums;
    private Random random;

    public ShuffleanArray(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] ret = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            int p = random.nextInt(i + 1);
            ret[i] = ret[p];
            ret[p] = nums[i];
        }
        return ret;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */