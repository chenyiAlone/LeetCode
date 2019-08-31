package easy;

import java.util.HashMap;
import java.util.Map;
/**
 * ClassName: NumberofBoomerangs.java
 * Author: chenyiAlone
 * Create Time: 2019/8/30 22:34
 * Description: No.447 Number of Boomerangs
 *
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 *
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 *
 * Example:
 *
 * Input:
 * [[0,0],[1,0],[2,0]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
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
                    int key = dist(points[i], points[j]);
                    if (!map.containsKey(key)) {
                        map.put(key, 0);
                    }
                    map.put(key, map.get(key) + 1);
                }
            }
            for (int d : map.values()) {
                ret += d * (d - 1);
            }
        }
        return ret;
    }
}