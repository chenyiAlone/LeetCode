package medium;
/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Example 1:
 *      Input: "abcabcbb"
 *      Output: 3 
 * Explanation: The answer is "abc", with the length of 3. 
 * 
 * Example 2:
 *      Input: "bbbbb"
 *      Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3:
 *      Input: "pwwkew"
 *      Output: 3
 * Explanation: The answer is "wke", with the length of 3. 
                 Note that the answer must be a substring,
                  "pwke" is a subsequence and not a substring.
 * @author chenyiAlone
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1) return 1;
        int max = 0;
        for (int lo = 0, i = 0; i < s.length(); i++) {
            int x = lastEqualIndex(s, lo, i);
            if (i- x > max) max = i - x;
            lo = x + 1;
        }
        return max;
    }
    
    // 放回扫描元素之前的元素中与他相同的第一个元素的下标
    public static int lastEqualIndex(String str,int lo, int x) {
        char c = str.charAt(x);
        while (x-- > lo) {
            if (str.charAt(x) == c) return x;
        }
        return x;
    }
}
