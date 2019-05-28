package hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * ClassName: CountofSmallerNumberAfterSelf.java
 * Author: chenyiAlone
 * Create Time: 2019/5/26 14:36
 * Description: No.315
 * 思路:
 *      一、归并排序
 *          在归并排序的过程中使用 res 记录比他要小的数的个数
 *
 *      二、树状数组
 *          转化为从后向前统计比这个数小的数的和
 *              1. 数组去重
 *              2. 重新编号，将 num 转化 nums[i] = 数组中小于原来 nums[i] 不重复的个数
 *              3. 从后向前添加到树状数组中，nums[i] 作为 id，val = 1
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
/****************************************************************************/
    private int[] sum;
//    private int len;

    private void add(int id, int val) {
        for (int i = id; i <= len; i += i & -i)
            sum[i] += val;
    }
    private int getSum(int id) {
        int ret = 0;
        for (int i = id; i > 0; i -= i & -i)
            ret += sum[i];
        return ret;
    }



    public List<Integer> countSmallerByTreeArray(int[] nums) {
        len = nums.length;
        List<Integer> res = new ArrayList<>();
        // Collections.nCopies(len, 0);
        while (res.size() < len)
            res.add(0);
        sum = new int[len + 1];

        int[] disc = new int[len];
        System.arraycopy(nums, 0, disc, 0, len);
        Arrays.sort(disc);
        int[] temp = new int[len];
        int size = 0;
        for (int i = 0; i < len; i++) {
            if (size == 0 || disc[i] != temp[size - 1]) {
                temp[size] = disc[i];
                size++;
            }
        }
        for (int i = 0; i < len; i++) {
            int x = nums[i];
            int l = 0, r = size - 1;
            while (l <= r) {
                int mid = (l + r) >>> 1;
                if (temp[mid] < x)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            nums[i] = l;
        }

//         for (int i = 0; i < len; i++) {
//             System.out.print(nums[i] + " ");
//         }
//         System.out.println("res.size() = " + res.size());
        for (int i = len - 1; i >= 0; i--) {
            res.set(i, getSum(nums[i]));
            add(nums[i] + 1, 1);
        }


        // for (int i = 0; i < size; i++) {
        //     System.out.print(temp[i] + " ");
        // }
        // System.out.println();


        return res;
    }

}