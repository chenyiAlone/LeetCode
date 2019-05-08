package medium;
/**
 * ClassName: HouseRobberII.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/8 17:47
 * Description: No.213
 * 思路:
 *      1. enum two cases
 *          1). rob     0, not rob len - 1
 *          2). not rob 0, rob     len - 1
 *      2. status i only depend on status i - 1 ans status i - 2
 *          use prev1 store status i - 1
 *              prev2 store status i - 2
 *
 *
 *
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 *
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 *              because they are adjacent houses.
 * Example 2:
 *
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 *
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        int res = 0;
        if (nums.length == 0)
            return res;
        int prev1 = 0, prev2 = nums[0];

        for (int i = 1; i < nums.length - 1; i++) {
            int tmp = prev2;
            prev2 = Math.max(prev1 + nums[i], prev2);
            prev1 = tmp;
        }
        res = prev2;
        prev1 = 0;
        prev2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int tmp = prev2;
            prev2 = Math.max(prev1 + nums[i], prev2);
            prev1 = tmp;
        }
        res = Math.max(res, prev2);
        return res;
    }
}
