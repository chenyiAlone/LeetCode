package medium;

import java.util.Arrays;

/**
 * ClassName: SuperUglyNumber.java
 * Author: chenyiAlone
 * Create Time: 2019/5/22 12:45
 * Description: No.313
 * 思路:
 *      1. DP 数组保存 ugly 初始化为 Integer.MAX_VALUE, ugly[0] = 1;，index[len] 对应 primes 每个数的下标
 *      2. ugly[i] 更新为 primes[j] * index[j] 中最小的值
 *      3. 更新 primes[j] * index[j] 中 j 对应的 index[j] += 1
 *
 *
 *
 * Write a program to find the nth super ugly number.
 *
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.
 *
 * Example:
 *
 * Input: n = 12, primes = [2,7,13,19]
 * Output: 32
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12
 *              super ugly numbers given primes = [2,7,13,19] of size 4.
 * Note:
 *
 * 1 is a super ugly number for any given primes.
 * The given numbers in primes are in ascending order.
 * 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
 * The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 *
 *
 */
public class SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int len = primes.length;
        int[] index = new int[len];
        int[] ugly = new int[n];
        Arrays.fill(ugly, Integer.MAX_VALUE);
        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < len; j++)
                ugly[i] = Math.min(ugly[i], ugly[index[j]] * primes[j]);

            for (int j = 0; j < len; j++) {
                if (primes[j] * ugly[index[j]] == ugly[i])
                    index[j] += 1;
            }
        }
        // for (int i : ugly)
        //     System.out.print(i + " ");
        // System.out.println();
        return ugly[n - 1];
    }
}
