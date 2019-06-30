package hard;
/**
 * ClassName: NumberofDigitOne.java
 * Author: chenyiAlone
 * Create Time: 2019/6/30 15:02
 * Description: No.233
 * 思路:
 *      1. 取出每一位的数字，从左向右逐位进行 DP
 *      2. f[i][1] 代表前 i 位和 n 的前缀不相同的含有有多少个 1
 *         f[i][0] 代表前 i 位和 n 的前缀相同的含有多少个 1
 *
 *         g[i][0] 代表前 i 位和 n 前缀不相同的有多少个组合
 *         g[i][i] 代表前 i 位和 n 前缀相同的有多少种
 *
 *
 *Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 *
 * Example:
 *
 * Input: 13
 * Output: 6
 * Explanation: Digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-digit-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 */
public class NumberofDigitOne {

    public int countDigitOne(int n) {
        int[][] f = new int[32][2], g = new int[32][2];
        int[] digit = new int[32];
        int len = 0;
        for ( ; n > 0; n /= 10)
            digit[len++] = n % 10;
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            int temp = digit[i];
            digit[i] = digit[j];
            digit[j] = temp;
        }
        g[0][1] = 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 10; j++) {
                g[i + 1][0] += g[i][0];
                f[i + 1][0] += f[i][0] + g[i][0] * (j == 1 ? 1 : 0);
                if (j < digit[i]) {
                    g[i + 1][0] += g[i][1];
                    f[i + 1][0] += f[i][1] + g[i][1] * (j == 1 ? 1 : 0);
                } else if (j == digit[i]) {
                    g[i + 1][1] += g[i][1];
                    f[i + 1][1] += f[i][1] + g[i][1] * (j == 1 ? 1 : 0);
                }
            }
        }
        return f[len][0] + f[len][1];
    }

}
