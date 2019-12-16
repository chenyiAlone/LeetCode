package easy;

/**
 * ClassName: ReverseOnlyLetters.java
 * Author: chenyiAlone
 * Create Time: 2019/12/16 20:14
 * Description: No.917 Reverse Only Letters
 *
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
 *
 *  
 *
 * Example 1:
 *
 * Input: "ab-cd"
 * Output: "dc-ba"
 * Example 2:
 *
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * Example 3:
 *
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 *  
 *
 * Note:
 *
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122 
 * S doesn't contain \ or "
 *
 */
public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String S) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0, j = S.length() - 1; i < S.length(); i++) {
            if ('a' <= S.charAt(i) && S.charAt(i) <= 'z' || 'A' <= S.charAt(i) && S.charAt(i) <= 'Z') {
                while (!('a' <= S.charAt(j) && S.charAt(j) <= 'z' || 'A' <= S.charAt(j) && S.charAt(j) <= 'Z')) j--;
                ret.append(S.charAt(j));
                j--;
            } else {
                ret.append(S.charAt(i));
            }
        }
        return ret.toString();
    }

}