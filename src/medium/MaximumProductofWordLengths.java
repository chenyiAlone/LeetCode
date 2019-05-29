package medium;
/**
 * ClassName: MaximumProductofWordLengths.java
 * Author: chenyiAlone
 * Create Time: 2019/5/29 15:53
 * Description: No.318
 * 思路:
 *      1. 题目限制了为小写字母，所以 26 个小写字母使用二进制表示也就 2^26
 *      2. 判断两个字符串是否有有相同字符 | nums[i] + nums[j] == (nums[i] | nums[j])
 *
 *
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 *
 * Example 1:
 *
 * Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 * Example 2:
 *
 * Input: ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4
 * Explanation: The two words can be "ab", "cd".
 * Example 3:
 *
 * Input: ["a","aa","aaa","aaaa"]
 * Output: 0
 * Explanation: No such pair of words.
 */
public class MaximumProductofWordLengths {
    public int maxProduct(String[] words) {
        int res = 0;
        int len;
        if ((len = words.length) < 2)
            return res;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            String s = words[i];
            for (char c : s.toCharArray()) {
                nums[i] |= (1 << (c - 'a'));
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] + nums[j] == (nums[i] | nums[j]))
                    res = Math.max(res, words[i].length() * words[j].length());
            }
        }
        return res;
    }
}
