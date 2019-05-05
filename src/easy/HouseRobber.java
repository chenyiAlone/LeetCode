package easy;

import java.util.Arrays;

/**
 * ClassName: HouseRobber.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/5 16:57
 * Description: No.198
 * 思路:
 *      1. 建立状态转移方程，这个题目里就是偷不偷当前这个房间
 *          1). 偷
 *                  rob(index - 2) + nums[index]
 *          2). 不偷
 *                  rob(index - 1)
 *      2. 根据转移方程列出递归式，top-down
 *      3. 增加记忆数组 memo[nums.length + 1] 来保存已经计算过的值，来避免重复计算，top-down
 *      4. 使用 DP 迭代推导，down-top
 *      5. 使用变量，down-top
 *
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 *
 * Input: [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 *              Total amount you can rob = 2 + 9 + 1 = 12.
 *
 *
 */
public class HouseRobber {
    /**
     * 1. 使用递归
     *      出现重复运算，效率低
     * @param nums
     * @return
     */
    public int robRecursive(int[] nums) {
        return rob(nums.length - 1, nums);
    }
    private int rob(int index, int[] nums) {
        if (index < 0)
            return 0;
        return Math.max(rob(index -1, nums), rob(index - 2, nums) + nums[index]);
    }

    /**
     * 2. 使用记忆数组
     *      space: O(N)
     * @param nums
     * @return
     */
    public int robRecursiveMemo(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob(nums.length, nums, memo);
    }
    private int rob(int index, int[] memo, int[] nums) {
        if (index < 0)
            return 0;
        if (memo[index] != -1)
            return memo[index];
        memo[index] = Math.max(rob(index - 1, nums, memo), rob(index - 2, nums, memo) + nums[index]);
        return memo[index];
    }

    /**
     * 3. 使用 DP 一维数组
     *      space: O(N)
     * @param nums
     * @return
     */
    public int robDP(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[nums.length];
    }


    /**
     * 4. 使用 两个变量保存依赖的两个状态
     *      当前状态只依赖于前一个以及再前一个状态，可以用 prev1 + prev2 来保存状态
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] f = new int[nums.length + 1];
        int prev1 = 0;
        int prev2 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = prev2;
            prev2 = Math.max(prev2, prev1 + nums[i]);
            prev1 = tmp;
        }
        return prev2;
    }
}
