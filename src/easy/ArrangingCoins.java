package easy;
/**
 * ClassName: ArrangingCoins.java
 * Author: chenyiAlone
 * Create Time: 2019/8/22 21:56
 * Description: No.441 Arranging Coins
 * 思路:
 *      1. 二分，查找第一个 (1 + i) * (i / 2) 值小于等于 n 的值
 *
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
 *
 * Given n, find the total number of full staircase rows that can be formed.
 *
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 *
 * Example 1:
 *
 * n = 5
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 *
 * Because the 3rd row is incomplete, we return 2.
 * Example 2:
 *
 * n = 8
 *
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 *
 * Because the 4th row is incomplete, we return 3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arranging-coins
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class ArrangingCoins {
    public int arrangeCoins(int n) {
        return (int)((Math.sqrt(8.0 * n + 1) - 1) / 2);
    }

    public int arrangeCoinsBinarySearch(int n) {
        long l = 0, r = Integer.MAX_VALUE;
        while (l <= r) {
            long mid = (r + l) >> 1;
            double total = (1 + mid) * (mid / 2.0);
            if (total > n) {
                r = mid - 1;
            } else if (total == n) {
                return (int)mid;
            } else {
                l = mid + 1;
            }
        }
        return (int)r;
    }

}

