package medium;

import java.util.Comparator;
import java.util.PriorityQueue;
/**
 * ClassName: MinimumNumberofArrowstoBurstBallons.java
 * Author: chenyiAlone
 * Create Time: 2019/5/25 13:34
 * Description: No.452
 * 思路:
 *      1. 按照右端点、左端点进行排序
 *      2. 贪心的取每个的右端点，这样肯定是当前区间的最大值
 *      3. 如果当前的左端点的值大于了上一个的右端点的值
 *      4. 如果第一个个数的左端点的值为 Integer.MIN_VALUE 就会不会计入结果，
 *          所以使用 long 类型来代表的默认的上一个右端点值为 -∞
 *
 *
 *
 * There are a number of spherical balloons spread in two-dimensional space. For each balloon,
 * provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal,
 * y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice.
 * Start is always smaller than end. There will be at most 104 balloons.
 *
 * An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with
 * xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number
 * of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find
 * the minimum number of arrows that must be shot to burst all balloons.
 *
 * Example:
 *
 * Input:
 * [[10,16], [2,8], [1,6], [7,12]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another
 * arrow at x = 11 (bursting the other two balloons).
 *
 */
public class MinimumNumberofArrowstoBurstBallons {
    private class Pair {
        int first;
        int second;

        private Pair(int f, int s) {
            this.first = f;
            this.second = s;
        }

        @Override
        public String toString() {
            return "[" + this.first + ", " + this.second + "]";
        }
    }


    public int findMinArrowShots(int[][] points) {
        PriorityQueue<Pair> queue = new PriorityQueue<>((p1, p2)-> {
                if (p1.second != p2.second)
                    return p1.second - p2.second;
                else
                    return p1.first - p2.first;
            }
        );
        for (int[] p : points)
            queue.offer(new Pair(p[0], p[1]));
        int res = 0;
        long pre = -(1L << 33);
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            if ((long)p.first > pre) {
                pre = p.second;
                res += 1;
            }
        }
        return res;
    }
}