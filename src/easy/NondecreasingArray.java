package easy;

/**
 * ClassName: NondecreasingArray.java
 * Author: chenyiAlone
 * Create Time: 2019/12/19 12:25
 * Description: No.665 Non-decreasing Array
 *
 * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
 *
 * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
 *
 * Example 1:
 * Input: [4,2,3]
 * Output: True
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * Example 2:
 * Input: [4,2,1]
 * Output: False
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 * Note: The n belongs to [1, 10,000].
 *
 */
public class NondecreasingArray {

    public boolean checkPossibility(int[] nums) {
        for (int i = 0, cnt = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) cnt++;
            if (cnt > 1 || cnt == 1
                    && i > 0 && i < nums.length - 2
                    && nums[i] > nums[i + 2]
                    && nums[i + 1] < nums[i - 1])
                return false;
        }
        return true;
    }

}