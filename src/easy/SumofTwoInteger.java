package easy;
/**
 * ClassName: SumofTwoInteger.java
 * Author: chenyiAlone
 * Create Time: 2019/7/19 22:49
 * Description: No.371 Sum of Two Integers
 * 思路:
 *      位运算模拟加法
 *      1. ^ 按位异或运算保留进位后的数
 *      2. & 按位与运算 << 1 位来计算进位
 *
 *
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 *
 * Example 1:
 *
 * Input: a = 1, b = 2
 * Output: 3
 * Example 2:
 *
 * Input: a = -2, b = 3
 * Output: 1
 *
 */
public class SumofTwoInteger {

    public int getSum(int a, int b) {
        if (b == 0) return a;
        return getSum(a ^ b, (a & b) << 1);
    }
    
}
