package easy;
/**
 * ClassName: ConvertaNumbertoHexadecimal.java
 * Author: chenyiAlone
 * Create Time: 2019/8/6 22:09
 * Description: No.405 Convert a Number to Hexadecimal
 *
 *      1. -1 == "fffffff" 即 (1L << 32) - 1
 *      2. 对 0 进行特判
 *
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 *
 * Note:
 *
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 * Example 1:
 *
 * Input:
 * 26
 *
 * Output:
 * "1a"
 * Example 2:
 *
 * Input:
 * -1
 *
 * Output:
 * "ffffffff"
 *
 */
public class ConvertaNumbertoHexadecimal {
    
    private char parse(long i) {
        if (i < 10) return (char)('0' + i);
        return (char)('a' + i - 10);
    }

    public String toHex(int num) {
        long maxVal = (1L << 32) - 1;
        long val = num;
        val = val < 0 ? maxVal + val + 1: val;
        StringBuilder ret = new StringBuilder(num == 0 ? "0" : "");
        while (val > 0) {
            ret.append(parse(val % 16));
            val /= 16;
        }
        for (int i = 0, j = ret.length() - 1; i < j; i++, j--) {
            char c = ret.charAt(i);
            ret.setCharAt(i, ret.charAt(j));
            ret.setCharAt(j, c);
        }
        return ret.toString();
    }
}