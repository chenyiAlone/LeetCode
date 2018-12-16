package hard;
import static util.Utils.*;
/**
 * 
 * ClassName: RegularExpressionMatching
 * @author chenyiAlone  
 * Create Time: 2018/12/15 17:55:28
 * Description: No.10 DP算法[动态规划]
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*' && dp[0][i - 2] == true)
                dp[0][i] = true;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j -1 ) || p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1]; 
                } else if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j  -2] || dp[i][j - 1] || dp[i - 1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
//        for (int i = 1; i < n; i++) {
//            if (p.charAt(i) == p.charAt(i - 1))
//                dp[0][i] = true;
//        }
    }
    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        System.out.println(new RegularExpressionMatching().isMatch(s, p));
    }
}
