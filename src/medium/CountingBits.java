package medium;
/**
 * ClassName: CountingBits.java
 * Author: chenyiAlone
 * Create Time: 2019/5/30 17:34
 * Description: No.338
 * 思路:
 *      也算是盲猜出来的吧，f[i] 中 1 的个数刚好是 f[i] 去掉最后一个 1 后的 f[i & (i - 1)] + 1
 *
 *     0 0000 0
 *     1 0001 1
 *     2 0010 1
 *     3 0011 2
 *     4 0100 1
 *     5 0101 2
 *
 *Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate
 * the number of 1's in their binary representation and return them as an array.
 *
 * Example 1:
 *
 * Input: 2
 * Output: [0,1,1]
 * Example 2:
 *
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * Follow up:
 *
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in
 * linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or
 * in any other language.
 *
 */
public class CountingBits {

    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            f[i] = f[i & (i - 1)] + 1;
        }
        return f;
    }
}
