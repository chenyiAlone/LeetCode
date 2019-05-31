package easy;
/**
 * ClassName: PowerofTree.java
 * Author: chenyiAlone
 * Create Time: 2019/5/31 18:39
 * Description: No.326
 * 思路:
 *      1. 最大到 3 ^ 19 = 1162261467
 *      2. 1162261467 % powerofthree == 0
 *
 *
 * Given an integer, write a function to determine if it is a power of three.
 *
 * Example 1:
 *
 * Input: 27
 * Output: true
 * Example 2:
 *
 * Input: 0
 * Output: false
 * Example 3:
 *
 * Input: 9
 * Output: true
 * Example 4:
 *
 * Input: 45
 * Output: false
 * Follow up:
 * Could you do it without using any loop / recursion?
 *
 *
 */
public class PowerofTree {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
