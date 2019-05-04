package easy;
/**
 * ClassName: FactorialTrailingZeroes.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/4 19:40
 * Description: No.172
 * 思路:
 *      只需要统计 n! 中出现了多少次 5 的倍数即可
 *
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Example 1:
 *
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 *
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Note: Your solution should be in logarithmic time complexity.
 *
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        long count = 0;
        for (long i = 5; i <= n; i *= 5) {
            count += n / i;
        }
        return (int)count;
    }
}
