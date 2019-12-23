package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


/**
 * ClassName: SortanArray.java
 * Author: chenyiAlone
 * Create Time: 2019/12/23 20:48
 * Description: No.912 Sort an Array
 *
 * Given an array of integers nums, sort the array in ascending order.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 *
 */
public class SortanArray {

    private Random rand = new Random();

    private void sort(int l, int r, int[] nums) {
        if (l >= r) return;
        int axie = l + rand.nextInt(r - l + 1);
        int L = l, R = r, pivot = nums[axie];
        while (L <= R) {
            while (L <= R && nums[L] < pivot) L++;
            while (L <= R && nums[R] > pivot) R--;
            if (L <= R) {
                int t = nums[L];
                nums[L] = nums[R];
                nums[R] = t;
                L++;    R--;
            }
        }
        sort(l, R, nums);
        sort(L, r, nums);

    }

    public List<Integer> sortArray(int[] nums) {
        sort(0, nums.length - 1, nums);
        List<Integer> ret = new LinkedList<>();
        for (int i : nums)
            ret.add(i);
        return ret;
    }
}