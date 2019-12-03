package medium;

import java.util.*;


/**
 * ClassName: SubarraySumEqualsK.java
 * Author: chenyiAlone
 * Create Time: 2019/12/3 16:07
 * Description: No.560 Subarray Sum Equals K
 */
public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ret = 0, sum = 0;
        for (int n : nums) {
            sum += n;
            if (map.containsKey(sum - k))
                ret += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ret;
    }
    
}