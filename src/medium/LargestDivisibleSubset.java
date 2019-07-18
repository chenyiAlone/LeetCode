package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * ClassName: LargestDivisibleSubset.java
 * Author: chenyiAlone
 * Create Time: 2019/7/18 23:35
 * Description: No.368 Largest Divisible Subset
 *
 *      1. 将数组排序
 *      2. f[i] > f[j] + 1 证明比原来的要长，就保存路径到 solution 中
 *      3. 将 solution 中的路径显示出来
 *
 *
 *
 *
 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
 *
 * Si % Sj = 0 or Sj % Si = 0.
 *
 * If there are multiple solutions, return any subset is fine.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2] (of course, [1,3] will also be ok)
 * Example 2:
 *
 * Input: [1,2,4,8]
 * Output: [1,2,4,8]
 *
 */
public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        List<Integer> ret = new ArrayList<>();
        if (len == 0) return ret;

        Arrays.sort(nums);
        int[] f = new int[len], solution = new int[len];
        Arrays.fill(f, -1);
        Arrays.fill(solution, -1);
        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && f[i] < f[j] + 1) {
                    f[i] = f[j] + 1;
                    solution[i] = j;
                }
            }
            if (f[i] > f[ans]) ans = i;
        }
        for (int i = ans; i != -1; i = solution[i]) {
            ret.add(nums[i]);
        }
        return ret;
    }
}
