package medium;

import java.util.Random;

/**
 * ClassName: RandomPickIndex.java
 * Author: chenyiAlone
 * Create Time: 2019/8/3 21:47
 * Description: No.398 Random Pick Index
 * 思路:
 *      1. random.nextInt(++cnt) 用来获取下一个值
 *      2. == 0 的概率为 1/cnt，也就是 nextInt(++cnt) 出现 0 的概率
 *
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.
 *
 * Note:
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 *
 * Example:
 *
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 *
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * solution.pick(3);
 *
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 *
 */
public class RandomPickIndex {
    private int[] nums;
    private Random random;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        int ret = -1;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) continue;
            if (random.nextInt(++cnt) == 0) ret = i;
        }
        return ret;
    }
}
