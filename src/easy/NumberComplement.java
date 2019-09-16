package easy;
/**
 * ClassName: NumberComplement.java
 * Author: chenyiAlone
 * Create Time: 2019/9/16 22:13
 * Description: No.476 Number Complement
 * 思路:
 *      1. ~ 按位取反运算符
 *      2. << >>> 移位操作去掉无用的位
 *
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 *
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 *
 */
public class NumberComplement {
    public int findComplement(int num) {
        int n = num, cnt = 0;
        while (n > 0) {
            n >>>= 1;
            cnt++;
        }
        int m = 32 - cnt;
        return (~num << m) >>> m;

    }
}