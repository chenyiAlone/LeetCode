package medium;
/**
 * ClassName: FindPeakElement.java
 * Auther: chenyiAlone
 * Create Time: 2019/4/30 23:45
 * Description: No.162
 * 思路:
 *      1. 寻找山顶，任意一个即可
 *      2. mid 的情况
 *          1). lv < nums[mid] > rv, return mid;
 *          2). lv > nums[mid], hi = mid - 1;
 *          3). nums[mid] < rv, lo = mid + 1;
 *      3. O(lgN) 的时间复杂度，只能使用 bianry search
 *
 *
 *
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 *              or index number 5 where the peak element is 6.
 * Note:
 *
 * Your solution should be in logarithmic complexity.
 *
 *
 *
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            switch(check(mid, nums)) {
                case -1:
                    hi = mid - 1;
                    break;
                case 0:
                    return mid;
                case 1:
                    lo = mid + 1;
                    break;
            }
        }
        return 0;
    }

    private int check(int index, int[] nums) {
        int lv = index == 0 ? Integer.MIN_VALUE : nums[index - 1];
        int rv = index == nums.length - 1 ? Integer.MIN_VALUE : nums[index + 1];
        int mv = nums[index];
        if (lv < mv && mv > rv)
            return 0;
        if (lv > mv)
            return -1;
        if (mv < rv)
            return 1;
        return 0;
    }
}