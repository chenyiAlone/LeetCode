package medium;
/**
 * 
 * ClassName: SearchinRotatedSortedArray
 * @author chenyiAlone  
 * Create Time: 2019/03/18 16:47:18
 * Description: No.33
 * 总结：
 *    题目要求的是 O(lg n) 的时间复杂度，所以需要使用二分查找，这道题目中情况一共两种特殊情况
 *    1. 当 nums[mid] < target 时，target ... nums[mid]
 *    2. 当 target < nums[mid] 时，nums[mid] ... target
 *  
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
    (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
    You are given a target value to search. If found in the array return its index, otherwise return -1.
    You may assume no duplicate exists in the array.
    Your algorithm's runtime complexity must be in the order of O(log n).

    Example 1:
    
    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4
    Example 2:
    
    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        int start = 0;
         int end = nums.length - 1;
         int mid = 0;
         while (start <= end) {
             mid = (start + end) / 2;
             if (target < nums[mid]) {
                 if (nums[start] > nums[end] && nums[mid] >= nums[start] && target < nums[start])
                     start = mid + 1;
                 else
                     end = mid - 1;
             } else if (target > nums[mid]) {
                 if (nums[start] > nums[end] && nums[mid] < nums[end] && target > nums[end])
                     end = mid - 1;
                 else
                     start = mid + 1;
             } else {
                 return mid;
             }
         }
         return -1;
     }
}
