package medium;
/**
 * ClassName: BitwiseANDofNumbersRange.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/6 16:39
 * Description: No.201
 * 思路:
 *      1. 假设 m、n 的第 i 位（从右至左）为为 1，如果 m 加上 1 << j ，向前一位进 1 后，
 *          如果此时 m 的值大于了 n ，那么证明 m、n 之间这一位是相邻的两个值，中间不存在 0
 *          m = _____1____ => m = ____10____
 *          n = _____1____    n = _____1____
 *
 *      2. 给出的 n 可以是个很大数，比如 Integer.MAX_VALUE，i 左移的过程中需要的条件是 > n，一次会超出 int 的范围，
 *          需要使用 long
 *
 *
 */
public class BitwiseANDofNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        // m
        // 00001
        // 00010
        // 00011
        // 00100
        // 00101
        // 00110
        // 00111
        // n
        int res = 0;
        for (long i = 1, j = 0; i <= n; i <<= 1, j++) {
            if ((n & i) > 0 && (m & i) > 0) {
                long new_m =  ((m >> j) << j) + i;
                if (new_m > n)
                    res |= i;
            }
        }
        return res;
    }
}
