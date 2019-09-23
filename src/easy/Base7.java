package easy;
/**
 * ClassName: Base7.java
 * Author: chenyiAlone
 * Create Time: 2019/9/23 20:39
 * Description: No.504 Base 7
 *
 * Given an integer, return its base 7 string representation.
 *
 * Example 1:
 * Input: 100
 * Output: "202"
 * Example 2:
 * Input: -7
 * Output: "-10"
 * Note: The input will be in range of [-1e7, 1e7].
 *
 */
public class Base7 {
    public String convertToBase7(int num) {
        boolean flag = num < 0;
        num = Math.abs(num);
        StringBuilder ret = new StringBuilder(num == 0 ? "0": "");
        while (num != 0) {
            ret.append(num % 7);
            num /= 7;
        }
        if (flag) ret.append('-');
        return ret.reverse().toString();
    }
}