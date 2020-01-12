package easy;

import java.util.*;


/**
 * ClassName: MinimumAbsoluteDifference.java
 * Author: chenyiAlone
 * Create Time: 2019/1/12 22:23 
 * Description: No.1200 Minimum Absolute Difference
 */
public class MinimumAbsoluteDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            diff = Math.min(diff, arr[i + 1] - arr[i]);
        }
        List<List<Integer>> ret = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == diff)
                ret.add(Arrays.asList(arr[i], arr[i + 1]));
        }
        return ret;
    }

}