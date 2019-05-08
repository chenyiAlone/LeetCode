package medium;
/**
 * ClassName: MinimumSizeSubarraySum.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/8 16:44
 * Description: No.209
 * 思路:
 *      1. prefix[i] store prefix sum(from arr[0] to arr[i])
 *      2. use ans record mid minimum
 *
 *          res ← len + 1
 *          for i = 0 to len - 1
 *              left ← i, right ← len - 1
 *              ans = len * 2
 *              while (left <= right)
 *                  mid ← (left + right) >> 1
 *                  sum ← prefix[mid] - (mid == 0 ? 0 : prefix[mid - 1])
 *                  if sum > target
 *                      ans = mid
 *                      right ← mid - 1
 *                  else
 *                      left ← mid + 1
 *              res ← min{ ans, res }
 *          if res = len + 1
 *              return 0
 *          else
 *              return res
 *
 *
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 *
 */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length, res = len + 1;
        if (len == 0)
            return 0;
        long[] prefix = new long[nums.length];
        for (int i = 0; i < len; i++) {
            prefix[i] = (i == 0 ? 0 : prefix[i - 1]) + nums[i];
        }
        // 1 2 3 4
        // 1 3 6 10
        for (int i = 0; i < len; i++) {
            int l = i, r = len - 1;
            int ans = len * 2;
            while (l <= r) {
                int mid = (l + r) >> 1;
                long sum = prefix[mid] - (i == 0 ? 0 : prefix[i - 1]);
                if (sum >= s) {
                    ans = mid;
                    r = mid - 1;
                } else
                    l = mid + 1;
            }
            res = Math.min(res, ans - i + 1);
        }
        return (res == len + 1 ? 0 : res);
    }
}
