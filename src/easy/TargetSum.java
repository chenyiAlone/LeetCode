package easy;

/**
 * ClassName: .java
 * Author: chenyiAlone
 * Create Time: 2019/9/20 22:19
 * Description: No.494 Target Sum
 *
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
 *
 * Find out how many ways to assign symbols to make sum of integers equal to target S.
 *
 * Example 1:
 * Input: nums is [1, 1, 1, 1, 1], S is 3.
 * Output: 5
 * Explanation:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * Note:
 * The length of the given array is positive and will not exceed 20.
 * The sum of elements in the given array will not exceed 1000.
 * Your output answer is guaranteed to be fitted in a 32-bit integer.
 *
 */
public class TargetSum {
    private int ret;
    private int[] arr;
    
    private void dfs(int index, int sum, int target) {
        if (index == arr.length) {
            if (sum == target) ret++;
            return;
        }
        dfs(index + 1, sum + arr[index], target);
        dfs(index + 1, sum - arr[index], target);
    }

    public int findTargetSumWays(int[] nums, int S) {
        int len = nums.length;
        arr = nums;
        dfs(0, 0, S);
        return ret;
    }

}