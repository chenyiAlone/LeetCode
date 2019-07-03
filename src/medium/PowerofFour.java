package medium;
/**
 * ClassName: PowerofFour.java
 * Author: chenyiAlone
 * Create Time: 2019/7/3 8:38
 * Description: No.342
 * 思路:
 *
 *  1  =>   1
 *  4  =>   100
 *  16 =>   10000
 *  64 =>   1000000
 *  ...
 *
 *      1. 从上面的规律中可以看出 0 的个数是成 += 2 的变化规律增长了，且只有一个 1
 *      2. 简单的就是统计所有位的个数，判断位数 - 1 的值是否为偶数，而且需要特判是否只有一个 1
 *
 * 在上面思路的基础上进行升级，只有一个 1 的是 4 的倍数和 2 的倍数，因此需要将 2 的倍数排除掉
 *      (num & 0x55555555) != 0 用于排除这种情况
 *
 *
 *
 *  Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 5
 * Output: false
 * Follow up: Could you solve it without loops/recursion?
 *
 *
 */
public class PowerofFour {

    public boolean isPowerOfFourOld(int num) {
        int cnt = -1;
        if ((num & (num - 1)) != 0) return false;
        while (num > 0) {
            cnt += 1;
            num >>= 1;
        }
        return cnt % 2 == 0;
    }

    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}
