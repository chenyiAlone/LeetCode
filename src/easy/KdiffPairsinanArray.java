package easy;

import java.util*;

/**
 * ClassName: KdiffPairsinanArray.java
 * Author: chenyiAlone
 * Create Time: 2019/1/3 21:43 
 * Description: No.532 K diff Pairs in an Array
 */
public class KdiffPairsinanArray {


    public int findPairs(int[] nums, int k) {
        int ret = 0;
        if (k < 0)
            return ret;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.put(i, map.containsKey(i) ? map.get(i) + 1 : 1);
        Iterator<Integer> iter = map.keySet().iterator();
        while (iter.hasNext()) {
            int i = iter.next();
            if (k == 0) {
                if (map.get(i) > 1) ret++; 
            } else {
                if (map.containsKey(i - k)) {
                    ret++;
                }
                if (map.containsKey(i + k)) {
                    ret++;
                }
            }
            iter.remove();
        }
        return ret;
    }

}