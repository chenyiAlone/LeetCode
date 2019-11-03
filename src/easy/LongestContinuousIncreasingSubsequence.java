package easy;

import java.util.*;

/**
 * ClassName: LongestContinuousIncreasingSubsequence.java
 * Author: chenyiAlone
 * Create Time: 2019/11/3 20:58 
 * Description: No.674 Longest Continuous Increasing Subsequence
 */
public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        int ret = nums.length == 0 ? 0 : 1;
        if (nums == null || nums.length == 0) return ret;
        int pre = nums[0];
        for (int i = 0, cnt = 1; i < nums.length; i++) {
            if (nums[i] > pre) {
                cnt++;
            } else {
                cnt = 1;
            }
            pre = nums[i];
            ret = Math.max(ret, cnt);
        }
        return ret;
    }

}