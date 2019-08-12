package hard;
/**
 * ClassName: SplitArrayLargestSum.java
 * Author: chenyiAlone
 * Create Time: 2019/8/12 23:27
 * Description: No.410 Split Array Largest Sum
 * 思路:
 *      1. 从 0 - Integer.MAX_VALUE 中二分得寻找这个值
 *      2. sum{ nums[a] ... nums[b] } <= ans ，使用 ans 即 mid 的值来判断当前的组是否结束
 *              index == len 证明 mid > ans，当前的 mid 要 >= 实际的结果 ans，实际组数 <= m
 *              index != len 证明 mid >= ans 当前的 mid 要 < 实际的结果 ans， 实际组数 > m
 *
 *
 *
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 *
 * Note:
 * If n is the length of array, assume the following constraints are satisfied:
 *
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * Examples:
 *
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 *
 * Output:
 * 18
 *
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 *
 */
public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int m) {
        long ret = -1, len = nums.length;
        for (long l = 0, r = Integer.MAX_VALUE; l <= r; ) {
            long mid = (l + r) >> 1;
            int index = 0;
            for (int i = 0; i < m; i++) {
                long sum = 0;
                while (index < len && sum + nums[index] <= mid) {
                    sum += nums[index];
                    index++;
                }
            }
            boolean flag = index == len;
            if (flag) {
                r = mid - 1;
                ret = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int)ret;
    }
    
}