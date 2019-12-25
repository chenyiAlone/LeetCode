package easy;

/**
 * ClassName: MaximumNumberofBalloons.java
 * Author: chenyiAlone
 * Create Time: 2019/12/25 15:21
 * Description: No.1189 Maximum Number of Balloons
 *
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 *
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 *
 *  
 *
 * Example 1:
 *
 *
 *
 * Input: text = "nlaebolko"
 * Output: 1
 * Example 2:
 *
 *
 *
 * Input: text = "loonbalxballpoon"
 * Output: 2
 * Example 3:
 *
 * Input: text = "leetcode"
 * Output: 0
 *  
 *
 * Constraints:
 *
 * 1 <= text.length <= 10^4
 * text consists of lower case English letters only.
 *
 */
public class MaximumNumberofBalloons {
    
    public int maxNumberOfBalloons(String text) {
        int[] cnt = new int[256];
        for (char c : text.toCharArray())
            cnt[c]++;
        char[] cs = {'b', 'a', 'l', 'o', 'n'};
        int[] base = {1, 1, 2, 2, 1};
        int ret = cnt[cs[0]] / base[0];
        for (int i = 1; i < cs.length; i++)
            ret = Math.min(ret, cnt[cs[i]] / base[i]);
        return ret;
    }
    
}