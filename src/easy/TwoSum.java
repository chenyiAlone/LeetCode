package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 *  Given nums = [2, 7, 11, 15], target = 9,
 *  Because nums[0] + nums[1] = 2 + 7 = 9,
 *  return [0, 1].
 * 
 * 
 * @author chenyiAlone
 */
public class TwoSum {

    /**
     * 1. for 2 => O(n^2)
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int answer = nums[i] + nums[j];
                if ((answer == target) && i != j)
                    return new int[]{i, j};
            }
        }
        return null;
    }

    /**
     * 3. hash
     */
    public int[] twoSumHash(int[] nums, int target) {
        if (nums.length < 1)
            return new int[]{};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (map.containsKey(n)) {
                return new int[]{map.get(n), i};
            }
            map.put(target - n, i);
        }
        return new int[]{};
    }

    static class Pair implements Comparable<Pair> {
        public int left = 0;
        public int right = 0;

        Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
        @Override
        public int compareTo(Pair target) {
            return this.left - target.left;
        }
    }


    /**
     * 3. sort+ 双指针
     *
     */
    public int[] twoSumDoublePointer(int[] nums, int target) {
        if (nums == null || nums.length < 1) return new int[]{};
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        Arrays.sort(pairs);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = pairs[l].left + pairs[r].left;
            if (sum < target) l++;
            else if (sum > target) r--;
            else return new int[]{pairs[l].right, pairs[r].right};
        }
        return new int[]{};
    }

}
