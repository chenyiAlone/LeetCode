package hard;

import java.util.Arrays;
import java.util.Comparator;
/**
 * ClassName: RussianDollEnvelopes.java
 * Author: chenyiAlone
 * Create Time: 2019/5/27 17:05
 * Description: No.354
 * 思路:
 *      1. 最长上升子序列 O(n logn)
 *      2. 按照 h 的非降序，以及 w 的非升序进行排列，避免掉 h 相同的情况下更新多个 w ，此时是不满足更新条件
 *
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 *
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 *
 * Note:
 * Rotation is not allowed.
 *
 * Example:
 *
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 *
 */
public class RussianDollEnvelopes {
    private class Pair {
        private int f;
        private int s;

        private Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }

        @Override
        public String toString() {
            return "[" + this.f + ", " + this.s + "]";
        }
    }

    public int maxEnvelopes(int[][] envelopes) {
        int len;
        if ((len = envelopes.length) == 0)
            return 0;
        Pair[] enves = new Pair[len];
        for (int i = 0; i < len; i++) {
            enves[i] = new Pair(envelopes[i][0], envelopes[i][1]);
        }

        int[] tmp = new int[len];
        Arrays.fill(tmp, Integer.MAX_VALUE);

        Arrays.sort(enves, new Comparator<Pair>() {

            @Override
            public int compare(Pair p1, Pair p2) {
                if (p1.f == p2.f)
                    return -(p1.s - p2.s);
                else
                    return p1.f - p2.f;
            }
        });

        int res = 0;
        for (Pair p : enves) {
            int l = 0, r = res;
            while (l <= r) {
                int mid = (l + r) >>> 1;
                if (tmp[mid] < p.s)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            tmp[l] = p.s;
            res = Math.max(res, l);
        }
        return res + 1;
    }
}