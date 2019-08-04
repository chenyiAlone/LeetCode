package easy;
/**
 * ClassName: NthDigit.java
 * Author: chenyiAlone
 * Create Time: 2019/8/4 22:35
 * Description: No.400 Nth Digit
 * 思路:
 *      1. 模拟每增加一位的时候，所出现的数个数
 *          len     数的长度
 *          start   开始的数字
 *          total   len 长度的时候能够表示数的个数
 *      2. start 和 total 每次 *= 10 变化
 *      3. number = (n - 1) / len + start
 *      4. 取 number 的 (n - 1) % len 个数
 *
 *
 *
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 *
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 231).
 *
 * Example 1:
 *
 * Input:
 * 3
 *
 * Output:
 * 3
 * Example 2:
 *
 * Input:
 * 11
 *
 * Output:
 * 0
 *
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is
 * part of the number 10.
 *
 *
 */
public class NthDigit {

    public int findNthDigit(int n) {
        int len = 1;
        long start = 1, total = 9;
        while (true) {
            if (n <= len * total) {
                long number = (n - 1) / len + start;
                return Long.toString(number).charAt(((n - 1) % len)) - '0';
            } else {
                n -= len * total;
                total *= 10;
                start *= 10;
                len++;
            }
        }
    }

}