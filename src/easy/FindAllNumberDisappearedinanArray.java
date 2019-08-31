package easy;

import java.util.ArrayList;
import java.util.List;
/**
 * ClassName: FindAllNumberDisappearedinanArray.java
 * Author: chenyiAlone
 * Create Time: 2019/8/31 22:15
 * Description: No.448 Find All Numbers Disappeared in an Array
 * 思路:
 *      1. 每次将当前元素可以的话就换到正确位置，如果要换的位置和当前位置的值相同，就置为 -1
 *      2. 将所有的 -1 位置的缺少的值加入结果中
 *
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 *
 *
 */
public class FindAllNumberDisappearedinanArray {
    
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != -1 && nums[i] != i + 1 && (nums[nums[i] - 1] != nums[i])) {
                int t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            }
            if (nums[i] != -1 && nums[nums[i] - 1] == nums[i] && i != nums[i] - 1) {
                nums[i] = -1;
            }
        }
        for (int i = 0; i < nums.length; i++)
            if (nums[i] == -1)
                ret.add(i + 1);
        return ret;
    }
    
}