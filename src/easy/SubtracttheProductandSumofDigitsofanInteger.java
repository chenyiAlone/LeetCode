package easy;
/**
 * ClassName: SubtracttheProductandSumofDigitsofanInteger.java
 * Author: chenyiAlone
 * Create Time: 2019/12/24 21:25
 * Description: No.1281 Subtract the Product and Sum of Digits of an Integer
 *
 * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 *  
 *
 * Example 1:
 *
 * Input: n = 234
 * Output: 15
 * Explanation:
 * Product of digits = 2 * 3 * 4 = 24
 * Sum of digits = 2 + 3 + 4 = 9
 * Result = 24 - 9 = 15
 * Example 2:
 *
 * Input: n = 4421
 * Output: 21
 * Explanation:
 * Product of digits = 4 * 4 * 2 * 1 = 32
 * Sum of digits = 4 + 4 + 2 + 1 = 11
 * Result = 32 - 11 = 21
 *  
 *
 * Constraints:
 *
 * 1 <= n <= 10^5
 *
 */
public class SubtracttheProductandSumofDigitsofanInteger {

    private int sum(int n) {
        if (n < 10) return n;
        return (n % 10) + sum(n / 10);
    }

    private int acc(int n) {
        if (n < 10) return n;
        return (n % 10) * acc(n / 10);
    }

    public int subtractProductAndSum(int n) {
        return acc(n) - sum(n);
    }

}