package hard;
/**
 * ClassName: FindMinimuminRotatedSortedArrayII.java
 * Auther: chenyiAlone
 * Create Time: 2019/4/29 19:13
 * Description: No.154
 * 思路:
 *     1. 这道题的思路跟 153 其实是一样的，额外加了一点的边界判断
 *     2. 当左右边界的值都相等的时候，这是不想看到的，让 lo 和 hi 同时进行改变
 *     3. 当 vm 和哪侧边界相等的时候就向另一侧移动相等的指针
 *
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 *
 * Example 1:
 *
 * Input: [1,3,5]
 * Output: 1
 * Example 2:
 *
 * Input: [2,2,2,0,1]
 * Output: 0
 * Note:
 *
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 *
 */
public class FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        int res = Integer.MAX_VALUE;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            int lv = nums[lo], mv = nums[mid], rv = nums[hi];
            if (lv == rv) {
                res = Math.min(res, lv);
                hi--;
                lo++;
            } else {
                if (mv < lv || mv < rv) {
                    hi = mid - 1;
                } else if (mv == lv) {
                    lo = mid + 1;

                } else if (mv == rv) {
                    hi = mid - 1;
                } else {
                    res = Math.min(res, mv);
                    lo = mid + 1;
                }
                res = Math.min(res, mv);
            }
        }
        return res;
    }
}
