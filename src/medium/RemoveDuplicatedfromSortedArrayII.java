package medium;
/**
 * ClassName: RemoveDuplicatedfromSortedArrayII.java
 * Auther: chenyiAlone
 * Create Time: 2019/4/28 11:13
 * Description: No.81
 * 思路:
 *     ps:[2,5,6,0,0,1,2] 数组随机旋转，原数组的起点就是这里的 nums[3] = 0 > nums[oldStart];
 *
 *     1. 数组是在一个位置打乱的，根据 nums[mid] 和 nums[lo] 、nums[hi] 大小关系分为两部分
 *         1). nums[mid] < nums[hi] || nums[mid] < nums[lo] , (oldStart 和 lo 可能重合)
 *                 对应 { nums[lo], ... , nums[oldStart], ..., nums[mid], ..., nums[hi] }
 *                 lo 右移的唯一情况是 target < nums[mid] && target  <= nums[hi]
 *
 *         2). nums[mid] > nums[lo] || nums[mid] > nums[hi] , (oldStart 和 hi 可能重合)
 *                 对应 { nums[lo], ... , nums[mid], ... , nums[oldStart], ... , nums[hi] }
 *                 hi 左移的唯一情况是 nums[mid] < target && nums[lo] <= target
 *
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Example 1:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * Follow up:
 *
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 *
 */
public class RemoveDuplicatedfromSortedArrayII {
    public boolean search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) >> 1;
            if (nums[mid] == target)
                return true;
            if (nums[mid] < nums[hi] || nums[mid] < nums[lo]) {
                if (target > nums[mid] && target <= nums[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1;

            } else if (nums[mid] > nums[lo] || nums[mid] > nums[hi]) {
                if (target < nums[mid] && target >= nums[lo])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            } else {
                hi--;
            }
        }
        return false;
    }
}
