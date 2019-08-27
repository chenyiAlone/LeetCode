package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * ClassName: FindRightIntervals.java
 * Author: chenyiAlone
 * Create Time: 2019/8/27 20:57
 * Description: No.436 Find Right Interval
 * 思路:
 *      碰到右端点就提出一个询问
 *
 * Given a set of intervals, for each of the interval i, check if there exists an interval j whose start point is bigger than or equal to the end point of the interval i, which can be called that j is on the "right" of i.
 *
 * For any interval i, you need to store the minimum interval j's index, which means that the interval j has the minimum start point to build the "right" relationship for interval i. If the interval j doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval as an array.
 *
 * Note:
 *
 * You may assume the interval's end point is always bigger than its start point.
 * You may assume none of these intervals have the same start point.
 *
 *
 * Example 1:
 *
 * Input: [ [1,2] ]
 *
 * Output: [-1]
 *
 * Explanation: There is only one interval in the collection, so it outputs -1.
 *
 *
 * Example 2:
 *
 * Input: [ [3,4], [2,3], [1,2] ]
 *
 * Output: [-1, 0, 1]
 *
 * Explanation: There is no satisfied "right" interval for [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point;
 * For [1,2], the interval [2,3] has minimum-"right" start point.
 *
 *
 * Example 3:
 *
 * Input: [ [1,4], [2,3], [3,4] ]
 *
 * Output: [-1, 2, -1]
 *
 * Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
 * For [2,3], the interval [3,4] has minimum-"right" start point.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 *
 */
public class FindRightIntervals {

    class Pair implements Comparable<Pair> {
        int first;
        int second;
        private Pair() {}
        private Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair o) {
            if (first != o.first) return first - o.first;
            return second - o.second;
        }
    }

    public int[] findRightInterval(int[][] intervals) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0], end = intervals[i][1];
            list.add(new Pair(start, i + 1));
            list.add(new Pair(end, -i - 1));
        }
        Collections.sort(list);
        List<Integer> quest = new ArrayList<>();
        int[] ret = new int[intervals.length];
        Arrays.fill(ret, -1);
        for (Pair p : list) {
            if (p.second > 0) {
                for (int i : quest) {
                    ret[i - 1] = p.second - 1;
                }
                quest.clear();
            } else {
                quest.add(-p.second);
            }
        }
        return ret;

    }
}