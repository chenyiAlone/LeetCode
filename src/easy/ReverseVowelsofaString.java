package easy;
/**
 * ClassName: ReverseVowelsofaString.java
 * Author: chenyiAlone
 * Create Time: 2019/7/3 9:03
 * Description: No.345
 * 思路:
 *      1. switch 来判断字母
 *      2. String 不能修改，使用 StringBuilder 来修改单词
 *
 *
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 *
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: "leetcode"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y".
 *
 */
public class ReverseVowelsofaString {

    public String reverseVowels(String s) {
        int len = s.length();
        StringBuilder ret = new StringBuilder(s);
        for (int i = 0, j = len - 1; i < j; i++, j--) {
            while (i + 1 < len && unVow(ret, i)) i++;
            while (j > 0 && unVow(ret, j)) j--;
            if (i >= j) break;
            char temp = ret.charAt(i);
            ret.setCharAt(i, ret.charAt(j));
            ret.setCharAt(j, temp);
        }
        return ret.toString();
    }

    private boolean unVow(StringBuilder sb, int p) {
        char c = sb.charAt(p);
        switch(c) {
            case 'a':
            case 'A':
            case 'e':
            case 'E':
            case 'i':
            case 'I':
            case 'o':
            case 'O':
            case 'u':
            case 'U': return false;
        }
        return true;
    }

}
