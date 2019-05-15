package easy;
/**
 * ClassName: UglyNumber.java
 * Author: chenyiAlone
 * Create Time: 2019/5/15 17:04
 * Description: No.263
 * 思路:
 *      1. 因为丑数的因数只有 2,3,5 ,其中 4 也是 2 的倍数
 *      2. for i ← 2 to 5，除尽所有的该因子
 *              while (num % i == 0)
 *                  num /= i;
 *      3. return num == 1;
 *
 *
 *
 *
 *
 * Write a program to check whether a given number is an ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example 1:
 *
 * Input: 6
 * Output: true
 * Explanation: 6 = 2 × 3
 * Example 2:
 *
 * Input: 8
 * Output: true
 * Explanation: 8 = 2 × 2 × 2
 * Example 3:
 *
 * Input: 14
 * Output: false
 * Explanation: 14 is not ugly since it includes another prime factor 7.
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * Input is within the 32-bit signed integer range: [−231,  231 − 1].
 */
public class UglyNumber {

    public boolean isUglyNumber(int num) {
        for (int i=2; i<6 && num>0; i++)
            while (num % i == 0)
                num /= i;
        return num == 1;
    }


    public boolean isUglyOld(int num) {
        while (num != 0) {
            if (num % 2 == 0)
                num /= 2;
            else if (num % 3 == 0)
                num /= 3;
            else if (num % 5 == 0)
                num /= 5;
            else
                break;
        }
        return num == 1;
    }
}
