package medium;
/**
 * ClassName: SingleNumberII.java
 * Author: chenyiAlone
 * Create Time: 2019/5/23 16:43
 * Description: No.137
 * 思路:
 *      1. 统计每个位置的个数，如果是 cnt % 3 == 1 就证明出现一个次的数个这位为 1
 *      2. res |= 1 << i
 *
 *
 *
 *
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 *
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 *
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int x : nums){
            ones = (ones ^ x) & ~twos;
            twos = (twos ^ x) & ~ones;
        }
        return ones;
    }
}