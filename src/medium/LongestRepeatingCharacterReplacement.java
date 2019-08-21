package medium;
/**
 * ClassName: LongestRepeatingCharacterReplacement.java
 * Author: chenyiAlone
 * Create Time: 2019/8/21 22:21
 * Description: No.424 Longest Repeating Character Replacement
 * 思路:
 *
 *
 *
 * Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
 *
 * In one operation, you can choose any character of the string and change it to any other uppercase English character.
 *
 * Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.
 *
 * Note:
 * Both the string's length and k will not exceed 104.
 *
 * Example 1:
 *
 * Input:
 * s = "ABAB", k = 2
 *
 * Output:
 * 4
 *
 * Explanation:
 * Replace the two 'A's with two 'B's or vice versa.
 *
 *
 * Example 2:
 *
 * Input:
 * s = "AABABBA", k = 1
 *
 * Output:
 * 4
 *
 * Explanation:
 * Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 *
 */
public class LongestRepeatingCharacterReplacement {

    private int[] cnt = new int[256];
    private int getMax() {
        int ret = 0;
        for (int i : cnt) ret = Math.max(ret, i);
        return ret;
    }

    public int characterReplacement(String s, int k) {
        int len = s.length();
        if (k >= len) return len;
        int ret = 0;
        int l = 0, r = -1;
        for ( ; l < len; cnt[s.charAt(l) - 'A']--, l++) {
            for ( ; r + 1 < len && (r + 1 - l + 1) - Math.max(cnt[s.charAt(r + 1) - 'A'] + 1, getMax()) <= k; ) {
                r++;
                cnt[s.charAt(r) - 'A']++;
            }
            ret = Math.max(ret, r - l + 1);
        }
        return ret;
    }
    
}