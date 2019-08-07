package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: LongestPalindrome.java
 * Author: chenyiAlone
 * Create Time: 2019/8/7 23:06
 * Description: No.409 Longest Palindrome
 *      1. 题目的意思能构成回文！！！
 *      2. 成对的肯定能够组成回文
 *      3. 如果最后 set 不为空，证明有至少有一个奇数个的字符，可以加在回文串的中间，cnt * 2 + 1
 *          否则 cnt * 2
 *
 *
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>();
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                cnt++;
            } else {
                set.add(c);
            }
        }
        if (!set.isEmpty()) return cnt * 2 + 1;
        return cnt * 2;
    }

}