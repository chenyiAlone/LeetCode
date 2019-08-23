package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: FindAllDuplicatesinanArray.java
 * Author: chenyiAlone
 * Create Time: 2019/8/23 19:27
 * Description: No.442 Find All Duplicates in an Array
 *
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements that appear twice in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 *
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [2,3]
 *
 */
public class FindAllDuplicatesinanArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != -1 && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            }
            if (nums[i] != -1 && nums[nums[i] - 1] == nums[i] && i != nums[i] - 1) {
                ret.add(nums[i]);
                nums[i] = -1;
            }
        }
        return ret;
    }

}
