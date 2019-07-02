package medium;
/**
 * ClassName: IntegerBreak.java
 * Author: chenyiAlone
 * Create Time: 2019/7/2 8:31
 * Description: No.343
 * 思路:
 * 一、
 *      1. 拆分过程中，拆的 3 越多，乘积就越大
 *      2. 对于前面的数进行打表
 *
 * 二、
 *      1. 递归 + 记忆数组
 *      2. 先拆一次，后面的选择拆或者不拆的最大值
 *
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 *
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * Note: You may assume that n is not less than 2 and not larger than 58.
 *
 *
 */
public class IntegerBreak {
    /*
    * 1. 递归 + 记忆数组
    * 2. 因为每个数字必须进行拆分，所以先进行拆分一次后，再选择拆不拆分
    *
    */
    private int[] memo;

    private int handle(int n) {
        if (n <= 3) return n;
        if (memo[n] != 0) return memo[n];
        for (int i = 1; i <= n / 2; i++) {
            memo[n] = Math.max(memo[n], Math.max(i, handle(i)) * Math.max(n - i, handle(n - i)));
        }
        return memo[n];
    }

    public int integerBreak(int n) {

        int ret = 0;
        memo = new int[n];
        for (int i = 1; i <= n / 2; i++) {
            ret = Math.max(ret, handle(i) * handle(n - i));
        }
        return ret;
    }


    /**
     * 1. 根据数学方法，拆的 3 越多，结果越大
     * 2. 贪心得优先拆分出 3
     *
     */
    public int integerBreakByMath(int n) {
        int[] arr = new int[] {1, 1, 1, 2, 4, 6, 9};
        if (n <= 6) return arr[n];
        int ret = 1;
        while (n > 6) {
            n -= 3;
            ret *= 3;
        }
        return ret * arr[n];
    }

}
