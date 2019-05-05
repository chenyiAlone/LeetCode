package easy;
/**
 * ClassName: ReverseBits.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/5 15:02
 * Description: No.190
 * 思路:
 *      ps: 需要注意的就是 java 没有无符号类型的，因此传入的 4,294,967,293(11111111111111111111111111111101)，在 java 中为 -3
 *      1. << 到第一位 >>> 到最低位，这样就仅仅保留了这一位，在 << 回到原来位置
 *      2. 按照折半的顺序反转，需要注意的是右移位操作需要使用 >>> 无符号右移操作运算符
 *
 *
 *
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * Example 1:
 *
 * Input: 00000010100101000001111010011100
 * Output: 00111001011110000010100101000000
 * Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
 * Example 2:
 *
 * Input: 11111111111111111111111111111101
 * Output: 10111111111111111111111111111111
 * Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10101111110010110010011101101001.
 *
 *
 * Note:
 *
 * Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 *
 */
public class ReverseBits {
    public int reverseBits1(int n) {
        int res = 0;
        for(int i = 32 ; i > 0 ; i--){
            res += (((n << (i - 1)) >>> 31) << (i - 1));
        }
        return res;
    }

    public int reverseBits2(int n) {
        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        return n;
    }

    public static void main(String[] args) {
        int n = -3;
        System.out.format("n = %s\n", Integer.toBinaryString(n));
        int res = new ReverseBits().reverseBits2(n);
        System.out.format("res = %s\n", Integer.toBinaryString(res));

    }
}
