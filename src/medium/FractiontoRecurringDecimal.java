package medium;

import java.util.HashMap;
import java.util.Map;
/**
 * ClassName: FractiontoRecurringDecimal.java
 * Auther: chenyiAlone
 * Create Time: 2019/5/3 16:43
 * Description: No.166
 * 思路:
 *      1. HashMap 存放 quotient 商和 remainder 余数
 *      2. 使用了 long 来存放两个数 long key = (qutient << 32) | remainder;
 *      3. StringBuffer => insert(int index, char c)
 *      4. Integer => intValue(): Integer > int
 *
 *
 *
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 *
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 *
 * Example 1:
 *
 * Input: numerator = 1, denominator = 2
 * Output: "0.5"
 * Example 2:
 *
 * Input: numerator = 2, denominator = 1
 * Output: "2"
 * Example 3:
 *
 * Input: numerator = 2, denominator = 3
 * Output: "0.(6)"
 *
 */
public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        Map<Long, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();
        long a = numerator, b = denominator;
        if (a * b < 0)
            res.append("-");
        a = Math.abs(a);
        b = Math.abs(b);

        long quotient = a / b;
        long remainder = a % b;

        res.append(quotient);
        if (remainder == 0)
            return res.toString();
        else
            res.append(".");
        while (true) {
            remainder *= 10;
            quotient = remainder / b;
            long key = (quotient << 32) | (remainder);
            if (map.containsKey(key)) {
                res.insert(map.get(key).intValue(), '(');
                res.append(")");
                return res.toString();
            } else {
                map.put(key, res.length());
                res.append(quotient);
                if (remainder % b == 0)
                    return res.toString();
            }
            remainder = remainder % b;
        }
    }
}