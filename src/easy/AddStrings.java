package easy;
/**
 * ClassName: AddStrings.java
 * Author: chenyiAlone
 * Create Time: 2019/8/13 23:40
 * Description: No.415 Add Strings
 * 思路:
 *      1. 从后向前遍历两个字符串，直到两个都走到了 index
 *      2. cy 需要提出来，最后进行判断
 *
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder ret = new StringBuilder();
        int cy = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int a = i >= 0 ? num1.charAt(i) - '0' : 0;
            int b = j >= 0 ? num2.charAt(j) - '0' : 0;
            ret.append((a + b + cy) % 10);
            cy = (a + b + cy) / 10;
        }
        if (cy != 0) ret.append(cy);
        return ret.reverse().toString();
    }

}