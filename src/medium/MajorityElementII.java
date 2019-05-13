package medium;

import java.util.ArrayList;
import java.util.List;
/**
 * ClassName: MajorityElementII.java
 * Author: chenyiAlone
 * Create Time: 2019/5/13 17:03
 * Description: No.229
 * 思路:
 *      1. temp1，temp2 储存出现的数，因为是储存超过 n / 3 次的数，因此只需要保存两个数即可，类似于前面的 n / 2 次的数只有一个
 *      2. 计数器的与前面不同的就是当出现跟这俩个数都不同的情况下，就让两个计数器同时 -= 1
 *
 *
 *
 *
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 *
 * Note: The algorithm should run in linear time and in O(1) space.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 *
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 *
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int len = nums.length;
        List<Integer> res = new ArrayList<>();
        int count1= 0, temp1 = 0, count2 = 0, temp2 = 0;
        for (int i : nums) {
            if (i == temp1) {
                count1 += 1;
            } else if (i == temp2) {
                count2 += 1;
            } else if (count1 == 0) {
                temp1 = i;
                count1 = 1;
            } else if (count2 == 0) {
                temp2 = i;
                count2 = 1;
            } else {
                count1 -= 1;
                count2 -= 1;
            }
        }
        count1 = 0;
        count2 = 0;
        // System.out.println(temp1 + ">> " + temp2);
        for (int i : nums) {
            if (i == temp1)
                count1 += 1;
            else if (i == temp2) {
                count2 += 1;
            }
        }
        if (count1 > len / 3)
            res.add(temp1);
        if (count2 > len / 3)
            res.add(temp2);

        return res;
    }
}
