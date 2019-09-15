/**
 * ClassName: OnesandZeros.java
 * Author: chenyiAlone
 * Create Time: 2019/9/15 15:56
 * Description: No.474 Ones and Zeros
 */

public class OnesandZeros {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] f = new int[m + 1][n + 1];
        for (int[] arr : f) Arrays.fill(arr, -1);
        f[0][0] = 0;
        int ret = 0;
        for (String s : strs) {
            int[] cnt = {0, 0};
            for (char c : s.toCharArray()) cnt[c - '0']++;
            int zeros = cnt[0], ones = cnt[1];
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    if (f[i - zeros][j - ones] >= 0) {
                        f[i][j] = Math.max(f[i][j], f[i - zeros][j - ones] + 1);
                        ret = Math.max(ret, f[i][j]);
                    }
                }
            }
        }
        return ret;
    }
}