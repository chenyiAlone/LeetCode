package medium;

import java.util.Arrays;
/**
 * ClassName: ReconstructOriginalDigitsfromEnglish.java
 * Author: chenyiAlone
 * Create Time: 2019/8/17 23:16
 * Description: No.423 Reconstruct Original Digits from English
 * 思路:
 *      1. 找出每个单词的特别单词，用来做 cnt
 *      2. 去掉已经找到的单词，剩下的就又有了新的判定方式
 *      3. 最后要求字典序
 *
 *
 *
 *  Given a non-empty string containing an out-of-order English representation of digits 0-9, output the digits in ascending order.
 *
 * Note:
 * Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original digits. That means invalid inputs such as "abc" or "zerone" are not permitted.
 * Input length is less than 50,000.
 * Example 1:
 * Input: "owoztneoer"
 *
 * Output: "012"
 * Example 2:
 * Input: "fviefuro"
 *
 * Output: "45"
 *
 */
public class ReconstructOriginalDigitsfromEnglish {

    private char[] str;
    private StringBuilder ret = new StringBuilder();
    private int[] cnt = new int[26];

    private void slove(int d, char c, String word) {
        int total = cnt[c - 'a'];
        for (int i = 0; i < total; i++) {
            ret.append(d);
        }
        for (char t : word.toCharArray()) {
            cnt[t - 'a'] -= total;
        }
    }

    public String originalDigits(String s) {
        String[] words = {"zero", "one", "two", "three", "four", "five",
                "six", "seven", "eigth", "nine"};
        str = s.toCharArray();
        for (char c : str) {
            cnt[c - 'a']++;
        }
        slove(0, 'z', words[0]);
        slove(2, 'w', words[2]);
        slove(4, 'u', words[4]);
        slove(6, 'x', words[6]);
        slove(8, 'g', words[8]);
        slove(1, 'o', words[1]);
        slove(5, 'f', words[5]);
        slove(7, 's', words[7]);
        slove(9, 'i', words[9]);
        slove(3, 't', words[3]);
        char[] temp = ret.toString().toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }

}