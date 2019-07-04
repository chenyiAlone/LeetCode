package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * ClassName: IntersectionofTwoArraysII.java
 * Author: chenyiAlone
 * Create Time: 2019/7/4 8:33
 * Description: No.350. Intersection of Two Arrays II
 * 思路：
 *      这道题主要的就是为了考察在不同情况下如何处理
 *          1. 两个数组的长度差不多，数据量不是很大
 *              1. 对两个数组进行排序，从头到尾进行扫描 O(N logN)
 *          2. 两个数组长度差别很大，数据量不是很大
 *              1. 对小的那个使用 hash 来进行记录
 *              2. 遍历长的元素，从 hash 中读取
 *          3. 两个数组长度差别很大，数据量很大
 *              1. 对小的那个使用 hash 来进行记录
 *              2. 将大的数据进行分段读取
 *
 *
 *
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that
 * you cannot load all elements into the memory at once?
 *
 */
public class IntersectionofTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; i++, j++) {
            while (i < nums1.length && j < nums2.length && nums1[i] != nums2[j]) {
                if (nums1[i] < nums2[j]) i++;
                else if (nums1[i] > nums2[j]) j++;
            }
            if (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
                list.add(nums1[i]);
            }
        }
        int[] ret = new int[list.size()];
        int i = 0;
        for (int n : list) {
            ret[i++] = n;
        }
        return ret;
    }
}
