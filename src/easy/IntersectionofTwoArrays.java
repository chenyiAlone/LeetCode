package easy;

import java.util.HashSet;
import java.util.Set;
/**
 * ClassName: IntersectionofTwoArrays.java
 * Author: chenyiAlone
 * Create Time: 2019/7/4 8:24
 * Description: No.349 Intersection of Two Arrays
 *
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 *
 */
public class IntersectionofTwoArrays {
    
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> inter = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i))
                inter.add(i);
        }
        int[] ret = new int[inter.size()];
        int i = 0;
        for (int num : inter)
            ret[i++] = num;
        return ret;
    }

}
