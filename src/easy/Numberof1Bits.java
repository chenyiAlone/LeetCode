package easy;
/**
 * ClassName: Numberof1Bits.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/5 15:44
 * Description: No.191
 * 思路:
 *      1. 需要注意的是 java 没有的无符号数，传入的 4,294,967,293(11111111111111111111111111111101)，在 java 中为 -3
 *      2. n &= n - 1; 可以消去 最后一个 1 之后的所有位
 *
 *
 *
 *
 *  Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
 *
 * Example 1:
 *
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * Example 2:
 *
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * Example 3:
 *
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 *
 *
 * Note:
 *
 * Note that in some languages such as Java, there is no unsigned integer type. In this case, the input will be given as
 * signed integer type and should not affect your implementation, as the internal binary representation of the integer
 * is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3 above the
 * input represents the signed integer -3.
 *
 */
public class Numberof1Bits {
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            n &= n - 1;
            cnt++;
        }
        return cnt;
    }
}
