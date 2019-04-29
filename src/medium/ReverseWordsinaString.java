package medium;
/**
 * ClassName: ReverseWordsinaString.java
 * Auther: chenyiAlone
 * Create Time: 2019/4/29 18:33
 * Description: No.151
 * 思路:
 *     1. 使用 StringBuffer 加速，从后向前遍历数组，不反转字符串
 *     2. blank 也可以使用 boolean 变量，统计是否有空格即可; wordLen 用来记录从上一个非空格位置至此的长度
 *
 *
 *  Given an input string, reverse the string word by word.
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 */
public class ReverseWordsinaString {
    public String reverseWords(String s) {
        StringBuffer res = new StringBuffer(s.trim());
        System.out.println(res);
        int len = res.length();
        int blank = 0;
        int wordLen = 0;
        for (int i = len -1; i >= 0; i--) {
            if (res.charAt(i) == ' ') {
                res.append(res.substring(i + 1, i + wordLen + 1));
                blank++;
                wordLen = 0;
            } else {
                if (blank > 0) {
                    res.append(" ");
                    blank = 0;
                }
                wordLen++;
            }
        }
        res.append(res.substring(0, wordLen));
        return res.delete(0, len).toString();
    }
}