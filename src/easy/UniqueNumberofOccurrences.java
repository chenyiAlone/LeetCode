package easy;

import java.util.*;

/**
 * ClassName: UniqueNumberofOccurrences.java
 * Author: chenyiAlone
 * Create Time: 2019/1/10 21:48 
 * Description: No.1207 Unique Number of Occurrences
 */
public class UniqueNumberofOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i : arr) {
            cnt.put(i, (cnt.containsKey(i) ? cnt.get(i) : 0) + 1);
        }
        HashSet<Integer> single = new HashSet<>(cnt.values());
        return cnt.size() == single.size();
    }
    
}