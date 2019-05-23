package medium;
/**
 * ClassName: SingleNumberIII.java
 * Author: chenyiAlone
 * Create Time: 2019/5/23 16:46
 * Description: No.260
 * 思路:
 *      1. 所有数的异或的值为 s ，它里面为 1 的位就是两个出现一次的数不同的位，一个为 0 ，一个为 1，
 *      2. 这一位为 1 的数中，肯定不包括另一个出现一次的数，将所有该位为 1 的数异或一遍，就得到
 *
 *
 *
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 *
 * Example:
 *
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * Note:
 *
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 *
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int s = 0;
        for (int x : nums)
            s ^= x;
        int k = 0;
        while (((s >> k) & 1) == 0)
            k++;
        int s1 = 0;
        for (int x : nums)
            if (((x >> k) & 1) == 1) {
                s1 ^= x;
            }
        // s1 ^ s2 = s
        // s1 ^ s2 ^ s1 = s2
        // 101
        //  11
        // 110
        return new int[]{s1, s ^ s1};
    }
}