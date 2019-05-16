package medium;
/**
 * ClassName: UglyNumberII.java
 * Author: chenyiAlone
 * Create Time: 2019/5/16 10:14
 * Description: No.264
 * 思路:
 *      1. 维护 p2, p3, p5 三个数组下标
 *      2. 3 个 if 用于跳过重复，避免出现 p2 = 3, p3 = 2 这种更新后重复的情况
 *
 *
 * Write a program to find the n-th ugly number.
 *
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 *
 * Example:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:
 *
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 *
 *
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(ugly[p2] * 2, Math.min(ugly[p3] * 3, ugly[p5] * 5));
            if (ugly[i] == ugly[p2] * 2)
                p2 += 1;
            if (ugly[i] == ugly[p3] * 3)
                p3 += 1;
            if (ugly[i] == ugly[p5] * 5)
                p5 += 1;
        }
        return ugly[n - 1];
    }
}
