package medium;

import java.util.Arrays;
/**
 * ClassName: KthLargestElementinanArray.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/9 18:25
 * Description: No.215
 * 思路:
 *      1. sort array
 *      2. return Kth largest elements
 *      3. ps: not need to skip repeat elements
 *
 *
 *
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 */
public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int index = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (index++ == k)
                return nums[i];
        }
        return 0;
    }


}