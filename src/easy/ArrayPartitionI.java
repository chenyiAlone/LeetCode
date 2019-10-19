package easy;

import java.util.*;

/**
 * ClassName: ArrayPartitionI.java
 * Author: chenyiAlone
 * Create Time: 2019/10/19 21:33
 * Description: No.561 Array Partition I
 */
public class ArrayPartitionI {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ret += nums[i];
        }
        return ret;
    }

}