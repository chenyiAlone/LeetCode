package medium;

import java.util.*;


/**
 * ClassName: ContainsDuplicateIII.java
 * Author: chenyiAlone
 * Create Time: 2019/11/28 18:31
 * Description: No.220 Contains Duplicate III
 */
public class ContainsDuplicateIII {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int size = nums.length;
        k = Math.min(k, size - 1) + 1;
        if (t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            long id = ((long)nums[i]) / ((long)t + 1);
            if (i >= k)
                map.remove(((long)nums[i - k]) / ((long)t + 1));
            if (!map.containsKey(id))
                map.put(id, 0L + nums[i]);
            else 
                return true;
            if (map.containsKey(id - 1) && map.get(id) - map.get(id - 1) <= t)
                return true;
            if (map.containsKey(id + 1) && map.get(id + 1) - map.get(id) <= t)
                return true;

        }
        return false;
    }
    
}