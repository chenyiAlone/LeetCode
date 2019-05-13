package medium;

import java.util.ArrayList;
import java.util.List;
/**
 * ClassName: SummaryRanges.java
 * Author: chenyiAlone
 * Create Time: 2019/5/13 16:57
 * Description: No.228
 * 思路:
 *      1. 只需要在 for 记录当前结点 j = i，让 i 向后延伸
 *      2. 根据 i 和 j 的值的关系，向 res 中添加结果
 *
 *
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 *
 * Example 1:
 *
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * Example 2:
 *
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 *
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        int len = nums.length;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < len; ) {
            int j = i;
            while (j + 1 < len && nums[j + 1] == nums[j] + 1)
                j++;
            if (i == j) {
                res.add("" + nums[i]);
            } else {
                res.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }
        return res;
    }
}
