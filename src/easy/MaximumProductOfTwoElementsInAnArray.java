package easy;

/**
 * @author chenyiAlone
 * @date 2020/10/17 23:56
 *
 *
 * Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
 *  
 *
 * Example 1:
 *
 * Input: nums = [3,4,5,2]
 * Output: 12
 * Explanation: If you choose the indices i=1 and j=2 (indexed from 0), you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
 * Example 2:
 *
 * Input: nums = [1,5,4,5]
 * Output: 16
 * Explanation: Choosing the indices i=1 and j=3 (indexed from 0), you will get the maximum value of (5-1)*(5-1) = 16.
 * Example 3:
 *
 * Input: nums = [3,7]
 * Output: 12
 *  
 *
 * Constraints:
 *
 * 2 <= nums.length <= 500
 * 1 <= nums[i] <= 10^3
 *
 *
 */
public class MaximumProductOfTwoElementsInAnArray {

    public int maxProduct(int[] nums) {
        int max1, max2;
        if (nums[0] > nums[1]) {
            max1 = 0;   max2 = 1;
        } else {
            max1 = 1;   max2 = 0;
        }
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[max2]) {
                max2 = i;
            }
            if (nums[max1] < nums[max2]) {
                int tmp = max1;
                max1 = max2;
                max2 = tmp;
            }
        }
        return (nums[max1] - 1) * (nums[max2] - 1);
    }

}
