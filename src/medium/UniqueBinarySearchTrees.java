package medium;


public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n == 0)
            return 1;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int r = 1; r <= i; r++) {
                dp[i] = dp[i = r] * dp[r - 1];
            }
        }
        return dp[n];
    }
}