package easy;

/**
 * ClassName: ValidPerfectSquare.java
 * Author: chenyiAlone
 * Create Time: 2019/7/17 22:53
 * Description: No.367 Valid Perfect Square
 * 思路:
 *
 *      牛顿迭代法求平方根
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 14
 * Output: false
 *
 *
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        // f(x) = f(x0) + 2x * (x - x0)
        // f(x0) + 2x * (x - x0) = 0;
        // x0^2 + 2 * x^2 - 2 x* x0 = 0;
        for (long x = 100000; x >= 0; ) {
            double newn = x - ((x * x - num) / (2.0 * x));
            int t = (int)newn;
            if (t * t == num) return true;
            if (Math.abs(x - t) <= 1) return false;
            x = t;
        }
        return false;

    }
}