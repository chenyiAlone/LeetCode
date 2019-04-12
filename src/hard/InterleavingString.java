package hard;

/**
 * 
 * ClassName: InterleavingString
 * @author chenyiAlone  
 * Create Time: 2019/04/12 17:46:56
 * Description: No.97
 * 思路:
 *   1. DP
 *   2. str2 是随机插入了 str1 中，而不是随机排列的
 *      "abc" "ab" "cbba" => false
 *     
 *      
 *      
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
    
    Example 1:
    
    Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
    Output: true
    Example 2:
    
    Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
    Output: false     
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3)
            return false;
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (dp[i][j]) {
                    if (i < len1 && s1.charAt(i) == s3.charAt(i + j)) 
                        dp[i + 1][j] = true;
                    if (j < len2 && s2.charAt(j + 1) == s3.charAt(i + j))
                        dp[i][j + 1] = true;
                }
            }
        }
        return dp[len1][len2];
    }
}
