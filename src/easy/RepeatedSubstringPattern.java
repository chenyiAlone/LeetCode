package easy;
/**
 * ClassName: RepeatedSubstringPattern.java
 * Author: chenyiAlone
 * Create Time: 2019/9/9 16:00
 * Description: No.459 Repeated Substring Pattern
 * 思路:
 *      1. KMP
 *      2. 如果 next[] 数组的最后一位的不为 -1 && s[len - 1] == s[next[len - 1]] && len % (len - (next[len] + 1)) == 0
 *          就证明 KMP 划分开的数组，刚好能够被长度将去头和尾相同的字符后整除
 *
 *
 *
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 *
 * Example 1:
 *
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 *
 * Input: "aba"
 * Output: False
 * Example 3:
 *
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 *
 */
public class RepeatedSubstringPattern {
    
    public boolean repeatedSubstringPattern(String s) {
        int i = 0, j = -1, len = s.length();
        int[] next = new int[len];
        next[0] = -1;
        while (i < len - 1) {
            if (j == -1 || s.charAt(i) == s.charAt(j)) {
                i++;    j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next[len - 1] != -1 && s.charAt(len - 1) == s.charAt(next[len - 1]) && len % (len - (next[len - 1] + 1)) == 0;
    }
    
}