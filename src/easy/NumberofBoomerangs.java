package easy;

import java.util.HashMap;
import java.util.Map;
/**
 * ClassName: NumberofBoomerangs.java
 * Author: chenyiAlone
 * Create Time: 2019/8/30 22:34
 * Description: No.447 Number of Boomerangs
 *
 *
 *
 *
 *
 */
public class NumberofBoomerangs {
    
    private int dist(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }


    public int numberOfBoomerangs(int[][] points) {
        int ret = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int t = dist(points[i], points[j]);
                    if (!map.containsKey(t)) {
                        map.put(t, 0);
                    }
                    map.put(t, map.get(t) + 1);
                }
                for (int val : map.values()) {
                    ret += val * (val - 1);
                }
            }
        }
        return ret;
    }
}