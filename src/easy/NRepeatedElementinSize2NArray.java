package easy;

import java.util.*;

/**
 * ClassName: NRepeatedElementinSize2NArray.java
 * Author: chenyiAlone
 * Create Time: 2019/12/30 21:53 
 * Description: No.961 N Repeated Element in Size 2N Array
 */
public class NRepeatedElementinSize2NArray {

    public int repeatedNTimes(int[] A) {
        int size = A.length;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i : A) {
            if (!cnt.containsKey(i)) cnt.put(i, 0);
            int t = cnt.get(i) + 1;
            if (t == size / 2) return i;
            cnt.put(i, t);
        }
        return -1;
    }
    
}