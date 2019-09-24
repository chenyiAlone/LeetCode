package easy;
/**
 * ClassName: PerfectNumber.java
 * Author: chenyiAlone
 * Create Time: 2019/9/24 17:23
 * Description: No.507 Perfect Number
 * 思路:
 *      1. 只需要统计 1 ~ sqrt(num) 范围内的即可
 *      2. 排除 num 本身这个数
 *
 *
 *
 *
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
 *
 * Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 * Example:
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * Note: The input number n will not exceed 100,000,000. (1e8)
 *
 */
public class PerfectNumber {

    public boolean checkPerfectNumber(int num) {
        int sum = 0;
        for (int i = 1; i < Math.sqrt(num); i++) {
            if (num % i == 0) sum += i + (i != 1 ? num / i : 0);
            if (sum > num) break;
        }
        return sum != 0 && sum == num;
    }
    
}