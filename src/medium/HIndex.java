package medium;
/**
 * ClassName: HIndex.java
 * Author: chenyiAlone
 * Create Time: 2019/5/16 11:08
 * Description: No.274
 * 思路:
 *      1. bucket[n + 1] 桶排序
 *      2. h 篇论文至少被引用了 h 次
 *
 *
 * Given an array of citations (each citation is a non-negative integer) of a researcher, write a function to compute the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her N papers have at least h citations each, and the other N − h papers have no more than h citations each."
 *
 * Example:
 *
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had
 *              received 3, 0, 6, 1, 5 citations respectively.
 *              Since the researcher has 3 papers with at least 3 citations each and the remaining
 *              two with no more than 3 citations each, her h-index is 3.
 * Note: If there are several possible values for h, the maximum one is taken as the h-index.
 *
 */
public class HIndex {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] bucket = new int[len + 1];
        for (int i : citations) {
            int p = Math.min(i, len);
            bucket[p] += 1;
        }
        int total = 0;
        int res = 0;
        for (int i = len; i >= 0; i--) {
            total += bucket[i];
            if (total >= i)
                return i;
        }
        return res;
    }
}