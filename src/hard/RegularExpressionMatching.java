package hard;
import static util.Utils.*;
/**
 * 
 * ClassName: RegularExpressionMatching
 * @author chenyiAlone  
 * Create Time: 2018/12/15 17:55:28
 * Description: No.10 DP算法
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        int n = s.length() + 1;
        int m = p.length() + 1;
        boolean[][] dp = new boolean[n][m];
        dp[0][0] = true;
        
        for (int i = 1; i < m; i++) {
            if (p.charAt(i - 1) == '*' && dp[0][i] == true)
                dp[0][i] = true;
        }
        printArray(dp[0]);
//        for (int i = 1; i < n; i++) {
//            if (p.charAt(i) == p.charAt(i - 1))
//                dp[0][i] = true;
//        }
        return false;
    }
    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        new RegularExpressionMatching().isMatch(s, p);
    }
}
