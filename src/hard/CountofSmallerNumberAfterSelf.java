package hard;

import java.util.ArrayList;
import java.util.List;
/**
 * ClassName: CountofSmallerNumberAfterSelf.java
 * Author: chenyiAlone
 * Create Time: 2019/5/26 14:36
 * Description: No.315
 * 思路:
 *      在归并排序的过程中使用 res 记录比他要小的数的个数
 *
 *
 *
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 *
 * Example:
 *
 * Input: [5,2,6,1]
 * Output: [2,1,1,0]
 * Explanation:
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 *
 */
public class CountofSmallerNumberAfterSelf {
    private class Pair {
        private int id;
        private int val;

        private Pair(int f, int s) {
            this.id = f;
            this.val = s;
        }
    }

    private int len;
    private List<Integer> res;
    private Pair[] N, M;

    private void merge(int l, int r) {
        if (l == r)
            return;
        int mid = (l + r) >> 1;
        merge(l, mid);
        merge(mid + 1, r);
        for (int i = l, j = mid + 1, index = l; i <= mid || j <= r; index ++) {
            if (j == r + 1 || (i <= mid && j <= r && N[i].val <= N[j].val)) {
                M[index] = N[i];
                // 134
                // 245
                res.set(N[i].id, res.get(N[i].id)  + j - (mid + 1));
                i ++;
            } else {
                M[index] = N[j];
                j ++;
            }
        }
        System.arraycopy(M, l, N, l, r - l + 1);
    }


    public List<Integer> countSmaller(int[] nums) {
        res = new ArrayList<>();
        if ((len = nums.length) == 0) return res;
        while (res.size() < len)
            res.add(0);
        N = new Pair[len];
        M = new Pair[len];
        for (int i = 0; i < len; i ++)
            N[i] = new Pair(i, nums[i]);
        System.arraycopy(N, 0, M, 0, len);
        merge(0, len - 1);
        return res;
    }
}