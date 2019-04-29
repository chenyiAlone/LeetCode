package medium;
/**
 * ClassName: FindMinimuminRotatedSortedArray.java
 * Auther: chenyiAlone
 * Create Time: 2019/4/29 19:02
 * Description: No.153
 * 思路:
 *     1. 因为这种情况没有重复，所以可以直接归类为两种情况
 *          1). 落在了旋转中心的左边
 *          2). 落在了旋转中心的右边
 *     2. 使用 res init Integer.MIN_VALUE 方法 mid 的左边小于 nums[mid] 的元素不存在
 *
 *
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 *
 * Example 1:
 *
 * Input: [3,4,5,1,2]
 * Output: 1
 * Example 2:
 *
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 *
 */
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        int res = Integer.MAX_VALUE;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            int lv = nums[lo], mv = nums[mid], rv = nums[hi];
            if (mv < lv || mv < rv) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
            res = Math.min(res, mv);
        }
        return res;
    }
}