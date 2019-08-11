package medium;
/**
 * ClassName: PartitionEqualSubsetSum.java
 * Author: chenyiAlone
 * Create Time: 2019/8/11 23:01
 * Description: No.416 Partition Equal Subset Sum
 * 思路:
 *
 *      完全背包问题
 *
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Note:
 *
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 *
 *
 * Example 1:
 *
 * Input: [1, 5, 11, 5]
 *
 * Output: true
 *
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 *
 *
 * Example 2:
 *
 * Input: [1, 2, 3, 5]
 *
 * Output: false
 *
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *
 */
public class PartitionEqualSubsetSum {
    
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) return false;
        sum /= 2;
        boolean[] f = new boolean[sum + 1];
        f[0] = true;
        for (int i : nums) {
            for (int j = sum; j >= 0; j--) {
                if (f[j] && i + j <= sum)
                    f[j + i] = true;
            }
        }
        return f[sum];
    }
    
}