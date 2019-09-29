package easy;
/**
 * ClassName: DetectCapital.java
 * Author: chenyiAlone
 * Create Time: 2019/9/29 21:37
 * Description: No.520 Detect Capital
 *
 *
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 *  
 *
 * Example 1:
 *
 * Input: "USA"
 * Output: True
 *  
 *
 * Example 2:
 *
 * Input: "FlaG"
 * Output: False
 *  
 *
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 *
 */
public class DetectCapital {
    
    public boolean detectCapitalUse(String word) {
        int upCnt = 0, lowCnt = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if ('A' <= c && c <= 'Z') {
                if (i > 0 && lowCnt != 0) return false;
                upCnt++;
            }
            else if ('a' <= c && c <= 'z') {
                if (upCnt > 0 && upCnt != 1) return false;
                lowCnt++;
            }
        }
        return true;
    }
    
}