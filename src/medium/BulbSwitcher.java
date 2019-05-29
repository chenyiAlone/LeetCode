package medium;
/**
 * ClassName: BulbSwitcher.java
 * Author: chenyiAlone
 * Create Time: 2019/5/29 16:10
 * Description: No.319
 * 思路:
 *      只有完全平方数最后才能亮着，只需要统计 1 ~ n 之间的完全平方数的个数即可
 *      从这里可以看出，完全平方数的个数刚好就是这个数开方后的结果
 *
 *      1 * 1 = 1；
 *      2 * 2 = 2；
 *      3 * 3 = 9；
 *      4 * 4 = 16；
 *
 *
 * 3: 11
 * 000
 * 111 111
 * 101 010
 * 100 001
 *
 * 4:101
 * 0000
 * 1111
 * 1010
 * 1000
 * 1001
 *
 *
 *
 * There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the i-th round, you toggle every i bulb. For the n-th round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
 *
 * Example:
 *
 * Input: 3
 * Output: 1
 * Explanation:
 * At first, the three bulbs are [off, off, off].
 * After first round, the three bulbs are [on, on, on].
 * After second round, the three bulbs are [on, off, on].
 * After third round, the three bulbs are [on, off, off].
 *
 * So you should return 1, because there is only one bulb is on.
 */
public class BulbSwitcher {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}