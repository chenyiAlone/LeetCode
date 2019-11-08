package medium;
/**
 * ClassName: SingleElementinaSortedArray.java
 * Author: chenyiAlone
 * Create Time: 2019/11/8 13:28
 * Description: No.540 Single Element in a Sorted Array
 *
 *
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
 *
 *  
 *
 * Example 1:
 *
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 *
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 *  
 *
 * Note: Your solution should run in O(log n) time and O(1) space.
 *
 */
public class SingleElementinaSortedArray {

    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l >> 1);
            if (mid > 0 && nums[mid] == nums[mid - 1])
                if (mid % 2 == 0) r = mid - 1;
                else l = mid + 1;
            else if (mid < nums.length - 1 && nums[mid] == nums[mid + 1])
                if (mid % 2 == 0) l = mid + 1;
                else r = mid - 1;
            else return nums[mid];
        }
        return -1;
    }
}