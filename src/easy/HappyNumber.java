package easy;

import java.util.HashSet;
import java.util.Set;
/**
 * ClassName: HappyNumber.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/6 16:51
 * Description: No.202
 * 思路:
 *      1. Set: boolean add(E e) set 添加失败的时候将会返回 false
 *      2. res == 1 的判定要放在 !set.add(res)之前
 *
 *
 *
 * Write an algorithm to determine if a number is "happy".
 *
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example:
 *
 * Input: 19
 * Output: true
 * Explanation:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Long> set = new HashSet<>();
        while (true) {
            long res = 0;
            while (n > 0) {
                res += (n % 10) * (n % 10);
                n /= 10;
            }
            if (res == 1)
                return true;
            if (!set.add(res))
                return false;
            n = (int)res;
        }
    }
}
