package medium;

import java.util.Arrays;
import java.util.Comparator;
/**
 * ClassName: NonoverlappingIntervals.java
 * Author: chenyiAlone
 * Create Time: 2019/8/26 17:10
 * Description: No.435 Non-overlapping Intervals
 * 思路:
 *      1. 贪心
 *      2. 按照右端的点的大小进行排序
 *      3. 当左端点大于最右边的结点的时候，就更新
 *
 *
 *
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 * Example 2:
 *
 * Input: [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of intervals non-overlapping.
 * Example 3:
 *
 * Input: [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 *
 *
 * Note:
 *
 * You may assume the interval's end point is always bigger than its start point.
 * Intervals like [1,2] and [2,3] have borders "touching" but they don't overlap each other.
 *
 */
public class NonoverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
//        Arrays.sort(intervals, (int[] a, int[] b)-> {return a[1] - b[1];});
        Arrays.sort(intervals, Comparator.comparing((int[] a)-> a[1]));
        int r = Integer.MIN_VALUE;
        int ret = intervals.length;
        for (int[] a : intervals) {
            if (a[0] >= r) {
                r = a[1];
                ret--;
            }
        }
        return ret;
    }

}