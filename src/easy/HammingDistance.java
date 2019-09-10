package easy;
/**
 * ClassName: HammingDistance.java
 * Author: chenyiAlone
 * Create Time: 2019/9/10 21:25
 * Description: No.461 Hamming Distance
 * 思路:
 *      1. 异或保留下不同位
 *      2. 使用 n & (n - 1) 依次去掉最后面的 1
 *
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, calculate the Hamming distance.
 *
 * Note:
 * 0 ≤ x, y < 231.
 *
 * Example:
 *
 * Input: x = 1, y = 4
 *
 * Output: 2
 *
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * The above arrows point to positions where the corresponding bits are different.
 *
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int ret = 0;
        while (n > 0) {
            n = n & (n - 1);
            ret++;
        }
        return ret;
    }
}